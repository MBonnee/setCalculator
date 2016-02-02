package assignment2;

import java.util.Random;

public class Set<E extends Data> implements SetInterface {

	private List<E> objects;

	public Set() {
		objects = new List<>();
	}
	
	public void init() {
		objects = new List<>();
	}

    public void addObject(Data e) {
        if (this.containsObject(e)) {
            return;
        }
        objects.insert(e);
	}
	
	public E getObject() {
        if (objects.size() == 0) {
            return null;
        }
        List<E> clone = objects.clone();

        for (int i = randInt(0, objects.size() - 1); i > 0; i--) {
            clone.goToNext();
        }

		return clone.retrieve();
	}
	
	public void removeObject(Data e) {
		while (objects.retrieve() != e) {
            objects.goToNext();
        }
        objects.remove();
	}
	
	public boolean isEmpty() {
		return objects.size() == 0;
	}
	
	public int size() {
		return objects.size();
	}
	
	public Set complement(Set c) {
        Set copy = this.clone();
		Set result = new Set();
        copy.objects.goToFirst();
		
		for(int i = 0; i < copy.size(); i++) {
			Data data = copy.objects.retrieve();
            copy.objects.goToNext();
			
			if(!c.containsObject(data)) {
                result.addObject(data);
			}
		}

		return result;
	}
	
	public Set intersection(Set c) {
        Set copy = this.clone();
		Set result = new Set();
        copy.objects.goToFirst();

		for(int i = 0; i < copy.size(); i ++) {
			Data data = copy.objects.retrieve();
            copy.objects.goToNext();

			if(c.containsObject(data)) {
				result.addObject(data);
			}
		}
		return result;
	}
	
	public Set union(Set c) {
        Set copy = this.clone();
        Set result = new Set();

        copy.objects.goToFirst();
        c.objects.goToFirst();

        for(int i = 0; i < copy.size(); i++) {
            result.addObject(copy.objects.retrieve());
            copy.objects.goToNext();
        }

		for(int i = 0; i < c.size(); i++) {
			result.addObject(c.objects.retrieve());
            c.objects.goToNext();
		}
		return result;
	}
	
	public Set symmetricDifference(Set c) {
        Set copy = this.clone();
		Set result;
		Set intersection = copy.intersection(c);
        Set union = copy.union(c);
        result = union.complement(intersection);
		return result;
	}
	
	private int randInt(int min, int max) {
		if(min - max != 0) {
		    Random rand = new Random();
		    return rand.nextInt((max - min) + 1) + min;
		} else {
			return 0;
		}
	}
	
	private boolean containsObject(Data data) {
        return this.objects.find(data);
	}
	
	public Set clone(){
		Set copy;
		
		try{
			copy = (Set) super.clone(); 
		} catch(CloneNotSupportedException e){
			throw new Error("");
		}
        copy.objects = objects.clone();

		return copy;
	}

    public String toString() {
        objects.goToFirst();

        StringBuffer stringBuffer = new StringBuffer();
        if (objects.isEmpty()) {
            stringBuffer.append("");
            return stringBuffer.toString();
        }
        stringBuffer.append(objects.retrieve().toString());
        while (objects.goToNext()) {
            stringBuffer.append(' ');
            stringBuffer.append(objects.retrieve().toString());
        }
        return stringBuffer.toString();
    }
}
