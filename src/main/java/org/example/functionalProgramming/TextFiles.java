package org.example;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class TextFiles {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String s = "123 23 1";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"))) {
            String substring = "";

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ') {
                    substring += s.charAt(i);
                    continue;
                }

                if (!substring.isEmpty()) {
                    int x = Integer.parseInt(substring);
                    System.out.println(x * 2);
                    substring = "";
                }
            }

            int x = Integer.parseInt(substring);
            System.out.println(x * 2);
            writer.newLine();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader("test.txt"))) {
            String line = reader.readLine();
            while (line != null) {
                int x = Integer.parseInt(line);
                System.out.println(numberToEnglish(x));
                line = reader.readLine();
            }
        }
    }
    public static String numberToEnglish(long number) {
        String[] ones = new String[]{"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] tens = new String[]{"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] teens = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] orders = new String[]{"", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion"};
        String hundred = "hundred";
        String zero = "zero";
        String minus = "minus";

        boolean isNegative = false;
        if (number < 0) {
            isNegative = true;
            number = -number;
        }

        String result = "";

        if (number == 0) {
            return zero;
        }

        int orderCount = 0;

        while (number > 0) {
            int three = (int) number % 1000;
            number /= 1000;

            // 123
            int onesValue = three % 10;        // 3
            int tensValue = three / 10 % 10;   // 2
            int hundredsValue = three / 100;   // 1

            String threeResult = "";

            if (hundredsValue != 0) {
                threeResult += ones[hundredsValue] + " " + hundred;
            }

            if (tensValue == 1) {
                if (!threeResult.isEmpty()) threeResult += " ";

                threeResult += teens[onesValue];
            } else if (tensValue > 1) {
                if (!threeResult.isEmpty()) threeResult += " ";

                threeResult += tens[tensValue];
            }

            if (tensValue != 1 && onesValue != 0) {
                if (!threeResult.isEmpty()) threeResult += " ";

                threeResult += ones[onesValue];
            }

            if (!threeResult.isEmpty()) {
                threeResult += " " + orders[orderCount];

                result = threeResult + " " + result;
            }

            orderCount++;
        }

        if (isNegative) {
            result = minus + " " + result;
        }

        return result.trim();
    }
}