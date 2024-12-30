import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SolutionP431Tests {
    @Test
    public void example1() {
        SolutionP431.Node root = new SolutionP431.Node(1, new ArrayList<>());
        root.children.add(new SolutionP431.Node(3, new ArrayList<>()));
        root.children.add(new SolutionP431.Node(2, new ArrayList<>()));
        root.children.add(new SolutionP431.Node(4, new ArrayList<>()));
        root.children.get(0).children.add(new SolutionP431.Node(5, new ArrayList<>()));
        root.children.get(0).children.add(new SolutionP431.Node(6, new ArrayList<>()));

        SolutionP431.Codec codec = new SolutionP431.Codec();
        Assertions.assertTrue(UtUtils.assertJsonEquals(root, codec.decode(codec.encode(root))));
    }
}
