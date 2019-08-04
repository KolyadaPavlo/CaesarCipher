import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * This test class simply tests the Caesar Java class for each method.
 */
public class CaesarTest {
    private static double[] knownFreq = {0.0855, 0.0160, 0.0316, 0.0387, 0.1210,
            0.0218, 0.0209, 0.0496, 0.0733, 0.0022,
            0.0081, 0.0421, 0.0253, 0.0717, 0.0747,
            0.0207, 0.0010, 0.0633, 0.0673, 0.0894,
            0.0268, 0.0106, 0.0183, 0.0019, 0.0172,
            0.0011};

    @org.junit.Test
    public void rot1ate() {
        Caesar caesar = new Caesar();
        assertEquals("zzz", caesar.rotate("zzz", -26));
        assertEquals("Zzz", caesar.rotate("Zzz", -26));
        assertEquals("Bcd", caesar.rotate("Abc", 1));
        assertEquals("ZZZ", caesar.rotate("ZZZ", -26));
        assertEquals("AAA", caesar.rotate("ZZZ", 1));
        assertEquals("BBB", caesar.rotate("AAA", -25));
        assertEquals("xyz", caesar.rotate("abc", -3));
        assertEquals("EXXEGOEXSRGI", caesar.rotate("ATTACKATONCE", 4));
    }

    @Test
    public void decipher() {
        Caesar caesar = new Caesar();
        assertEquals("zzz", caesar.rotate("zzz", -52));
        assertEquals("aaa", caesar.decipher("ccc", 2));
        assertEquals("abc", caesar.decipher("bcd", 1));
        assertEquals("bcd", caesar.decipher("abc", -1));
        assertEquals("AAA", caesar.decipher("BBB", 1));
        assertEquals("ATTACKATONCE", caesar.decipher("EXXEGOEXSRGI", 4));

    }

    @Test
    public void frequencies() {
        Caesar caesar = new Caesar();
        assertEquals(0.5,caesar.frequencies("aabb").get(0).doubleValue(),0.0001);
        assertEquals(0.5,caesar.frequencies("AaBb").get(0).doubleValue(),0.0001);
    }

    @Test
    public void chiSquared() {
        Caesar caesar = new Caesar();
        ArrayList<String> temp = new ArrayList<>();
        ArrayList<Double> know = new ArrayList<>();
        double tempMin=20.0;
        double tempCHI =0;
        String fin = null;
        for (int i = 0; i < knownFreq.length; i++) {
            know.add(knownFreq[i]);
        }
        for (int i=0;i<26;i++) {
            temp.add(caesar.rotate("Wkh vklsv kxqj lq wkh vnb lq pxfk wkh vdph zdb wkdw eulfnv grq'w.",i));
            tempCHI=caesar.chiSquared(caesar.frequencies(temp.get(i)),know);
            if (tempCHI<tempMin) {
                tempMin=tempCHI;
                fin=temp.get(i);
            }
        }
        assertEquals("The ships hung in the sky in much the same way that bricks don't.", fin);
    }
}