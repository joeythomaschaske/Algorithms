package Algorithms;

/**
 * Created by josephthomaschaske on 5/31/16.
 */
public class BinaryTreeClass {
    public static void main(String [] args) {
        BinaryTree bt = new BinaryTree();
        bt.insert(40);
        bt.insert(25);
        bt.insert(10);
        bt.insert(32);
        bt.insert(78);
        bt.inorder();
        System.out.println(bt.search(40, bt.root).val);
    }
    public static class BinaryTree {
        Node root;

        public BinaryTree() {

        }

        public void insert(int val) {
            if(root == null){
                root = new Node(val);
            }
            else {
                insert(root, val);
            }
        }

        public void delete(int val) {

        }

        private void delete(int val, Node node) {

        }

        private void insert(Node parent, int val){
            if(parent.left == null && val < parent.val){
                parent.left = new Node(val);
            }
            else if(parent.right == null && val >= parent.val) {
                parent.right = new Node(val);
            }
            else if(val < parent.val) {
                insert(parent.left, val);
            }
            else {
                insert(parent.right, val);
            }
        }

        public void inorder() {
            inorder(root);
        }
        private void inorder(Node node){
            if(node != null){
                inorder(node.left);
                System.out.println(node.val);
                inorder(node.right);
            }
        }

        public Node search(int val, Node node){
            if(node == null) {
                return null;
            }
            else {
                if(val == node.val) {
                    return node;
                }
                else {
                    if(val > node.val) {
                        return search(val, node.right);
                    }
                    else {
                        return search(val, node.left);
                    }
                }

            }
        }
    }
    private static class Node {
        public Node left;
        public Node right;
        public int val;

        public Node(int val){
            this.val = val;
        }
    }
}
