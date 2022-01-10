package com.example.helloworld;

public class Calculate {
    private  String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
    private int n;
    private int result;
    public Calculate(){
        n = (int) (Math.random() * 1_000_000);
    }
    public void nCalc(){
        n *= 3;
        n += Integer.parseInt("10101", 2);
        n += Integer.parseInt("FF", 16);
        n *= 6;
    }
    public void resultCalc(){
        int a = 0;
        while (n > 9) {
            while (n > 0) {
                a = a + n % 10;
                n /= 10;
            }
            n = a;
            a = 0;
        }
        result=n;
    }
    public void printMessage(){
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);
    }
}
