import java.util.ArrayList;
import java.util.List;

public class Solution2191 {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int len = nums.length;

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(new Node(nums[i], i, getMappedNum(mapping, nums[i])));
        }

        // 如果两个数字映射后对应的数字大小相同，则将它们按照输入中的 相对顺序 排序。
        // nums 中的元素只有在排序的时候需要按照映射后的值进行比较，返回的值应该是输入的元素本身。
        list.sort((o1, o2) -> {
            if (o1.mappedNum == o2.mappedNum) {
                return Integer.compare(o1.idx, o2.idx);
            }
            return Integer.compare(o1.mappedNum, o2.mappedNum);
        });

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = list.get(i).rawNum;
        }
        return res;
    }

    private int getMappedNum(int[] mapping, int num) {
        String numStr = String.valueOf(num);
        int len = numStr.length();

        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 10; j++) {
                if (numStr.charAt(i) == (char) ('0' + j)) {
                    chars[i] = (char) ('0' + mapping[j]);
                }
            }
        }
        return Integer.parseInt(new String(chars));
    }

    private static class Node {
        int rawNum;
        int idx;
        int mappedNum;

        public Node(int rawNum, int idx, int mappedNum) {
            this.rawNum = rawNum;
            this.idx = idx;
            this.mappedNum = mappedNum;
        }
    }
}
/*
2191. 将杂乱无章的数字排序
https://leetcode.cn/problems/sort-the-jumbled-numbers/

第 73 场双周赛 T2。

给你一个下标从 0 开始的整数数组 mapping ，它表示一个十进制数的映射规则，mapping[i] = j 表示这个规则下将数位 i 映射为数位 j 。
一个整数 映射后的值 为将原数字每一个数位 i （0 <= i <= 9）映射为 mapping[i] 。
另外给你一个整数数组 nums ，请你将数组 nums 中每个数按照它们映射后对应数字非递减顺序排序后返回。
注意：
- 如果两个数字映射后对应的数字大小相同，则将它们按照输入中的 相对顺序 排序。
- nums 中的元素只有在排序的时候需要按照映射后的值进行比较，返回的值应该是输入的元素本身。

模拟自定义排序。
 */
