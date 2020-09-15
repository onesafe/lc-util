/**
 * Author: 第九代封妖师
 * Date: 2020/09/15
 */
public class UnionFind {
    private final int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i=0; i<n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        parent[rootA] = rootB;
    }

    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}
