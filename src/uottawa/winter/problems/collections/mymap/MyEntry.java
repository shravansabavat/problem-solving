package uottawa.winter.problems.collections.mymap;

public class MyEntry<K,V> {
	
	private final K key;
	private V value;
	
	public MyEntry(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public K getKey() {
		return key;
	}
	
	

}
