package javaStuff;
import java.util.*;
import java.io.*;

class hashMap{
	public static void main(String []argh)
	{
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		in.nextLine();
        Map<String, Integer> map = new HashMap<>(n);
		for(int i=0;i<n;i++)
		{
			String name=in.nextLine();
			int phone=in.nextInt();
			in.nextLine();
            map.put(name,phone);
		}
		while(in.hasNext())
		 {
        String query = in.nextLine().trim();
        if(map.containsKey(query))
        {
            System.out.println(query + "=" + map.get(query));
        }
        else
        {
            System.out.println("Not found");
        }
    }
	}
}