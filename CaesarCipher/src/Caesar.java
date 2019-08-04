import java.util.ArrayList;

/**
 *  realisation Rotation Cipher as Caesar  cipher
 */
public class Caesar implements RotationCipher{



    /**
     * simple caesar cipher algorithm used ternary operator for calculate new symbol for negative and positive n
     */
    @Override
    public String rotate(String s, int n) {
        char[] temp = s.toCharArray();
        for (int i=0;i<temp.length;i++) {
            if (Character.isLetter(temp[i])) {
                if (Character.isLowerCase(temp[i])) {
                    temp[i]=(char)((((int)temp[i]+n)<97) ? (((int)temp[i] + n - 97) % 26 + 123 ) : (((int)temp[i] + n - 97) % 26 + 97));
                }
                else {
                    temp[i]=(char)((((int)temp[i]+n)<65) ? (((int)temp[i] + n - 65) % 26 + 91 ) : (((int)temp[i] + n - 65) % 26 + 65));
                }
            }
        }
        return new String(temp);
    }

    /**
     * run the caesar cipher for n = 26-n
     */
    @Override
    public String decipher(String s, int n) {
        return rotate(s, 26-n);
    }

    @Override
    public ArrayList<Double> frequencies(String s) {
        ArrayList<Double> temp = new ArrayList<>();
        s=s.toLowerCase();
        double sum;
        for (char i='a';i<='z';i++) {
            sum=0;
            for (int j=0;j<s.length();j++) {
                if (s.charAt(j)==i) sum+=1.0;
            }
            temp.add(sum/((double)s.length()));
        }
        return temp;
    }

    @Override
    public double chiSquared(ArrayList<Double> real, ArrayList<Double> know) {
        double sum=0;
        for (int i=0;i<real.size();i++) {
            sum+=Math.pow(real.get(i)-know.get(i),2)/know.get(i);
        }
        return sum;
    }
}