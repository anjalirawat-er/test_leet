import java.util.*;

public class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        TreeSet<Integer> uniqueCosts = new TreeSet<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            adj[u].add(new int[]{v, cost});
            uniqueCosts.add(cost);
        }
        
        int[] inDegree = new int[n];
        for (int[] edge : edges) {
            inDegree[edge[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> topoOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            topoOrder.add(curr);
            for (int[] neighbor : adj[curr]) {
                int v = neighbor[0];
                if (--inDegree[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        

        List<Integer> costs = new ArrayList<>(uniqueCosts);
        
        int low = 0;
        int high = costs.size() - 1;
        int ans = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int targetMinCost = costs.get(mid);
            
            if (isValidPathPossible(targetMinCost, n, topoOrder, adj, online, k)) {
                ans = targetMinCost;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return ans;
    }
    
    private boolean isValidPathPossible(int minCostThreshold, int n, List<Integer> topoOrder, 
                                        List<int[]>[] adj, boolean[] online, long k) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        for (int u : topoOrder) {
            if (dist[u] == Long.MAX_VALUE || !online[u]) {
                continue;
            }
            
            for (int[] edge : adj[u]) {
                int v = edge[0];
                int cost = edge[1];
                
                if (cost < minCostThreshold || !online[v]) {
                    continue;
                }
                
                if (dist[u] + cost < dist[v]) {
                    dist[v] = dist[u] + cost;
                }
            }
        }
        
        return dist[n - 1] <= k;
    }
}