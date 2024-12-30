import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class Solution1600Tests {
    @Test
    public void example1() {
        // 继承顺序：king
        Solution1600.ThroneInheritance t = new Solution1600.ThroneInheritance("king");

        // 继承顺序：king > andy
        t.birth("king", "andy");

        // 继承顺序：king > andy > bob
        t.birth("king", "bob");

        // 继承顺序：king > andy > bob > catherine
        t.birth("king", "catherine");

        // 继承顺序：king > andy > matthew > bob > catherine
        t.birth("andy", "matthew");

        // 继承顺序：king > andy > matthew > bob > alex > catherine
        t.birth("bob", "alex");

        // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        t.birth("bob", "asha");

        // 返回 ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
        List<String> expected = List.of("king", "andy", "matthew", "bob", "alex", "asha", "catherine");
        List<String> actual = t.getInheritanceOrder();
        Assertions.assertEquals(expected, actual);

        // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        t.death("bob");

        // 返回 ["king", "andy", "matthew", "alex", "asha", "catherine"]
        expected = List.of("king", "andy", "matthew", "alex", "asha", "catherine");
        actual = t.getInheritanceOrder();
        Assertions.assertEquals(expected, actual);
    }
}