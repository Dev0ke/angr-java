public class SolutionP1826 {
    public int badSensor(int[] sensor1, int[] sensor2) {
        boolean f1 = judge(sensor1, sensor2);
        boolean f2 = judge(sensor2, sensor1);
        if (f1 && f2) return -1;
        return f1 ? 2 : 1;
    }

    // s1 是对的看是否成立
    private boolean judge(int[] s1, int[] s2) {
        for (int i = 0, j = 0; i < s1.length; i++) {
            if (s1[i] != s2[j]) {
                if (i != j) return false;
            } else j++;
        }
        return true;
    }
}
/*
$1826. 有缺陷的传感器
https://leetcode.cn/problems/faulty-sensor/description/

实验室里正在进行一项实验。为了确保数据的准确性，同时使用 两个 传感器来采集数据。您将获得2个数组 sensor1 and sensor2，其中 sensor1[i] 和 sensor2[i] 分别是两个传感器对第 i 个数据点采集到的数据。
但是，这种类型的传感器有可能存在缺陷，它会导致 某一个 数据点采集的数据（掉落值）被丢弃。
数据被丢弃后，所有在其右侧的数据点采集的数据，都会被向左移动一个位置，最后一个数据点采集的数据会被一些随机值替换。可以保证此随机值不等于掉落值。
- 举个例子, 如果正确的数据是 [1,2,3,4,5] ， 此时 3 被丢弃了, 传感器会返回 [1,2,4,5,7] (最后的位置可以是任何值, 不仅仅是 7).
可以确定的是，最多有一个 传感器有缺陷。请返回这个有缺陷的传感器的编号 （1 或 2）。如果任一传感器 没有缺陷 ，或者 无法 确定有缺陷的传感器，则返回 -1 。
提示：
sensor1.length == sensor2.length
1 <= sensor1.length <= 100
1 <= sensor1[i], sensor2[i] <= 100
 */