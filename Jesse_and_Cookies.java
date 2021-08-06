/*
@Author: Anmol Kumar Sharma

Problem: Jesse and Cookies
Problem Link: https://www.hackerrank.com/challenges/jesse-and-cookies/problem
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        int n = A.size();   
        
        //Creting a Max-Heap which contains maximum elements on the top of the heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        int i = 0;
    
        //Inserting all elements in the heap
        for(int item: A) {
            maxHeap.add(item);
        }
      
        //main code
        while(maxHeap.peek() < k || maxHeap.peek() == 0) {
            int x = maxHeap.poll();
            if(maxHeap.isEmpty()) return -1;
            
            int y = maxHeap.poll();
            
            maxHeap.add(x + 2*y);
            i++;    
        }
        
        if(maxHeap.size() == 1) {
            if(maxHeap.peek() < k) return -1;
            else return i;
        }
        return i;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] ATemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> A = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int AItem = Integer.parseInt(ATemp[i]);
            A.add(AItem);
        }

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
