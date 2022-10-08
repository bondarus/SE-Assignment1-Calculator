package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class MainTest {

    //Test for the isValid function in the Main class
    @org.junit.Test
    public void isValidTests() {
        //tests valid expressions
        assertTrue("Invalidates a valid input, '1 + 1'", Main.isValid(new ArrayList<>(Arrays.asList("1", "+", "1"))));
        assertTrue("Invalidates a valid input, '1 * 2'", Main.isValid(new ArrayList<>(Arrays.asList("1", "*", "1"))));
        assertTrue("Invalidates a valid input, '1 - 2'", Main.isValid(new ArrayList<>(Arrays.asList("1", "-", "1"))));
        assertTrue("Invalidates a valid input, '12 - 2 + 3 * 4'", Main.isValid(new ArrayList<>(Arrays.asList("12", "-", "2", "+", "3", "*", "4"))));

        //Tests an input of less than 3 char
        assertFalse("Validates an invalid input '1 -'", Main.isValid(new ArrayList<>(Arrays.asList("1", "-"))));
        //Tests invalid Operator
        assertFalse("Validates an invalid operator '1 / 2'", Main.isValid(new ArrayList<>(Arrays.asList("1", "/", "2"))));
        //Tests double symbol
        assertFalse("Validates an invalid input '1 - - 1", Main.isValid(new ArrayList<>(Arrays.asList("1", "-", "-", "1"))));
        assertFalse("Validates an invalid input '1 + +'", Main.isValid(new ArrayList<>(Arrays.asList("1", "-", "-"))));

        //Tests extreme invalids
        assertFalse("Validates an invalid input 'babushka",Main.isValid(new ArrayList<>(Arrays.asList("b", "a", "b", "u", "s", "h", "k", "a"))));
    }

    //Tests for the calculate function in the main class
    @org.junit.Test
    public void calculateTests() {

        //Calculates many valid expressions
        int calculateResult = Main.calculate(new ArrayList<>(Arrays.asList("1", "+", "1")));
        assertEquals("Incorrectly calculates '1 + 1'", 2, calculateResult);

        calculateResult = Main.calculate(new ArrayList<>(Arrays.asList("1", "+", "1", "+", "1")));
        assertEquals("Incorrectly calculates '1 + 1'", 3, calculateResult);

        calculateResult = Main.calculate(new ArrayList<>(Arrays.asList("1", "-", "1")));
        assertEquals("Incorrectly calculates '1 - 1'", 0, calculateResult);

        calculateResult = Main.calculate(new ArrayList<>(Arrays.asList("1", "*", "3")));
        assertEquals("Incorrectly calculates '1 * 3'", 3, calculateResult);

        calculateResult = Main.calculate(new ArrayList<>(Arrays.asList("12", "-", "2", "+", "3", "*", "4")));
        assertEquals("Incorrectly calculates '12 - 2 + 3 * 4'", 22, calculateResult);
    }

    //mocks user input for the main
    @org.junit.Test
    public void mainTest() {

        InputStream stdin = System.in;
        System.setIn(new ByteArrayInputStream("12-2+3*4".getBytes()));

        Main.main(new String[0]);

        System.setIn(stdin);
        assertEquals("Incorrect output with the user input of '12-2+3*4'", 22, Main.result);

    }

}