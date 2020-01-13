package enigma;

public class Rotor extends GeneralRotor {
   
    public static Rotor rotorFactory(String str, String notches){
	char[] s = str.trim().replace(" ", "").toCharArray();
	int[] cipher = new int[ALPHA_SIZE];
	for (int i = 0; i< ALPHA_SIZE; i++){
		cipher[i] = toIndex(s[i]);
	}
	s = notches.trim().replace(" and ", "").toCharArray();
		if (s.length == 2){
		return new Rotor(cipher, toIndex(s[0]), toIndex(s[1]));
	} else {
		return new Rotor(cipher, toIndex(s[0]));
	}
		
    }

    Rotor(int[] c, int notch1, int notch2) {
        super(c,notch1);
	this.notch2 = notch2;
	cipher = c;
	createBCipher();
    }
    
    Rotor(int[] c, int notch1){
        super(c, notch1);
	createBCipher();
    }

    public int convertBackward(int e) {
        return ((bcipher[((e+position)%ALPHA_SIZE+ALPHA_SIZE)%ALPHA_SIZE]-position)%ALPHA_SIZE+ALPHA_SIZE)%ALPHA_SIZE;
    }
    
    protected void advance() {
        position = (position+1) % ALPHA_SIZE;
    }
    
    protected boolean atNotch() {
        return (position == notch1 || position == notch2);
    }
    
    private void createBCipher() {
	for(int i =0; i<ALPHA_SIZE; i++)
            bcipher[cipher[i]] = i;
    }
}

