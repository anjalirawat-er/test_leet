class Solution {
    public boolean hasValidPath(int[][] grid) {
        //BFS
        int[][] map = {{0,-1, 0, 1},{-1, 0, 1,0}, {0, -1, 1, 0}, {0, 1, 1, 0}, {0, -1,-1, 0}, {-1, 0, 0,1}};
        int r = grid.length;
        int c = grid[0].length;
        boolean[][] visited = new boolean[r][c];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int i = grid[x][y];
            int[] next = map[i-1];
            //check 2 possible next cells
            for(int k = 0; k < 2; k++) {
                int xnext = x + next[2*k];
                int ynext = y + next[2*k+1];
                //check eligibility
                if( xnext <0 || xnext >= r || ynext < 0 || ynext >= c ) {
                    continue;
                }
                //if not visited and can be connected, add to queue
                if(!visited[xnext][ynext] && canBeConnected(map, x,y, xnext, ynext, grid)) {
                    q.add(new int[]{xnext, ynext});
                    visited[xnext][ynext] = true;
                }
            }
        }
        return visited[r-1][c-1];
    }
    
    private boolean canBeConnected( int[][] map, int x, int y, int xnext, int ynext, int[][] grid ) {
        int i = grid[xnext][ynext];
        int[] next = map[i-1];
        int xtemp1 = xnext+next[0];
        int ytemp1 = ynext+next[1];
        int xtemp2 = xnext+next[2];
        int ytemp2 = ynext+next[3];
        if(x == xtemp1 && y == ytemp1 || x == xtemp2 && y == ytemp2) {
            return true;
        } else {
            return false;
        }
    }
}