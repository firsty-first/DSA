package Graph.Unionfind;

import java.util.ArrayList;

class Disjoint {
  ArrayList<Integer> parent = new ArrayList<>();
  ArrayList<Integer> rank = new ArrayList<>();

  Disjoint(int n) {
      for (int i = 0; i < n; i++) {
          rank.add(0);
          parent.add(i);
      }
  }

  public int findParent(int node) {
      if (parent.get(node) == node)
          return node;
      int ulp = findParent(parent.get(node));
      parent.set(node, ulp);
      return ulp;
  }

  public void unionRank(int u, int v) {
      int ulpU = findParent(u);
      int ulpV = findParent(v);
      
      if (ulpU == ulpV)
          return;
      
      if (rank.get(ulpU) > rank.get(ulpV)) {
          parent.set(ulpV, ulpU);
      } else if (rank.get(ulpU) < rank.get(ulpV)) {
          parent.set(ulpU, ulpV);
      } else {
          parent.set(ulpV, ulpU); // Attach tree of ulpV to ulpU
          rank.set(ulpU, rank.get(ulpU) + 1); // Increment rank of ulpU 
          //as both are of equal rank jisme add kernge uska rank will increase
      }
  }
}

class Unionfind {
  public static void main(String[] args) {
      Disjoint disjoint = new Disjoint(12);
      disjoint.unionRank(1, 2);
      disjoint.unionRank(2, 3);
      disjoint.unionRank(4, 5);
      disjoint.unionRank(6, 7);
      disjoint.unionRank(5, 6);
      
      if (disjoint.findParent(3) == disjoint.findParent(1))
          System.out.println("same");
      else
          System.out.println("different");
  }
}
