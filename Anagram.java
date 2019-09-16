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
		//ensure that ASCII's match
		String s1Lower = s1.toLowerCase();
		String s2Lower = s2.toLowerCase();
		Comparator<String> comp = (s1,s2) -> s1Lower.compareTo(s2Lower);
		//set flag
		boolean found = false;
		String firstLetter = "";
		String secondLetter = "";
		for (int i = 0; i < s1Lower.length() - 1; i++) {
			// get letter
			firstLetter = s1Lower.substring(i, i + 1);
			for (int j = 0; j < s1Lower.length(); j++) {
				//find letter in other word
				secondLetter = s2Lower.substring(j, j + 1);
				if (firstLetter.compareTo(secondLetter) == 0) {
					found = true;
				}
			}
			if (!found)
				return false;
		}
		return true;
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
	public List<String> getLargestAnagramGroup(String filename) {
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
	public <T> void insertionSort(List<T> list, Comparator<? super T> order) {

	}

	/**
	 * Returns a case-insensitive sorted version of the input String. For example,
	 * if {@code str = "Utah"}, it returns {@code "ahtu"}. This sorting must be done
	 * using insertion sort.
	 * 
	 * @param str string to be sorted
	 * @return sorted string
	 */
	public static String sort(String str) {
		return null;
	}

	/**
	 * Returns the largest group of anagrams in the input list of words, in no
	 * particular order.
	 * 
	 * @param input list of strings
	 * @return largest group of anagrams in {@code input}
	 */
	public List<String> getLargestAnagramGroup(List<String> input) {

		return null;
	}

}
