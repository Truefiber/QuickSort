package com.elinecka.quicksort;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gennadiy on 22.05.2014.
 */
public class QuickSortMain {

    public static void main(String[] args) throws IOException {
        List<Integer> input = new ArrayList<Integer>();
        BufferedReader reader = new BufferedReader(new FileReader("C:\\JavaProject\\CourseraHW\\QuickSort.txt"));
        String nextLine;
        while ((nextLine = reader.readLine()) != null) {
            input.add(new Integer(nextLine));
        }

        QuickSort ex = new QuickSort(input);
        ex.sort(0, input.size() - 1);
        System.out.println(ex.getComparisons());
    }
}
