package kasia90;

import java.util.*;

public class Solution {
 
  private Map<Integer, List<Integer>> maph = new HashMap<>();

  private boolean[] hadSearched;

  public int countAllComponents(int n, int[][] edges) {
    if (n < 1) {
      return 0;
    }
    hadSearched = new boolean[n];
    for (int i = 0; i < n; i++) {
      maph.put(i, new LinkedList<>());
    }

    for (int i = 0; i < edges.length; i++) {
      maph.get(edges[i][0]).add(edges[i][1]);
      maph.get(edges[i][1]).add(edges[i][0]);
    }

    int count = 0;

    for (int i = 0; i < n; i++) {
      if (!hadSearched[i]) {
        dfs(i);
        count++;
      }
    }
    return (count - 1) / 2;
  }

  private void dfs(int i) {
    for (Integer nextint : maph.get(i)) {
      if (!hadSearched[nextint]) {
        hadSearched[nextint] = true;
        dfs(nextint);
      }
    }
  }

  public static void main(String[] args) {

    int[][] multi =
        new int[][] {
          {0, 1}, {1, 2}, {2, 3}, {3, 4}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {15, 16}, {18, 19},
          {19, 20}, {22, 23}, {24, 25}, {25, 26}, {26, 27}, {29, 30}, {32, 33},{35,36}
        };

    Scanner scan = new Scanner(System.in);
    System.out.println("Give n  the number one greater than the last vertex number");
    int n = scan.nextInt();
    Solution sol = new Solution();
    System.out.println("separated graphs" + " " + sol.countAllComponents(n, multi));
  }
}
