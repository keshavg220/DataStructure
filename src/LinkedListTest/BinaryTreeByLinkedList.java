package LinkedListTest;
import java.util.*;

import node.BinaryNode;
public class BinaryTreeByLinkedList {
	BinaryNode root;
	
	BinaryTreeByLinkedList(){
		this.root = null;
	}
	void insert(int value) {
		BinaryNode node = new BinaryNode();
		node.setValue(value);
		if(root == null) {
			root = node;
			System.out.println("succesfully entered root in a binary tree");
			return;
		}
		
	
	Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
	queue.add(root);
	while (!queue.isEmpty()) {
		BinaryNode presentNode = queue.remove();
		if(presentNode.getLeft() ==null) {
			presentNode.setLeft(node);
			System.out.println("Successfully inserted new node !");
			break;
		}else if (presentNode.getRight() == null) {
			presentNode.setRight(node);
			System.out.println("Successfully inserted new node !");
			break;
		} else {
				queue.add(presentNode.getLeft());
				queue.add(presentNode.getRight());
			}
			
		}
	}
		void search(int value) {
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(root);
			while(!queue.isEmpty()) {
				BinaryNode presentNode = queue.remove();
				if(presentNode.getValue()==value) {
					System.out.println("value -"+value+"is found in tree");
				}
				else {
					if(presentNode.getLeft() != null)
						queue.add(presentNode.getLeft());
					if (presentNode.getRight()!=null)
					queue.add(presentNode.getRight());
				}
			}
			System.out.println("Value-"+value+" is not found in Tree !");
		}
		void deleteNodeOfBinaryTree(int value) {
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(root);
			while (!queue.isEmpty()) {
				BinaryNode presentNode = queue.remove();
				// if node is found then copy deepest node here and delete deepest node.
				if (presentNode.getValue() == value) {
					presentNode.setValue(getDeepestNode().getValue());
					DeleteDeepestNode();
					System.out.println("Deleted the node !!");
					return;
				}else {
					if (presentNode.getLeft() != null)
						queue.add(presentNode.getLeft());
					if (presentNode.getRight() != null)
						queue.add(presentNode.getRight());
				}
			}//end of while loop
			System.out.println("Did not find the node!!");
		}
		
		public void DeleteDeepestNode() {
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(root);
			BinaryNode previousNode ,presentNode = null;
			while(!queue.isEmpty()) {
			previousNode = presentNode;
			presentNode = queue.remove();
			if(presentNode.getLeft()==null) {
				presentNode.setRight(null);
				return;
			}
			else if ((presentNode.getRight() == null)) {
				presentNode.setLeft(null);
				return;
			}
			queue.add(presentNode.getLeft());
			queue.add(presentNode.getRight());
			
			}
					
		}
		
		public BinaryNode getDeepestNode() {
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(root);
			BinaryNode presentNode= null;
			while(!queue.isEmpty()) {
			presentNode = queue.remove();
			if(presentNode.getLeft() != null) 
				queue.add(presentNode.getLeft());
				if (presentNode.getRight() != null)
					queue.add(presentNode.getRight());
				
			}
			return presentNode;
			
		}
		
		void preOrder(BinaryNode node) {
			if(node == null)
				return;
			System.out.print(node.getValue() + " ");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
		void postOrder(BinaryNode node) {
			if (node == null)
				return;
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.print(node.getValue() + " ");
		}//end of method

		
		
		// in-order traversal of binary tree
		void inOrder(BinaryNode node) {
			if (node == null) {
				return;
			}
			inOrder(node.getLeft());
			System.out.print(node.getValue() + " ");
			inOrder(node.getRight());
		}//end of method
		void levelOrder() {
			Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
			queue.add(root);
			
			while (!queue.isEmpty()) {
				BinaryNode presentNode = queue.remove();
				System.out.print(presentNode.getValue() + " ");
				if (presentNode.getLeft() != null) {
					queue.add(presentNode.getLeft());
				}
				if (presentNode.getRight() != null)
					queue.add(presentNode.getRight());
			}
		}// end of method
		
		
		// Delete Tree
		void deleteTree() {
			root = null;
			System.out.println("Binary Tree has been deleted successfully");
		}

}