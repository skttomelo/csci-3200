package problem4;

public class Map<KeyType, ValueType> {
	public Map() {
		items = new QuadraticProbingHashTable<Entry<KeyType, ValueType>>();
	}
	
	public void put(KeyType key, ValueType val) {
		items.insert(new Entry<>(key, val));
	}
	public ValueType get(KeyType key) {
		Entry<KeyType, ValueType> entry = new Entry<>(key, null);
		if(!items.contains(entry)) {
			return null;
		}
		return items.get(entry).value;
	}
	public boolean isEmpty() {
		return items.size() == 0;
	}
	public void makeEmpty() {
		items.makeEmpty();
	}
	
	private QuadraticProbingHashTable<Entry<KeyType, ValueType>> items;
	
	private static class Entry<KeyType, ValueType>
	{
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Entry other = (Entry) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			return true;
		}
		KeyType key;
		ValueType value;
		//appropriate constructions, etc.
		public Entry(KeyType k, ValueType v) {
			key = k;
			value = v;
		}
	}
}
