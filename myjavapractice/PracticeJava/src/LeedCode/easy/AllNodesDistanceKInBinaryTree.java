package easy;
import java.util.*;
public class AllNodesDistanceKInBinaryTree{
    static class TreeNode{int val;TreeNode left,right;TreeNode(int val){this.val=val;}}
    public static List<Integer>distanceK(TreeNode root,TreeNode target,int k){
        Map<TreeNode,TreeNode>parent=new HashMap<>();
        dfs(root,null,parent);
        Set<TreeNode>visited=new HashSet<>();
        List<Integer>result=new ArrayList<>();
        bfs(target,k,parent,visited,result);
        return result;
    }
    static void dfs(TreeNode node,TreeNode par,Map<TreeNode,TreeNode>map){
        if(node==null)return;
        map.put(node,par);
        dfs(node.left,node,map);
        dfs(node.right,node,map);
    }
    static void bfs(TreeNode node,int k,Map<TreeNode,TreeNode>parent,Set<TreeNode>visited,List<Integer>res){
        if(node==null||visited.contains(node))return;
        visited.add(node);
        if(k==0){res.add(node.val);return;}
        bfs(node.left,k-1,parent,visited,res);
        bfs(node.right,k-1,parent,visited,res);
        bfs(parent.get(node),k-1,parent,visited,res);
    }
    public static void main(String[]args){System.out.println("Distance K works\n");}
}
