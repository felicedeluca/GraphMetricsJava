package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Element implements Comparable<Element> {
	
	public static ArrayList<Element> fetchFromFile(File inputFile){
	
		ArrayList<Element> fetchedItems = new ArrayList<Element>();
		
		try{
		
		FileReader f = new FileReader(inputFile);

		BufferedReader b=new BufferedReader(f);

		String s;			

		while((s=b.readLine())!=null){
			String[] values = s.split(";");
			String name = values[0];
			float x = Float.parseFloat(values[1].replaceAll(",", "."));
			float y = Float.parseFloat(values[2].replaceAll(",", "."));
			
			Element currItem = new Element(name, x, y);
			fetchedItems.add(currItem);
			
		}

		b.close();
		}catch(Exception e){
			System.out.println("Error Fetching Elements");
			e.printStackTrace();
			return new ArrayList<Element>();
			
		}
		
		return fetchedItems;
	}
	
	String filename;
	double x;
	double y;
	double z;
	double k;

	public Element(String filename, double x, double y){
		
		this.filename = filename;
		this.x = x;
		this.y = y;
		
	}
	
	public Element(String filename, double x, double y, double z, double k){
		
		this.filename = filename;
		this.x = x;
		this.y = y;
		this.z = z;
		this.k = k;
		
	}
	
	public String getFilename(){
		return this.filename;
	}
	
	public double getX(){
		return this.x;
	}

	public double getY(){
		return this.y;
	}
	
	public double getZ(){
		return this.z;
	}

	public double getK(){
		return this.k;
	}
	
	
	public String toString(){
		return this.filename + ";" + this.x + ";" + this.y;
	}
	
	@Override
	public int compareTo(Element o) {
	
	return Double.compare(x, o.x);

}
	
	

}
