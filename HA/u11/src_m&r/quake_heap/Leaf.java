package quake_heap;

interface Leaf<K extends Comparable<K>,V> extends Node<K,V> {
	public V getValue();
	public Node<K,V> getHeighestKey();
}
