package quake_heap;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class QuakeHeap<K extends Comparable<K>,V> implements Heap<K,V> {
	
	Set<TournamentTree<K,V>> forest;
	Map<Integer,Vector<TournamentTree<K,V>>> T;
	Map<Integer,Integer> n;
	
	public QuakeHeap() {
		forest = new HashSet<TournamentTree<K,V>>();
		T = new HashMap<Integer,Vector<TournamentTree<K,V>>>();
		n = new HashMap<Integer,Integer>();
	}
	
	@Override
	public Node<K,V> insert(K key, V value) {
		TournamentTree<K,V> t = new TournamentTreeImpl<K,V>(key,value);
		forest.add(t);
		if (!T.keySet().contains(0)) {
			T.put(0, new Vector<TournamentTree<K, V>>());
		}
		T.get(0).add(t);
		n.put(0,n.get(0)+1);
		return t.getRoot();
	}

	@Override
	public void decreaseKey(Node<K,V> v, K k) throws IllegalArgumentException {
		if (!forest.contains(v.getTree())) {
			throw new IllegalArgumentException("v is not part of this heap.");
		}
		if (v.getKey().compareTo(k) > 0) {
			throw new IllegalArgumentException("k is bigger than the key in v.");
		}
		if (v.getKey().compareTo(k) == 0) {
			// wenn Schlüssel nicht verändert wird bleibt nichts zu tun.
			return;
		}
		Node<K,V> u = ((Leaf<K,V>)v).getHeighestKey();
		TournamentTree<K,V> T_ = u.getTree().cut(u);
		forest.add(T_);
		Integer i = T_.getDepth();
		if (!T.keySet().contains(i)) {
			T.put(i, new Vector<TournamentTree<K, V>>());
		}
		T.get(i).add(T_);
	}
	
	private void consolidate() {
		for (Vector<TournamentTree<K,V>> t : T.values()) {
			while (t.size() > 1) {
				TournamentTree<K,V> T_1 = t.remove(0);
				TournamentTree<K,V> T_2 = t.remove(0);
				TournamentTree<K,V> T_ = T_1.link(T_2);
				T.get(T_.getDepth()).add(T_);
			}
		}
	}
	
	private void quake() {
		for (Integer i : n.keySet()) {
			if (n.get(i+1) < 3/4 * n.get(i)) {
				for (Integer j = i+1; j <= Collections.max(T.keySet()); j++) {
					if (T.containsKey(j)) {
						// Lösche Knoten mit Höhe > i
					}
				}
			}
		}
	}
	
	@Override
	public V deleteMin() {
		Node<K,V> min = ((TournamentTree<K,V>)(forest.toArray()[0])).getRoot();
		for (TournamentTree<K,V> t : forest) {
			Node<K,V> k_t = t.getRoot();
			if (k_t.getKey().compareTo(min.getKey()) < 0) {
				min = k_t;
			}
		}
		// Lösche Pfad von Wurzel min zu Blatt
		consolidate();
		quake();
		return null; // ((Leaf<K,V>)min).getValue()
	}

}
