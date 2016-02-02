package assignment2;

import java.util.Objects;

/** ADT for the class Identifier.
*
* @author Michiel Bonnee & Jonatan Roose
* @elements
* 	alphanumeric characters of type char
* @structure 
*	lineair
* @domain
*	positive size of at least 1, first element is a letter
* @constructor
*	Identifier();
*	    <dl>
*		<dt><b>PRE-condition</b><dd>-
*		<dt><b>POST-condition</b><dd>A new copy of an Identifier-object has been made, with character 'a' as first element.
*	    </dl>
*	<br>
 *	Identifier(char c);
 *	    <dl>
 *		<dt><b>PRE-condition</b><dd>-
 *		<dt><b>POST-condition</b><dd>A new copy of an Identifier-object has been made, with character c as first element.
 *	    </dl>
**/

public interface IdentifierInterface extends Data<IdentifierInterface> {
	
	/** Initializes the Identifier object.
	 * @precondition
	 * 	-
	 * @postcondition
	 * 	The identifier exactly contains character c at position 0 
	 **/
	void init(char c);

	/** Returns the character at index i of the identifier.
	 * @precondition
	 * Index i is between (exclusive) 0 and the number of characters in the identifier.
	 * @postcondition
	 * 	The character at index i of the identifier is returned.
	 **/
	char getChar(int i);

	/** Adds character c to the identifier after the last character.
	 * @precondition
	 *  char c is alphanumeric
	 * @postcondition
	 * 	Character c is added to the identifier after the last character.
	 **/
	void addChar(char c);

	/** Returns whether the identifier is empty.
	 * @precondition
	 * 	-
	 * @postcondition
	 * 	true: the number of elements in the identifier == 0.<br>
	 * 	false: the amount of elements in the identifier &gt; 0.
	 **/
	boolean isEmpty();

	/** Returns the number of characters of the identifier.
	 * @precondition
	 * 	-
	 * @postcondition
	 * 	The number of characters of the identifier is returned.
	 **/
	int length();
	
	/** Returns whether the identifier object contains the same elements in the same order as identifier object id.
	 * @precondition
	 *  -
	 * @postcondition
	 *  true: the identifier object contains the same characters in exactly the same order as identifier object id.<br>
	 *  false: the identifier object does not contain the same characters in exactly the same order as identifier object id.
	 */
	int compareTo(IdentifierInterface identifierInterface);
	
	/**Returns a copy of an identifier object
	 * @precondition
	 * -
	 * @postcondition
	 * a copy of an identifier has been made
	 */
	IdentifierInterface clone();
} 