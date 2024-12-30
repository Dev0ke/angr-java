import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution609Tests {
    private final Solution609 solution609 = new Solution609();

    @Test
    public void example1() {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
                """);
        Assertions.assertEquals(expected, solution609.findDuplicate(paths));
    }

    @Test
    public void example2() {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)"};
        List<List<String>> expected = UtUtils.stringToStringList2("""
                [["root/a/2.txt","root/c/d/4.txt"],["root/a/1.txt","root/c/3.txt"]]
                """);
        Assertions.assertEquals(expected, solution609.findDuplicate(paths));
    }
}