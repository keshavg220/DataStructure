package LinkedListTest;

import node.SingleNode;

public class SingleLinkedList {
	private SingleNode head;
	private SingleNode tail;
	private int size;

	public void createSingleLinkedList(int nodeValue) {
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		node.setNext(null);
		head=node;
		tail=node;
		size=1;
		
	}
	
	public SingleNode getHead() {
		return head;
	}
	public void setHead(SingleNode head) {
		this.head = head;
	}

	public SingleNode getTail() {
		return tail;
	}

	public void setTail(SingleNode tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void insertInLinkedList(int nodeValue, int location) {
		SingleNode node = new SingleNode();
		node.setValue(nodeValue);
		if(!existLinkedList()) {
			System.out.println("linked list not exist");
			return;
		}
		else if(location==0){
			node.setNext(head);
			head=node;	
		}
		else if(location >=size) {
			node.setNext(null);
			tail.setNext(node);
			tail = node;
		}
		else {
			SingleNode tempNode = head;
			int index = 0;
			while(index < location-1) {
				tempNode = tempNode.getNext();
				index++;
			}
			SingleNode nextNode = tempNode.getNext();
			tempNode.setNext(node);
			node.setNext(nextNode);
		}
		setSize(getSize()+1);
	}
	
	public boolean existLinkedList() {
		return head != null;
	}
	
	void traverseLinkedList() {
		if(existLinkedList()) {
			SingleNode tempNode = head;
			for(int i=0; i< getSize();i++) {
				System.out.print(tempNode.getValue());
				if (i != getSize() - 1) {
					System.out.print(" -> ");
				}
				tempNode = tempNode.getNext();
			}
		}
			else {
				System.out.println("linked list not exist");
			}
		System.out.println("\n");
		}
		void deleteLinkedList() {
			
			System.out.println("\n\nDeleting Linked List...");
			head = null;
			tail = null;
			System.out.println("Linked List deleted successfully !");
		
	}
		
		boolean searchNode(int nodeValue) {
			if (existLinkedList()) {
				SingleNode tempNode = head;
				for (int i = 0; i < getSize(); i++) {
					if (tempNode.getValue() == nodeValue) {
						System.out.print("Found the node at location: "+i+"\n");
						return true;
					}
					tempNode = tempNode.getNext();
				}
			}
			System.out.print("Node not found!! \n");
			return false;
		}
		
		public void deletionOfNode(int location) {
			
			if(!existLinkedList()) {
				System.out.println("linked list not exist");
				
			}
			else if(location == 0) {
				head = head.getNext();
				setSize(getSize()-1);
				if(getSize() == 0) {
					tail=null;
				}
			}
			else if(location >= size) {
				SingleNode tempNode = head;
				for(int i=0; i < size-1;i++) {
					tempNode = tempNode.getNext();
				}
				if (tempNode == head) { 
					
					tail = head = null;
					setSize(getSize()-1);
					return;
				}
				tempNode.setNext(null); 
				tail= tempNode;
				setSize(getSize()-1);
			}
			else { 
				
				SingleNode tempNode = head;
				for (int i = 0; i < location - 1; i++) {
					tempNode = tempNode.getNext(); // we need to traverse till we find the location
				}	
				tempNode.setNext(tempNode.getNext().getNext()); // delete the required node
				setSize(getSize()-1);
			}
		}
	
}
