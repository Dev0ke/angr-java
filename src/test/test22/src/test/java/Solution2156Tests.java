import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Solution2156Tests {
    private final Solution2156 solution2156 = new Solution2156();

    @Test
    public void example1() {
        String s = "leetcode";
        int power = 7;
        int modulo = 20;
        int k = 2;
        int hashValue = 0;
        String expected = "ee";
        Assertions.assertEquals(expected, solution2156.subStrHash(s, power, modulo, k, hashValue));
        Assertions.assertEquals(expected, solution2156.subStrHash2(s, power, modulo, k, hashValue));
    }

    @Test
    public void example2() {
        String s = "fbxzaad";
        int power = 31;
        int modulo = 100;
        int k = 3;
        int hashValue = 32;
        String expected = "fbx";
        Assertions.assertEquals(expected, solution2156.subStrHash(s, power, modulo, k, hashValue));
        Assertions.assertEquals(expected, solution2156.subStrHash2(s, power, modulo, k, hashValue));
    }

    // 补充用例
    @Test
    public void example3() {
        String s = "xmmhdakfursinye";
        int power = 96;
        int modulo = 45;
        int k = 15;
        int hashValue = 21;
        String expected = "xmmhdakfursinye";
        Assertions.assertEquals(expected, solution2156.subStrHash(s, power, modulo, k, hashValue));
        Assertions.assertEquals(expected, solution2156.subStrHash2(s, power, modulo, k, hashValue));
    }

    @Test
    public void example4() {
        String fileName = "solution2156-example4-input.txt";
        String s = UtUtils.loadingString(fileName, 0);
        int power = UtUtils.loadingInt(fileName, 1);
        int modulo = UtUtils.loadingInt(fileName, 2);
        int k = UtUtils.loadingInt(fileName, 3);
        int hashValue = UtUtils.loadingInt(fileName, 4);
        String expected = UtUtils.loadingString("solution2156-example4-output.txt", 0);
        Assertions.assertEquals(expected, solution2156.subStrHash(s, power, modulo, k, hashValue));
    }

    @Test
    public void example5() {
        String s = "rlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblprlzblpbfleezoimfzxwnk";
        int power = 842163460;
        int modulo = 815354026;
        int k = 6;
        int hashValue = 472331242;
        String expected = "rlzblp";
        Assertions.assertEquals(expected, solution2156.subStrHash(s, power, modulo, k, hashValue));
        Assertions.assertEquals(expected, solution2156.subStrHash2(s, power, modulo, k, hashValue));
    }
}