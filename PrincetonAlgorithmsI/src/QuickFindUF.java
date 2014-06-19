/*
 * quick-find cost model:
 * 
 * initialization: N
 * union: N
 * find: 1 
 *
 */

public class QuickFindUF {
	private int[] id;
	
	public QuickFindUF(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) 
			id[i] = i;
	}
	
	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}
	
	public void union(int p, int q) {
		int pid = id[p];
		int qid = id[q];
		
		for (int i = 0; i < id.length; i++) 
			if (id[i] == pid) id[i] = qid;
	}
	
	public void printAll() {
		if (id == null) return;
		for (int i = 0; i < id.length; i++) 
			System.out.print(id[i] + " ");
	}
	
	public static void main(String[] args) {
		QuickFindUF x = new QuickFindUF(10);
		x.union(5,6);
		x.union(0,9);
		x.union(4,2);
		x.union(7,9);
		x.union(9,3);
		x.union(7,1);
		x.printAll();
	}
}
