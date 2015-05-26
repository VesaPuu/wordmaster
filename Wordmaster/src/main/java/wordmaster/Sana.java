/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordmaster;

/**
 *
 * @author Vesa
 */
public class Sana {

    String sana;
    static int pituus;
    static int r;

    /**
     *
     * @param sana
     */
    public Sana(String sana) {

        this.sana = sana.toUpperCase();
        this.pituus = sana.length();

    }

    /**
     *
     * @return
     */
    public int getPituus() {
        return this.pituus;
    }

    /**
     *
     * @return
     */
    public String getSana() {
        return this.sana;
    }

    /**
     *
     * @param input
     * @return
     */
    public static boolean teeAnagrammi(String input) {

        boolean[] used = new boolean[input.length()];
        StringBuffer outputString = new StringBuffer();
        char[] in;
        in = input.toCharArray();
        permutoi(in, outputString, used, input.length(), 0);
        return true;

    }

    /**
     *
     * @param in
     * @param outputString
     * @param used
     * @param inputLength
     * @param level
     * @return
     */
    public static boolean permutoi(char[] in, StringBuffer outputString,
            boolean[] used, int inputLength, int level) {
        if (level == inputLength) {
            System.out.println(outputString.toString());
            return true;
        }

        for (int i = 0; i < inputLength; ++i) {

            if (used[i]) {
                continue;
            }

            outputString.append(in[i]);
            used[i] = true;
            permutoi(in, outputString, used, inputLength, level + 1);
            used[i] = false;
            outputString.setLength(outputString.length() - 1);
        }
        return true;
    }

    public String toString() {

        return this.sana;
    }

}
