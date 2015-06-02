package wordmaster;

public class Anagrammi {

    Sanasto sanasto;

    public Anagrammi() {

    }

    public String aloita(Sana muutettava) {
//        Sana anagrammiksiMuutettava = Main.sanasto.luoRandomSana();
        // tekee sanan kaikki anagrammit
//        anagrammiksiMuutettava.teeAnagrammi(anagrammiksiMuutettava.getSana());
        // tekee satunnaisen anagrammin
//        System.out.println(muutettava);
        return muutettava.randomAnagrammi(muutettava.getSana());

    }

    public static boolean ovatkoAnagrammeja(String sana, String anagrammi) {

        if (sana.length() != anagrammi.length()) {
            return false;
        }
        char[] merkit = sana.toUpperCase().toCharArray();
        for (char m : merkit) {
            int index = anagrammi.indexOf(m);
            if (index != -1) {
                anagrammi = anagrammi.substring(0, index) + anagrammi.substring(index + 1, anagrammi.length());
            } else {
                return false;
            }
        }
        return anagrammi.isEmpty();
    }

}
