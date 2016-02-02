package assignment2;

public class List<E extends Data> implements ListInterface {
	private Node current;
    private Node first;
    private Node last;

	private int numberOfNodes;

	List() {
		current = null;
		first = null;
		last = null;
		numberOfNodes = 0;
	}
	
	public boolean isEmpty() {
		return numberOfNodes == 0;
	}
	
	public List<E> init() {
		current = null;
        first = null;
        last = null;
		numberOfNodes = 0;
		return this;
	}
	
	public int size() {
		return numberOfNodes;
	}


    public List<E> insert(Data d) {
		E copy = (E) d.clone();
        if (isEmpty()) { // if list is empty
            last = first = current = new Node(copy);
            numberOfNodes++;
            return this;
        }
        if (copy.compareTo(first.data) < 0) { // if data is smaller than first element
            current = first = first.prior = new Node(copy, null, first);
            numberOfNodes++;
            return this;
        } else if (copy.compareTo(last.data) >= 0) { //if dat is bigger or equal than last element
            current = last = last.next = new Node (copy, last, null);
            numberOfNodes++;
            return this;
        } else { // if data is between two elements
            current = first;
            while (goToNext()) {
                if (copy.compareTo(current.data) < 0) {
                    current = current.prior.next = new Node(copy, current.prior, current);
                    current.next.prior = current;
                    numberOfNodes++;
                    return this;
                }
            }
            return this;
        }
	}

	public E retrieve() {
        return current.data;
	}
	
	public List<E> remove() {
		if(numberOfNodes == 1) { // if just one node
			last = first = current = null;
			numberOfNodes = 0;
            return this;
		} else if (current == last) { // if last node
            last.prior.next = null;
            current = last = last.prior;
            numberOfNodes--;
            return this;
        } else if (current == first) { // if first node
            first.next.prior = null;
            current = first = first.next;
            numberOfNodes--;
            return this;
        } else { // if node in the middle
            current.next.prior = current.prior;
            current = current.prior.next = current.next;
            numberOfNodes--;
            return this;
        }

	}

    public boolean find(Data d) {
        goToFirst();
        current = first;

        if (current == null) {
            return false;
        }

        do {
            if (d.compareTo(current.data) == 0) {
                return true;
            }
        } while (goToNext());

		return false;
	}
	
	public boolean goToFirst() {
		if(isEmpty()) {
			return false;
		} else {
            current = first;
			return true;
		}
	}
	
	public boolean goToLast() {
		if(isEmpty()) {
			return false;
		} else {
            current = last;

			return true;
		}
	}
	
	public boolean goToNext() {
		if(isEmpty() || current == last) {
            return false;
        } else {
			current = current.next;
			return true;
		}
	}
	
	public boolean goToPrevious() {
		if(isEmpty() || current.prior == null) {
			return false;
		} else {
			current = current.prior;
			return true;
		}
	}
	
	public List<E> clone() {
		List<E> copy;
		
		try {
			copy = (List<E>) super.clone();
		} catch (CloneNotSupportedException e) {
            throw new Error("");
        }
		
		copy.current = current;
		copy.first = first;
		copy.last = last;

		return copy;
	}

    private class Node implements Data<E> {
        E data;
        Node prior,
                next;

        public Node (E d) {
            this(d, null, null);
        }


        public Node (E data, Node prior, Node next) {
            this.data = data == null ? null : data;
            this.prior = prior;
            this.next = next;
        }

        public E clone() {
            Node copy;

            try {
                copy = (Node) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new Error("");
            }
            copy.data = this.data;
            copy.prior = prior;
            copy.next = next;
            return (E) copy;
        }

        @Override
        public int compareTo(E o) {
            return 0;
        }
    }
}
