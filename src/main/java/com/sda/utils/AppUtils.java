package com.sda.utils;

import java.util.Scanner;

public class AppUtils {
    private Scanner scanner = new Scanner(System.in);

    public int getInteger() {
        return scanner.nextInt();
    }

    public String getString() {
        return scanner.next();
    }
}
