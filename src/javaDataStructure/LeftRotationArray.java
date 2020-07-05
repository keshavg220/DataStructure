package javaDataStructure;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRotationArray {

        

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        
        
        for(int i=0; i<n;i++) {
            a[(i+n-d)%n] = scanner.nextInt();
        }
        for(int i=0; i<n;i++) {
            System.out.print(a[i] + " ");
        }      

        scanner.close();
    }
}
