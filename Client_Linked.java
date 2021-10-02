package Lecture_45_46__Linked_List;

public class Client_Linked {
	public static void main(String[] args) {
		Linked_List LL = new Linked_List();
		System.out.println(LL.isEmpty());
		LL.addLast(10);
		LL.display();
		LL.addLast(20);
		LL.display();
		LL.addLast(30);
		LL.display();
		LL.addLast(40);
		LL.display();
		LL.addLast(50);
		LL.addLast(60);
//		LL.addAt(2, 50);

		LL.display();
		System.out.println(LL.size());

//		LL.reverse();
//		LL.display();
		LL.rec_rev();
		LL.rec_rev();

		LL.display();
//		System.out.println(LL.mid());
//		System.out.println("---------------------");
//		System.out.println(LL.k_ele(1));
//		System.out.println(LL.k_ele(2));
//		System.out.println(LL.k_ele(3));
//		System.out.println(LL.k_ele(4));
//		System.out.println(LL.k_ele(5));
//		System.out.println(LL.k_ele(10));
//		LL.linked_list();
		
		

	}

}
