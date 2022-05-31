package com.practice.dsa.binarytree;


import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    int height;
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

    int sumOfLeafNode= 0;
    public int getSumofLeafNodes(Node node) {
        sumOfLeafNode = 0;
        if(node == null)
            return 0;
        if(node.left == null && node.right == null){
            return sumOfLeafNode + node.data;
        }
        return getSumofLeafNodes(node.left) + getSumOfNodes(node.right);
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

    public boolean checkIfPairExists(Node root, int sum) {
        HashSet<Integer> set = new HashSet<>();
        return checkIfPairExistsUtil(root,sum,set);
    }

    private boolean checkIfPairExistsUtil(Node node, int sum, HashSet<Integer> set) {
        if(node == null){
            return false;
        }
        if(set.contains(sum - node.data)){
            return true;
        }
        set.add(node.data);

        if(checkIfPairExistsUtil(node.left,sum,set))
            return true;

        return checkIfPairExistsUtil(node.right,sum,set);
    }

    public int getAverageOfAllNodes(Node root) {
       int sumOfAllNodes =  getSumOfNodes(root);
       int numOfNodes = getNumberOfNodes(root);

       return sumOfAllNodes/numOfNodes;
    }

    int sum = 0;
    int count = 0;
    public int getAverageOfAllNodesV2(Node node) {
        if(node == null ){
            return 0;
        }
        sum = sum + node.data;
        count = count + 1;
        getAverageOfAllNodesV2(node.left);
        getAverageOfAllNodesV2(node.right);
        return (sum/count);
    }

    public boolean printAncestors(Node node, int val) {
        if(node == null){
            return false;
        }
        if(node.data == val){
            return true;
        }
        if(printAncestors(node.left,val) || printAncestors(node.right,val)){
            System.out.print(node.data + " ");
            return  true;
        }
        return false;
    }

    public Node getParent(Node node, int val) {
        if(node == null || node.data == val){
            return null;
        }
        if((node.left != null && node.left.data == val) || (node.right != null && node.right.data == val)){
            return node;
        }
        Node l = getParent(node.left,val);
        if(l != null){
            return l;
        }
        l = getParent(node.right,val);
        return l;
    }

    public int getSibling(Node root, int siblingFor) {
        Node node = getParent(root,siblingFor);
        if(node.left != null) {
            if (node.left.data == siblingFor && node.right != null) {
                return node.right.data;
            }
        }else if(node.right != null) {
            if (node.right.data == siblingFor && node.left != null) {
                return node.left.data;
            }
        }
        return -1;
    }

    public void topView(Node node){
        if(node == null)
            return;
        TreeMap<Integer,Integer> map = new TreeMap<>();

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while (queue.size() > 0){
            Node top = queue.remove();
            int step = top.height;

           if(map.get(step) == null){
               map.put(step,top.data);
           }

            if(top.left != null) {
                top.left.height = step -1;
                queue.add(top.left);
            }
            if(top.right != null) {
                top.right.height = step +1;
                queue.add(top.right);
            }
        }
        System.out.println(map.values());
    }

    public void bottomView(Node node) {
        if(node == null)
            return;
        TreeMap<Integer,Integer> map = new TreeMap<>();

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);

        while (queue.size() > 0){
            Node top = queue.remove();
            int step = top.height;

            map.put(step,top.data);

            if(top.left != null) {
                top.left.height = step -1;
                queue.add(top.left);
            }
            if(top.right != null) {
                top.right.height = step +1;
                queue.add(top.right);
            }
        }
        System.out.println(map.values());
    }

    public void boundaryNodes(Node node) {
        if(node != null)
            System.out.print(node.data + " ");
        printBoundaryLeft(node.left);

        printLeaves(node.left);
        printLeaves(node.right);

        printBoundaryRight(node.right);
    }

    private void printBoundaryRight(Node node) {
       if(node == null)
           return;
       if(node.right != null){
           printBoundaryRight(node.right);
           System.out.print(node.data+ " ");
       }else if(node.left != null){
           printBoundaryRight(node.left);
           System.out.print(node.data+ " ");
       }
    }

    private void printLeaves(Node node) {
        if(node == null){
            return;
        }
        printLeaves(node.left);
        if(node.left == null && node.right == null){
            System.out.print(node.data + " ");
        }
        printLeaves(node.right);
    }

    private void printBoundaryLeft(Node node) {
        if(node == null)
            return;
        if(node.left != null){
            System.out.print(node.data + " ");
            printBoundaryLeft(node.left);
        }else if(node.right != null){
            System.out.print(node.data + " ");
            printBoundaryLeft(node.right);
        }
    }


    public boolean checkIfParentSumOfChildren(Node node) {
        if(node == null || (node.left == null && node.right == null)){
            return true;
        }
        int a = node.left != null ? node.left.data : 0;
        int b = node.right != null ? node.right.data : 0;

        return (a + b == node.data) && checkIfParentSumOfChildren(node.left) && checkIfParentSumOfChildren(node.right);
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


        Node root3 = tree.createNewNode(2);
        root3.left = tree.createNewNode(7);
        root3.right = tree.createNewNode(5);
        root3.left.right = tree.createNewNode(6);
        root3.left.right.left = tree.createNewNode(5);
        root3.left.right.left.left = tree.createNewNode(10);
        root3.left.right.right = tree.createNewNode(11);
        root3.right.right = tree.createNewNode(9);
        // root 3

    /*
                   2
            7             5
               6                9
         5         11
    10
    */
        Node root4 = tree.createNewNode(2);
        root4.left = tree.createNewNode(7);
        root4.right = tree.createNewNode(5);
        root4.left.right = tree.createNewNode(6);
        root4.left.left = tree.createNewNode(2);
        root4.left.right.left = tree.createNewNode(5);
        root4.left.right.right = tree.createNewNode(11);
        root4.right.right = tree.createNewNode(9);
        // root 4
    /*
                    2
             7               5
         2        6              9
              5       11
    */

        Node root5 = tree.createNewNode(12);
        root5.left = tree.createNewNode(4);
        root5.right = tree.createNewNode(8);
        root5.left.left = tree.createNewNode(3);
        root5.left.right = tree.createNewNode(1);
        root5.right.right = tree.createNewNode(8);


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

        int sum = 50;
        // time complexity  - O(n) space complexity - O(n)
        System.out.println("Check if there exists a pair for given sum : " + sum+ " in binary tree: "+ tree.checkIfPairExists(root,sum));

        System.out.println("Get Average of all nodes: "+tree.getAverageOfAllNodes(root));
        System.out.println("Get Average of all nodes V2: "+tree.getAverageOfAllNodesV2(root));

        int searchAncestorVal = 4;
        System.out.print("Print ancestors of given value in binary tree: ");
        tree.printAncestors(root,searchAncestorVal);

        int parentFor = 4;
        System.out.print("Parent for given value: "+parentFor+ " is: ");
        Node parent = tree.getParent(root,parentFor);
        if(parent != null)
            System.out.println(parent.data);
        else
            System.out.println("Parent is null");

        int siblingFor = 6;
        System.out.println("Get Sibling of a given value: "+siblingFor + " is : "+ tree.getSibling(root,siblingFor));

        System.out.println("Sum of all leaf nodes "+ tree.getSumofLeafNodes(root));


        System.out.println("Print Top view of binary tree is: ");
        tree.topView(root3);

        System.out.println("Print Bottom view of binary tree is: ");
        tree.bottomView(root4);

        System.out.println("Print Boundary nodes in binary tree: ");
        tree.boundaryNodes(root3);
        System.out.println();

        System.out.println("Print Vertical Order of binary tree ");

        System.out.println("Check if parent contain sum of both children "+ tree.checkIfParentSumOfChildren(root5));


    }
}
