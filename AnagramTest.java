package assignment04;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;


public class AnagramTest {
	
	
	@Test
	public void testAreAnagrams() {
		String s1 = "Caters";
		String s2 = "caster";
		assertEquals(true, Anagram.areAnagrams(s1,s2));
	}
	
	@Test
	public void testAreNotAnagrams() {
		String s1 = "Caterr";
		String s2 = "caster";
		assertEquals(false, Anagram.areAnagrams(s1,s2));
	}

	@Test
	public void testSort() {
		String s1 = "Utah";
		assertEquals("ahtu", Anagram.sort(s1));
	}
	
	@Test
	public void testSort2() {
		String s1 = "ziploc";
		assertEquals("cilopz", Anagram.sort(s1));
	}
	
	@Test
	public void getLargestAnagramGroupReadFileTest() {
		List <String> list = new ArrayList<>();
		list = Anagram.getLargestAnagramGroup("root/words.txt");
		list.get(0);
	}
	
	@Test
	public void getLargestAnagramGroupStringInputTest() {
		List <String> list = new ArrayList<>();
		List <String> compare = new ArrayList<>(
			List.of("carets", 
					"Caters", 
					"caster", 
					"crates", 
					"Reacts", 
					"recast"
					));
		list = Anagram.getLargestAnagramGroup("root/words.txt");
		assertEquals(compare, list);
	}
	
	@Test
	public void getLargestAnagramGroupStringInputTestModerateList() {
		List <String> list = new ArrayList<>();
		List <String> compare = new ArrayList<>(
			List.of("act",
					"cat"
					));
		list = Anagram.getLargestAnagramGroup("root/moderate_word_list.txt");
		assertEquals(compare, list);
	}
	
	@Test
	public void getLargestAnagramGroupStringInputTestDictionary() {
		List <String> list = new ArrayList<>();
		List <String> compare = new ArrayList<>(
			List.of("apers",
					"apres",
					"asper",
					"pares",
					"parse",
					"pears",
					"rapes",
					"reaps",
					"spare",
					"spear"
					));
		list = Anagram.getLargestAnagramGroup("root/words_english.txt");
		assertEquals(compare, list);
	}
	
	
	@Test 
	public void getLargestAnagramInGroupFirstTenThousandOfDictionary() {
		List<String> anagramList = new ArrayList<>();
		SimpleReader file = new SimpleReader1L("root/words_english.txt"); 
		List<String> list = new ArrayList<>();
		String line = file.nextLine(); //lines of the file
		while (!file.atEOS()) {  
			list.add(line); //add each line of the file
			line = file.nextLine();
		}
		file.close();
		
		List<String> listOfTenThousand = new ArrayList<>(); //create a new list
		for(int i = 0; i < 10_000; i++) //add lines one through ten thousand
			listOfTenThousand.add(list.get(i));
		
		anagramList = Anagram.getLargestAnagramGroup(listOfTenThousand);
	}
	
	@Test
	public void timeOfGetLargestAnagramInGroup() {
		List<String> anagramList = new ArrayList<>();
		SimpleReader file = new SimpleReader1L("root/words_english.txt"); 
		List<String> list = new ArrayList<>();
		String line = file.nextLine(); //lines of the file
		while (!file.atEOS()) {  
			list.add(line); //add each line of the file
			line = file.nextLine();
		}
		file.close();
		
		SimpleReader file2 = new SimpleReader1L("root/words.txt"); 
		//read words.txt to anagramList
		String line2 = file2.nextLine(); //lines of the file
		while (!file2.atEOS()) {  
			anagramList.add(line2); //add each line of the file
			line2 = file2.nextLine();
		}
		file2.close();
		
		int index = 0;
		while(index < list.size()/50) { //get 1/50th of the dictionary
			long start = System.nanoTime();
			Anagram.getLargestAnagramGroup(anagramList);
			long stop = System.nanoTime();
			System.out.println((stop - start));
			System.out.println(anagramList.size());
			//add the next ten items from the list
			for(int i = 0; i < 15; i++) {
				anagramList.add(list.get(index + i));
			}
			index += 15;
		}
	}
	
	@Test
	public void timeOfAreAnagrams() {
		List<String> anagramList = new ArrayList<>();
		SimpleReader file = new SimpleReader1L("root/words_english.txt"); 
		List<String> list = new ArrayList<>();
		String line = file.nextLine(); //lines of the file
		while (!file.atEOS()) {  
			list.add(line); //add each line of the file
			line = file.nextLine();
		}
		file.close();
		
		SimpleReader file2 = new SimpleReader1L("root/words.txt"); 
		//read words.txt to anagramList
		String line2 = file2.nextLine(); //lines of the file
		while (!file2.atEOS()) {  
			anagramList.add(line2); //add each line of the file
			line2 = file2.nextLine();
		}
		file2.close();
		
		int index = 0;
		String anagram = "";
		String anagramScrabled = "";
		while(index < list.size()/50) { //get 1/50th of the dictionary
			long start = System.nanoTime();
			for(int i = 0; i + 1 < anagramList.size(); i++) {
				Anagram.areAnagrams(anagram, anagramScrabled);
			}
			long stop = System.nanoTime();
			System.out.println(anagram.length());
			System.out.println(stop - start);
			//add the next ten items from the list
			for(int i = 0; i < 10; i++) {
				anagram += list.get(index + i).charAt(0);
			}
			anagramScrabled = anagram.substring(0, anagram.length()/2);
			anagramScrabled += anagram.substring(anagram.length()/2, anagram.length());
			index += 10;
		}
	}
	
	@Test
	public void timeOfInsertionSort() {
		List<String> anagramList = new ArrayList<>();
		List<String> anagramListTemp = new ArrayList<>();
		SimpleReader file = new SimpleReader1L("root/words_english.txt"); 
		List<String> list = new ArrayList<>();
		String line = file.nextLine(); //lines of the file
		while (!file.atEOS()) {  
			list.add(line); //add each line of the file
			line = file.nextLine();
		}
		file.close();
		
		SimpleReader file2 = new SimpleReader1L("root/words.txt"); 
		//read words.txt to anagramList
		String line2 = file2.nextLine(); //lines of the file
		while (!file2.atEOS()) {  
			anagramList.add(line2); //add each line of the file
			line2 = file2.nextLine();
		}
		file2.close();
		Comparator<String> order = (s1, s2) -> {return s1.compareTo(s2);};
		
		int index = 0;
		while(index < list.size()/50) { //get 1/50th of the dictionary
			for(String i: anagramList) //copy the unsorted array
				anagramListTemp.add(i);
			long start = System.nanoTime();
			Anagram.insertionSort(anagramList, order);
			long stop = System.nanoTime();
			anagramList.clear();
			for(String i: anagramListTemp) //reset the array to unsorted
				anagramList.add(i);
			anagramListTemp.clear();
			System.out.println((stop - start));
			System.out.println(anagramList.size());
			//add the next ten items from the list
			for(int i = 0; i < 15; i++) {
				anagramList.add(list.get(index + i));
			}
			index += 15;
		}
	}
	
	@Test
	public void timeOfArrayListSort() {
		List<String> anagramList = new ArrayList<>();
		List<String> anagramListTemp = new ArrayList<>();
		SimpleReader file = new SimpleReader1L("root/words_english.txt"); 
		List<String> list = new ArrayList<>();
		String line = file.nextLine(); //lines of the file
		while (!file.atEOS()) {  
			list.add(line); //add each line of the file
			line = file.nextLine();
		}
		file.close();
		
		SimpleReader file2 = new SimpleReader1L("root/words.txt"); 
		//read words.txt to anagramList
		String line2 = file2.nextLine(); //lines of the file
		while (!file2.atEOS()) {  
			anagramList.add(line2); //add each line of the file
			line2 = file2.nextLine();
		}
		file2.close();
		Comparator<String> order = (s1, s2) -> {return s1.compareTo(s2);};
		
		int index = 0;
		while(index < list.size()/50) { //get 1/50th of the dictionary
			for(String i: anagramList) //copy the unsorted array
				anagramListTemp.add(i);
			long start = System.nanoTime();
			anagramList.sort(order);
			long stop = System.nanoTime();
			anagramList.clear();
			for(String i: anagramListTemp) //reset the array to unsorted
				anagramList.add(i);
			anagramListTemp.clear();
			System.out.println((stop - start));
			System.out.println(anagramList.size());
			//add the next ten items from the list
			for(int i = 0; i < 15; i++) {
				anagramList.add(list.get(index + i));
			}
			index += 15;
		}
	}
	
	@Test
	public void timeOfArrayListSortInegers() {
		List<Integer> anagramList = new ArrayList<>();
		List<Integer> anagramListTemp = new ArrayList<>();
		anagramList.add(500);
		
		Comparator<?  super Integer> order = (s1, s2) -> {return s1.compareTo(s2);};
		
		int index = 0;
		while(index < 10_000) { //test the first 50,000 integers
			for(Integer i: anagramList) //copy the unsorted array
				anagramListTemp.add(i);
			long start = System.nanoTime();
			anagramList.sort(order);;
			long stop = System.nanoTime();
			anagramList.clear();
			for(Integer i: anagramListTemp) //reset the array to unsorted
				anagramList.add(i);
			anagramListTemp.clear();
			System.out.println((stop - start));
			System.out.println(anagramList.size());
			//add the next ten items from the list
			for(int i = 0; i < 50; i++) {
				Integer j = (int) Math.random() * 1_000;
				anagramList.add(j);
			}
			index += 50;
		}
	}

	@Test
	public void timeOfInsertionSortInegers() {
		List<Integer> anagramList = new ArrayList<>();
		List<Integer> anagramListTemp = new ArrayList<>();
		anagramList.add(500);
		
		Comparator<?  super Integer> order = (s1, s2) -> {return s1.compareTo(s2);};
		
		int index = 0;
		while(index < 10_000) { //test the first 50,000 integers
			for(Integer i: anagramList) //copy the unsorted array
				anagramListTemp.add(i);
			long start = System.nanoTime();
			anagramList.sort(order);;
			long stop = System.nanoTime();
			anagramList.clear();
			for(Integer i: anagramListTemp) //reset the array to unsorted
				anagramList.add(i);
			anagramListTemp.clear();
			System.out.println((stop - start));
			System.out.println(anagramList.size());
			//add the next ten items from the list
			for(int i = 0; i < 50; i++) {
				Integer j = (int) Math.random() * 1_000;
				anagramList.add(j);
			}
			index += 50;
		}
	}
}