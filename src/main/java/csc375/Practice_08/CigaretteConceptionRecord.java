package csc375.Practice_08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet;

public class CigaretteConceptionRecord {

	private int id;
	private int doctor;
	private int children;
	private double access;
	private double health;
	
	public CigaretteConceptionRecord(int id, int doctor, int children, double access, double health) {
		this.id = id;
		this.doctor = doctor;
		this.children = children;
		this.access = access;
		this.health = health;
	}
	
//	public String toString() {
//		return "ID: " + this.id
//				+ ", Doctor: " + this.doctor
//				+ ", Children: " + this.children
//				+ ", Access: " + this.access
//				+ ", Health: " + this.health;
//	}

    public static void main( String[] args ) {
//    	calculateAverageSize();
    	rangeStuff();
    }
    
    public static double calculateAverageSize() {
    	ArrayListMultimap<Integer, Integer> almm = readCSVData("Doctor.csv");
    	List<Integer> al = (List<Integer>) almm.get(4);
    	int numFamilies = al.size();
    	int total = 0;
    	
    	 for (int i : al) {
    		 total += i;
    	 }
    	
    	return ((double)total / (double)numFamilies);
    }
    
    public static int rangeStuff() {
    	TreeRangeSet health = TreeRangeSet.create();
    	
    	health.add(Range.open(0, 10));
//    	health.add(Range.closedOpen(1, 1));
    	
    	System.out.println(health.contains(2));
    	System.out.println(health.contains(5));
    	
    	return 0;
    }
    
    public static ArrayListMultimap<Integer, Integer> readCSVData(String fileName) {
    	String currLine = null;
    	File csvFile = new File(fileName);
    	ArrayListMultimap<Integer, Integer> multiMap = ArrayListMultimap.create();
    	
    	try {
    		BufferedReader br = new BufferedReader(new FileReader(csvFile));
    		br.readLine(); // Skip over the header line of the file
    		
    		while ((currLine = br.readLine()) != null) {
    			String[] splitLine = currLine.split(",");
    			
    			CigaretteConceptionRecord ccr =
    					new CigaretteConceptionRecord(
    							Integer.parseInt(splitLine[0].replaceAll("\"", "")),
    							Integer.parseInt(splitLine[1]),
    							Integer.parseInt(splitLine[2]),
    							Double.parseDouble(splitLine[3]),
    							Double.parseDouble(splitLine[4]));
    			
    			multiMap.put(ccr.getDoctor(), ccr.getChildren());
    			
//    			System.out.println(ccr.toString());
    		}
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	return multiMap;
    }
    
    public int getId() {
		return id;
	}

	public int getDoctor() {
		return doctor;
	}

	public int getChildren() {
		return children;
	}

	public double getAccess() {
		return access;
	}

	public double getHealth() {
		return health;
	}
}