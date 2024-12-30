import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1125Tests {
    private final Solution1125 solution1125 = new Solution1125();

    @Test
    public void example1() {
        String[] req_skills = {"java", "nodejs", "reactjs"};
        List<List<String>> people = UtUtils.stringToStringList2("""
                [["java"],["nodejs"],["nodejs","reactjs"]]
                """);
        int[] expected = {0, 2};
        Assertions.assertArrayEquals(expected, solution1125.smallestSufficientTeam(req_skills, people));
        Assertions.assertArrayEquals(expected, solution1125.smallestSufficientTeam2(req_skills, people));
    }

    @Test
    public void example2() {
        String[] req_skills = {"algorithms", "math", "java", "reactjs", "csharp", "aws"};
        List<List<String>> people = UtUtils.stringToStringList2("""
                [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
                """);
        int[] expected = {1, 2};
        Assertions.assertArrayEquals(expected, solution1125.smallestSufficientTeam(req_skills, people));
        Assertions.assertArrayEquals(expected, solution1125.smallestSufficientTeam2(req_skills, people));
    }

    // 补充用例
    @Test
    public void example3() {
        // https://leetcode.cn/submissions/detail/386213977/ TLE
        String[] req_skills = {"hdbxcuzyzhliwv", "uvwlzkmzgis", "sdi", "bztg", "ylopoifzkacuwp", "dzsgleocfpl"};
        List<List<String>> people = UtUtils.stringToStringList2("""
                [["hdbxcuzyzhliwv","dzsgleocfpl"],["hdbxcuzyzhliwv","sdi","ylopoifzkacuwp","dzsgleocfpl"],["bztg","ylopoifzkacuwp"],["bztg","dzsgleocfpl"],["hdbxcuzyzhliwv","bztg"],["dzsgleocfpl"],["uvwlzkmzgis"],["dzsgleocfpl"],["hdbxcuzyzhliwv"],[],["dzsgleocfpl"],["hdbxcuzyzhliwv"],[],["hdbxcuzyzhliwv","ylopoifzkacuwp"],["sdi"],["bztg","dzsgleocfpl"],["hdbxcuzyzhliwv","uvwlzkmzgis","sdi","bztg","ylopoifzkacuwp"],["hdbxcuzyzhliwv","sdi"],["hdbxcuzyzhliwv","ylopoifzkacuwp"],["sdi","bztg","ylopoifzkacuwp","dzsgleocfpl"],["dzsgleocfpl"],["sdi","ylopoifzkacuwp"],["hdbxcuzyzhliwv","uvwlzkmzgis","sdi"],[],[],["ylopoifzkacuwp"],[],["sdi","bztg"],["bztg","dzsgleocfpl"],["sdi","bztg"]]
                """);
        int[] expected = {1, 16};
        Assertions.assertArrayEquals(expected, solution1125.smallestSufficientTeam(req_skills, people));
        int[] expected2 = {0, 16};
        Assertions.assertArrayEquals(expected2, solution1125.smallestSufficientTeam2(req_skills, people));
    }
}
