class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        String res = "1";
        
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int len = res.length();
            
            int count = 1;
            for (int j = 0; j < len; j++) {
                if (j + 1 < len && res.charAt(j) == res.charAt(j + 1)) {
                    count++;
                } else {
                    sb.append(count).append(res.charAt(j));
                    count = 1; 
                }
            }
            res = sb.toString();
        }
        
        return res;
    }
}