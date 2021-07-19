/*
@Author: Anmol Kumar Sharma

Problem: Breaking The Record
Problem Link: https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem?h_r=profile
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

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int max = 0;
        int min = 0;
        
        int maximumScore = scores.get(0);
        int minimumScore = scores.get(0);
        
        for(int i = 1; i <= scores.size()-1; i++){
            if(scores.get(i) > maximumScore){
                maximumScore = scores.get(i);
                max++;
            }
            if(scores.get(i) < minimumScore){
                minimumScore = scores.get(i);
                min++;
            }
        }
        
        List<Integer> list = new ArrayList();
        list.add(max);
        list.add(min);
        
        return list;   
    }        

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
