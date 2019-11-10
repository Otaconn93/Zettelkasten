/**
 * Klasse Bibliothek
 * @author Shamil Gradov
 *
 */
public class Bibliothek {

    public static void main(String[] args) {

        Medium[] mediumarr = new Medium[4];
        mediumarr[0] = new Buch("\"Duden 01. Die deutsche Rechtschreibung\"", 2004, "Bibliographisches Institut, Mannheim",
                "3-411-04013-0", "-");
        mediumarr[1] = new CD("\"1\"", "Apple (Bea (EMI)", "The Beatles");
        mediumarr[2] = new Zeitschrift("\"Der Spiegel\"", "0038-7452 ", 54, 6);
        mediumarr[3] = new ElektronischesMedium("\"Hochschule Stralsund\"", "https://www.hochschule-stralsund.de");
        /*
         * Schleife zum ausgeben aller Inhalte des Arrays mediumarr
         */
        for (int i = 0; i <= mediumarr.length-1; i++) {
            System.out.println(mediumarr[i].calculateRepresentation());
        }

    }
}
