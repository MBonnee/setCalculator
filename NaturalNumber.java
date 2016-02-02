package assignment2;

public class NaturalNumber implements NaturalNumberInterface {

	private StringBuffer stringBuffer;
	
	NaturalNumber() {
		stringBuffer = new StringBuffer();
		stringBuffer.append(0);
	}
	
	public void init(char c) {
		stringBuffer = new StringBuffer();
		stringBuffer.append(c);
	}
	
	public void add(char c) {
        if (stringBuffer.charAt(0) == '0') {
            stringBuffer.deleteCharAt(0);
            stringBuffer.append(c);
        } else {
            stringBuffer.append(c);
        }
	}
	
	public char get(int index) {
        return stringBuffer.charAt(index);
	}
	
	public void remove(int index) {
		stringBuffer.deleteCharAt(index);
	}
	
	public int size() {
		return stringBuffer.length();
	}
	
	public NaturalNumber clone() {
		NaturalNumber copy = null;
		
		try {
			copy = (NaturalNumber) super.clone();
		} catch (CloneNotSupportedException e) {

        }
		
		copy.stringBuffer = new StringBuffer();
		
		for(int i = 0; i < this.stringBuffer.length(); i ++) {
			copy.stringBuffer.append(this.stringBuffer.charAt(i));
		}
		
		return copy;
	}
	
	public int compareTo(Object object) {
        //TODO: change to not use ints
        NaturalNumber naturalNumber = (NaturalNumber) object;

        int length = this.size();

        if (this.size() > naturalNumber.size()) {
            length = naturalNumber.size();
        }

        if (this.size() > naturalNumber.size()) {
            return 1;
        } else if (this.size() < naturalNumber.size()) {
            return -1;
        }

        for (int i = 0; i < length; i++) {
            if (this.stringBuffer.charAt(i) < naturalNumber.stringBuffer.charAt(i)) {
                return -1;
            } else if (this.stringBuffer.charAt(i) > naturalNumber.stringBuffer.charAt(i)) {
                return 1;
            }
        }

        return 0;
    }

    public String toString() {
        return stringBuffer.toString();
    }
}
