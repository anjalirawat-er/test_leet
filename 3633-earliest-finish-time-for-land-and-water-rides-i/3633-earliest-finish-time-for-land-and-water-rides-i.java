class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int res = Integer.MAX_VALUE;
        int n = landStartTime.length;
        int m = waterStartTime.length;

        for (int i = 0; i < n; i++) {
            int a = landStartTime[i]; 
            int d = landDuration[i]; 

            for (int j = 0; j < m; j++) {
                int b = waterStartTime[j]; 
                int e = waterDuration[j]; 

                int landEnd = a + d;
                int startWater = Math.max(landEnd, b); 
                int finish1 = startWater + e;

                int waterEnd = b + e;
                int startLand = Math.max(waterEnd, a); 
                int finish2 = startLand + d;

                res = Math.min(res, Math.min(finish1, finish2));
            }
        }

        return res;
    }
}