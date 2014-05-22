package com.elinecka.quicksort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Gennadiy on 21.05.2014.
 */
public class QuickSort {

    List<Integer> source;
    private long comparisons;

    public QuickSort (List<Integer> data) {
        source = data;
        comparisons = 0;
    }

    public void sort (int startIndex, int endIndex) {
        if ((endIndex - startIndex) <= 0)
            return;
        else  {
            int p = partition (startIndex, endIndex);
            sort(startIndex, p - 1);
            sort(p + 1, endIndex);
        }

    }

    private int partition(int startIndex, int endIndex) { //Pivot point is media of 3 elements
        int i = startIndex;

        swapElements(startIndex, medianElement(startIndex, endIndex));
        comparisons += endIndex - startIndex;

        for (int j = startIndex + 1; j <= endIndex; j++) {
            if (source.get(startIndex) > source.get(j)) {
                i++;
                swapElements(i, j);
            }

        }

        swapElements(startIndex, i);
        return i;
    }

    private int medianElement(int start, int end) {
        int middle = (end - start) / 2 + start;
        List<Integer> medianArray = new ArrayList<Integer>();
        medianArray.add(source.get(start));
        medianArray.add(source.get(middle));
        medianArray.add(source.get(end));
        Collections.sort(medianArray);
        return source.indexOf(medianArray.get(1));


    }


    public long getComparisons() {
        return comparisons;
    }

    void swapElements(int i, int j) {
        int swap = source.get(j);
        source.set(j, source.get(i));
        source.set(i, swap);
    }
}
