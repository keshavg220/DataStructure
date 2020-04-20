package LinkedListTest;

import java.util.Currency;
import java.util.LinkedList;
import java.util.Queue;

import node.BinaryNode;

public class AVLTree {
	BinaryNode root;
	
	public BinaryNode getRoot(){
		return root;
	}
	
	AVLTree(){
		root = null;
	}
	void insert(int value) {
		root = insert(root,value);
	}
	BinaryNode insert(BinaryNode currentNode, int value) {
		if(currentNode == null) {
			System.out.println("Successfully inserted" + value);
			return createNewNode(value);
			
		}
		else if(value <= currentNode.getValue()) {
			currentNode.setLeft(insert(currentNode.getLeft(),value));
			
		}else {
		currentNode.setRight(insert(currentNode.getRight(),value));
		}
	int balance = checkBalance(currentNode.getLeft(),currentNode.getRight()){
		if(balance>1) {
			if(checkBalance(currentNode.getLeft().getLeft(),currentNode.getLeft().getRight())> 0) {
				currentNode = rotateRight(currentNode); //LL condition
			}
			else {
				currentNode.setLeft(leftRotate(currentNode.getLeft()); //LR condition
				currentNode = rotateRight(currentNode);
			}
		else if(balance < -1) {
			if(checkBalance(currentNode.getRight().getRight(),currentNode.getRight().getLeft())>0) {
				currentNode = rotateLeft(currentNode); //RR condition
			}
			else {
				currentNode.setRight(rightRotate(currentNode.getRight())); //RL condition
				currentNode = rotateLeft(currentNode);
			}
		}
		if(currentNode.getLeft() != null) {
			currentNode.setHeight(calculateHeight(currentNode.getLeft()));
		}
		if (currentNode.getRight() != null) {
			currentNode.getRight().setHeight(calculateHeight(currentNode.getRight()));
		}
		currentNode.setHeight(calculateHeight(currentNode));
		return currentNode;
	}
		private BinaryNode leftRotate(BinaryNode currentNode) {
			BinaryNode newRoot = currentNode.getRight();
			currentNode.setRight(currentNode.getRight().getLeft());
			newRoot.setLeft(currentNode);
			currentNode.setHeight(calculateHeight(currentNode));
			newRoot.setHeight(calculateHeight(newRoot));
			return newRoot;
		}// end of method

		
		// Helper Method
		private BinaryNode rightRotate(BinaryNode currentNode) {
			BinaryNode newRoot = currentNode.getLeft();
			currentNode.setLeft(currentNode.getLeft().getRight());
			newRoot.setRight(currentNode);
			currentNode.setHeight(calculateHeight(currentNode));
			newRoot.setHeight(calculateHeight(newRoot));
			return newRoot;
		}
		private int checkBalance(BinaryNode rootLeft, BinaryNode rootRight) {
			if(rootLeft == null ) && (rootRight == null){
				return 0;
			}
			else if(rootLeft == null) {
				return -1*(rootRight.getHeight()+1);
			}
			else if (rootRight == null) {
				return rootLeft.getHeight() + 1;
			} else {
				return rootLeft.getHeight() - rootRight.getHeight(); // +1 is not required, as both right and left child
																		// exits and 1 gets nullified
			}
		}
		private int calculateHeight(BinaryNode currentNode) {
			if(currentNode == null) {
				return 0;
			}
			else {
				return 1 + Math.max((currentNode.getLeft() != null ? currentNode.getLeft().getHeight() :-1),(currentNode.getRight() != null ? currentNode.getRight().getHeight() : -1));

			}
		}
			public BinaryNode createNewNode(int value) {
				BinaryNode node = new BinaryNode();
				node.setValue(value);
				node.setHeight(0);// Since this is a leaf node, its height is 0
				return node;
			}
			void levelOrderTraversal() {
				Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
				queue.add(root);
				System.out.println("Printing Level order traversal of AVL Tree...");
				if (root == null) {
					System.out.println("Tree does not exists !");
					return;
				}
				while (!queue.isEmpty()) {
					BinaryNode presentNode = queue.remove();
					System.out.print(presentNode.getValue() + " ");
					if (presentNode.getLeft() != null)
						queue.add(presentNode.getLeft());
					if (presentNode.getRight() != null)
						queue.add(presentNode.getRight());
				}
			}
			public void deleteNodeOfBST(int value) {
				System.out.println("Deleting " + value + " from AVL Tree ...");
				root = deleteNodeOfBST(root, value);
			}
			public BinaryNode deleteNodeOfBST(BinaryNode currentNode,int value) {
				if(root == null) {
					return null;
				}
				else if(value < currentNode.getValue()) {
					currentNode.setLeft(deleteNodeOfBST(currentNode.getLeft(), value));
				}
				else if(value > currentNode.getValue()) {
					currentNode.setRight(deleteNodeOfBST(currentNode.getRight(), value));
				}
				else {
					if(currentNode.getLeft() != null && currentNode.getRight() !=null) {
						BinaryNode temp = currentNode;
						BinaryNode minNodeForRight = minimumElement(temp.getRight());
						currentNode.setValue(minNodeForRight.getValue());
						deleteNodeOfBST(currentNode.getRight(), minNodeForRight.getValue());
				   }
					else if (currentNode.getLeft() != null) {// if nodeToBeDeleted has only left child
						currentNode = currentNode.getLeft();
					} else if (currentNode.getRight() != null) {// if nodeToBeDeleted has only right child
						currentNode = currentNode.getRight();
					} else { // if nodeToBeDeleted do not have child (Leaf node)
						//System.out.println("This node is leaf node");
						currentNode = null;
					}
					return currentNode;
				}
				int balance = checkBalance(currentNode.getLeft(), currentNode.getRight());
				if (balance > 1) {
					if (checkBalance(currentNode.getLeft().getLeft(), currentNode.getLeft().getRight()) > 0) {
						currentNode = rightRotate(currentNode);// LL Condition
					} else {
						currentNode.setLeft(leftRotate(currentNode.getLeft())); // LR Condition
						currentNode = rightRotate(currentNode);
					}
				} else if (balance < -1) {
					if (checkBalance(currentNode.getRight().getRight(), currentNode.getRight().getLeft()) > 0) {
						currentNode = leftRotate(currentNode);// RR Condition

					} else {
						currentNode.setRight(rightRotate(currentNode.getRight()));// RL Condition
						currentNode = leftRotate(currentNode);

					}
				}

				if (currentNode.getLeft() != null) {
					currentNode.getLeft().setHeight(calculateHeight(currentNode.getLeft()));
				}
				if (currentNode.getRight() != null) {
					currentNode.getRight().setHeight(calculateHeight(currentNode.getRight()));
				}
				currentNode.setHeight(calculateHeight(currentNode));
				return currentNode;

				
			}
			void printTreeGraphically() {
				Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
				Queue<Integer> level = new LinkedList<Integer>();
				int currentLevel = 1;
				boolean previousLevelWasAllNull = false;
				queue.add(root);
				level.add(1);
				
				System.out.println("\nPrinting Level order traversal of Tree...");
				if(root == null) {
					System.out.println("Tree does not exists !");
					return;
				}
				while(!queue.isEmpty()) {
					if(currentLevel == level.peek()) {
						if(queue.peek() == null) {
							queue.add(null);
							level.add(currentLevel + 1);
						}
						else {
							queue.add(queue.peek().getLeft());level.add(currentLevel+1);
							queue.add(queue.peek().getRight());level.add(currentLevel+1);
							previousLevelWasAllNull = false;
						}
						System.out.print(queue.remove() + "  ");level.remove();
					}
					
				}
			}
	
}