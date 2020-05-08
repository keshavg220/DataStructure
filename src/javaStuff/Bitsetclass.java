package javaStuff;
import java.io.*;
import java.util.*;

public class Bitsetclass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        BitSet b1 = new BitSet(n);
        BitSet b2 = new BitSet(n);
        while(m > 0){
            String func = sc.next();
            int p = sc.nextInt();
            int q = sc.nextInt();
            if(func.equals("AND") || func.equals("OR")|| func.equals("XOR")){
                if(p == 1){
                    switch(func){
                        case "AND" : b1.and(b2);break;
                        case "OR" : b1.or(b2);break;
                        case "XOR" : b1.xor(b2);break;

                    }
                }
            
                else{
                    switch(func){
                        case "AND" : b2.and(b1);break;
                        case "OR" : b2.or(b1);break;
                        case "XOR" : b2.xor(b1);break;
                    }    
                }
            }
             if(func.equals("SET") || func.equals("FLIP")){
                if(p == 1) {
                    switch(func) {
                        case "SET" : b1.set(q);break;
                        case "FLIP" : b1.flip(q);break;

                    }
                }
                else
                    {
                    switch(func) {
                    case "SET" : b2.set(q);break;
                    case "FLIP" : b2.flip(q);break;
                    }
                }

            }    
           
            System.out.println(b1.cardinality()+" "+b2.cardinality());
            
        m--;
        }
        sc.close();

    }
}



//Another approach using lambda's
//public static void main(String[] args) {
//    Scanner sc = new Scanner(System.in);
//    int setSize = sc.nextInt();
//    int noOps = sc.nextInt();
//    BitSet[] bitSets = new BitSet[]{new BitSet(setSize), new BitSet(setSize)};
//    Map<String, BiConsumer<Integer,Integer>> ops = new HashMap<>();
//    ops.put("AND", (index1, index2) -> bitSets[index1-1].and(bitSets[index2-1]));
//    ops.put("OR", (index1, index2) -> bitSets[index1-1].or(bitSets[index2-1]));
//    ops.put("XOR", (index1, index2) -> bitSets[index1-1].xor(bitSets[index2-1]));
//    ops.put("SET", (index1, index2) -> bitSets[index1-1].set(index2));
//    ops.put("FLIP", (index1, index2) -> bitSets[index1-1].flip(index2));
//    for (int i = 0; i < noOps; i++){
//        ops.get(sc.next()).accept(sc.nextInt(), sc.nextInt());    
//        System.out.println(bitSets[0].cardinality() + " " + bitSets[1].cardinality());
//    }
//}




