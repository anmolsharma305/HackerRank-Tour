/*
@Author: Anmol Kumar Sharma

Problem: Migratory Birds
Problem Link: https://www.hackerrank.com/challenges/migratory-birds/problem
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

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> birds = new HashMap<>();
        int key = 0;

        for(int i = 0; i < arr.size(); i++){
            if(birds.containsKey(arr.get(i))){
                birds.put(arr.get(i), birds.get(arr.get(i)) + 1);
            }else{
                birds.put(arr.get(i), 1);
            }
        }
        key = Collections.max(birds.entrySet(), Map.Entry.comparingByValue()).getKey();
        return key;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
