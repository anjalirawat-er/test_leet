class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invoc) {
        HashSet<Integer> sus = new HashSet<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        ArrayList<ArrayList<Integer>> incoming = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            incoming.add(new ArrayList<>());
        }

        for (int[] edge : invoc) {
            graph.get(edge[0]).add(edge[1]);
            incoming.get(edge[1]).add(edge[0]);
        }

        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(k);
        sus.add(k);

        while (!queue.isEmpty()) {
            int curr = queue.removeFirst();

            for (int next : graph.get(curr)) {
                if (!sus.contains(next)) {
                    sus.add(next);
                    queue.addLast(next);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        boolean invalid = false;

        for (int i = 0; i < n; i++) {
            if (sus.contains(i)) {
                for (int parent : incoming.get(i)) {
                    if (!sus.contains(parent)) {
                        invalid = true;
                        break;
                    }
                }

                if (invalid) break;
            } else {
                ans.add(i);
            }
        }

        if (invalid) {
            ans.clear();
            for (int i = 0; i < n; i++) {
                ans.add(i);
            }
        }

        return ans;
    }
}