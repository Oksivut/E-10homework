package com.company;

public class Recursion {
    public int printNumbers(int number) {
        if (number > 0) {
            printNumbers(number - 1);
            System.out.print(number + " ");
        }
        return number;
    }

    public int sumOfNumbers(int n) {
        if (n < 10) {
            return n % 10;
        } else {
            return n % 10 + sumOfNumbers(n/10);
        }
    }

    public boolean isPalindrome(String string) {
        if (string.length() <= 1) {
            return true;
        }
        if (string.charAt(0) == string.charAt(string.length() - 1)) {
            String s = string.substring(1, string.length() - 1);
            return isPalindrome(s);
        }
        return false;
    }
}


