package javaStuff;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Prime {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BigInteger n = scanner.nextBigInteger();
        System.out.println(n.isProbablePrime(1) ? "prime" : "not prime");

        scanner.close();
    }
}