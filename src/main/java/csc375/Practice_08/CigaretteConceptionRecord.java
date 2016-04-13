package csc375.Practice_08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    public static void main( String[] args ) throws IOException {
//    	calculateAverageSize();
//    	rangeStuff();
    	multimapStuff();
    }
    
    public static double calculateAverageSize() {
//    	ArrayListMultimap<Integer, Integer> almm = readCSVData("Doctor.csv");
//    	List<Integer> al = (List<Integer>) almm.get(4);
//    	int numFamilies = al.size();
//    	int total = 0;
    	
//    	 for (int i : al) {
//    		 total += i;
//    	 }
    	
//    	return ((double)total / (double)numFamilies);
    	return 0;
    }
    
    public static ArrayListMultimap<Integer, Integer> multimapStuff() throws IOException {
    	ArrayListMultimap<Integer, Integer> multimap = ArrayListMultimap.create();
    	String currLine;
    	
    	BufferedReader br = getBufferedReader("Doctor.csv");
		while ((currLine = br.readLine()) != null) {
			String[] splitLine = currLine.split(",");
		
			CigaretteConceptionRecord ccr =
				new CigaretteConceptionRecord(
					Integer.parseInt(splitLine[0].replaceAll("\"", "")),
					Integer.parseInt(splitLine[1]),
					Integer.parseInt(splitLine[2]),
					Double.parseDouble(splitLine[3]),
					Double.parseDouble(splitLine[4]));
		
			multimap.put(ccr.getDoctor(), ccr.getChildren());
		}

    	return multimap;
    }
    
    public static int rangeStuff() throws IOException {
    	TreeRangeSet<Integer> lowerHalf = TreeRangeSet.create();
    	TreeRangeSet<Integer> upperHalf = TreeRangeSet.create();
    	String currLine;
    	
    	lowerHalf.add(Range.open(0, 5000));
    	upperHalf.add(Range.closedOpen(5000, 10000));
    	
//    	System.out.println(lowerHalf.contains(2500));
//    	System.out.println(lowerHalf.contains(7500));

    	BufferedReader br = getBufferedReader("Doctor.csv");
		while ((currLine = br.readLine()) != null) {
			String[] splitLine = currLine.split(",");
		
			CigaretteConceptionRecord ccr =
				new CigaretteConceptionRecord(
					Integer.parseInt(splitLine[0].replaceAll("\"", "")),
					Integer.parseInt(splitLine[1]),
					Integer.parseInt(splitLine[2]),
					Double.parseDouble(splitLine[3]),
					Double.parseDouble(splitLine[4]));
		
//			multimap.put(ccr.getDoctor(), ccr.getChildren());
		}

    	return 0;
    }
    
    public static BufferedReader getBufferedReader (String fileName) {
    	File csvFile = new File(fileName);
    	BufferedReader br = null;
    	
    	try {
    		br = new BufferedReader(new FileReader(csvFile));
    		br.readLine(); // Skip over the header line of the file
    		
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
		return br;
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