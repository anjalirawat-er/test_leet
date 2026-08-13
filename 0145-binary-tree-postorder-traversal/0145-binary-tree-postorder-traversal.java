public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack();
        List<Integer> ans = new ArrayList<Integer>();
        TreeNode cur = root;
        
        while (cur != null || !s.empty()) {
            while (!isLeaf(cur)) {
                s.push(cur);
                cur = cur.left;
            }
            
            if (cur != null) ans.add(cur.val);
            
            while (!s.empty() && cur == s.peek().right) {
                cur = s.pop();
                ans.add(cur.val);
            }
            
            if (s.empty()) cur = null; else cur = s.peek().right;
        }
        
        return ans;
    }
    
    private boolean isLeaf(TreeNode r) {
        if (r == null) return true;
        return r.left == null && r.right == null;
    }
}