package quake_heap;

public interface Heap<K extends Comparable<K>,V> {
	public Node<K,V> insert(K key, V value);
	public void decreaseKey(Node<K,V> v, K k) throws IllegalArgumentException;
	public V deleteMin();
}
