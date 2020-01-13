/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enigma;

/**
 *
 * @author jm512325
 */
public class GeneralRotor {
    protected static int ALPHA_SIZE = 26;
    
    protected int position;
    protected int[] cipher = new int[ALPHA_SIZE];
    protected int notch1 = -1;
    protected int notch2 = -1;
    
    GeneralRotor(int[] cipher, int notch1) {
	this.notch1 = notch1;
	this.cipher = cipher;
    }
    
    protected static char toLetter(int p) {
        return (char)(p + 'A');
    }

    protected static int toIndex(char c) {
        return c - 'A';
    }
    
    public int convertForward(int p) {
        return ((cipher[(p+position)%ALPHA_SIZE]-position) + ALPHA_SIZE)%ALPHA_SIZE;
    }
    
    public int getPosition() {
        return position;
    }

    public void setPosition(int posn) {
        position = posn;
    }
}
