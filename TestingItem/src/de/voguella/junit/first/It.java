package de.voguella.junit.first;


import java.util.ArrayList;


public class It {
	
	private String name, brand, description, link, price, categorytag, imageFile;
	private ArrayList<String> taglist;
	

	public It(String name){
		this.name = name; 
	}
	
	
	public It (String name, String imageFile, String brand, 
					String price, String description, ArrayList<String> taglist,
					String link, String categorytag){
		this.name = name;
		this.imageFile = imageFile;
		this.brand = brand;
		this.price = price;
		this.description = description;
		this.taglist = taglist;
		this.link = link;
		this.categorytag = categorytag;
	}
	
	//accesor and mutator methods for the class' fields
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name; 
	}

	public String getImageFileString(){
		return imageFile;
	}
	
	public void setImageFileString(String url){
		imageFile = url; 
	}
	
	public String getBrand(){
		return brand;
	}
	
	public void setBrand(String mybrand){
		brand = mybrand; 
	}
	
	public String getPrice(){
		return price;
	}
	
	public void setPrice(String money){
		price = money;
	}
	
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String descript){
		description = descript;
	}
	
	public ArrayList<String> getTagList(){
		return taglist;
	}
	
	public void addTag (String newTag){
		if(!taglist.contains(newTag)){
			taglist.add(newTag);
		}
	}
	
	public String getLink(){
		return link;
	}
	public void setLink(String st){
		link= st;
	}
	
	
	public String getCategoryTag(){
		return categorytag;
	}
	

	public void setCategory(String s){
		categorytag =s;
	}

	
}
