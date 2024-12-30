import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1604 {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int len = keyName.length;
        Map<String, List<Integer>> nameTimeMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            nameTimeMap.computeIfAbsent(keyName[i], key -> new ArrayList<>()).add(hhmm2int(keyTime[i]));
        }

        List<String> resList = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : nameTimeMap.entrySet()) {
            List<Integer> timeList = entry.getValue();
            int sz = timeList.size();
            if (sz < 3) {
                continue;
            }
            Collections.sort(timeList);
            for (int i = 2; i < sz; i++) {
                if (timeList.get(i) - timeList.get(i - 2) <= 60) {
                    resList.add(entry.getKey());
                    break;
                }
            }
        }
        Collections.sort(resList);
        return resList;
    }

    private static int hhmm2int(String hhmm) {
        return Integer.parseInt(hhmm.substring(0, 2)) * 60 + Integer.parseInt(hhmm.substring(3, 5));
    }
}
/*
1604. 警告一小时内使用相同员工卡大于等于三次的人
https://leetcode.cn/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/

力扣公司的员工都使用员工卡来开办公室的门。每当一个员工使用一次他的员工卡，安保系统会记录下员工的名字和使用时间。如果一个员工在一小时时间内使用员工卡的次数大于等于三次，这个系统会自动发布一个 警告 。
给你字符串数组 keyName 和 keyTime ，其中 [keyName[i], keyTime[i]] 对应一个人的名字和他在 某一天 内使用员工卡的时间。
使用时间的格式是 24小时制 ，形如 "HH:MM" ，比方说 "23:51" 和 "09:49" 。
请你返回去重后的收到系统警告的员工名字，将它们按 字典序升序 排序后返回。
请注意 "10:00" - "11:00" 视为一个小时时间范围内，而 "23:51" - "00:10" 不被视为一小时内，因为系统记录的是某一天内的使用情况。
提示：
1 <= keyName.length, keyTime.length <= 10^5
keyName.length == keyTime.length
keyTime 格式为 "HH:MM" 。
保证 [keyName[i], keyTime[i]] 形成的二元对 互不相同 。
1 <= keyName[i].length <= 10
keyName[i] 只包含小写英文字母。

模拟。使用 HashMap 分组后进行排序，统计。
时间复杂度 O(nlogn)
 */