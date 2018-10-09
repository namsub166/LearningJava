import java.util.*;

/*
 * Author: Nam Tran
 * Date: Feb 2, 2018
 * Problem Source: https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem
 */

public class fraudulentActivityNotifications {
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        int[] pastActivity = new int[201];
        int notifications = 0;
        
        // Skip the first d days
        for(int i = 0; i < d; i++)
        {
            int transaction = in.nextInt();
            queue.offer(transaction);
            pastActivity[transaction] = pastActivity[transaction]+1;
        }
        
        // Check for notifications for the remaining days
        for(int i = 0; i < n-d; i++)
        {
            int newTrans = in.nextInt();
            
            //Check if fraudulent activity may have occurred
            if(newTrans >= (2* median(pastActivity, d)))
                notifications++;
            
            //Remove the oldest transaction
            int oldestTrans = queue.poll();
            pastActivity[oldestTrans] = pastActivity[oldestTrans]-1;
            
            //Add the new transaction
            queue.offer(newTrans);
            pastActivity[newTrans] = pastActivity[newTrans]+1;
        }
        in.close();
        System.out.println(notifications);
    }
    
    /**
     * This method accept an array of # numbers in an array (i.e [0, 1, 1, 0, 2] from [0, 1, 2, 4, 4])
     * Return the number supposed to be the median of the original array.
     * 
     * @param array The original array
     * @param elements The size of the original array
     * @return The number supposed to be the median of the original array.
     */
    static double median(int[] array, int elements)
    {
        int index = 0;
        if(elements % 2 == 0) //Find median of even number of elements
        {
            int counter = (elements / 2);

            while(counter > 0)
            {                
                counter -= array[index];
                index++;
            }
            index--; //Remove extra iteration
            
            if(counter <= -1) //Both medians is the same as index
                return index;
            else //(counter == 0)
            {
                int firstIndex = index;
                int secondIndex = index+1;
                while(array[secondIndex] == 0) //Find next non-zero transaction
                {
                    secondIndex++;
                }
                return (firstIndex + secondIndex)/2.0; //Calculate the average of middle two elements
            }
        }
        else //Find median of odd number of elements
        {
            int counter = elements / 2;
            while(counter >= 0)
            {
                counter -= array[index]; 
                index++;
            }
            return index-1;
        }
    }
}

