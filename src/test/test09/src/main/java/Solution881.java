import java.util.Arrays;

public class Solution881 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        // 双指针
        int left = 0;
        int right = people.length - 1;
        int cnt = 0;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            cnt++;
        }
        return cnt;
    }
}
/*
881. 救生艇
https://leetcode.cn/problems/boats-to-save-people/

第 96 场周赛 T2。

第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
提示：
1 <= people.length <= 5 * 10^4
1 <= people[i] <= limit <= 3 * 10^4

贪心。考虑体重最重的人，是否能跟最轻的人同船，否则体重最重的人独占一条船。
排序后双指针即可。
时间复杂度 O(nlogn)
 */