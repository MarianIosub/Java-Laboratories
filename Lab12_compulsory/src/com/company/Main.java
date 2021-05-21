package com.company;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        String inputClass=null;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input your class-name:");
        inputClass=scanner.nextLine();
        int passed = 0, failed = 0;

        for (Method m : Class.forName(inputClass).getMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                try {
                    m.invoke(null);
                    passed++;
                } catch (Throwable ex) {
                    System.out.printf("Test %s failed: %s %n",m, ex.getCause());
                    failed++;
                }
            }
        }
        System.out.printf("Passed: %d, Failed %d%n", passed, failed);
    }
}
