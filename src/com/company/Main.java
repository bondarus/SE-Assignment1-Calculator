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
    }
}
