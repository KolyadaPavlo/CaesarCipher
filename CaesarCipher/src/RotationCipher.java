import java.util.ArrayList;

/**
 *
 */
public interface RotationCipher {
    String rotate(String s, int n);
    String decipher(String s, int n);
    ArrayList<Double> frequencies(String s);
    double chiSquared(ArrayList<Double> a, ArrayList<Double> b);
}