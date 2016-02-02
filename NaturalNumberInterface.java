package assignment2;

/**
 *  @author Michiel Bonnee & Jonatan Roose
 *	@elements : characters of type char
 *	@structure : lineair
 *	@domain :	 Minimum size 0, maximum size infinite;
 *				 First character != 0 if size == 1
 *	@constructor 
 *  NaturalNumber ();
 *	<dl>
 *		<dt><b>PRE-condition</b><dd>	-
 *		<dt><b>POST-condition</b><dd> 	The new NaturalNumber-object contains 1 as first character.
 * </dl>
 * <br>
 *  NaturalNumber (char c);
 *	<dl>
 *		<dt><b>PRE-condition</b><dd>	Char c is 1-9.
 *		<dt><b>POST-condition</b><dd> 	The new NaturalNumber-object contains c as first character.
 * </dl>

 **/

public interface NaturalNumberInterface extends Data {
	
	/**	Initializes the NaturalNumber object to the NaturalNumber containing exactly one character c.
	 *  @precondition  - Char c is 1-9.
	 *	@postcondition - The instance contains only contains character c as first character.
	 **/
	void init(char c);
	
	/**	Adds character c to the object.
	 *  @precondition  - Char c is 0-9.
	 *	@postcondition - Char c is added to the instance as last character. If NaturalNumber is 0 replace with c
	 **/
	void add(char c);
	
	/**	Returns a copy of the character at the index.
	 *  @precondition  - The index is within the boundaries of the length of the object.
	 *	@postcondition - A copy of the character at the index has been returned.
	 **/
	char get(int index);
	
	/**	Removes the character at the given index.
	 *  @precondition  - Index is valid. The size is greater than 1.
	 *	@postcondition - The character at the given index has been removed.
	 **/
	void remove(int index);
	
	/**	Returns a copy of the size.
	 *  @precondition  - 
	 *	@postcondition - A copy of the size has been returned.
	 **/
	int size();
	
	/** Compares two objects and returns their difference.
	 *  @precondition  - 
	 *	@postcondition - return -1 if object is smaller. returns 0 if objects are equal. returns 1 if object is bigger
	 */
	int compareTo(Object object);
    
    /**Returns a copy of an NaturalNumber object
     * @precondition
     * -
     * @postcondition
     * a copy of an NaturalNumber has been made
     **/
    NaturalNumber clone();
}
