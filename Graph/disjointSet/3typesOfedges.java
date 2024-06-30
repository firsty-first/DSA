import java.util.ArrayList;
import java.util.Arrays;

class Disjoint {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();
    int count;

    Disjoint(int n) {
        count = n;
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    int getParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = getParent(parent.get(node));
        parent.set(node, ulp); // Path compression
        return ulp;
    }

    boolean union(int u, int v) {
        int ulp_u = getParent(u);
        int ulp_v = getParent(v);
        if (ulp_u == ulp_v) {
            return false; // They are already in the same set
        }

        if (size.get(ulp_u) > size.get(ulp_v)) {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_u) + size.get(ulp_v));
        }
        count--;
        return true;
    }

    int getCount() {
        return count;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int redundantEdges = 0;
        Disjoint alice = new Disjoint(n);
        Disjoint bob = new Disjoint(n);

        // Sort edges by type in descending order
        Arrays.sort(edges, (x, y) -> y[0] - x[0]);

        for (int[] edge : edges) {
            int type = edge[0];
            int u = edge[1] - 1; // 0-based index
            int v = edge[2] - 1; // 0-based index

            if (type == 3) {
                boolean aliceUnion = alice.union(u, v);
                boolean bobUnion = bob.union(u, v);
                if (!aliceUnion && !bobUnion) {
                    redundantEdges++;
                }
            } else if (type == 1) {
                if (!alice.union(u, v)) {
                    redundantEdges++;
                }
            } else if (type == 2) {
                if (!bob.union(u, v)) {
                    redundantEdges++;
                }
            }
        }

        // If either Alice or Bob doesn't cover all nodes, return -1
        if (alice.getCount() > 1 || bob.getCount() > 1) {
            return -1;
        }

        return redundantEdges;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] edges = {
            {3, 1, 2},
            {3, 2, 3},
            {1, 1, 3},
            {1, 2, 4},
            {1, 1, 2},
            {2, 3, 4}
        };
        int result = solution.maxNumEdgesToRemove(n, edges);
        System.out.println(result);  // Expected output: 2
    }
}
