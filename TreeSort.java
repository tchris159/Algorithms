import java.util.Arrays;


/**
 * Binary tree is a tree structure where each node has a maximum of two children. 
 * A kind of binary tree used for Tree sorting is known as a Binary Search Tree (BST).
 * 
 * In Binary search tree for each node the node’s left child must have a value less than 
 * its parent node and the node’s right child must have a value greater than (or equal)
 * its parent. If we consider the root node of the binary search tree the left subtree 
 * must have nodes with values less than the root node and the right subtree must have 
 * nodes with values greater than the root node.
 * 
 * 
 * To write a Java program for Tree sort it is necessary to have:
 * 
 * A node class representing each node in the binary search tree.
 * 
 * A method to insert nodes in Binary search tree. Logic for inserting a new node 
 * to the Binary search tree goes as given below:
 * 
 *         If new node’s value is less than the current node move to the left.
 * 
 *         If new node’s value is greater than the current node move to the right.
 * 
 *         When current node is null that means leaf node is reached. New node should be 
 *         inserted in that position.
 * 
 * A method to traverse the tree to get the elements in order.
 * 
 * Performance: 
 * 
 * Average case time complexity of tree sort is O(nlogn), as insertion of an element
 * in the Binary search tree takes O(logn) time so for n elements it is O(nlogn).
 * 
 * However, as with all BST, this is under the assumption that it is well balanced.
 * With an unbalanced tree, the sort could degerate to a runtime of O(n^2), with
 * N comparisons times N number of elements similar to a linkedlist.
 * 
 * Space complexity of tree sort is O(n) as we need to create n nodes for n elements.
 * 
 * 
 * 
 */

class Node {
    int value;
    Node left;
    Node right;
    Node(int value){
        this.value = value;
        left = null;
        right = null;        
    }
}

class Tree{
    Node node;
    Tree(int value){
        node = new Node(value);
    }
    public Node insert(Node node, int value){
        if(node == null){
            return new Node(value);
        }
        // Move to the left if passed value is 
        // less than the current node
        if(value < node.value){
            node.left = insert(node.left, value);
        }
        // Move to the right if passed value is 
        // greater than the current node
        else if(value > node.value){
            node.right = insert(node.right, value);
        }
        return node;
    }
    
    // For traversing in order
    public void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }
    

    public void inOrderDesc(Node node){
        if(node != null){
            inOrderDesc(node.right);
            System.out.print(node.value + " ");
            inOrderDesc(node.left);
        }
    }
}

public class TreeSort {    
    public static void main(String[] args) {
        int[] arr = {50, 30, 70, 15, 7, 62, 22, 35, 87, 22, 31};
        System.out.println("Original array- "+Arrays.toString(arr));
        Tree tree = new Tree(arr[0]);
        for(int num : arr){
            tree.insert(tree.node, num);
        }
        System.out.println("Sorted Array (Ascending)- ");
        tree.inOrder(tree.node);
        System.out.println();
        System.out.println("Sorted Array (Descending)- ");
        tree.inOrderDesc(tree.node);
    }
}