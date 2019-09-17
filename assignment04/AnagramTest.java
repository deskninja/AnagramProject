package assignment04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import components.set.Set;
import components.set.Set1L;
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
		list = Anagram.getLargestAnagramGroup("data/words.txt");
		list.get(0);
	}
	
	@Test
	public void getLargestAnagramGroupStringInputTest() {
		List <String> list = new ArrayList<>();
		List <String> compare = new ArrayList<>(
			List.of("Caters", 
					"caster", 
					"crates", 
					"Reacts", 
					"recast", 
					"traces"
					));
		list = Anagram.getLargestAnagramGroup("data/words.txt");
		list = Anagram.getLargestAnagramGroup(list);
		//assertEquals(compare, list);
		System.out.println(list.toString());
	}
}