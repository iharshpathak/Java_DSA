package jav.ds.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 28-03-2022
public class BinaryTree {

    private TreeNode root;

    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data; //Generic Type

        public TreeNode(int data){
            this.data =  data;
        }
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(9);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
       // TreeNode fifth = new TreeNode(5);

        root = first; // root ----> first
        first.left = second;
        first.right = third; // second <---- first ----> third

        second.left = fourth; // fourth <---- second ----> fifth
       // second.right = fifth;
    }

    // 28-03-2022 -> Pre - Order Traversal Of A tree ----> NLR -> Root->Left->Right
    public void preOrder(TreeNode root){
        if (root ==  null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 29-03-2022 -> Iterative Pre - Order Traversal Of A tree ----> NLR -> Root->Left->Right
    public void iterativePreOrder(){
        if(root == null)
            return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data+" ");

            if(temp.right != null)
                stack.push(temp.right);
            if(temp.left != null)
                stack.push(temp.left);
        }
    }

    // 31-03-2022 -> In - Order Traversal Of A tree ----> LNR -> Left->Root->Right
    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    // 31-03-2022 -> Iterative In - Order Traversal Of A tree ----> LNR -> Left->Root->Right
    public void iterativeInorder(){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp =root;

        while(!stack.isEmpty() || temp != null){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else{
                temp = stack.pop();
                System.out.print(temp.data+" ");
                temp = temp.right;
            }
        }
    }

    // 1-04-2022 -> Post - Order Traversal Of A tree ----> LRN -> Left->Right->Root
    public void postOrder(TreeNode root){
        if(root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    // 2-04-2022 -> Iterative Post - Order Traversal Of A tree ----> LRN -> Left->Right->Root
    public void iterativePostOrder(){
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        while (current != null || !stack.isEmpty()){
            if (current != null){
                stack.push(current);
                current = current.left;
            }else{
                TreeNode temp = stack.peek().right;
                if(temp ==  null){
                    temp = stack.pop();
                    System.out.println(temp.data+" ");

                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.println(temp.data+" ");
                    }
                }else {
                    current = temp;
                }
            }
        }
    }

    // 3-04-2022 -> iterative Level - Order traversal of a tree (Breadth First Search)
    public void levelOrder(){
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.data+" ");

            if (temp.left != null)
                queue.offer(temp.left);

            if (temp.right != null)
                queue.offer(temp.right);
        }
    }

    // 3-04-2022 Find the Max. Value if a binary tree (Recursive)
    public int findMax(TreeNode root){
        if (root == null)
            return Integer.MIN_VALUE;

        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);

        if (left>result)
            result = left;
        if (right>result)
            result = right;
        return result;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
       // bt.preOrder(bt.root);

       // bt.iterativePreOrder();
       // bt.inOrder(bt.root);
       // bt.iterativeInorder();
       // bt.postOrder(bt.root);
       // bt.iterativeInorder();
       // bt.levelOrder();
        System.out.println(bt.findMax(bt.root));
    }
}
