package quake_heap;

import java.util.Set;

interface TournamentTree<K extends Comparable<K>,V> {
	public TournamentTree<K,V> link(TournamentTree<K,V> tree) throws IllegalArgumentException;
	public TournamentTree<K,V> cut(Node<K,V> node) throws IllegalArgumentException;
	public Node<K,V> getRoot();
	public Set<Leaf<K,V>> getLeafes();
	public int getDepth();
}
