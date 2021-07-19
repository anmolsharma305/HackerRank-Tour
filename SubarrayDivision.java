/*
 @Author: Anmol Kumar Sharma
 
 Problem:  Subarray Division
 Problem Link: https://www.hackerrank.com/challenges/the-birthday-bar/problem?isFullScreen=false&h_r=next-challenge&h_v=zen&h_r=next-challenge&h_v=zen
 
 Approach Used: Window Sliding Technique
 Time Complexity: O(N)
 Space Complexity: O(1)
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    
    public static int birthday(List<Integer> s, int d, int m) {
    // Write your code here
        int n = s.size();
        int count = 0;
        int sum = 0;
        
        //Here we are finding sum of first m element in the array
        for(int i = 0; i < m; i++){
            sum += s.get(i);
        }
        
        //checking if first m element sum is same as d
        // if true then increment count
        if(sum == d){
            count++;
        }
        
        //Sliding window technique used for further contiguous segment
        for(int i = m; i < n; i++){
            sum += s.get(i) - s.get(i-m);
            if(sum == d)
                count++;
        }
        
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
