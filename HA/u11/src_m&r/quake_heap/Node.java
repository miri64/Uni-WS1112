package quake_heap;

import java.util.Vector;

public interface Node<K extends Comparable<K>,V> {
	public K getKey();
	public TournamentTree<K,V> getTree();
	public Node<K,V> getFather();
	public void setFather(Node<K,V> node);
	public Vector<Node<K,V>> getChildren();
	public void setChild(int index, Node<K,V> node) throws IllegalArgumentException;
	public void addChild(Node<K,V> node) throws IndexOutOfBoundsException;
	public boolean removeChild(Node<K,V> child);
	public int getHeight();
	void setHeighestKey(Node<K,V> node);
}
