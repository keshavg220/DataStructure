package javaStuff;
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

class InsertInLevelOrderTraversal {
   
  	public static void preOrder( Node root ) {
      
    	if( root == null)
        	return;
      
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
     
    }

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

	public static Node insert(Node root,int data) {
    Node current = root;

    if(current == null){
        return new Node(data);
    }

    while((current.left != null && current.data > data) || (current.right != null && current.data < data)){
        if(current.data < data){
            current = current.right;
        }else{
            current = current.left;
        }
    }

    Node temp = new Node(data);
    if(current.data < data){
        current.right = temp;
    }else{
        current.left = temp;
    }

    return root;

}
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
      	preOrder(root);
    }	
}