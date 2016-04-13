package csc375.Practice_08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    public static void main( String[] args ) throws IOException {
    	System.out.println(calculateAverageSize());
    	accessRange();
    }
    
    public static double calculateAverageSize() throws IOException {
    	ArrayListMultimap<Integer, Integer> almm = generateMultimap();
    	List<Integer> al = (List<Integer>) almm.get(4);
    	int numFamilies = al.size();
    	int total = 0;
    	
    	 for (int i : al) {
    		 total += i;
    	 }
    	
    	return ((double)total / (double)numFamilies);
    }
    
    public static ArrayListMultimap<Integer, Integer> generateMultimap() throws IOException {
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
    
    public static int accessRange() throws IOException {
    	TreeRangeSet<Integer> lowerHalf = TreeRangeSet.create();
    	TreeRangeSet<Integer> upperHalf = TreeRangeSet.create();
    	String currLine;
    	int lowerHalfCount = 0;
    	int upperHalfCount = 0;
    	
    	lowerHalf.add(Range.open(0, 500));
    	upperHalf.add(Range.closedOpen(500, 1000));
    	
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
			
			int accessValue = (int) (ccr.getAccess()*1000);
			if (lowerHalf.contains(accessValue)) {
				lowerHalfCount++;
			} else {
				upperHalfCount++;
			}
		
		}
		System.out.printf("lower: %d, upper: %d\n", lowerHalfCount, upperHalfCount);
		return 0;
//    	return lowerHalfCount;
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
    
    /**
	 * @return a String representation of an instance of this class
	 */
	public String toString() {
		return "ID: " + this.id
				+ ", Doctor: " + this.doctor
				+ ", Children: " + this.children
				+ ", Access: " + this.access
				+ ", Health: " + this.health;
	}
    
    /**
     * @return row ID
     */
    public int getId() {
		return id;
	}

    /**
     * @return doctor ID
     */
	public int getDoctor() {
		return doctor;
	}
	
	/**
	 * @return number of children
	 */
	public int getChildren() {
		return children;
	}
	
	/**
	 * @return access value
	 */
	public double getAccess() {
		return access;
	}

	/**
	 * @return health value
	 */
	public double getHealth() {
		return health;
	}
}