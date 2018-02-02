package HackerRank.Sorting;

/*
 * Author: Nam Tran
 * Date: Feb 2, 2018
 * Problem Source: https://www.hackerrank.com/challenges/lilys-homework/problem
 * Things to remember: 
 * 		To sort an array arr using the default java method: Arrays.sort(arr);
 * 		To sort an array arr in reverse order: Arrays.sort(arr, Collections.reverseOrder());
 * 		Remember the latter method only works for array of primitive type. 
 */

import java.util.*;
import java.io.*;

public class lilyHomework {

    static int lilysHomework(Integer[] arr) {
        /*
         * Using optimizition in combinatorics, it is possible to point out the beautiful array 
         * happens when the array is sorted ascending or descending.
         */
        int n = arr.length;
        
        int ascendingSwaps = 0;
        int[] homeworkAscendingSorted = new int[n];
        HashMap<Integer,Integer> ascending = new HashMap<Integer,Integer>();
        
        int descendingSwaps = 0;   
        int[] homeworkDescendingSorted = new int[n];        
        HashMap<Integer,Integer> descending = new HashMap<Integer,Integer>();
        
        //Initialize arrays and maps
        for(int i = 0; i < n; i++)
        {
            homeworkAscendingSorted[i] = arr[i];
            homeworkDescendingSorted[i] = arr[i];
            ascending.put(homeworkAscendingSorted[i],i);
            descending.put(homeworkDescendingSorted[i],i);
        }
            
        Arrays.sort(arr); //Sort the input ascending    
        for(int i = 0; i < n; i++)
        {
            if(homeworkAscendingSorted[i] != arr[i])
            {
                //swap the element from homework to the right position
                int temp = homeworkAscendingSorted[i];
                homeworkAscendingSorted[i] = homeworkAscendingSorted[ascending.get(arr[i])];
                homeworkAscendingSorted[ascending.get(arr[i])] = temp;
                //Update index after swap
                ascending.put(temp,ascending.get(arr[i]));
                ascendingSwaps++;               
            }
        }
        
        Arrays.sort(arr, Collections.reverseOrder());//Sort the input descending        
        for(int i = 0; i < n; i++)
        {
            if(homeworkDescendingSorted[i] != arr[i])
            {
                //swap the element from homework to the right position
                int temp = homeworkDescendingSorted[i];
                homeworkDescendingSorted[i] = homeworkDescendingSorted[descending.get(arr[i])];
                homeworkDescendingSorted[descending.get(arr[i])] = temp;
                //Update index after swap
                descending.put(temp, descending.get(arr[i]));
                descendingSwaps++;
            }
        }
        return (Math.min(ascendingSwaps,descendingSwaps));//Choose the smallest of the two possible smallest
    }

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = br.read();
    	Integer[] arr = new Integer[n];
    	for(int i = 0; i < n; i++) {
    		arr[i] = br.read();
    	}
    	br.close();
    	int result = lilysHomework(arr);
    	System.out.println(result);
    }
}

