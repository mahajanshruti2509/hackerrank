import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {

	/*
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
	public static Node lca(Node root, int v1, int v2) {
        /* 1. If the root receives a null from left and right child, return null
           2. If one of the childern returns a non-null, return non-null 
           3. If one of the childern is root, return root
        */
        if(root == null) {
            return null;
        }
        if(root.data == v1 || root.data == v2) {
            return root;
        }
        Node leftChild = lca(root.left, v1, v2);
        Node rightChild = lca(root.right, v1, v2);

        if(leftChild != null && rightChild != null) {
            return root;
        }

        if(leftChild == null && rightChild == null) {
            return null;
        }

        return leftChild != null? leftChild : rightChild;
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
      	int v1 = scan.nextInt();
      	int v2 = scan.nextInt();
        scan.close();
        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }	
}
