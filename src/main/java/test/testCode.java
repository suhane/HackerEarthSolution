package test;

public class testCode {
 public static void main(String args[]){
	 //testTrie();
	 testlinkedlist();
	 //testdll();
	 //testqueue();
	 //teststack();
 }

private static void teststack() {
	Stack stack=new Stack();
	stack.push(1);
	stack.print();
	stack.push(2);
	stack.print();
	stack.push(3);
	stack.print();
	stack.push(4);
	stack.print();
	stack.push(5);
	stack.print();
	stack.push(6);
	stack.print();
	stack.pop();
	stack.print();
	stack.pop();
	stack.print();
	stack.pop();
	stack.print();
	stack.pop();
	stack.print();
	stack.pop();
	stack.print();
	stack.pop();
	stack.print();
	
}

private static void testqueue() {
	Queue queue=new Queue();
	queue.enqueue(1);
	queue.print();
	queue.enqueue(2);
	queue.print();
	queue.enqueue(3);
	queue.print();
	queue.enqueue(4);
	queue.print();
	queue.enqueue(5);
	queue.print();
	queue.enqueue(6);
	queue.print();
	queue.dequeue();
	queue.print();
	queue.dequeue();
	queue.print();
	queue.dequeue();
	queue.print();
	queue.dequeue();
	queue.print();
	queue.dequeue();
	queue.print();
	queue.dequeue();
	queue.print();
	
}

private static void testTrie() {
	Trie t = new Trie();
	t.insert( "hac" );
	t.insert( "hack" );
	
}

private static void testlinkedlist() {
	LinkList list=new LinkList();
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(4);
	list.add(5);
	list.add(6);
	list.print();
	//list.swap(2, 11);
	//list.print();
	System.out.println(list.getElemFromLast(1));
	
	
}

private static void testdll() {
	DoubleLinkedList dll=new DoubleLinkedList();
	 dll.add(1);
	 dll.add(12);
	 dll.add(33);
	 dll.print();
	 dll.addinSortedList(3);
	 dll.print();
	 dll.addinSortedList(2);
	 dll.print();
	 dll.addinSortedList(-1);
	 dll.print();
	 dll.reverse();
	 dll.print();
	
}
}