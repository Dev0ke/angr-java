import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionP271Tests {
    @Test
    public void example1() {
        SolutionP271.Codec codec = new SolutionP271.Codec();
        List<String> strs = new ArrayList<>(List.of("", ""));
        String encode = codec.encode(strs);
        List<String> actual = codec.decode(encode);
        List<String> expected = new ArrayList<>(List.of("", ""));
        Assertions.assertEquals(expected, actual);
    }
}
