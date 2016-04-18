// Wes Breisch & Ian Jacobs
// CSC375 Practice #8

package csc375.Practice_08.problem01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Range;
import com.google.common.collect.TreeRangeSet;

public class HealthRecord {

	private int id;
	private int doctor;
	private int children;
	private double access;
	private double health;
	
	/**
	  * Constructor.
	  * 
	  * Empty constructor for running test cases
	  */
    public HealthRecord() {}

    /**
     * Constructor.
     * 
     * @param id (required) 
     * @param doctor (required) 
     * @param children (required) 
     * @param access (required) 
     * @param health (required) 
     */
	public HealthRecord(int id, int doctor, int children, double access, double health) {
		this.id = id;
		this.doctor = doctor;
		this.children = children;
		this.access = access;
		this.health = health;
	}

	/**
	 * 
	 * @return The average number of doctor visits by a family of four people per year
	 * @throws IOException
	 */
    public double calculateAverageDoctorVisits() throws IOException {
    	ArrayListMultimap<Integer, Integer> multimap = generateMultimap();
    	List<Integer> numDoctorVisits = (List<Integer>) multimap.get(4);
    	
    	return numDoctorVisits.stream().mapToInt(Integer::intValue).average().getAsDouble();
    }
    
    /**
     * 
     * @return An ArrayListMultiMap that contains all data rows from the Doctor.csv file
     * @throws IOException
     */
    public ArrayListMultimap<Integer, Integer> generateMultimap() throws IOException {
    	ArrayListMultimap<Integer, Integer> multimap = ArrayListMultimap.create();
    	String currLine;
    	
    	BufferedReader br = getBufferedReader("Doctor.csv");
		while ((currLine = br.readLine()) != null) {
			String[] splitLine = currLine.split(",");
		
			HealthRecord hr =
				new HealthRecord(
					Integer.parseInt(splitLine[0].replaceAll("\"", "")),
					Integer.parseInt(splitLine[1]),
					Integer.parseInt(splitLine[2]),
					Double.parseDouble(splitLine[3]),
					Double.parseDouble(splitLine[4]));
		
			multimap.put(hr.getDoctor(), hr.getChildren());
		}

    	return multimap;
    }
    
    /**
     * 
     * @return an array of integers in which the 0th index holds the number of people with
     * health coverage less than 0.5 and the 1st index holds the number of people with
     * health coverage greater than or equal to 0.5.
     * @throws IOException
     */
    public int[] accessRange() throws IOException {
    	TreeRangeSet<Integer> lowerHalf = TreeRangeSet.create();
    	TreeRangeSet<Integer> upperHalf = TreeRangeSet.create();
    	String currLine;
    	int lowerHalfCount = 0;
    	int upperHalfCount = 0;
    	int[] returnValue = new int[2];
    	
    	lowerHalf.add(Range.open(0, 500));
    	upperHalf.add(Range.closedOpen(500, 1000));
    	
    	BufferedReader br = getBufferedReader("Doctor.csv");
		while ((currLine = br.readLine()) != null) {
			String[] splitLine = currLine.split(",");
		
			HealthRecord hr =
				new HealthRecord(
					Integer.parseInt(splitLine[0].replaceAll("\"", "")),
					Integer.parseInt(splitLine[1]),
					Integer.parseInt(splitLine[2]),
					Double.parseDouble(splitLine[3]),
					Double.parseDouble(splitLine[4]));
			
			int accessValue = (int) (hr.getAccess()*1000);
			
			// I have no idea if this is a good way to use a TreeRangeSet...
			if (lowerHalf.contains(accessValue)) {
				lowerHalfCount++;
			} else {
				upperHalfCount++;
			}
		
		}
		
		returnValue[0] = lowerHalfCount;
		returnValue[1] = upperHalfCount;

    	return returnValue;
    }
    
    /**
     * @param fileName
     * @return a BufferedReader instance based on the fileName
     */
    public BufferedReader getBufferedReader (String fileName) {
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