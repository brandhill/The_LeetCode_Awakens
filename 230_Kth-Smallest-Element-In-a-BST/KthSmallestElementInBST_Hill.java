/**
 * Created by hill on 20/11/2016.
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Time : O(n)
 * Space: O(1)
 *
 * 解題思路:
 * 用 InOrder 的方式來尋訪節點，第 k 個就是答案
 *
 *
 *
 */
public class KthSmallestElementInBST {

    int count = 0;
    int current = 0;

    public int kthSmallest(TreeNode root, int k) {
        inOrderTraversal(root,k);
        return current;
    }

    public void inOrderTraversal(TreeNode root, int k){
        if(count==k){
            return;
        }else{
            if(root.left!=null){
                inOrderTraversal(root.left, k);
            }

            if(count==k) return; //break after already found kth smallest.

            count++;
            if(count==k){
                current = root.val;
                return;
            }

            if(root.right!=null){
                inOrderTraversal(root.right, k);
            }
        }
    }

}