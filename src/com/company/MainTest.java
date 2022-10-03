package com.company;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class MainTest {

    @org.junit.Test
    public void mainT() {
    }

    //Test for the isValid function in the Main class
    @org.junit.Test
    public void isValidT() {
        //tests valid expressions
        assertEquals("Invalidates a valid expression, '1 + 1'", true, Main.isValid(new ArrayList<>(Arrays.asList("1","+","1"))));
        assertEquals("Invalidates a valid expression, '1 * 2'", true, Main.isValid(new ArrayList<>(Arrays.asList("1","*","1"))));
        assertEquals("Invalidates a valid expression, '1 - 2'", true, Main.isValid(new ArrayList<>(Arrays.asList("1","-","1"))));



    }
}