package HackerRank.Sorting;

import java.util.*;

/*
 * Author: Nam Tran
 * Date: Feb 2, 2018
 * Problem Source: https://www.hackerrank.com/challenges/big-sorting/problem
 */

public class bigSorting {

    public static void main(String[] args) 
    {
    	// Read the input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int i = 0; i < n; i++) {
            unsorted[i] = in.next();
        }
        in.close();
        
        // Initialize a Comparator to compare two numbers appear as String
        Comparator<String> stringCompare = new Comparator<String>(){
        	public int compare(String a, String b){
        		return StringAsIntegerCompare(a,b);
        	}
        };
        Arrays.sort(unsorted, stringCompare);
        
        for (int i = 0; i < n; i++){
            System.out.println(unsorted[i]);
        }
    }
    
    /*
     * Compare two numbers appear as String. Return 1 if the first number 
     * is larger, return -1 if the second number is larger. Return 0 if 
     * two numbers are equal.
     */
    public static int StringAsIntegerCompare(String s1, String s2)
    {
        if(s1.length() > s2.length()) return 1;
        if(s1.length() < s2.length()) return -1;
        for(int i = 0; i < s1.length(); i++)
        {
            if((int)s1.charAt(i) > (int)s2.charAt(i)) return 1;
            if((int)s1.charAt(i) < (int)s2.charAt(i)) return -1;
        }
        return 0;
    }
}

