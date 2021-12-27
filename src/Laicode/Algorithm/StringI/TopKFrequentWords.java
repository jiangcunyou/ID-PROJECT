package Laicode.Algorithm.StringI;

/*
* Given a composition with different kinds of words, return a list of the top K most frequent words in the composition.

Assumptions

the composition is not null and is not guaranteed to be sorted
K >= 1 and K could be larger than the number of distinct words in the composition, in this case, just return all the distinct words
Return

a list of words ordered from most frequent one to least frequent one (the list could be of size K or smaller than K)
Examples

Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 2 frequent words are [“b”, “c”]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 4 frequent words are [“b”, “c”, "a", "d"]
Composition = ["a", "a", "b", "b", "b", "b", "c", "c", "c", "d"], top 5 frequent words are [“b”, “c”, "a", "d"]
* */

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {
    //Assumption: combo is not null, and k >= 1
    public String[] topKFrequent(String[] combo, int k) {
        // Handle the special case of empty combo at the very beginning
        if(combo.length == 0){
            return new String[0];
        }
        //get all the distict strings as keys and their frequencies as values.
        //Notice: the freqMap has at least size 1.
        Map<String, Integer> freqMap = getFreqMap(combo);
        //minheap on the frequencies of the strings.
        //NOTICE: using the Map.Entry as the element type directly so that all the
        //operations are mostly efficient
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k,
                new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                //compare the frequencies, directly call the compareTo method since
                //the frequencies are represented by Integer.
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry: freqMap.entrySet()){
            if (minHeap.size() < k){
                minHeap.offer(entry);
            }else if (entry.getValue() > minHeap.peek().getValue()){
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        //Since the returned array requires the strings sorted by their
        //frequencies, use a separate helper method to do this operation
        return freqArray(minHeap);
    }

    private Map<String, Integer> getFreqMap(String[] combo){
        Map<String, Integer> freqMap = new HashMap<>();
        //Notice: when possible, choose the most efficient way for
        //HashMap operations.
        for(String s: combo){
            Integer freq = freqMap.get(s);
            if (freq == null){
                freqMap.put(s, 1);
            }else {
                freqMap.put(s, freq + 1);
            }
        }
        return freqMap;
    }

    private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap){
        String[] result = new String[minHeap.size()];
        for (int i = minHeap.size() - 1; i >= 0 ; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}

//Time complexity: O(n + nlogk)
//1.  put in to hashmap time: time = O(n)
//2.  use minheap:
//      offertime = O(log1 + log2 + ... + logk) = O(klogk)
//      size > k pop, time = O(n - k)logk = O(nlogk)
//      so, time = O(klogk) + O(n - k)logk = O(nlogk)
//3.    pop result from heap: time = O(klogk)
//Space complexity: O(n)
