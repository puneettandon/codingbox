package com.practice.dsa.binarysearchtree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Node{
    int data;
    Node left;
    Node right;
}

class BST{

    private Node createNewNode(int val) {
        Node node = new Node();
        node.data = val;
        node.left = null;
        node.right = null;
        return  node;
    }

    public Node insert(Node node, int val){
        if(node == null)
            return createNewNode(val);

        if(val < node.data)
            node.left = insert(node.left,val);
        else
            node.right = insert(node.right,val);

        return  node;
    }

    public void inorder(Node node) {
        if(node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
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
        System.out.print(node.data+ " ");

    }

    public boolean ifNodePresent(Node node, int val) {
        if(node == null)
            return false;

        boolean isPresent = false;

        while(node != null){
            if(val < node.data)
                node = node.left;
            else if(val > node.data)
                node = node.right;
            else{
                isPresent = true;
                break;
            }
        }
        return  isPresent;
    }

    public Node getParentNode(Node node, int value) {
        if(node == null)
            return  null;
        Node parent = null;
        while(node != null){
            if(value < node.data) {
                parent = node;
                node = node.left;
            }
            else if (value > node.data) {
                parent = node;
                node = node.right;
            }
            else {
                break;
            }
        }
        return  parent;
    }

    public Node getSiblingNode(Node node, int value) {
        if(node == null || node.data == value){
            return null;
        }
        Node siblingNode = null;
        Node parentNode = null;
        while(node != null){
            if(value < node.data){
                parentNode = node;
                node = node.left;
            }else if(value > node.data){
                parentNode = node;
                node = node.right;
            }else{
                break;
            }
        }
        if(parentNode.left != null && value == parentNode.left.data){
            return parentNode.right;
        }
        if(parentNode.right != null && value == parentNode.right.data){
            return  parentNode.left;
        }
        return  null;
    }

    public int getDifferenceEvenOddLevel(Node node) {
        if(node == null){
            return 0;
        }
        return node.data - getDifferenceEvenOddLevel(node.left) - getDifferenceEvenOddLevel(node.right);
    }

    public int getMaxValueBST(Node node) {
        if(node == null){
            return -1;
        }
        while(node.right != null){
            node = node.right;
        }
        return node.data;
    }

    public int getMinValueBST(Node node) {
        if(node == null)
            return -1;
        while(node.left != null){
            node = node.left;
        }
        return node.data;
    }

    public boolean ifPairExists(Node node, int sum) {
        HashSet<Integer> set = new HashSet<>();

        return ifPairExistsUtil(node,sum,set);
    }

    private boolean ifPairExistsUtil(Node node, int sum, HashSet<Integer> set) {

        if(node == null)
            return false;
        if(set.contains(sum -node.data))
            return  true;

        set.add(node.data);

        if(ifPairExistsUtil(node.left,sum,set))
            return true;

        return ifPairExistsUtil(node.right,sum,set);
    }

    public boolean isBST(Node root) {
        return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isBSTUtil(Node node, int minValue, int maxValue) {
        if(node == null)
            return  true;
        if(node.data < minValue || node.data > maxValue)
            return false;

        return (isBSTUtil(node.left,minValue,node.data -1) &&
                isBSTUtil(node.right,node.data+1,maxValue));
    }

    Node prev = null;
    public boolean isBST2(Node node) {
        if(node != null){
            if(!isBST2(node.left))
                return false;

            if(prev != null && node.data <= prev.data)
                return false;
            prev = node;
            return isBST2(node.right);
        }
        return true;
    }

    public boolean CheckIfTwoBSTContainSameElement(Node node1, Node node2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorderC(node1,list1);
        inorderC(node2,list2);

        return list1.equals(list2);
    }

    private void inorderC(Node node, List<Integer> list) {
        if(node == null)
            return;
        inorderC(node.left,list);
        list.add(node.data);
        inorderC(node.right,list);
    }

    public Node findLowestCommonAncestor(Node node,int val1, int val2) {
        if(node == null)
            return  null;
        while(node != null){
            if(node.data > val1 && node.data > val2)
                node = node.left;
            else if(node.data < val1 && node.data < val2)
                node = node.right;
            else
                break;
        }
        return node;
    }

    public Node getInorderPredecessor(Node node, int val) {
        if(node == null)
            return null;

        Node inorderPredecessor = null;

        while(node != null){
            if(val < node.data){
                node = node.left;
            }else if(val > node.data){
                inorderPredecessor = node;
                node = node.right;
            }else{
                if(node.left != null){
                    inorderPredecessor = getPredecessor(node);
                }
                break;
            }
        }
        return  node!= null ? inorderPredecessor : null;
    }

    private Node getPredecessor(Node node) {
        if(node == null)
            return null;
        Node temp = node.left;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp;
    }

    /*
    public Node delete(Node node, int val){
        if(node == null)
            return  null;

        if(val < node.data){
            node.left = delete(node.left,val);
        }else if(val > node.data){
            node.right = delete(node.right,val);
        }else{
            if(node.left == null  || node.right == null) {
                Node temp = null;
                temp = node.left == null ? node.right : node.left;

                if(temp== null)
                    return  null;
                else
                    return  node;
            }else {
                Node successor  = getSuccessor(node);
            }
        }
        return node;
    }*/



}

public class BSTApp {

    public static void main(String[] args) {

        BST tree = new BST();
        Node root = null;
        // 8,3,6,10,4,7,1,14,13

        root = tree.insert(root,8);
        root = tree.insert(root,3);
        root = tree.insert(root,6);
        root = tree.insert(root,10);
        root = tree.insert(root,4);
        root = tree.insert(root,7);
        root = tree.insert(root,1);
        root = tree.insert(root,14);
        root = tree.insert(root,13);

        Node root2 = null;
        root2 = tree.insert(root2,8);
        root2 = tree.insert(root2,15);
        root2 = tree.insert(root2,6);
        root2 = tree.insert(root2,2);
        root2 = tree.insert(root2,7);
        root2 = tree.insert(root2,20);


        Node root3 = null;
        root3 = tree.insert(root3,8);
        root3 = tree.insert(root3,15);
        root3 = tree.insert(root3,6);
        root3 = tree.insert(root3,2);
        root3 = tree.insert(root3,7);
        root3 = tree.insert(root3,20);


        System.out.println("Print elements in Inorder(sorted/ascending): ");
        tree.inorder(root);
        System.out.println();

        System.out.println("Print elements in Preorder: ");
        tree.preorder(root);
        System.out.println();

        System.out.println("Print elements in Postorder: ");
        tree.postorder(root);
        System.out.println();

        System.out.println("Check if given node is present or not: ");
        System.out.println(tree.ifNodePresent(root,3));

        System.out.print("Get parent node of a given value: ");
        Node parentNode = tree.getParentNode(root,8);
        System.out.println(parentNode != null ? parentNode.data : "Parent does not exist");

        System.out.println("Get Sibling Node of given value in BST: ");
        Node siblingNode = tree.getSiblingNode(root,4);
        if(siblingNode != null){
            System.out.println(siblingNode.data);
        }else {
            System.out.println("Sibling Node doesn't exist");
        }

        System.out.println("Difference of Even & odd level values: "+ tree.getDifferenceEvenOddLevel(root));

        System.out.println("Max value element in BST: "+ tree.getMaxValueBST(root));

        System.out.println("Min value element in BST: "+ tree.getMinValueBST(root));

        System.out.println("Check if there exists a pair for given sum in BST: "+ tree.ifPairExists(root,21));

        System.out.println("Check if binary tree is bst or not: "+ tree.isBST(root));

        System.out.println("Check if binary tree is bst or not using inorder: "+tree.isBST2(root));

        System.out.println("Check if elements of two bsts are same: "+tree.CheckIfTwoBSTContainSameElement(root2,root3));

        System.out.println("Find lowest common ancestor in BST ");
        Node lca = tree.findLowestCommonAncestor(root2,2,100);
        if(lca != null)
            System.out.println(lca.data);


        Node inorderPredecssor = tree.getInorderPredecessor(root2,20);
        if(inorderPredecssor != null)
            System.out.println("Inorder Predecessor: "+inorderPredecssor.data);
        else
            System.out.println("Inorder Predecessor doesn't exists");



    }
}
