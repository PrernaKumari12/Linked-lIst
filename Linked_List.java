package Lecture_45_46__Linked_List;

public class Linked_List {
	private class Node {
		int data;
		Node next;
		public node(){
			
		}
		public Node(int data) {
			this.data=data;
		}
	}

	Node head;
	//-----------------DISPLAY----------------------------

	public void display() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			// jump
			temp = temp.next;
		}
		System.out.println(" ");
		System.out.println("---------------");

	}

	public boolean isEmpty() {
		return head == null;

	}
//-----------------------SIZE------------------------------
	public int size() {
		Node temp = head;
		int size = 0;
		while (temp != null) {
			size++;
			// jump
			temp = temp.next;
		}
		return size;
	}
//---------------GET FIRST,GET AT,GET LAST--------------------
	public int getfirst() {
		return head.data;
	}

	public int getlast() {
		Node temp = head;
		while (temp != null) {
			// jump
			temp = temp.next;
		}
		return temp.data;
	}

	public int getAt(int idx) {
		Node temp = head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}
	//--------------ADD FUNCTION-----------------------------

	public void addFirst(int ele) {
		Node nn = new Node();
		nn.data = ele;
		nn.next = head;
		head = nn;
	}

	public void addLast(int ele) {
		if (head == null) {
			Node nn = new Node();
			nn.data = ele;
			head = nn;
		} else {
			Node nn = new Node();
			nn.data = ele;
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = nn;
		}
	}

	public void addAt(int idx, int ele) {
		if (idx == 0) {
			addFirst(ele);
		} else if (idx == size()) {
			addLast(ele);
		} else {
			Node prev = head;
			for (int i = 1; i <= idx - 1; i++) {
				prev = prev.next;
			}
			// Create New Node
			Node after = prev.next;
			Node nn = new Node();
			nn.data = ele;
			// connect
			prev.next = nn;
			nn.next = after;

		}
	}
	//---------------GET AT----------------------------

	public Node getat(int idx) {
		Node temp = head;
		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}
		return temp;
	}
	//---------------------------------------------------------

	// Remove Function
	public int removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("LL is Empty!");
		}
		int data = head.data;
		head = head.next;
		return data;
	}

	public int removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("LL is Empty!");
		}

		Node temp = getat(size() - 2);
		Node last = temp.next;
		int data = temp.data;
		// break connection
		temp.next = null;
		return data;

	}

	public int removeAt(int idx) throws Exception {
		if (idx == 0) {
			return removeFirst();
		} else if (idx == size() - 1) {
			return removeLast();
		} else {
			Node temp1 = getat(idx - 1);
			Node temp2 = temp1.next; // idx
			Node temp3 = temp2.next; // idx+1
			temp1.next = temp3;
			return temp2.data;

		}

	}

//reverse
	public void reverse() {
		Node Prev = null;
		Node Curr = head;
		while (Curr != null) {
			Node After = Curr.next;

			// REVERSE

			Curr.next = Prev;

			// UPDATE
			Prev = Curr;
			Curr = After;

		}
		head = Prev;

	}

//Recursive code of reverse
	public void rec_rev() {
//		rec_rev(null,head);
		Node temp=head;
		rec_rev_single_param(head);
		temp.next=null;
	}
	
	private void rec_rev(Node Prev, Node Curr) {
		if (Curr == null) {
			//Head Update
			head = Prev;
			return;
		}
		rec_rev(Curr, Curr.next);
		Curr.next = Prev;
	}
	//Recursive Code With Single Parameter
	private void rec_rev_single_param(Node Prev) {
		Node Curr=Prev.next;
		if(Curr==null) {
//			head.next=null;
			
			head=Prev;
			return;
		}
		
		rec_rev_single_param(Curr);
//		System.out.println(Prev.data +" "+ Curr.data);
		Prev.next.next=Prev;
				
	}
	//---------------GET MIDDLE NODE-----------------------
	public int mid() {
		Node Fast=head;
		Node Slow=head;
		while(Fast.next.next!=null &&Fast.next!=null) {
			Fast=Fast.next.next;
			Slow=Slow.next;
		}
		return Slow.data;
		
	}
	//----------------GET Kth LAST NODE DATA-------------------
	public int k_ele(int k) {
		Node Fast=head;
		Node Slow=head;
		for(int i=0;i<k;i++) {
			Fast=Fast.next;
		}
		while(Fast!=null) {
			Fast=Fast.next;
			Slow=Slow.next;
			
		}
		return Slow.data;
	}
//--------FIND INTERSECTING NODE DATA FROM 2 LINKED LIST-------
	public Node intersect(Node head1,Node head2) {
		Node car1=head1;
		Node car2=head2;
		while(car1!=car2) {
			if(car1!=null) {
				car1=car1.next;
			}
			else {
				car1=head2;
			}
			if(car2==null) {
				car2=head1;
			}
			else {
				car2=car2.next;
			}
			
		}
		return car1;
	}
	public void linked_list() {
		Node n1=new Node(1);
		Node n2=new Node(2);
		Node n3=new Node(3);
		Node n4=new Node(4);
		Node n5=new Node(5);
		Node n6=new Node(6);
		Node n7=new Node(7);
		Node n8=new Node(8);
		Node n9=new Node(9);
		Node n11=new Node(11);
		Node n12=new Node(12);
		n1.next=n2;
		n2.next=n3;
		n3.next=n4;
		n4.next=n5;
		n5.next=n6;
		n6.next=n7;
		n7.next=n8;
		n8.next=n9;
		n11.next=n12;
//		n12.next=n8;
		display(n1);
		System.out.println();
		display(n11);		
		System.out.println();
		display();
		display(intersect(n1, n11));
		System.out.println();
//		System.out.println((intersect(n1, n11).data));
		System.out.println((intersect(n1, n11)));
		
	}//PRIVATE DISP FUNC FOR PRINTING LINKED LIST WE HAVE CREATED
	private void display(Node temp) {//CREATE CONSTRUCTOR OF NODE SINGLE PARAMETER AND EMPTY PARAMETER
		
		while (temp != null) {
			System.out.print(temp.data + " ");
			// jump
			temp = temp.next;
		}
}}
