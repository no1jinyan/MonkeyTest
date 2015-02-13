package com.bankht.monkey.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Test {
	/**
	 * vector对比arraylist线程安全/可设定增长长度/空间不足时增加的空间不同
	 * linkedlist有堆栈操作
	 */
	private static ArrayList<String> arrayList = new ArrayList<String>();
	private static Vector<String> vector = new Vector<String>();
	private static LinkedList<String> linkedList = new LinkedList<String>();

	private static List<String> temple = Arrays.asList(new String[] { "111",
			"222", "333" });

	public static void printList(List<String> list) {
		int count = 0;
		for (String object : list) {
			System.out.println(count++ + " : " + object);
		}
		System.out.println();
	}

	public static void out(Object obj) {
		System.out.println(obj);
		System.out.println();
	}

	public static void testArrayList() {
		arrayList.addAll(temple);
		arrayList.add(null);
		printList(arrayList);

		arrayList.add(2, "000");
		printList(arrayList);
	}

	public static void testVector() {
		vector.addAll(temple);
		vector.add(null);
		printList(vector);

		vector.addElement("444");
		printList(vector);

		out(vector.capacity());
		vector.trimToSize();
		out(vector.capacity());

		vector.removeAll(temple);
		printList(vector);

		vector.addElement("444");
		vector.addElement("555");
		vector.addElement("666");
		vector.addElement("777");
		vector.addElement("888");
		vector.addElement("999");
		vector.addElement("000");
		vector.addElement("123");
		printList(vector);
		out(vector.capacity());
		
		vector.addElement("444");
		vector.addElement("555");
		vector.addElement("666");
		printList(vector);
		out(vector.capacity());
	}

	public static void testLinkedList() {
		linkedList.addAll(temple);
		linkedList.push("444");
		linkedList.addLast(null);
		printList(linkedList);

		out(linkedList.poll());
		printList(linkedList);

		linkedList.offerFirst("444");
		out(linkedList.peekFirst());
		printList(linkedList);

		out(linkedList.pollLast());
		printList(linkedList);

		for (Iterator<String> iterator = linkedList.descendingIterator(); iterator
				.hasNext();) {
			out((String) iterator.next());
		}
	}

	public static void main(String[] args) {
		// testArrayList();
		 testVector();
//		testLinkedList();
	}

}
