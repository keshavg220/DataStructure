package DivideConquerTest;
import java.util.*;

public class LongestCommonSubsequence_DC {
	public int findLCSLength(String s1 , String s2) {
		return findLCSLengthAux(s1, s2, 0, 0);
		
	}
	int value;
	public int charAt(int index) {  
		 int [] value = null;
	       if ((index < 0) || (index >= value.length)) {  
	           throw new StringIndexOutOfBoundsException(index);  
	       }  
	       return value[index];  
	   }  
	public int findLCSLengthAux(String s1 , String s2 , int n, int m) {
		if(n == s1.length() || m == s2.length())
			return 0;
		int c3 = 0;
		if(s1.charAt[n] == s2.charAt(m)) {
			return c3 = 1 + findLCSLengthAux(s1,s2,n+1,m+1);
		}
		int c1 = findLCSLengthAux(s1, s2, n, m + 1);//Increase index of 2nd String
		int c2 = findLCSLengthAux(s1, s2, n + 1, m);//Increase index of 1st String
		return Math.max(c3, Math.max(c1, c2));
	}
	public static void main(String[] args) {
		LongestCommonSubsequence_DC lcs = new LongestCommonSubsequence_DC();
		System.out.println(lcs.findLCSLength("houdini", "hdupti"));
	}
}