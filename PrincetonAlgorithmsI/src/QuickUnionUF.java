/*
 * cost model:
 * 
 * initialization: N
 * union: N worst case
 * find: N worst case 
 * 
 */

public class QuickUnionUF {
	private int[] id;
	
	public QuickUnionUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) 
			id[i] = i;
	}
	
	public int root(int i) {
		while (i != id[i]) i = id[i];
		return i;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int rp = root(p);
		int rq = root(q);
		id[rp] = rq;
	}
}
