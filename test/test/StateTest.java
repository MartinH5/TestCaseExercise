package test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import statetransiations.MyArrayListWithoutBugs;

/**
 *
 * @author Opinator
 */
public class StateTest {

    MyArrayListWithoutBugs st;
    Object o;

    public StateTest() {
    }

    @Before
    public void setUp() {
        st = new MyArrayListWithoutBugs();
        o = new Object();

    }

    @Test // Open Slots
    public void testAdd1() {
        System.out.println("Testing Open Slot Add Test Without Index");
        st.add(o);
        System.out.println("Actual size after insertion: " + st.size());
        assertEquals(1, st.size());
    }

    @Test // No Slots
    public void testAdd2() {
        System.out.println("\nTesting Closed Add test Without Index");
        //Filling up Array
        for (int i = 0; i < st.getListLength(); i++) {
            st.add(o);
        }
        //Adding 1 more despite being full
        st.add(o);
        System.out.println("Size after insertion: " + st.size());
        assertEquals(6, st.size());
    }
    
    @Test // Open Slots 2
    public void testAdd3(){
        System.out.println("\nTesting Open Add test With Index");
        st.add(0, o);
        System.out.println("Output size: " + st.size());
        assertEquals(1, st.size());
    }
    
    @Test // No Slots 2
    public void testAdd4(){
        System.out.println("\nTesting Closed Add test With Index");
        st.add(o);
        st.add(0, o);
        System.out.println("Output size: " + st.size());
        assertEquals(2, st.size());
    }
    
    @Test // Remove existing
    public void testRemove1(){
        System.out.println("\nTesting removing existing");
        st.add(o);
        st.remove(0);
        System.out.println("Output size: " + st.size());
        assertEquals(0, st.size());
    }
    
    @Test // Remove existing
    public void testRemove2(){
        System.out.println("\nTesting removing existing");
        st.remove(0);
        System.out.println("Output size: " + st.size());
        assertEquals(0, st.size());
    }
}
