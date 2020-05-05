package javaStuff;
import java.io.*;
import java.util.*;

public class StringTokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();

        String delims = "[ !,?._'@]+";
        s = s.trim();
        String[] arrOfStr = s.split(delims);
         if(s.length() == 0)
        System.out.println("0");
        else
        System.out.println(arrOfStr.length);

        for(String a : arrOfStr)
            System.out.println(a);
        
        scan.close();
    }
}
