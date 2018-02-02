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


public class lilyHomework {

	static int lilysHomework(Integer[] arr) {
        /*
         *  Using optimizition in combinatorics, it is possible to point out the beautiful array 
         *  happens when the array is sorted ascending or descending
         */
        int n = arr.length;
        
        int ascendingSwaps = 0;
        int[] homeworkAscendingSorted = new int[n];
        HashMap<Integer,Integer> original = new HashMap<Integer,Integer>();
        
        int descendingSwaps = 0;   
        int[] homeworkDescendingSorted = new int[n];        
        HashMap<Integer,Integer> unoriginal = new HashMap<Integer,Integer>();
        
        //Initialize arrays and maps
        for(int i = 0; i < n; i++)
        {
            homeworkAscendingSorted[i] = arr[i];
            homeworkDescendingSorted[i] = arr[i];
            original.put(homeworkAscendingSorted[i],i);
            unoriginal.put(homeworkDescendingSorted[i],i);
        }
            
        Arrays.sort(arr); //Sort the input ascending    
        for(int i = 0; i < n; i++)
        {
            if(homeworkAscendingSorted[i] != arr[i])
            {
                //swap the element from homework to the right position
                int temp = homeworkAscendingSorted[i];
                homeworkAscendingSorted[i] = homeworkAscendingSorted[original.get(arr[i])];
                homeworkAscendingSorted[original.get(arr[i])] = temp;
                //Update index after swap
                original.put(temp,original.get(arr[i]));
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
                homeworkDescendingSorted[i] = homeworkDescendingSorted[unoriginal.get(arr[i])];
                homeworkDescendingSorted[unoriginal.get(arr[i])] = temp;
                //Update index after swap
                unoriginal.put(temp, unoriginal.get(arr[i]));
                descendingSwaps++;
            }
        }
        return (Math.min(ascendingSwaps,descendingSwaps));//Choose the smallest of the two possible smallest
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Integer[] arr = new Integer[n];
        for(int i = 0; i < n; i++){
            arr[i] = in.nextInt();
        }
        int result = lilysHomework(arr);
        System.out.println(result);
        in.close();
    }
}
