import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution756Tests {
    private final Solution756 solution756 = new Solution756();

    @Test
    public void example1() {
        String bottom = "BCD";
        List<String> allowed = Arrays.asList("BCC", "CDE", "CEA", "FFF");
        Assertions.assertTrue(solution756.pyramidTransition(bottom, allowed));
    }

    @Test
    public void example2() {
        String bottom = "AAAA";
        List<String> allowed = Arrays.asList("AAB", "AAC", "BCD", "BBE", "DEF");
        Assertions.assertFalse(solution756.pyramidTransition(bottom, allowed));
    }

    // 补充用例
    @Test
    public void example3() {
        String bottom = "ABBBBBBG";
        List<String> allowed = Arrays.asList("BDD", "BFB", "FDA", "CCC", "FBD", "FBG", "EEB", "GBA", "CFB", "ECB", "GDA", "ECC", "EFE", "FCA", "DBA", "FAD", "BEE", "GEC", "CFC", "CFD", "BCG", "CAC", "FCC", "GAC", "CAG", "CFF", "BEC", "EAD", "GBE", "FEG", "BDC", "GBF", "FBB", "FBE", "DDG", "FDF", "EDF", "FAF", "BEB", "DDE", "EEA", "FAG", "GDC", "DFE", "CDB", "DFD", "GDD", "DAF", "ECE", "DBG", "DDD", "EFG", "FAC", "FEC", "GED", "DEE", "CCF", "EFD", "FDE", "GDF", "ECG", "DAE", "FCG", "DCA", "EAF", "EED", "EEE", "FEA", "BFG", "EAA", "GDE", "CEB", "FAE", "BDE", "EBB", "GFD", "DBB", "BFD", "EFF", "DAD", "CDC", "DCD", "FFD", "DBD", "EFA", "BCB", "ECF", "CFA", "GFF", "CFG", "EEG", "DAG", "CAE", "FED", "CCA", "EDE", "FDG", "BEF", "FDD", "BEG", "FFE", "DDC", "BCE", "GAA", "GFE", "FFF", "CFE", "BDF", "DFG", "DEF", "FEF", "GEE", "EAB", "GDB", "CEE", "BDA", "DEG", "DEC", "GCG", "DFB", "EFB", "GAB", "CDF", "CAF", "BAB", "GCC", "DDA", "CDD", "FCB", "DAA", "GBG", "BAC", "GCE", "GAG", "EAE", "EBG", "GBD", "BFE", "CCD", "EDD", "FCD", "FBC", "DEB", "EDG", "GEA", "EBE", "GDG", "DBE", "BCD", "GBB", "FEB", "DED", "CAD", "EDB", "CED", "GCD", "BFC", "GAE", "CEG", "EEC", "FEE", "GCA", "FCF", "ECD", "DCC", "BDB", "EBD", "DCE", "BAE", "FFG", "DDF", "DCF", "BED", "CAA", "BCF", "GBC", "CCB", "BCC", "GFC", "FFB", "DFA", "BBA", "BBB", "BBC", "BBD", "BBE", "BBF", "BBG", "AAA", "ABA", "ACA", "ADA", "AEA", "AFA", "BGG", "CGG", "DGG", "EGG", "FGG", "GGG");
        Assertions.assertFalse(solution756.pyramidTransition(bottom, allowed));
    }
}