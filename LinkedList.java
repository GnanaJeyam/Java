package existingProject;

public class LinkedList{
	
	Node head;
	static int n=10;
	static class Node{
		int data;
		Node next;
		Node(int data) {
			this.data=data;
		}
	}
	
	private void printNode(Node head) {
	
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	
	private Node reverse(Node head) {
		
		Node currentPtr = head, prevPtr = null;
		
		while(currentPtr != null) {
			currentPtr = head.next;
			head.next = prevPtr;
			prevPtr = head;
			head = currentPtr;
		}
		  head = prevPtr;
		return head;
	}
	
	public static void main( String args[] ) {
		
		LinkedList ld = new LinkedList();
			Node head = new Node(1);
			head.next = new Node(2); 
			head.next.next = new Node(3);
			head.next.next.next = new Node(4);
			head.next.next.next.next = new Node(5);
				
		System.out.println("Before Reversing:");	
			ld.printNode(head);
		System.out.println("After Reversing:");
			head = ld.reverse(head);
			ld.printNode(head);
	}
	
}

