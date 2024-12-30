import java.util.HashMap;
import java.util.Map;

public class SolutionP533 {
    // 531
    public int findBlackPixel(char[][] picture, int target) {
        int m = picture.length;
        int n = picture[0].length;
        // 预处理
        int[] cols = new int[n];
        for (char[] chars : picture) {
            for (int j = 0; j < n; j++) {
                if (chars[j] == 'B') {
                    cols[j]++;
                }
            }
        }
        // 相同行进行合并计数 [B的数量, 相同行数]
        Map<String, int[]> cntMap = new HashMap<>();
        for (char[] chars : picture) {
            String key = new String(chars);
            if (cntMap.containsKey(key)) {
                cntMap.get(key)[1]++;
            } else {
                int cntB = 0;
                for (char ch : chars) {
                    if (ch == 'B') {
                        cntB++;
                    }
                }
                cntMap.put(key, new int[]{cntB, 1});
            }
        }

        int res = 0;
        for (Map.Entry<String, int[]> entry : cntMap.entrySet()) {
            String key = entry.getKey();
            int[] tuple = entry.getValue();
            // 行满足要求
            if (tuple[0] == target && tuple[1] == target) {
                for (int j = 0; j < n; j++) {
                    // 列满足要求
                    if (key.charAt(j) == 'B' && cols[j] == target) {
                        res++;
                    }
                }
            }
        }
        return res * target;
    }
}
/*
$533. 孤独像素 II
https://leetcode.cn/problems/lonely-pixel-ii/

给你一个大小为 m x n 的二维字符数组 picture ，表示一张黑白图像，数组中的 'B' 表示黑色像素，'W' 表示白色像素。另给你一个整数 target ，请你找出并返回符合规则的 黑色 孤独像素的数量。
黑色孤独像素是指位于某一特定位置 (r, c) 的字符 'B' ，其中：
- 行 r 和列 c 中的黑色像素恰好有 target 个。
- 列 c 中所有黑色像素所在的行必须和行 r 完全相同。
提示：
m == picture.length
n == picture[i].length
1 <= m, n <= 200
picture[i][j] 为 'W' 或 'B'
1 <= target <= min(m, n)

难度升级，条件二的意思是 满足要求的行全部相同，因此要将相同的行进行预处理。
相似题目: $531. 孤独像素 I
https://leetcode.cn/problems/lonely-pixel-i/
 */