import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution406 {
    public int[][] reconstructQueue(int[][] people) {
        // hi 降序，ki 升序 组合排序
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? Integer.compare(o1[1], o2[1]) : Integer.compare(o2[0], o1[0]));

        // 插入队列
        List<int[]> resList = new ArrayList<>();
        for (int[] peo : people) {
            resList.add(peo[1], peo);
        }
        return resList.toArray(int[][]::new);
    }
}
/*
406. 根据身高重建队列
https://leetcode.cn/problems/queue-reconstruction-by-height/

假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。
每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
提示：
1 <= people.length <= 2000
0 <= hi <= 10^6
0 <= ki < people.length
题目数据确保队列可以被重建

第一眼以为是单调栈，实际上并不是。
将每个人按照身高从大到小进行排序，ki 升序排序
然后插入队列，高的人会挡住矮的人，但是矮的人不会挡住高的人，所以未添加到队列的人并不会对已添加进队列的人有影响。
时间复杂度 O(n^2)（组合排序 O(nlogn)，插入队列 O(n^2)）
空间复杂度 O(logn)
 */