package quake_heap;

import java.util.HashSet;
import java.util.Set;

class TournamentTreeImpl<K extends Comparable<K>,V> implements TournamentTree<K,V> {
	
	Node<K,V> root;
	Set<Leaf<K,V>> leafes;
	
	public TournamentTreeImpl(K key, V value) {
		Leaf<K,V> leaf = new LeafImpl<K,V>(key,value,this);
		root = leaf;
		leafes = new HashSet<Leaf<K,V>>();
		leafes.add((Leaf<K,V>)leaf);
	}
	
	private TournamentTreeImpl(TournamentTree<K,V> left_tree, TournamentTree<K,V> right_tree) 
			throws IllegalArgumentException {
		if (left_tree.getDepth() != right_tree.getDepth()) {
			throw new IllegalArgumentException("Trees must be of same height");
		}
		root = new NodeImpl<K,V>(left_tree.getRoot(), right_tree.getRoot(), this);
		leafes.addAll(left_tree.getLeafes());
		leafes.addAll(right_tree.getLeafes());
	}
	
	private TournamentTreeImpl(Node<K,V> root) 
			throws IllegalArgumentException {
		this.root = root;
		root.getFather().removeChild(root);
		root.setFather(null);
	}
	
	@Override
	public TournamentTree<K, V> link(TournamentTree<K, V> tree) 
				throws IllegalArgumentException {
		return new TournamentTreeImpl<K, V>(this, tree);
	}

	@Override
	public TournamentTree<K,V> cut(Node<K,V> node) 
			throws IllegalArgumentException {
		if (node.getTree() != this) {
			throw new IllegalArgumentException("node not part of this tree.");
		}
		
		if (node.getFather() == null) {
			return null;
		}
		if (node.getFather().getKey() == node.getKey()) {
			throw new IllegalArgumentException("node's key and node's father's key must be different.");
		}
		
		return new TournamentTreeImpl<K,V>(node);
	}

	@Override
	public Node<K,V> getRoot() {
		return root;
	}

	@Override
	public int getDepth() {
		return root.getHeight();
	}

	@Override
	public Set<Leaf<K, V>> getLeafes() {
		return leafes;
	}
}
