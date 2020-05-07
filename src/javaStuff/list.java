package javaStuff;
import java.io.*;
import java.util.*;

public class list {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0; i<n ; i++){
            int value = sc.nextInt();
            list.add(value);
        }
        int q = sc.nextInt();
        while(q > 0){
            String s = sc.next();
            if(s.equals("Insert")){
                int index = sc.nextInt();
                int value = sc.nextInt();
                list.add(index, value);    
            }
            else{
                int index = sc.nextInt();
                list.remove(index);
            }
        q--;
        }
        sc.close();
        for(Integer num : list){
            System.out.print(num + " ");
        }
        
    }
}


//Sample Input
//
//5
//12 0 1 78 12
//2
//Insert
//5 23
//Delete
//0
//Sample Output
//
//0 1 78 12 23


