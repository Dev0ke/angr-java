import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Solution2286Tests {
    @Test
    public void example1() throws Exception {
        reflection(Solution2286.BookMyShow.class, "solution2286-example1-input.txt", "solution2286-example1-output.txt");
        reflection(Solution2286.BookMyShow2.class, "solution2286-example1-input.txt", "solution2286-example1-output.txt");
    }

    // 补充用例
    @Test
    public void example2() throws Exception {
        // https://leetcode.cn/submissions/detail/319206175/
        // 爆 int
        reflection(Solution2286.BookMyShow.class, "solution2286-example2-input.txt", "solution2286-example2-output.txt");
        reflection(Solution2286.BookMyShow2.class, "solution2286-example2-input.txt", "solution2286-example2-output.txt");
    }

    @Test
    public void example3() throws Exception {
        // https://leetcode.cn/submissions/detail/319218596/
        // 92 / 94 个通过测试用例 TLE
        reflection(Solution2286.BookMyShow.class, "solution2286-example3-input.txt", "solution2286-example3-output.txt");
    }

    private void reflection(Class<?> clazz, String inputFile, String outputFile) throws Exception {
        // 类、构造器、类方法
        Constructor<?> constructor = clazz.getConstructor(int.class, int.class);
        Method gather = clazz.getMethod("gather", int.class, int.class);
        Method scatter = clazz.getMethod("scatter", int.class, int.class);

        // 入参
        String[] methods = JSON.parseObject(UtUtils.loadingString(inputFile, 0), String[].class);
        String[] parameters = JSON.parseObject(UtUtils.loadingString(inputFile, 1), String[].class);
        String[] returns = JSON.parseObject(UtUtils.loadingString(outputFile, 0), String[].class);
        String[] args = JSON.parseObject(parameters[0], String[].class);
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        // 实例化
        List<Object> invokes = new ArrayList<>();
        invokes.add(null);
        Object obj = constructor.newInstance(n, m);
        for (int i = 1; i < methods.length; i++) {
            String method = methods[i];
            int[] parameter = JSON.parseObject(parameters[i], int[].class);
            int k = parameter[0];
            int maxRow = parameter[1];

            if (method.equals("gather")) {
                int[] invoke = (int[]) gather.invoke(obj, k, maxRow);
                int[] expected = JSON.parseObject(returns[i], int[].class);
                Assertions.assertArrayEquals(expected, invoke);
                invokes.add(invoke);
            } else if (method.equals("scatter")) {
                boolean invoke = (boolean) scatter.invoke(obj, k, maxRow);
                boolean expected = JSON.parseObject(returns[i], boolean.class);
                Assertions.assertEquals(expected, invoke);
                invokes.add(invoke);
            }
        }
        System.out.println(JSON.toJSONString(invokes, SerializerFeature.WRITE_MAP_NULL_FEATURES));
    }
}
