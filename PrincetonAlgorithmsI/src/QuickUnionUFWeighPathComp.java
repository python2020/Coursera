/*
 * M union-find: O(N+Mlg^*N)
 * 
 * 
 */

public class QuickUnionUFWeighPathComp {
	private int[] id;
	private int[] sz;
	
	public QuickUnionUFWeighPathComp(int N) {
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) { 
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public int root(int i) {
		while (i != id[i]) {
			id[i] = id[id[i]]; // !
			i = id[i];
		}
		return i;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int rp = root(p);
		int rq = root(q);
		
		if (rp == rq) return;
		
		int total = sz[rp] + sz[rq];
		if (sz[rp] < sz[rq]) { 
			id[rp] = id[rq]; 
			sz[rq] = total;
		} else { 
			id[rq] = id[rp]; 
			sz[rp] = total;
		}
	}
	
	public void printAll() {
		if (id == null) return;
		for (int i = 0; i < id.length; i++) 
			System.out.print(id[i] + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		QuickUnionUFWeighPathComp x = new QuickUnionUFWeighPathComp(10);
		
		x.union(3, 1); x.printAll();
		x.union(1, 0); x.printAll();
		x.union(0, 5); x.printAll();
		x.union(3, 7); x.printAll();
		x.union(8, 4); x.printAll();
		x.union(9, 2); x.printAll();
		x.union(9, 4); x.printAll();
		x.union(8, 0); x.printAll();
		x.union(0, 6); x.printAll();
	}
}
