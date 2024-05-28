package JavaPrograms;

import java.util.HashMap;

public class CountOccurance {
public static void main(String[] args)
{
	String str="testYantra";
	char[] ch=str.toCharArray();
	HashMap<Character, Integer> map=new HashMap<Character, Integer>();
	for(int i=0; i<str.length();i++)
	{
		if(!map.containsKey(ch[i]))
		{
			map.put(ch[i], 1);
		}
		else
		{
			int n=map.get(ch[i]);
			n++;
			map.put(ch[i],n);
		}
	}
	System.out.println(map);
}
}
