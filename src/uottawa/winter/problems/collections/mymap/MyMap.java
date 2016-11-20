package uottawa.winter.problems.collections.mymap;

import java.util.Map;

public class MyMap<K,V> {

	private static final int DEFALT_MAP_CAPACITY = 16;
	int size = 0;
	MyEntry<K,V>[] entries = new MyEntry[DEFALT_MAP_CAPACITY];

	private void put(K key, V value){
		Boolean insert = true;
		int hash = key.hashCode();
		for(MyEntry<K, V> entry : entries){
			if(entry.getKey().hashCode() == hash){
				if(entry.getKey().equals(key)){
					entry.setValue(value);
					insert  = false;
				}
			}
		}
		if(insert){
			ensureCapacity();
			entries[size++] = new MyEntry<K, V>(key, value);
		}

	}

	private void ensureCapacity() {
		// TODO Auto-generated method stub
		if(entries.length == DEFALT_MAP_CAPACITY){
			
		}
		
	}

	/**
	          * Applies a supplemental hash function to a given hashCode, which
	          * defends against poor quality hash functions.  This is critical
	          * because HashMap uses power-of-two length hash tables, that
	          * otherwise encounter collisions for hashCodes that do not differ
	          * in lower bits. Note: Null keys always map to hash 0, thus index 0.
	          */
	static int hash(int h) {
		// This function ensures that hashCodes that differ only by
		// constant multiples at each bit position have a bounded
		// number of collisions (approximately 8 at default load factor).
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

}
