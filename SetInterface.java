package assignment2;

/** ADT for the class Set<E extends Data>.
*
* @author Michiel Bonnee & Thomas Sterrenburg
* @elements
*	All objects
* @structure 
*	none
* @domain
*	No duplicate values
* @constructor
*	Set();
*	    <dl>
*		<dt><b>PRE-condition</b><dd>-
*		<dt><b>POST-condition</b><dd>A new 
*		copy of a Set-object has been created and is empty.
*	    </dl>
*	<br>
**/

public interface SetInterface<E extends Data> extends Clonable {
	/** Initializes the Set object to the empty Set.
	 * @precondition
	 * 	-
	 * @postcondition
	 * 	The Set is empty.
	 **/
	void init();

	/** Adds a copy of an Object obj to the Set.
	 * @precondition
	 * 	-
	 * @postcondition
	 * 	The Set contains one copy of an Object obj.
	 **/
	void addObject(E e);

	/** Returns a copy of a random object from the Set.
	 * @precondition
	 * 	The Set is not empty.
	 * @postcondition
	 * 	A copy of a random object is returned.
	 **/
	E getObject();
	
	/** Removes Object obj from the Set.
	 * @precondition
	 *  -
	 * @postcondition
	 *  Object obj is removed from the Set.
	 **/
	void removeObject(E e);

	/** Returns whether the Set is empty.
	 * @precondition
	 * 	-
	 * @postcondition
	 * 	true: the number of elements in the Set == 0.<br>
	 * 	false: the amount of elements in the Set &gt; 0.
	 **/
	boolean isEmpty();

	/** Returns the number of objects of the Set.
	 * @precondition
	 * 	-
	 * @postcondition
	 * 	The number of objects in the Set is returned.
	 **/
	int size();
	
	/** Returns a Set of all elements contained in the 1st but not in the 2nd Set.
	 *	@precondition
	 *	-
	 *	@postcondition
	 *	 A Set of all elements contained in the 1st but not in the 2nd Set is returned.
	 **/
	Set complement(Set c);
	
	/** Returns a copy of the Set of all elements contained in both Sets.
	 *	@precondition
	 *	-
	 *	@postcondition
	 *	A copy of the Set of all elements contained in both Sets is returned.
	 **/
	Set intersection(Set c);
	
	/** Returns a copy of the Set of all elements in both Sets.
	 *	@precondition
	 *	-
	 *	@postcondition
	 *	A copy of the Set of all elements in both Sets is returned.
	 **/
	Set union(Set c);
	 
	/** Returns a copy of the Set of all elements of both Sets that are not contained in the intersection.
	 *	@precondition
	 *	-
	 *	@postcondition
	 *  a copy of the Set of all elements of both Sets that are not contained in the intersection is returned.
	 **/
	Set symmetricDifference(Set c);
	
	/**Returns a copy of a Set object
	 * @precondition
	 * -
	 * @postcondition
	 * a copy of a Set has been made
	 */
	Set clone();
}