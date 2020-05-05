package javaStuff;
import java.io.*;
import java.util.*;

public class Arraylist {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>(p);
        for(int i = 0; i < p ; i++){
            int n = sc.nextInt();
            ArrayList<Integer> inner = new ArrayList<Integer>(n);
            for(int j =0; j<n ; j++){
                int q = sc.nextInt();
                inner.add(q);
            }
            outer.add(inner);
        }
        int r = sc.nextInt();
        while(r>0){
            int o= sc.nextInt();
            int t= sc.nextInt();
            int g = o-1;
            int h= t-1;
           if(g < outer.size() && h< outer.get(g).size())
    {
      System.out.println(outer.get(g).get(h));
    }
    else
    {
      System.out.println("ERROR!");
    }
    r--; 
        }
    }
}
