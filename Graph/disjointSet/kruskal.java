package Graph.MST;

import java.util.ArrayList;
import java.util.Collections;

class Disjoint {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> size = new ArrayList<>();

    Disjoint(int n) {
        for (int i = 0; i < n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    int findUPar(int node) {
        if (node == parent.get(node))
            return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    void unionBySize(int u, int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_u == ulp_v)
            return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            // add u to v, therefore parent of u will change
            parent.set(ulp_u, ulp_v);
            int newSize = size.get(ulp_v) + size.get(ulp_u);
            size.set(ulp_v, newSize);
        } else {
            parent.set(ulp_v, ulp_u);
            int newSize = size.get(ulp_v) + size.get(ulp_u);
            size.set(ulp_u, newSize);
        }
    }
}

class Edges {
    int src, dest, weight;

    Edges(int weight, int src, int dest) {
        this.weight = weight;
        this.src = src;
        this.dest = dest;
    }
}

public class kruskal {
    Disjoint ds;

    kruskal(int n) {
        ds = new Disjoint(n);
    }

    int MST(ArrayList<Edges> adj, int n) {
        int ans = 0;
        Collections.sort(adj, (x, y) -> x.weight - y.weight);
        for (Edges edge : adj) {
            int u = edge.src;
            int v = edge.dest;
            int wt = edge.weight;
            if (ds.findUPar(u) != ds.findUPar(v)) {
                ds.unionBySize(u, v);
                ans += wt;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 9; // number of vertices
        ArrayList<Edges> adj = new ArrayList<>();

        // adding edges to the graph
        adj.add(new Edges(1,1,4));
        adj.add(new Edges(2,1,2));
        adj.add(new Edges(3,2,3));
        adj.add(new Edges(3,2,4));
        adj.add(new Edges(4,1,5));
              adj.add(new Edges(5,3,4));
                            adj.add(new Edges(7,2,6));
                                          adj.add(new Edges(8,3,6));
                                                        adj.add(new Edges(9,4,5));

        // creating an instance of kruskal class
        kruskal k = new kruskal(n);
        
        // calculating the MST
        int mst_weight = k.MST(adj, n);

        // printing the result
        System.out.println("Weight of the Minimum Spanning Tree is: " + mst_weight);
    }
}
