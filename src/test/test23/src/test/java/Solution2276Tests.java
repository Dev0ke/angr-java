import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Solution2276Tests {
    @Test
    public void example1() {
        // 用一个区间空集初始化对象
        Solution2276.CountIntervals countIntervals = new Solution2276.CountIntervals();
        // 将 [2, 3] 添加到区间集合中
        countIntervals.add(2, 3);
        // 将 [7, 10] 添加到区间集合中
        countIntervals.add(7, 10);

        // 返回 6
        // 整数 2 和 3 出现在区间 [2, 3] 中
        // 整数 7、8、9、10 出现在区间 [7, 10] 中
        Assertions.assertEquals(6, countIntervals.count());

        // 将 [5, 8] 添加到区间集合中
        countIntervals.add(5, 8);

        // 返回 8
        // 整数 2 和 3 出现在区间 [2, 3] 中
        // 整数 5 和 6 出现在区间 [5, 8] 中
        // 整数 7 和 8 出现在区间 [5, 8] 和区间 [7, 10] 中
        // 整数 9 和 10 出现在区间 [7, 10] 中
        Assertions.assertEquals(8, countIntervals.count());
    }

    @Test
    public void example1_2() throws Exception {
        reflection("solution2276-example1-input.txt", "solution2276-example1-output.txt");
    }

    @Test
    public void example2() throws Exception {
        reflection("solution2276-example2-input.txt", "solution2276-example2-output.txt");
    }

    private void reflection(String inputFile, String outputFile) throws Exception {
        // 类、构造器、类方法
        // CountIntervals2 9sec148ms
        Class<?> clazz = Solution2276.CountIntervals2.class;
        Constructor<?> constructor = clazz.getConstructor();
        Method add = clazz.getMethod("add", int.class, int.class);
        Method count = clazz.getMethod("count");

        // 入参
        String[] methods = JSON.parseObject(UtUtils.loadingString(inputFile, 0), String[].class);
        String[] parameters = JSON.parseObject(UtUtils.loadingString(inputFile, 1), String[].class);
        String[] returns = JSON.parseObject(UtUtils.loadingString(outputFile, 0), String[].class);

        // 实例化
        List<Object> invokes = new ArrayList<>();
        invokes.add(null);
        Object obj = constructor.newInstance();
        for (int i = 1; i < methods.length; i++) {
            String method = methods[i];
            String parameter = parameters[i];

            if (method.equals("add")) {
                int[] tuple = JSON.parseObject(parameter, int[].class);
                int left = tuple[0];
                int right = tuple[1];
                add.invoke(obj, left, right);
                invokes.add(null);
            } else if (method.equals("count")) {
                int invoke = (int) count.invoke(obj);
                int expected= JSON.parseObject(returns[i], int.class);
                Assertions.assertEquals(expected, invoke);
                invokes.add(invoke);
            }
        }
        System.out.println(JSON.toJSONString(invokes, SerializerFeature.WRITE_MAP_NULL_FEATURES));
    }
}
