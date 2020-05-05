package javaStuff;
import java.io.*;
import java.util.*;

public class Subarray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr=new int[n];
    int res=0;
    for (int i=0; i<n; i++){
        arr[i]=sc.nextInt();
        int s=arr[i];
        if (s<0) res++;
        for (int j=i-1; j>=0; j--){
            s+=arr[j];
            if (s<0) res++;
        }
    }
     System.out.println(res);
    }
    
}
