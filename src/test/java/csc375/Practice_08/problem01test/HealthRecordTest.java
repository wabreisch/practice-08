// Wes Breisch & Ian Jacobs
// CSC375 Practice #8

package csc375.Practice_08.problem01test;

import java.io.IOException;

import csc375.Practice_08.problem01.HealthRecord;
import junit.framework.TestCase;

/**
 * Unit tests for HealthRecord class.
 */
public class HealthRecordTest extends TestCase {

    /**
     * Test average number of doctor visits method
     * @throws IOException 
     */
    public void testMethod1() throws IOException {
    	assertEquals("Test average doctor visits", (int) (new HealthRecord().calculateAverageDoctorVisits()), 2);
    }
    
    /**
     * Test both the upper and lower halves of the coverage TreeRangeSet
     * @throws IOException 
     */
    public void testMethod2() throws IOException {
    	assertEquals("Test coverage range, lower half", (new HealthRecord().accessRange()[0]), 279);
    	assertEquals("Test coverage range, upper half", (new HealthRecord().accessRange()[1]), 206);
    }
}
