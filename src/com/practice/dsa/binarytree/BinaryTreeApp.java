package com.practice.dsa.binarytree;


import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
}

class BinaryTree{

    public Node createNewNode(int val){
        Node newNode = new Node();
        newNode.data = val;
        newNode.left = null;
        newNode.right = null;
        return newNode;
    }

    public void inorder(Node node) {
        if(node == null)
            return;
        inorder(node.left);
        System.out.print(node.data+ " ");
        inorder(node.right);
    }

    public void preorder(Node node) {
        if(node == null)
            return;
        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder(Node node) {
        if(node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    public int getSumOfNodes(Node node) {
        if(node == null)
            return 0;
        return node.data + getSumOfNodes(node.left) + getSumOfNodes(node.right);
    }

    public int getDifferenceEvenOddValues(Node node){
        if(node == null)
            return 0;
        return  node.data - getDifferenceEvenOddValues(node.left)  - getDifferenceEvenOddValues(node.right);
    }

    public int getNumberOfNodes(Node node) {
        if(node == null)
            return 0;
        return 1 + getNumberOfNodes(node.left) + getNumberOfNodes(node.right);
    }

    public int getNumberOfLeafNodes(Node node) {
        if(node == null)
            return 0;
        if(node.left == null && node.right == null)
            return 1;
        return getNumberOfLeafNodes(node.left) + getNumberOfLeafNodes(node.right);
    }

    public int heightOfTree(Node node) {
        if(node == null)
            return -1;
        return max(heightOfTree(node.left),heightOfTree(node.right)) + 1;
    }

    private int max(int a, int b) {
        return  a>b ? a : b;
    }

    public void printAtGivenLevel(Node node, int level){
        if(node == null)
            return;
        if(level == 1){
            System.out.print(node.data + " ");
            return;
        }
        printAtGivenLevel(node.left,level-1);
        printAtGivenLevel(node.right,level-1);
    }

    public void levelOrderTraversalUsingRecursion(Node node){
        if(node == null){
            return;
        }
        int height = heightOfTree(node);
        for(int i =0;i<=height; i++){
            printAtGivenLevel(node,i+1);
            System.out.println();
        }
    }

    public void levelOrderTraversalUsingQueue(Node node) {
        if(node == null)
            return;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while (queue.size() > 0){
            Node top = queue.remove();
            System.out.print(top.data + " ");

            if(top.left != null)
                queue.add(top.left);
            if(top.right != null)
                queue.add(top.right);
        }
    }

    int maxLevel;
    public void leftViewOfTree(Node node, int level) {
        if(node == null)
            return;
        if(level >= maxLevel){
            System.out.print(node.data + " ");
            maxLevel++;
        }
        leftViewOfTree(node.left, level+1);
        leftViewOfTree(node.right, level+1);

    }

    int maxRightLevel;
    public void rightViewOfTree(Node node, int level) {
        if(node == null){
            return;
        }
        if(level >= maxRightLevel){
            System.out.print(node.data + " ");
            maxRightLevel++;
        }
        rightViewOfTree(node.right,level+1);
        rightViewOfTree(node.left,level+1);
    }

    public Node mirrorTree(Node node) {
        if(node == null)
            return null;
        Node t = node.left;
        node.left = node.right;
        node.right = t;

        mirrorTree(node.left);
        mirrorTree(node.right);

        return node;
    }

    public boolean checkIfIdentical(Node t1, Node t2) {
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        return  t1.data == t2.data
                && checkIfIdentical(t1.left,t2.left)
                && checkIfIdentical(t1.right,t2.right);
    }
}

public class BinaryTreeApp {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = tree.createNewNode(2);
        root.left = tree.createNewNode(7);
        root.right = tree.createNewNode(5);
        root.left.left = tree.createNewNode(2);
        root.left.right = tree.createNewNode(6);
        root.left.right.left = tree.createNewNode(5);
        root.left.right.right = tree.createNewNode(11);
        root.right.right = tree.createNewNode(9);
        root.right.right.left = tree.createNewNode(4);

        /*
                                2
                        7               5
                   2        6                 9
                        5       11        4

         */





        Node root2 = tree.createNewNode(2);
        root2.left = tree.createNewNode(7);
        root2.right = tree.createNewNode(5);
        root2.left.left = tree.createNewNode(2);
        root2.left.right = tree.createNewNode(6);
        root2.left.right.left = tree.createNewNode(5);
        root2.left.right.right = tree.createNewNode(11);
        root2.right.right = tree.createNewNode(9);
        root2.right.right.left = tree.createNewNode(4);

        System.out.println("Inorder");
        tree.inorder(root);
        System.out.println();

        System.out.println("Preorder");
        tree.preorder(root);
        System.out.println();

        System.out.println("Postorder");
        tree.postorder(root);
        System.out.println();

        System.out.println("Sum of nodes: "+tree.getSumOfNodes(root));

        System.out.println("Difference of even odd values: "+tree.getDifferenceEvenOddValues(root));

        System.out.println("Total number of nodes in binary tree: "+tree.getNumberOfNodes(root));

        System.out.println("Total number of leaf nodes : "+ tree.getNumberOfLeafNodes(root));

        System.out.println("Get height of Binary tree/node: "+tree.heightOfTree(root));

        System.out.print("Print at given level: ");
        tree.printAtGivenLevel(root,3);

        System.out.println("Print Elements in Level Order using recursion: ");
        tree.levelOrderTraversalUsingRecursion(root);

        System.out.println("Print Elements in Level Order using queue: ");
        tree.levelOrderTraversalUsingQueue(root);

        System.out.println();
        System.out.println("Print left view of binary tree: ");
        tree.leftViewOfTree(root,0);

        System.out.println();
        System.out.println("Print right view of binary tree: ");
        tree.rightViewOfTree(root,0);


        System.out.println();
        System.out.println("Mirror View of binary tree: ");
        Node mirror = tree.mirrorTree(root);
        tree.inorder(mirror);

        System.out.println("\nCheck if two trees are identical: "+ tree.checkIfIdentical(root,root2));

    }
}
