import java.util.Stack;
import java.util.LinkedList;

public class TreeTraversal {

  // A binary tree node
  static class Node {
      int data;
      Node left, right;
      Node(int item) {
          data = item;
          left = right = null;
      }
  }

  Node root;

  // http://www.geeksforgeeks.org/iterative-preorder-traversal/
  // 10 8 3 5 2 2
  void preorder() {
    System.out.println("PreOrder");
    preorder(root);
    System.out.println("");
    iterativePreorder(root);
    System.out.println("");
  }

  void preorder(Node node) {
    System.out.print(node.data + " ");
    if(node.left != null) preorder(node.left);
    if(node.right != null) preorder(node.right);
  }

  void iterativePreorder(Node node) {
    Stack<Node> stack = new Stack<>();
    stack.push(node);

    while(!stack.isEmpty()) {
      node = stack.pop();
      System.out.print(node.data + " ");

      if(node.right != null) stack.push(node.right);
      if(node.left != null) stack.push(node.left);
    }
  }

  // http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
  void inorder() {
    System.out.println("InOrder");
    inorder(root);
    System.out.println("");
    iterativeInorder(root);
    System.out.println("");
  }

  void inorder(Node node) {
    if(node.left != null) inorder(node.left);
    System.out.print(node.data + " ");
    if(node.right != null) inorder(node.right);
  }

  void iterativeInorder(Node node) {
    Stack<Node> stack = new Stack<>();
    while(node != null) {
      stack.push(node);
      node = node.left;
    }

    while(!stack.isEmpty()) {
      node = stack.pop();
      System.out.print(node.data + " ");

      if(node.right != null) {
        node = node.right;
        while(node != null) {
          stack.push(node);
          node = node.left;
        }
      }
    }
  }

  // http://www.geeksforgeeks.org/iterative-postorder-traversal/
  void postorder() {
    System.out.println("PostOrder");
    postorder(root);
    System.out.println("");
    iterativePostorder(root);
    System.out.println("");
  }

  void postorder(Node node) {
    if(node.left != null) postorder(node.left);
    if(node.right != null) postorder(node.right);
    System.out.print(node.data + " ");
  }

  void iterativePostorder(Node node) {
    Stack<Node> stack1 = new Stack<>();
    Stack<Node> stack2 = new Stack<>();

    stack1.push(node);
    while(!stack1.isEmpty()) {
      node = stack1.pop();
      stack2.push(node);

      if(node.left != null) stack1.push(node.left);
      if(node.right != null) stack1.push(node.right);
    }

    while(!stack2.isEmpty()) {
      node = stack2.pop();
      System.out.print(node.data + " ");
    }
  }

  void levelorder() {
    System.out.println("LevelOrder");
    levelorder(root);
    System.out.println("");
  }

  void levelorder(Node node) {
    LinkedList<Node> queue = new LinkedList<>();
    queue.offer(node);

    while(!queue.isEmpty()) {
      node = queue.poll();
      System.out.print(node.data  + " ");

      if(node.left != null) queue.offer(node.left);
      if(node.right != null) queue.offer(node.right);
    }
  }


/**
      10
    8   2
  3  5 2
*/
  public static void main(String[] args) {
    TreeTraversal tree = new TreeTraversal();
    tree.root = new Node(10);
    tree.root.left = new Node(8);
    tree.root.right = new Node(2);
    tree.root.left.left = new Node(3);
    tree.root.left.right = new Node(5);
    tree.root.right.left = new Node(2);
    tree.preorder();
    tree.inorder();
    tree.postorder();
    tree.levelorder();

  }
}
