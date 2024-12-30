import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Node> maxHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1.freq.equals(o2.freq)) {
                return o1.word.compareTo(o2.word);
            }
            return Integer.compare(o2.freq, o1.freq);
        });
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            maxHeap.add(new Node(entry.getKey(), entry.getValue()));
        }

        List<String> resList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            resList.add(maxHeap.remove().word);
        }
        return resList;
    }

    private static class Node {
        String word;
        Integer freq;

        public Node(String word, Integer freq) {
            this.word = word;
            this.freq = freq;
        }
    }
}
/*
692. 前K个高频单词
https://leetcode.cn/problems/top-k-frequent-words/

给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
注意：
1 <= words.length <= 500
1 <= words[i] <= 10
words[i] 由小写英文字母组成。
k 的取值范围是 [1, 不同 words[i] 的数量]
进阶：尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。

HashMap 统计频次，组合排序。
时间复杂度 O(nlogn)
 */