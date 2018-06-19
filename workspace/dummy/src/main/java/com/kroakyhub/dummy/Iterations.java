package com.kroakyhub.dummy;

import java.util.*;
import java.util.Map.Entry;

public class Iterations {

	public static void main(String[] args) {
		Map<String,String> map1 = new HashMap<String, String>();
		map1.put("Amit", "Srimanti's boy friend");
		map1.put("Sri", "Amit's girl friend");
		map1.put("Badri", "Scotch's owner");
		map1.put("Scotch", "cute doggie");
		map1.put("Sri", "Cute girl");
		
		for( Entry<String, String> map1entry : map1.entrySet()){
			System.out.println("Key ---> " + map1entry.getKey() + "Value --->" + map1entry.getValue());
		}
	}

	public void SetIterator() {
		Set<String> set1 = new HashSet<String>();
		set1.add("Amit");
		set1.add("Sri");
		set1.add("Amit");
		set1.add("Sri");

		set1.size();
		Iterator<String> set1Iterator = set1.iterator();
		while (set1Iterator.hasNext()) {
			System.out.println("Value ------------> " + set1Iterator.next());
		}
	}

	public void ListIterations() {
		// Iteration in a List

		List<String> list1 = new ArrayList<String>();

		list1.add("Sri1");
		list1.add("Sri2");
		list1.add("Sri3");
		list1.add("Sri4");
		list1.add("Sri5");
		list1.add("Sri6");
		list1.add("Sri7");

		for (int i = 0; i < list1.size(); i++) {
			System.out.println("List value -----> " + list1.get(i));
		}

		System.out.println("=====================");

		for (String name : list1) {
			System.out.println("List value -----> " + name);
		}

		System.out.println("=====================");

		Iterator<String> list1Iterator = list1.iterator();
		while (list1Iterator.hasNext()) {
			System.out.println("List value -----> " + list1Iterator.next());
		}
	}

	public void ArrayIterations() {
		// Iterations in an Array

		// Values can be inserted in an Array in 2 ways:

		// Way 1
		String[] array1 = { "Sri", "Amit", "Badri", "Anu", "Neetu", "Anku" };

		// Way 2
		String[] array2 = new String[5];
		array2[0] = "Sri";
		array2[1] = "Amit";

		/*
		 * System.out.println(array1[0]); System.out.println(array1[1]);
		 */

		// To get values from an array we need loop

		// FOR loop:
		for (int i = 0; i < array1.length; i++) {
			System.out.println("Array value -----> " + array1[i]);
		}

		System.out.println("=====================");
		// While loop:
		int i = 0;
		while (i < array1.length) {
			System.out.println("Array---> " + array1[i]);
			i++;
		}

		System.out.println("=====================");
		// Do-while loop:
		int j = 0;
		do {
			System.out.println("Array---> " + array1[j]);
			j++;
		} while (j < array1.length);
	}

}
