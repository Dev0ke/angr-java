import java.util.Arrays;

public class Solution825 {
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);

        int res = 0;
        int l = 0, r = 0;
        for (int i = 0; i < n; i++) {
            int age = ages[i];
            while (l < i && !check(ages[l], age)) {
                l++;
            }
            r = Math.max(r, i);
            while (r + 1 < n && check(ages[r + 1], age)) {
                r++;
            }
            // [l, r] 满足要求，同时需要减去自身
            res += r - l;
        }
        return res;
    }

    // 用户 x 是否会向用户 y（x != y）发送好友请求
    private boolean check(int x, int y) {
        // IDEA Simplify
        return !(y <= 0.5 * x + 7) && y <= x;
    }
}
/*
825. 适龄的朋友
https://leetcode.cn/problems/friends-of-appropriate-ages/

在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
- ages[y] <= 0.5 * ages[x] + 7
- ages[y] > ages[x]
- ages[y] > 100 && ages[x] < 100
否则，x 将会向 y 发送一条好友请求。
注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
返回在该社交媒体网站上产生的好友请求总数。
提示：
n == ages.length
1 <= n <= 2 * 10^4
1 <= ages[i] <= 120

排序 + 双指针
因条件 2 包含条件 3，可以省略条件 3。
时间复杂度 O(nlogn)
空间复杂度 O(logn)。排序需要使用的栈空间。
 */
