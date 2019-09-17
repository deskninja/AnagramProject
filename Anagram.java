package assignment04;

import java.util.Comparator;
import java.util.List;

public class Anagram {
	

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
		return null;
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
//    			if(list.get(compareIndex) < arr[compareIndex + 1]) //if the next number is less than the last one
//    				postionFound = true;
    			if(order.compare(list.get(compareIndex), list.get(compareIndex)) < 0) {
    				
    			}
    			else { //swap the two values
    				temp = list.get(compareIndex);
    				list.set(compareIndex, list.get(compareIndex + 1));
    				list.set(compareIndex + 1, temp);
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
		char[] arrayOfChars = new char[input.length()];
		for(int i = 0; i < input.length(); i++) {
			arrayOfChars[i] = input.charAt(i);
		}
		char temp = 0;
		for(int i =0; i < arrayOfChars.length - 1; i++) {
			for(int j = i + 1; j > 0; j--) {
				if(arrayOfChars[j] < arrayOfChars[j - 1]) {
					temp = arrayOfChars[j];
					arrayOfChars[j] = arrayOfChars[j - 1];
					arrayOfChars[j - 1] = temp;
				}
			}
		}
		String result = "";
		for(int i = 0; i < arrayOfChars.length; i++) {
			result += arrayOfChars[i];
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
		
		return null;
	}
	
	public static void main(String[] args) {
		Comparator<String> order = (s1, s2) -> {return s1.compareTo(s2);};
		
		
	}

}