package quake_heap;

import java.util.Vector;

class LeafImpl<K extends Comparable<K>,V> implements Leaf<K,V> {
	
	private K key;
	private V value;
	private Node<K,V> heighestKey, father;
	private TournamentTree<K,V> tree;
	
	public LeafImpl(K key, V value, TournamentTree<K,V> tree) {
		this.key = key;
		this.value = value;
		this.heighestKey = this;
		this.father = null;
		this.tree = tree;
	}
	
	@Override
	public K getKey() {
		return key;
	}

	@Override
	public Node<K,V> getFather() {
		return father;
	}
	
	@Override
	public void setFather(Node<K,V> node) {
		if (father == null) {
			setHeighestKey(node);
		}
		father = node;
	}

	@Override
	public Vector<Node<K,V>> getChildren() {
		return new Vector<Node<K,V>>(0);
	}
	
	@Override
	public void setChild(int index, Node<K,V> node) throws IllegalArgumentException {
		throw new IllegalArgumentException("Leaf can't have no children.");
	}
	
	@Override
	public void addChild(Node<K,V> node) throws IndexOutOfBoundsException {
		throw new IllegalArgumentException("Leaf can't have no children.");
	}
	
	@Override
	public boolean removeChild(Node<K,V> node) throws IndexOutOfBoundsException {
		return false;
	}
	
	@Override
	public int getHeight() {
		return 0;
	}

	@Override
	public V getValue() {
		return value;
	}

	@Override
	public Node<K,V> getHeighestKey() {
		return heighestKey;
	}

	@Override
	public void setHeighestKey(Node<K,V> node) {
		heighestKey = node;
	}

	@Override
	public TournamentTree<K,V> getTree() {
		return tree;
	}
}
