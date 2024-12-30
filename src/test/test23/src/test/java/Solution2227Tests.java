import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Solution2227Tests {
    @Test
    public void example1() {
        char[] keys = {'a', 'b', 'c', 'd'};
        String[] values = {"ei", "zf", "ei", "am"};
        String[] dictionary = {"abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"};

        Solution2227.Encrypter encrypter = new Solution2227.Encrypter(keys, values, dictionary);

        // 返回 "eizfeiam"。
        // 'a' 映射为 "ei"，'b' 映射为 "zf"，'c' 映射为 "ei"，'d' 映射为 "am"。
        Assertions.assertEquals("eizfeiam", encrypter.encrypt("abcd"));

        // return 2.
        // "ei" 可以映射为 'a' 或 'c'，"zf" 映射为 'b'，"am" 映射为 'd'。
        // 因此，解密后可以得到的字符串是 "abad"，"cbad"，"abcd" 和 "cbcd"。
        // 其中 2 个字符串，"abad" 和 "abcd"，在 dictionary 中出现，所以答案是 2 。
        Assertions.assertEquals(2, encrypter.decrypt("eizfeiam"));
    }

    @Test
    public void example1_2() throws Exception {
        reflection("solution2227-example1-input.txt", "solution2227-example1-output.txt");
    }

    @Test
    public void example2() throws Exception {
        // 201 / 203 个通过测试用例
        reflection("solution2227-example2-input.txt", "solution2227-example2-output.txt");
    }

    private void reflection(String inputFile, String outputFile) throws Exception {
        // 类、构造器、类方法
        Class<?> clazz = Solution2227.Encrypter.class;
        Constructor<?> constructor = clazz.getConstructor(char[].class, String[].class, String[].class);
        Method encrypt = clazz.getMethod("encrypt", String.class);
        Method decrypt = clazz.getMethod("decrypt", String.class);

        // 入参
        String[] methods = JSON.parseObject(UtUtils.loadingString(inputFile, 0), String[].class);
        String[] parameters = JSON.parseObject(UtUtils.loadingString(inputFile, 1), String[].class);
        String[] returns = JSON.parseObject(UtUtils.loadingString(outputFile, 0), String[].class);
        String[] args = JSON.parseObject(parameters[0], String[].class);
        char[] keys = JSON.parseObject(args[0], char[].class);
        String[] values = JSON.parseObject(args[1], String[].class);
        String[] dictionary = JSON.parseObject(args[2], String[].class);

        // 实例化
        List<Object> invokes = new ArrayList<>();
        invokes.add(null);
        Object obj = constructor.newInstance(keys, values, dictionary);
        for (int i = 1; i < methods.length; i++) {
            String method = methods[i];
            String parameter = parameters[i];
            Object expected = returns[i];

            Object invoke = null;
            if (method.equals("encrypt")) {
                String word1 = JSON.parseObject(parameter, String[].class)[0];
                invoke = encrypt.invoke(obj, word1);
            } else if (method.equals("decrypt")) {
                String word2 = JSON.parseObject(parameter, String[].class)[0];
                invoke = decrypt.invoke(obj, word2);
            }
            Assertions.assertEquals(expected, String.valueOf(invoke));
            invokes.add(invoke);
        }
        System.out.println(JSON.toJSONString(invokes, SerializerFeature.WRITE_MAP_NULL_FEATURES));
    }
}
