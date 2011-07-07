package de.vogella.junit.first;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import de.voguella.junit.first.It;


public class ItTest {

	//check of methods set and return the classes' fields correctly
	@Test
	public void testGetName() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		assertEquals("Result", "shirt", tester.getName());
	}
	
	@Test
	public void testSetName() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		tester.setName("pants");
		assertEquals("Result", "pants", tester.getName());
	}
	
	@Test
	public void testGetImageFileString() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		assertEquals("Result", "shirt.jpg", tester.getImageFileString());
	}
	
	@Test
	public void testSetImageFileString() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		tester.setImageFileString("pants.jpg");
		assertEquals("Result", "pants.jpg", tester.getImageFileString());
	}
	
	@Test
	public void testGetBrand() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		assertEquals("Result", "brandeis", tester.getName());
	}
	
	@Test
	public void testSetBrand() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		tester.setBrand("university");
		assertEquals("Result", "university", tester.getBrand());
	}

	@Test
	public void testGetPrice() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		assertEquals("Result", "$50.00", tester.getPrice());
	}
	
	@Test
	public void testSetPrice() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		tester.setPrice("$100.00");
		assertEquals("Result", "$100.00", tester.getPrice());
	}

	@Test
	public void testGetDescription() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		assertEquals("Result", "blue, brandeis logo", tester.getDescription());
	}
	
	@Test
	public void testSetDescription() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		tester.setDescription("red, brandeis owl");
		assertEquals("Result", "red, brandeis owl", tester.getDescription());
	}

	@Test
	public void testGetTagList() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		assertEquals("Result", tags, tester.getTagList());
	}
	
	@Test
	public void testAddTag() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		tester.addTag("university");
		assertEquals("Result", true, tester.getTagList().contains("university"));
	}

	@Test
	public void testGetLink() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		assertEquals("Result", "www.brandeis.edu", tester.getLink());
	}
	
	@Test
	public void testSetLink() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		tester.setLink("www.amazon.com");
		assertEquals("Result", "www.amazon.com", tester.getLink());
	}
	
	
	@Test
	public void testCategoryTag() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		assertEquals("Result", "www.brandeis.edu", tester.getCategoryTag());
	}
	
	@Test
	public void testSetCategory() {
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("college");
		It tester = new It("shirt", "shirt.jpg", "brandeis", 
				"$50.00", "blue, brandeis logo", tags,
				"www.brandeis.edu", "tops");
		tester.setCategory("university");
		assertEquals("Result", "university", tester.getCategoryTag());
	}
}
