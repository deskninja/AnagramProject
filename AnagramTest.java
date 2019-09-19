package assignment04;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;


public class AnagramTest {
	

	@Before
	public void  setUp() {

	}
	
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
	public void getLargestAnagramGroupFirstTwentyInModerateArray() {
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
		list = Anagram.getLargestAnagramGroup("root/firstTwenty.txt");
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
		System.out.println(anagramList.toString());
	}
}