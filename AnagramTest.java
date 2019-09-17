package assignment04;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

public class AnagramTest {

	@Before
	public void  setUp(){
		List<String> list = new ArrayList<>();
		
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
	public void testGetLargestAnagramGroup() {
		SimpleReader f1 = new SimpleReader1L("/Assignment04-Anagrams/Test/sudoku1.txt");
		Set<String> result = new Set1L<>();
		for(int i = 0; i < 9; i++) {
			result.add(f1.nextLine());
		}
		f1.close();
		List<String> input = Anagram.getLargestAnagramGroup("/Assignment04-Anagrams/Test/sudoku1.txt");
		assertEquals(result, input);
	}

}
