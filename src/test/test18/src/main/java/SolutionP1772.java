import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SolutionP1772 {
    public String[] sortFeatures(String[] features, String[] responses) {
        Map<String, Integer> appearances = new HashMap<>();
        for (String r : responses) {
            Arrays.stream(r.split(" ")).distinct()
                    .forEach(s -> appearances.merge(s, 1, Integer::sum));
        }
        Arrays.sort(features, (o1, o2) -> Integer.compare(appearances.getOrDefault(o2, 0), appearances.getOrDefault(o1, 0)));
        return features;
    }
}
/*
$1772. 按受欢迎程度排列功能
https://leetcode.cn/problems/sort-features-by-popularity/description/

给定一个字符串数组 features ，其中 features[i] 是一个单词，描述你最近参与开发的项目中一个功能的名称。你调查了用户喜欢哪些功能。另给定一个字符串数组 responses，其中 responses[i] 是一个包含以空格分隔的一系列单词的字符串。
你想要按照受欢迎程度排列这些功能。 严格地说，令 appearances(word) 是满足 responses[i] 中包含单词 word 的 i 的个数，则当 appearances(features[x]) > appearances(features[y]) 时，第 x 个功能比第 y 个功能更受欢迎。
返回一个数组 sortedFeatures ，包含按受欢迎程度排列的功能名称。当第 x  个功能和第 y 个功能的受欢迎程度相同且 x < y 时，你应当将第 x 个功能放在第 y 个功能之前。
提示：
1 <= features.length <= 10^4
1 <= features[i].length <= 10
features 不包含重复项。
features[i] 由小写字母构成。
1 <= responses.length <= 10^2
1 <= responses[i].length <= 10^3
responses[i] 由小写字母和空格组成。
responses[i] 不包含两个连续的空格。
responses[i] 没有前置或后置空格。

哈希表 模拟。
实现 appearances，然后 自定义排序。
 */