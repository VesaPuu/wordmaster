package wordmaster;

import java.util.Random;

public class Sana {

    String sana;
    static int pituus;
    private static Random random;

    /**
     *
     * @param sana
     */
    public Sana(String sana) {

        this.sana = sana.toUpperCase();
        this.pituus = sana.length();
        this.random = new Random();

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
     * Metodi muodostaa kaikki anagrammit annetusta sanasta
     *
     * @param input merkkijono, josta anagrammit muodostetaan
     * @return palauttaa "true", kun anagrammien muodostus onnistuu
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

    public String randomAnagrammi(String input) {
        char[] mtaulu = input.toCharArray();
        String anagrammi = "";
        int pituus = input.length();
        for (int i = 0; i < input.length(); i++) {
            while (true) {
                int r = random.nextInt(pituus);
                if (mtaulu[r] != 0) {
                    anagrammi = anagrammi + mtaulu[r];
                    mtaulu[r] = 0;
                    break;
                }
            }
        }
        return anagrammi;
    }

    public String toString() {

        return this.sana;
    }

}
