package assignment2;

public class Identifier implements IdentifierInterface {
	
	private StringBuffer stringBuffer;
	
	public Identifier() {
		stringBuffer = new StringBuffer("");
	}
	
	public void init(char c) {
		stringBuffer = new StringBuffer(Character.toString(c));
	}
	
	public char getChar(int i) {
		return stringBuffer.charAt(i);
	}
	
	public void addChar(char c) {
		stringBuffer.append(c);
	}
	
	public boolean isEmpty() {
		return stringBuffer.length() == 0;
	}
	
	public int length() {
		return stringBuffer.length();
	}
	
	public Identifier clone(){
		Identifier copy = null;
		try{
			copy = (Identifier) super.clone();
		}catch (CloneNotSupportedException e){
			
		}
		
		copy.stringBuffer = new StringBuffer();
		
		for(int i = 0; i < this.stringBuffer.length(); i ++) {
			copy.stringBuffer.append(this.stringBuffer.charAt(i));
		}
		
		return copy;
	}

	public int compareTo(IdentifierInterface identifier) {
		Identifier id = (Identifier) identifier;
        int length = this.length();

        if (this.length() > id.length()) {
            length = id.length();
        }
        for (int i = 0; i < length; i++) {
            if (this.stringBuffer.charAt(i) < id.stringBuffer.charAt(i)) {
                return 1;
            } else if (this.stringBuffer.charAt(i) > id.stringBuffer.charAt(i)) {
                return -1;
            }
        }

        if (this.length() > id.length()) {
            return -1;
        } else if (this.length() < id.length()) {
            return 1;
        } else {
            return 0;
        }
	}
}
