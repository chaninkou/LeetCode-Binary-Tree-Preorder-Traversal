package preorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversalFunction {
	// Recursive way
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        dfs(result, root);
        
        return result;
    }
    
    private void dfs(List<Integer> result, TreeNode root){
        
        if(root == null){
            return;
        }
        
        result.add(root.val);
        
        dfs(result, root.left);
        
        dfs(result, root.right);
    }
    
    // Iterative way
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        Stack<TreeNode> stack = new Stack<>();
        
        if(root == null){
            return result;
        }
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode dummy = stack.pop();
            
            result.add(dummy.val);
            
            if(dummy.right != null){
                stack.push(dummy.right);
            }
            
            if(dummy.left != null){
                stack.push(dummy.left);
            }
            
        }
        
        return result;
    }
}
