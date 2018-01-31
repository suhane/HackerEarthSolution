package asde2;

import test.LinkList;
import test.LinkList.Node;

public class Mergepoint {
	
	public static void main(String args[]){
		LinkList l1=new LinkList();
		LinkList l2=new LinkList();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l2.add(9);
		l2.add(6);
		l2.add(3);
		l2.add(4);
		System.out.println(getMergePoint(l1,l2));
	}

	private static int getMergePoint(LinkList l1, LinkList l2) {
		int countA=l1.size();
		int countB=l2.size();
		Node headA=l1.getHead();
		Node headB=l2.getHead();
		if(countA>countB){
			int i=0;
			while(i++<countA-countB){
				headA=headA.getNext();
			}
		}
		if(countB>countA){
			int i=0;
			while(i++<countB-countA){
				headB=headB.getNext();
			}
		}
		
		while(headA!=null && headB!=null){
			headA=headA.getNext();
			headB=headB.getNext();
			if(headA.equals(headB))
				return headA.getData();
		}
		return -1;
	}

	
}
