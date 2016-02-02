package assignment2;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by mbonnee on 28/09/15.
 */

public class Parser {

    private Table<Identifier, Set> table = new Table<>();

    private void start() {
        Scanner in = new Scanner(System.in);

        while (in.hasNextLine()) {
            String programString = in.nextLine();
            Scanner programScanner = new Scanner(programString);

            try {
                statement(programScanner);
            } catch (APException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    void statement(Scanner input) throws APException {
        input.useDelimiter("");
        ignoreSpaces(input);

        if (nextCharIsLetter(input)) { // assignment
            assignment(input);
        } else if (nextCharIs(input, '?')) { // printStatement
            printStatement(input);
        } else if (nextCharIs(input, '/')) { // comment
            return;
            //comment(input);
        } else {
            throw new APException("Make an assignment, a print statement or a comment");
        }
    }

//    void comment (Scanner input) throws APException {
//
//        character(input , '/');
//        input.nextLine();
//        eoln(input);
//    }

    void printStatement(Scanner input) throws APException {
        Set result;
        character(input, '?');
        ignoreSpaces(input);
        result = expression(input);
        eoln(input);

        System.out.println(result.toString());
    }

    Set expression (Scanner input) throws APException { //returns a set
        Set result = term(input);
        ignoreSpaces(input);

        while (nextCharIs(input, '+') || nextCharIs(input, '|') || nextCharIs(input, '-')) {
            if (nextCharIs(input, '+')) {
                character(input, '+');
                ignoreSpaces(input);
                result = result.union(term(input));
            } else if (nextCharIs(input, '|')) {
                character(input, '|');
                ignoreSpaces(input);
                result = result.symmetricDifference(term(input));
            } else if (nextCharIs(input, '-')) {
                character(input, '-');
                ignoreSpaces(input);
                result = result.complement(term(input));
            }
        }

        return result;
    }

    Set term(Scanner input) throws APException {
        Set result = factor(input);
        ignoreSpaces(input);

        while (nextCharIs(input, '*')) {
            character(input, '*');
            ignoreSpaces(input);
            result = result.intersection(factor(input));
            ignoreSpaces(input);
        }

        return result;
    }

    Set factor (Scanner input) throws APException {
        Set result;

        if (nextCharIsLetter(input)) { // identifier
            Identifier key = identifier(input);
            if (!table.containsKey(key)) {
                throw new APException("Identifier not assigned yet");
            }
            result = table.getValue(key);
        } else if (nextCharIs(input, '(')) { //complex factor
            result = complexFactor(input);
        } else if (nextCharIs(input, '{')) { //Set
            result = set(input);
        } else {
            throw new APException("Factor was expected");
        }

        return result;
    }

    Set complexFactor(Scanner input) throws APException {
        character(input, '(');
        ignoreSpaces(input);
        Set result = expression(input);
        ignoreSpaces(input);
        character(input, ')');

        return result;
    }

    Set set(Scanner input) throws APException {
        character(input, '{');
        ignoreSpaces(input);
        Set result = rowNaturalNumbers(input);
        ignoreSpaces(input);
        character(input, '}');

        return result;
    }

    Set<NaturalNumber> rowNaturalNumbers(Scanner input) throws APException {
        Set<NaturalNumber> result = new Set();

        while (nextCharIsDigit(input) || nextCharIs(input, ',')) {
            if (nextCharIsDigit(input)) {
                result.addObject(naturalNumber(input));
            }
            if (nextCharIs(input, ',')) {
                character(input, ',');
                ignoreSpaces(input);
            } else if (nextCharIs(input, ' ')) {
                ignoreSpaces(input);
            } else if (nextCharIs(input, '}')) {
                return result;
            } else {
                throw new APException("row of numbers should be in form of: {0, 1, 2, 3} and numbers never start with 0");
            }
        }

        return result;
    }

    void assignment (Scanner input) throws APException {
        Identifier key = identifier(input);
        ignoreSpaces(input);
        character(input, '=');
        ignoreSpaces(input);

        Set value = expression(input);
        eoln(input);

        table.addEntry(key, value);
    }

    Identifier identifier(Scanner input) throws APException {
        Identifier result = new Identifier();
        result.addChar(letter(input));

        while (nextCharIsDigit(input) || nextCharIsLetter(input)) {
            if (nextCharIsDigit(input)) {
                NaturalNumber number = naturalNumber(input);
                result.addChar(number.get(0));
            } else if (nextCharIsLetter(input)) {
                result.addChar(letter(input));
            }
        }
        return result;
    }

    char letter(Scanner input) throws APException {
        if (!nextCharIsLetter(input)) {
            throw new APException("Identifier must begin with a letter");
        }

        return nextChar(input);
    }

    NaturalNumber naturalNumber(Scanner input) throws APException { // not zero and zero etc.
        NaturalNumber result = new NaturalNumber();

        if (!nextCharIsDigit(input)) {
            throw new APException("Number is expected");
        } else if (!nextCharIs(input, '0')) {
            result = positiveNumber(input);
        } else if (nextCharIs(input, '0')) {
            result.add(nextChar(input));
        }

        return result;
    }

    NaturalNumber positiveNumber(Scanner input) throws APException {
        NaturalNumber result = new NaturalNumber();

        if (nextCharIs(input, '0')) {
            throw new APException("positive number cannot start with 0");
        }
        while(nextCharIsDigit(input)) {
            result.add(nextChar(input));
        }

        return result;
    }

    void eoln (Scanner input) throws APException {
        if (input.hasNext()) {
            throw new APException("End of line is expected");
        }
    }

    void character(Scanner input, char c) throws APException {
        if (!nextCharIs(input, c)) {
            throw new APException("Missing " + c);
        }

        nextChar(input);
    }

    void ignoreSpaces(Scanner input) throws APException {
        while (nextCharIs(input, ' ')) {
            character(input, ' ');
        }
    }


    char nextChar (Scanner in) {
        return in.next().charAt(0);
    }

    boolean nextCharIs(Scanner in, char c) {
        return in.hasNext(Pattern.quote(c + ""));
    }

    boolean nextCharIsDigit (Scanner in) {
        return in.hasNext("[0-9]");
    }

    boolean nextCharIsLetter (Scanner in) {
        return in.hasNext("[a-zA-Z]");
    }

    public static void main(String[] args) {
        new Parser().start();
    }

}
