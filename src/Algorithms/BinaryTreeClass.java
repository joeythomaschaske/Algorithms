package Algorithms;

import java.util.TreeMap;

/**
 * Created by josephthomaschaske on 5/31/16.
 */
public class BinaryTreeClass {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        bt.insert(50);
        bt.insert(55);
        bt.insert(30);
        bt.insert(35);
        bt.insert(49);
        bt.insert(47);
        bt.insert(46);
        bt.insert(48);
        bt.inorder();
        System.out.println();

        bt.delete(50);
        bt.inorder();
        System.out.println();

        bt.delete(49);
        bt.inorder();
        System.out.println();

        bt.delete(48);
        bt.inorder();
        System.out.println();

        bt.delete(47);
        bt.inorder();
        System.out.println();

        bt.delete(46);
        bt.inorder();
        System.out.println();

        bt.delete(35);
        bt.inorder();
        System.out.println();

        bt.delete(30);
        bt.inorder();
        System.out.println();

        bt.delete(55);
        bt.inorder();
        System.out.println();


        bt.insert(50);
        bt.insert(45);
        bt.insert(70);
        bt.insert(65);
        bt.insert(59);
        bt.insert(62);
        bt.insert(61);
        bt.insert(63);
        bt.inorder();
        System.out.println();

        bt.delete(50);
        bt.inorder();
        System.out.println();

        bt.delete(70);
        bt.inorder();
        System.out.println();

        bt.delete(65);
        bt.inorder();
        System.out.println();

        bt.delete(59);
        bt.inorder();
        System.out.println();

        bt.delete(62);
        bt.inorder();
        System.out.println();

        bt.delete(61);
        bt.inorder();
        System.out.println();

        bt.delete(63);
        bt.inorder();
        System.out.println();

        bt.delete(45);
        bt.inorder();
        System.out.println();
    }

    public static class BinaryTree {
        Node root;

        public BinaryTree() {

        }

        public void insert(int val) {
            if (root == null) {
                root = new Node(val);
            } else {
                insert(root, val);
            }
        }

        private void insert(Node parent, int val) {
            if (parent.left == null && val < parent.val) {
                parent.left = new Node(val);
                parent.left.parent = parent;
            } else if (parent.right == null && val >= parent.val) {
                parent.right = new Node(val);
                parent.right.parent = parent;
            } else if (val < parent.val) {
                insert(parent.left, val);
            } else {
                insert(parent.right, val);
            }
        }

        /**
         * the public method that is accessible for deletion
         *
         * @param val the value to be removed from the BST
         * @return the node with the specified value
         */
        public Node delete(int val) {
            return delete(val, root);
        }

        /**
         * private helper method for the public delete method.
         *
         * @param val  the value to be searched and removed
         * @param node the current node we are checking to see if it has the same value as the val param
         * @return the node that we are removing
         */
        private Node delete(int val, Node node) {
            if (search(val) == null) { //search to see if the value exists in the BST
                return null;
            } else {
                if (val < node.val) {
                    return delete(val, node.left);
                } else if (val > node.val) {
                    return delete(val, node.right);
                } else {
                    //node is a leaf
                    if (node.left == null && node.right == null) {
                        deleteLeafNode(node);
                    }
                    //node has one child
                    else if ((node.left != null && node.right == null) || (node.left == null && node.right != null)) {
                        deleteSingleChildNode(node);
                    }
                    //node has 2 children
                    else {
                        deleteTwoChildNode(node);
                    }
                    return node;
                }
            }
        }

        /**
         * detaches a node from its parent
         *
         * @param node the node to be detached from its parent
         */
        private void deleteLeafNode(Node node) {
            detach(node);
        }

        /**
         * removes a node from the BST that has a single child. The node might have a right child or left child
         * if it has a left child it is replaced by its predecessor. If the predecessor has a child it will be relinked
         * if it has a right child it is replaced bu its successor. If the successor has a child it will be relinked
         *
         * @param node the node to be deleted
         */
        private void deleteSingleChildNode(Node node) {
            if (node.left != null) {
                Node predecessor = getPredecessor(node);
                if (predecessor.left != null) {
                    //relink the predecessor's child to its parent
                    predecessor.parent.right = predecessor.left;
                    predecessor.left.parent = predecessor.parent;
                    //replace the current node with the predecessor
                    node.left.parent = predecessor;
                    if (predecessor != node.left) { //will cause the predecessor to point to itself. Infinite loop
                        predecessor.left = node.left;
                    }
                    predecessor.parent = node.parent;
                } else {
                    //just
                    node.left.parent = predecessor;
                    predecessor.parent.right = null;
                    if (node.left != predecessor) { //will cause the predecessor to point to itself. Infinite loop
                        predecessor.left = node.left;
                    }
                    predecessor.parent = node.parent;
                }
                detach(node, predecessor);
            }
            //node has a right branch
            else {
                Node successor = getSuccessor(node);
                if (successor.right != null) {
                    //relink the predecessor's child to its parent
                    successor.parent.left = successor.right;
                    successor.right.parent = successor.parent;
                    //replace the current node with the successor
                    node.right.parent = successor;
                    if (node.right != successor) { //will cause the successor to point to itself. Infinite loop
                        successor.right = node.right;
                    }
                    successor.parent = node.parent;
                } else {
                    node.right.parent = successor;
                    successor.parent.left = null;
                    if (node.right != successor) { //will cause the successor to point to itself. Infinite loop
                        successor.right = node.right;
                    }
                    successor.parent = node.parent;
                }
                detach(node, successor);
            }
        }

        /**
         * removes a node from the BST that has two children.
         * we replace the node with its predecessor. If the predecessor has a child it will be relinked
         *
         * @param node the node to be deleted
         */
        private void deleteTwoChildNode(Node node) {
            //we can choose to either replace with the successor or predecessor. Just go with predecessor
            Node predecessor = getPredecessor(node);
            if (predecessor.left != null) {
                //relink the predecessor's child to its parent
                predecessor.parent.right = predecessor.left;
                predecessor.left.parent = predecessor.parent;
                //replace the current node with the predecessor
                node.left.parent = predecessor;
                if (node.left != predecessor) {
                    predecessor.left = node.left;
                }
                predecessor.parent = node.parent;
            } else {
                node.left.parent = predecessor;
                predecessor.parent.right = null;
                if (predecessor != node.left) { //will cause the predecessor to point to itself. Infinite loop
                    predecessor.left = node.left;
                }
                predecessor.parent = node.parent;
            }
            if (predecessor != node.left) { //will cause the predecessor to point to itself. Infinite loop
                predecessor.left = node.left;
            }
            predecessor.right = node.right;
            node.left.parent = predecessor;
            node.right.parent = predecessor;
            detach(node, predecessor);
        }

        /**
         * detached a node from its parent
         *
         * @param node the node to be detached
         */
        private void detach(Node node) {
            if (node != root) {
                if (node.parent.left == node) {
                    node.parent.left = null;
                } else {
                    node.parent.right = null;
                }
            } else {
                root = null;
            }
        }

        /**
         * detaches a node from its parent. Replaces the parents child with the replacement node
         *
         * @param current     the current node to be removed
         * @param replacement the replacement node to replace the current node
         */
        private void detach(Node current, Node replacement) {
            if (current != root) {
                if (current.parent.left == current) {
                    current.parent.left = replacement;
                } else {
                    current.parent.right = replacement;
                }
            } else {
                root = replacement;
                root.parent = null;
            }
        }

        /**
         * returns the successor of a node
         *
         * @param node the node we want to produce a successor of
         * @return the successor
         */
        private Node getSuccessor(Node node) {
            Node successor = node;
            if (successor.right != null) {
                successor = successor.right;
                while (successor.left != null) {
                    successor = successor.left;
                }
            } else {
                successor = null;
            }
            return successor;
        }

        /**
         * returns a predecessor of a node
         *
         * @param node the node we want to produce a predecessor of
         * @return the predecessor
         */
        private Node getPredecessor(Node node) {
            Node predecessor = node;
            if (predecessor.left != null) {
                predecessor = predecessor.left;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
            } else {
                predecessor = null;
            }
            return predecessor;
        }

        public void inorder() {
            if (root != null) {
                inorder(root);
            } else {
                System.out.println("Empty");
            }
        }

        private void inorder(Node node) {
            if (node != null) {
                inorder(node.left);
                System.out.println(node.val);
                inorder(node.right);
            }
        }

        public Node search(int val) {
            return search(val, root);
        }

        public Node search(int val, Node node) {
            if (node == null) {
                return null;
            } else {
                if (val == node.val) {
                    return node;
                } else {
                    if (val > node.val) {
                        return search(val, node.right);
                    } else {
                        return search(val, node.left);
                    }
                }

            }
        }
    }

    private static class Node {
        public Node left;
        public Node right;
        public Node parent;
        public int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
