package enigma;

/** Class that represents a reflector in the enigma.
 *  @author
 */
public class Reflector extends GeneralRotor {
	
    public static Reflector reflectorFactory(String str){
	char[] s = str.trim().replace(" ", "").toCharArray();
	int[] cipher = new int[ALPHA_SIZE];
	for (int i = 0; i< ALPHA_SIZE; i++){
		cipher[i] = toIndex(s[i]);
	}
	return new Reflector(cipher);
    }

    Reflector(int[] r){
	super(r,0);
    }
}
