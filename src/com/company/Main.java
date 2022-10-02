package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
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
}
