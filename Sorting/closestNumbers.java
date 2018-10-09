import java.util.*;

/*
 * Author: Nam Tran
 * Date: Feb 2, 2018
 * Problem Source: https://www.hackerrank.com/challenges/closest-numbers/problem
 * Things to remember: 
 */

public class closestNumbers {
	static String closestNumber(int[] arr) 
    {
        // Complete this function
        Arrays.sort(arr);
        int minAbs = Integer.MIN_VALUE; //Minimum absolute difference
        String result = "";
        for(int i = 0; i < arr.length-1; i++)
        {
            int absDiff = Math.abs(arr[i] - arr[i+1]);
            if(absDiff < minAbs)
            {
                minAbs = absDiff;
                result = "";
                result = result + arr[i] + " " + arr[i+1] + " ";
            } 
            else if(absDiff == minAbs)
            {
                result = result + arr[i] + " " + arr[i+1] + " ";
            }
        } 
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        String result = closestNumber(arr);
        System.out.println(result);
        in.close();
    }
}

