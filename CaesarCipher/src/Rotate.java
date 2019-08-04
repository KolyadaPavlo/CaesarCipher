/**
 *
 *
 *
 */
public class Rotate {

    static String s;
    public static void main(String[] args) {
        RotationCipher caesar = new Caesar();
        if (args.length==2) {
            s = args[1];
            if (s.length()<100 || s.length()>=0) {
                System.out.println(caesar.rotate(s,Integer.parseInt(args[0])));
            }
            else {
                System.out.println("String is small or too big!!!");
            }
        }
        else if (args.length<2) {
            System.out.println("Too few parameters!");
        }
        else {
            System.out.println("Too many parameters!");
        }
    }
}
