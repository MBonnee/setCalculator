package assignment2;

public class Table<K extends Identifier, V extends Set> implements TableInterface<K, V>{

    private List<Mapping> table;
    private int numberOfMappings;

    public Table() {
        table = new List<>();
        numberOfMappings = 0;
    }

	public void init() {
        table = new List<>();
        numberOfMappings = 0;
	}

	@Override
	public void addEntry(K key, V value) {
        Mapping map = new Mapping(key, value);

        if (this.containsKey(key)) {
            table.find(map);
            table.remove();
            table.insert(map);
            numberOfMappings++;
        } else {
            table.insert(map);
            numberOfMappings++;
        }
	}

	@Override
	public void removeEntry(K key) {
        Mapping map = new Mapping(key);

        if (this.containsKey(key)) {
            table.find(map);
            table.remove();
            numberOfMappings--;
        }
    }

	@Override
	public V getValue(K key) {
        Mapping map = new Mapping(key);

        if (this.containsKey(key)) {
            table.find(map);
            map = table.retrieve();
            return map.value;
        }
		return null;
	}

	@Override
	public int size() {
		return numberOfMappings;
	}

	@Override
	public boolean isEmpty() {
		return numberOfMappings == 0;
	}

	@Override
	public boolean containsKey(K key) {
        Mapping map = new Mapping(key);
        return table.find(map);
    }

    @Override
    public Table<K, V> clone() {
        Table copy;

        try{
            copy = (Table) super.clone();
        } catch(CloneNotSupportedException e){
            throw new Error("");
        }

        copy.table = new List<Mapping>();

        Mapping map;
        for(int i = 0; i < this.size(); i ++){
            map = table.retrieve();
            copy.addEntry(map.key, map.value);
            table.goToNext();
        }

        return copy;
    }

    private class Mapping implements Data<Mapping> {

        private K key;
        private V value;

        Mapping (K key, V value) {
            this.key = key;
            this.value = value;
        }

        Mapping (K key) {
            this(key, null);
        }

        @Override
        public Mapping clone() {
            Mapping copy;

            try{
                copy = (Mapping) super.clone();
            } catch(CloneNotSupportedException e){
                throw new Error("");
            }

            copy.key = this.key;
            copy.value = this.value;

            return copy;
        }

        @Override
        public int compareTo(Mapping o) { // Compare on key level
            return o.key.compareTo(this.key);
        }
    }


}
