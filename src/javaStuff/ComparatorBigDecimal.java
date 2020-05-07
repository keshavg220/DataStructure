package javaStuff;
import java.math.BigDecimal;
import java.util.*;
class ComparatorBigDecimal{
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();
        Arrays.sort(s,0,n,Collections.reverseOrder(new Comparator<String>(){
            @Override
            public int compare(String a1, String a2) {
        
        BigDecimal a = new BigDecimal(a1);
        BigDecimal b = new BigDecimal(a2);
        return a.compareTo(b);
            }
        }));
        
        
        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}



//Sample Input
//
//9
//-100
//50
//0
//56.6
//90
//0.12
//.12
//02.34
//000.000
//Sample Output
//
//90
//56.6
//50
//02.34
//0.12
//.12
//0
//000.000
//-100