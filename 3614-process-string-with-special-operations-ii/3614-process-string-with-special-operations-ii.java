class Solution {
    public char processStr(String s, long k) {
        long len = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '*' && len > 0)
                len--;
            else if (ch == '#')
                len *= 2;
            else if (ch >= 'a' && ch <= 'z')
                len++;
        }
        
        if (k >= len)
            return '.';
        
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            
            if (ch >= 'a' && ch <= 'z') {
                len--;
                if (k == len)
                    return ch;
            } else if (ch == '*') {
                len++;
            } else if (ch == '#') {
                len /= 2;
                k = k % len;
            } else if (ch == '%') {
                k = len - 1 - k;
            }
        }
        
        return '.';
    }
}