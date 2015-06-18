package main;

import java.io.*;
import wordmaster.Sana;
import wordmaster.Sanasto;

/**
 *
 */
public class TiedostonLukija {

    Sanasto sanasto;

    /**
     *
     */
    public TiedostonLukija() {

        this.sanasto = new Sanasto();

    }

    /**
     * Metodi lukee txt-tiedoston, luo sen riveistä Sana-olioita ja tallentaa ne
     * Sanasto-luokan ilmentymään.
     *
     * @return @throws Exception
     */
    public boolean lueTiedosto() throws Exception {

        try {
            File fileDir = new File("kotus_sanat_karsittu.txt");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileDir), "UTF-8"));

            String str;
            while ((str = in.readLine()) != null) {

                Sana sana = new Sana(str);

                sanasto.lisaaSana(sana);
            }

            in.close();

        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return true;
    }
}
