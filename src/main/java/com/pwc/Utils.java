package com.pwc;

import java.util.Scanner;

public class Utils {
    public static void echoActions() {
        System.out.println("Please enter a number in each line and enter the command!!");
    }

    public static void echoNum(Double aDouble) {
        System.out.println(aDouble);
    }

    public static void echoStatus(String status) {
        System.out.println(status);
    }

    public static Double parseConsoleLine(Scanner scanner) {
        String s = scanner.nextLine();
        Double aDouble = Double.valueOf(s);
        return aDouble;
    }
}
