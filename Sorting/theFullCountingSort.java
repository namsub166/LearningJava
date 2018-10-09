import java.util.*;

/*
 * Author: Nam Tran
 * Date: Feb 2, 2018
 * Problem Source: https://www.hackerrank.com/challenges/countingsort4/problem
 */

public class theFullCountingSort {

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] frequencies = new int[100];

        HashMap<Integer, Queue<String>> order = new HashMap<Integer, Queue<String>>(); 

        for(int i = 0; i < n; i++)
        {
            int curNum = in.nextInt();
            String curChar = in.next();
            if(i < n/2) curChar = "-";
            if(!order.containsKey(curNum))
            {
                Queue<String> str = new LinkedList<String>();
                order.put(curNum, str);
            }
            order.get(curNum).add(curChar);    
            frequencies[curNum] = frequencies[curNum] + 1;
        }
        
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < frequencies.length; i++)
        {
            for(int j = 0; j < frequencies[i]; j++)
            {
                output.append(order.get(i).poll() + " ");
            }
        }
        System.out.println(output);
        in.close();
    }
}