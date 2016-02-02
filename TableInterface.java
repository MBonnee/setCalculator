package assignment2;

/** ADT for the class Table<K extends Identifier, V extends Set>.
*
* @author Michiel Bonnee & Jonatan Roose
* @elements
*	Keys: Data and Values: Clonables
* @structure 
*	None
* @domain
*	No duplicate keys
* @constructor
*	Table();
*	    <dl>
*		<dt><b>PRE-condition</b><dd>-
*		<dt><b>POST-condition</b><dd> a Table-object has been created and is empty.
*	    </dl>
*	<br>
**/
public interface TableInterface<K extends Data, V extends Clonable> extends Clonable<TableInterface<K, V>> {

	/** Initializes the Table object to the empty table.
	 * @precondition
	 * 	-
	 * @postcondition
	 * 	The table is empty.
	 **/
	void init();
	
	/**adds an entry to the table
	 * @precondition
	 * -
	 * @postcondition
	 * an entry consisting of an key and value has been made 
	 */
	void addEntry(K key, V value);
	
	/**removes an entry from the table
	 * @precondition
	 * the table is not empty
	 * @postcondition
	 * the entry containing K key has been removed
	 */
	void removeEntry(K key);
	
	/**returns the value belonging to K key
	 * @precondition
	 * the table is not empty 
	 * @postcondition
	 * the value paired with the K key has been returned
	 */
	V getValue(K key) throws APException;
	
	/**returns the number of key and value pairs
	 * @precondition
	 * -
	 * @postcondition
	 * the number of key and value pairs has been returned
	 */
	int size();
	
	/**returns whether the table is empty or not
	 * @precondition
	 * -
	 * @postcondition
	 * whether the table is empty or not has been returned
	 */
	boolean isEmpty();
	
	/**returns whether the table contains key K or not
	 * @precondition
	 * -
	 * @postcondition
	 * whether the table contains the key has been returned
	 */
	boolean containsKey(K key);
	
}
