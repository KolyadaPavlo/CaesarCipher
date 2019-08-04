import java.util.ArrayList;

/**
 *
 * We consider chi-squared score  from for each n from 0 to 26 and choose a string with a smaller score
 *
 */
public class BreakCaesar {
    private static double[] knownFreq = {0.0855, 0.0160, 0.0316, 0.0387, 0.1210,
            0.0218, 0.0209, 0.0496, 0.0733, 0.0022,
            0.0081, 0.0421, 0.0253, 0.0717, 0.0747,
            0.0207, 0.0010, 0.0633, 0.0673, 0.0894,
            0.0268, 0.0106, 0.0183, 0.0019, 0.0172,
            0.0011};
    public static void main(String[] args) {
        if (args.length==1) {
            Caesar caesar = new Caesar();
            ArrayList<String> temp = new ArrayList<>();
            ArrayList<Double> know = new ArrayList<>();
            double tempMin=10.0;
            double tempCHI =0;
            String fin = null;
            for (int i = 0; i < knownFreq.length; i++) {
                know.add(knownFreq[i]);
            }
            for (int i=0;i<26;i++) {
                temp.add(caesar.rotate(args[0],i));
                tempCHI=caesar.chiSquared(caesar.frequencies(temp.get(i)),know);
                if (tempCHI<tempMin) {
                    tempMin=tempCHI;
                    fin=temp.get(i);
                }
            }
            System.out.println(fin);
        }
        else if (args.length<1) {
            System.out.println("Too few parameters!");
        }
        else {
            System.out.println("Too many parameters!");
        }
    }
}
