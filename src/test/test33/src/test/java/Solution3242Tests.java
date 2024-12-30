import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Solution3242Tests {
    @Test
    public void example1() throws Exception {
        reflection("solution3242-example1-input.txt", "");
    }

    @Test
    public void example2() throws Exception {
        reflection("solution3242-example2-input.txt", "");
    }

    private void reflection(String inputFile, String outputFile) throws Exception {
        // 类、构造器、类方法
        // CountIntervals2 9sec148ms
        Class<?> clazz = Solution3242.neighborSum.class;
        Constructor<?> constructor = clazz.getConstructor(int[][].class);
        Method adjacentSum = clazz.getMethod("adjacentSum", int.class);
        Method diagonalSum = clazz.getMethod("diagonalSum", int.class);

        // 入参
        String[] methods = JSON.parseObject(UtUtils.loadingString(inputFile, 0), String[].class);
        String[] parameters = JSON.parseObject(UtUtils.loadingString(inputFile, 1), String[].class);
        String[] returns = JSON.parseObject(UtUtils.loadingString(inputFile, 2), String[].class);

        // 实例化
        List<Object> invokes = new ArrayList<>();
        int[][] grid = JSON.parseObject(parameters[0], int[][][].class)[0];
        Object obj = constructor.newInstance((Object) grid);
        invokes.add(null);
        for (int i = 1; i < methods.length; i++) {
            String method = methods[i];
            String parameter = parameters[i];

            if (method.equals("adjacentSum")) {
                int value = JSON.parseObject(parameter, int[].class)[0];
                int expected = JSON.parseObject(returns[i], int.class);
                int invoke = (int) adjacentSum.invoke(obj, value);
                Assertions.assertEquals(expected, invoke);
                invokes.add(invoke);
            } else if (method.equals("diagonalSum")) {
                int value = JSON.parseObject(parameter, int[].class)[0];
                int expected = JSON.parseObject(returns[i], int.class);
                int invoke = (int) diagonalSum.invoke(obj, value);
                Assertions.assertEquals(expected, invoke);
                invokes.add(invoke);
            }
        }
        System.out.println(JSON.toJSONString(invokes, SerializerFeature.WRITE_MAP_NULL_FEATURES));
    }
}