package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        int currentVal = 0;
        int i = 0;
        boolean exit1 = false;
        boolean exit2 = false;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an expression you want to calculate: ");
        String str = input.nextLine();
        Pattern p = Pattern.compile("[*,+,-]+|\\d+");
        Matcher m = p.matcher(str);
        ArrayList<String> allMatches = new ArrayList<>();
        while(m.find())
        {
            allMatches.add(m.group());
        }
        System.out.println(Arrays.toString(allMatches.toArray()));
        boolean valid = isValid(allMatches);
        if(valid)
        {
            System.out.println("The expression is valid");
            while(!exit1 && i < allMatches.size())
            {
                if((allMatches.get(i)).equals("*") && allMatches.size() >= 3)
                {
                    int val1 = Integer.parseInt(allMatches.get(i-1));
                    int val2 = Integer.parseInt(allMatches.get(i+1));
                    currentVal = val1 * val2;
                    System.out.println("\n" + val1 + " * " + val2 + " = " + currentVal);
                    System.out.println("Current Value: " + currentVal);
                    if(allMatches.size() > 3) {
                        allMatches.set(i,Integer.toString(currentVal));
                        allMatches.remove(i+1);
                        allMatches.remove(i-1);
                        System.out.println("Current Size: " + allMatches.size());
                        System.out.println("Current List: " + Arrays.toString(allMatches.toArray()));
                        i = -1;
                    }
                    else {
                        exit1 = true;
                    }
                    i++;
                }
                i++;
            }
            i = 0;
            while(!exit2)
            {
                if((allMatches.get(i)).equals("+") && allMatches.size() >= 3)
                {
                    int val1 = Integer.parseInt(allMatches.get(i-1));
                    int val2 = Integer.parseInt(allMatches.get(i+1));
                    currentVal = val1 + val2;
                    System.out.println("\n" + val1 + " + " + val2 + " = " + currentVal);
                    System.out.println("Current Value: " + currentVal);
                    if(allMatches.size() > 3) {
                        allMatches.set(i,Integer.toString(currentVal));
                        allMatches.remove(i+1);
                        allMatches.remove(i-1);
                        System.out.println("Current Size: " + allMatches.size());
                        System.out.println("Current List: " + Arrays.toString(allMatches.toArray()));
                        i = -1;
                    }
                    else {
                        exit2 = true;
                    }
                    i++;
                }
                else if((allMatches.get(i)).equals("-") && allMatches.size() >= 3)
                {
                    int val1 = Integer.parseInt(allMatches.get(i-1));
                    int val2 = Integer.parseInt(allMatches.get(i+1));
                    currentVal = val1 - val2;
                    System.out.println("\n" + val1 + " - " + val2 + " = " + currentVal);
                    System.out.println("Current Value: " + currentVal);
                    if(allMatches.size() > 3) {
                        allMatches.set(i,Integer.toString(currentVal));
                        allMatches.remove(i+1);
                        allMatches.remove(i-1);
                        System.out.println("Current Size: " + allMatches.size());
                        System.out.println("Current List: " + Arrays.toString(allMatches.toArray()));
                        i = -1;
                    }
                    else {
                        exit2 = true;
                    }
                    i++;
                }
                i++;
            }
            System.out.println("Result: " + currentVal);
        }
        else
        {
            System.err.println("The expression is invalid");
        }
    }

    public static boolean isValid(ArrayList<String> matches)
    {
        int j = 0;
        while(j < matches.size())
        {
            if(j % 2 == 0 || j == 0)
            {
                try {
                    Integer.parseInt(matches.get(j));
                    if(j == matches.size()-1) return true;
                } catch(NumberFormatException e) {
                    System.err.println("Error: Input expression is invalid");
                    j = matches.size();
                }
                j++;
            }
            else
            {
                if((matches.get(j)).equals("*") || (matches.get(j)).equals("+") || (matches.get(j)).equals("-"))
                {
                    j++;
                }
                else
                {
                    System.err.println("Error: Invalid operator used");
                    j = matches.size();
                }
            }
        }
        return false;
    }

    public void test(){
        System.out.print("Test works");
    }
}
