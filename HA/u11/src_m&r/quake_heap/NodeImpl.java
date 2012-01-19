package quake_heap;

import java.util.Vector;

class NodeImpl<K extends Comparable<K>,V> implements Node<K,V> {
	
	private K key;
	private Node<K,V> father;
	private Vector<Node<K,V>> children;
	private TournamentTree<K,V> tree;
	
	public NodeImpl(Node<K,V> child, TournamentTree<K,V> tree) {
		this.father = null;
		addChild(child);
		this.tree = tree;
	}
	
	public NodeImpl(Node<K,V> left_child, Node<K,V> right_child, TournamentTree<K,V> tree) {
		father = null;
		addChild(left_child);
		addChild(right_child);
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
		return children;
	}

	@Override
	public void setChild(int index, Node<K,V> node) throws IllegalArgumentException {
		if (index != 0 || index != 1) {
			throw new IllegalArgumentException("index may only < 2");
		}
		children.set(index, node);
		if (key == null || key.compareTo(node.getKey()) > 0) {
			key = node.getKey();
		}
		node.setFather(this);
		setHeighestKey(this);
	}
	
	@Override
	public void addChild(Node<K,V> node) throws IndexOutOfBoundsException {
		if(children.size() == 2) {
			throw new IndexOutOfBoundsException("Only <= 2 children allowed");
		}
		children.add(node);
		if (key == null || key.compareTo(node.getKey()) > 0) {
			key = node.getKey();
		}
		node.setFather(this);
		setHeighestKey(this);
	}

	@Override
	public boolean removeChild(Node<K,V> child) throws IllegalArgumentException {
		boolean result = children.remove(child);
		setHeighestKey(this);
		return result;
	}

	@Override
	public int getHeight() {
		if (children.size() > 0) {
			return children.get(0).getHeight() + 1;
		}
		return 0;
	}

	@Override
	public void setHeighestKey(Node<K,V> node) {
		if (children.size() > 0) {
			if (children.get(0).getKey().compareTo(key) == 0) {
				children.get(0).setHeighestKey(node);
			} else {
				children.get(1).setHeighestKey(node);
			}
		}
	}

	@Override
	public TournamentTree<K,V> getTree() {
		return tree;
	}
	
}
