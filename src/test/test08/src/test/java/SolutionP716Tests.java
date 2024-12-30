import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SolutionP716Tests {
    @Test
    public void example1() {
        SolutionP716.MaxStack stk = new SolutionP716.MaxStack();

        // [5] - 5 既是栈顶元素，也是最大元素
        stk.push(5);

        // [5, 1] - 栈顶元素是 1，最大元素是 5
        stk.push(1);

        // [5, 1, 5] - 5 既是栈顶元素，也是最大元素
        stk.push(5);

        // 返回 5，[5, 1, 5] - 栈没有改变
        Assertions.assertEquals(5, stk.top());

        // 返回 5，[5, 1] - 栈发生改变，栈顶元素不再是最大元素
        Assertions.assertEquals(5, stk.popMax());

        // 返回 1，[5, 1] - 栈没有改变
        Assertions.assertEquals(1, stk.top());

        // 返回 5，[5, 1] - 栈没有改变
        Assertions.assertEquals(5, stk.peekMax());

        // 返回 1，[5] - 此操作后，5 既是栈顶元素，也是最大元素
        Assertions.assertEquals(1, stk.pop());

        // 返回 5，[5] - 栈没有改变
        Assertions.assertEquals(5, stk.top());
    }

    @Test
    public void example2() throws Exception {
        // https://leetcode.cn/submissions/detail/395134704/
        // 165 / 166 个通过测试用例
        reflection(SolutionP716.MaxStack2.class, "solution716-example2-input.txt", "solution716-example2-output.txt");
    }

    @Test
    public void example3() throws Exception {
        // https://leetcode.cn/submissions/detail/395127962/
        // 164 / 166 个通过测试用例
        reflection(SolutionP716.MaxStack2.class, "solution716-example3-input.txt", "solution716-example3-output.txt");
    }

    private void reflection(Class<?> clazz, String inputFile, String outputFile) throws Exception {
        // 类、构造器、类方法
        Constructor<?> constructor = clazz.getConstructor();
        Method push = clazz.getMethod("push", int.class);
        Method pop = clazz.getMethod("pop");
        Method top = clazz.getMethod("top");
        Method peekMax = clazz.getMethod("peekMax");
        Method popMax = clazz.getMethod("popMax");

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

            Object invoke = null;
            if (method.equals("push")) {
                int[] parameter = JSON.parseObject(parameters[i], int[].class);
                int x = parameter[0];
                push.invoke(obj, x);
            } else if (method.equals("pop")) {
                invoke = pop.invoke(obj);
                int expected = JSON.parseObject(returns[i], int.class);
                Assertions.assertEquals(expected, invoke);
                invokes.add(invoke);
            } else if (method.equals("top")) {
                invoke = top.invoke(obj);
                int expected = JSON.parseObject(returns[i], int.class);
                Assertions.assertEquals(expected, invoke);
                invokes.add(invoke);
            } else if (method.equals("peekMax")) {
                invoke = peekMax.invoke(obj);
                int expected = JSON.parseObject(returns[i], int.class);
                Assertions.assertEquals(expected, invoke);
                invokes.add(invoke);
            } else if (method.equals("popMax")) {
                invoke = popMax.invoke(obj);
                int expected = JSON.parseObject(returns[i], int.class);
                Assertions.assertEquals(expected, invoke);
            }
            invokes.add(invoke);
        }
        System.out.println(JSON.toJSONString(invokes, SerializerFeature.WRITE_MAP_NULL_FEATURES));
    }
}