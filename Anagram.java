package assignment04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

public class Anagram {
	
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	private static List<Integer> anagram(List<String> list){
		List<Integer> mostAnagramIndexes = new ArrayList<>();
		List<Integer> nextAnagramIndexes = new ArrayList<>();
		String currentAnagram = list.get(0);
		nextAnagramIndexes.add(0);
		
		int index = 0;
		while(index + 1 < list.size()) {
			while(index + 1 < list.size() && areAnagrams(currentAnagram, list.get(index + 1))) { //while on the current anagram
				nextAnagramIndexes.add(index + 1);
				index++;
			}
			if(nextAnagramIndexes.size() > mostAnagramIndexes.size()) {
				mostAnagramIndexes.clear();
				for(Integer i: nextAnagramIndexes) {
					mostAnagramIndexes.add(i);
				}
			}
			nextAnagramIndexes.clear();
			nextAnagramIndexes.add(index);
			if(index + 1 < list.size()) {
				currentAnagram = list.get(index);
				if(!areAnagrams(currentAnagram, list.get(index + 1)))
					index++;
					currentAnagram = list.get(index);
					nextAnagramIndexes.clear();
					nextAnagramIndexes.add(index);
			}
		}
		return mostAnagramIndexes;
	}
	
	/**
	 * Pulls the words from the file and puts them into a list.
	 * @param filename being read.
	 * @return list of words.
	 */
	private static List<String> readFile(String filename){
		SimpleReader file = new SimpleReader1L(filename);
		List<String> list = new ArrayList<>();
		String line = file.nextLine();
		while (!file.atEOS()) {  
			list.add(line);
			line = file.nextLine();
		}
		file.close();
		return list;
	}
	
	/**
	 * Swaps T elements to their corresponding location.
	 * @param <T> Generic type.
	 * @param index of list.
	 * @param list of T elements.
	 */
	private static <T> void swapItems(int index, List<T> list){
		T temp = list.get(index);
		list.set(index, list.get(index + 1));
		list.set(index + 1, temp);

	}
	
	/**
	 * Swaps integers to their corresponding location.
	 * @param index of list.
	 * @param list of integers.
	 */
	private static void swapItems(int index, int[] list){
		int temp = list[index];
		list[index] = list[index + 1];
		list[index + 1] = temp;
	}
	
	/**
	 * @param list
	 * @param order
	 * @return
	 */
	private static <T> List<T> sortData(List<T> list, Comparator<? super T> order) {
		
		int currentIndex = 0;
    	boolean postionFound = false;
    	int compareIndex = 0;
    	
		while(currentIndex + 1 < list.size()) {
    		postionFound = false;
    		compareIndex = currentIndex;
    		while(!postionFound) { //as long as the number is not sorted
    			if(order.compare(list.get(compareIndex), list.get(compareIndex + 1)) <= 0) //if the next number is less than the last one
    				postionFound = true;
    			else { //swap the two values
    				swapItems(compareIndex, list);
    				compareIndex--;
    				if(compareIndex < 0)
    					postionFound = true;
    			}
    		}
    		currentIndex++;
    	}
		return list;
	}
	

	/**
	 * Ensures that the list is sorted. This is done by insertion sort.
	 * @param list of T elements that need sorting.
	 * @param order Comparator that uses a comparable to ensure proper placement.
	 * @param indexes Array of locations that the list of T elements are in.
	 * @return A sorted list of T elements.
	 */
	private static <T> List<T> sortData(List<T> list, Comparator<? super T> order, int[] indexes){
		int currentIndex = 0;
    	boolean postionFound = false;
    	int compareIndex = 0;
    	
		while(currentIndex + 1 < list.size()) {
    		postionFound = false;
    		compareIndex = currentIndex;
    		while(!postionFound) { //as long as the number is not sorted
    			if(order.compare(list.get(compareIndex), list.get(compareIndex + 1)) <= 0) //if the next number is less than the last one
    				postionFound = true;
    			else { //swap the two values
    				swapItems(compareIndex, list);
    				swapItems(compareIndex, indexes);
    				compareIndex--;
    				if(compareIndex < 0)
    					postionFound = true;
    			}
    		}
    		currentIndex++;
    	}
		return list;
	}

	/**
	 * Reports whether the two input strings are anagrams of each other. *
	 * 
	 * @param s1 the first candidate string
	 * @param s2 the second candidate string
	 * @return true iff {@code s1} and {@code s2} are anagrams of each other
	 */

	public static boolean areAnagrams(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;
		boolean result = false;
		String sort1 = sort(s1);
		String sort2 = sort(s2);
		if(sort1.compareTo(sort2) == 0 ) {
			result = true;
		}
		return result;
	}

	/**
	 * Returns the largest group of anagrams from the list of words in the given
	 * file, in no particular order.
	 * 
	 * It is assumed that the file contains one word per line. If the file is empty,
	 * the method returns an empty list because there are no anagrams.
	 * 
	 * @param filename file to read strings from
	 * @return largest group of anagrams in the input file
	 */
	public static List<String> getLargestAnagramGroup(String filename) {
		List<String> list = new ArrayList<>();
		list = readFile(filename);
		list = getLargestAnagramGroup(list);
		return list;
	}

	/**
	 * Sorts the input list using an insertion sort and the input {@code Comparator}
	 * * object. *
	 * 
	 * @param <T>   type of the element of the list
	 * @param list  input list
	 * @param order comparator used to sort elements
	 * 
	 * @modifies {@code list}
	 */
	public static <T> void insertionSort(List<T> list, Comparator<? super T> order) {
		int currentIndex = 0;
    	boolean postionFound = false;
    	int compareIndex = 0;
    	T temp = list.get(0);
    	
		while(currentIndex + 1 < list.size()) {
    		postionFound = false;
    		compareIndex = currentIndex;
    		while(!postionFound) { //as long as the number is not sorted
    			if(order.compare(list.get(compareIndex), list.get(compareIndex + 1)) <= 0) //if the next number is less than the last one
    				postionFound = true;
    			else { //swap the two values
    				swapItems(compareIndex, list);
    				compareIndex--;
    				if(compareIndex < 0)
    					postionFound = true;
    			}
    		}
    		currentIndex++;
    	}
	}

	/**
	 * Returns a case-insensitive sorted version of the input String. For example,
	 * if {@code str = "Utah"}, it returns {@code "ahtu"}. This sorting is done
	 * using insertion sort.
	 * 
	 * @param str string to be sorted
	 * @return sorted string
	 */
	public static String sort(String str) {
		String input = str.toLowerCase();
		List<String> chars = new ArrayList<>(str.length()); //create an ArrayList of chars for the insertionSort
		
		for(int i = 0; i < input.length(); i++) {
			chars.add(i, input.substring(i, i + 1));
		}
		
		
		Comparator<String> order = (s1, s2) -> {return s1.compareTo(s2);}; //create the comparator (lambda)
		insertionSort(chars, order);
		String result = "";
		for(String character: chars) {
			result += character;
		}
		return result;
	}

	/**
	 * Returns the largest group of anagrams in the input list of words, in no
	 * particular order.
	 * 
	 * @param input list of strings
	 * @return largest group of anagrams in {@code input}
	 */
	public static List<String> getLargestAnagramGroup(List<String> input) {
		Comparator<String> order = (s1, s2) -> {return s1.compareTo(s2);};
		List<String> largestAnagramGroup = new ArrayList<>();
		List<String> sortedList = new ArrayList<>();
		for(String item: input) {
			sortedList.add(sort(item)); //create a list of sorted elements
		}
		
		int[] indexes = new int[input.size()]; //track the indexes of each anagram
		for(int i = 0; i < indexes.length; i++) {
			indexes[i] = i;
		}
		List<Integer> indexOfAnagrams = new ArrayList<>();
		sortData(sortedList, order, indexes);
		indexOfAnagrams = anagram(sortedList);
		for(Integer i: indexOfAnagrams) {
			largestAnagramGroup.add(input.get(indexes[i]));
		}
		
		return largestAnagramGroup;
	}
	
	public static void main(String[] args) {
		getLargestAnagramGroup("data/words.txt");
	}

}