/**
 * Klasse Bibliothek
 * @author Shamil Gradov
 *
 */
public class Bibliothek {

    public static void main(String[] args) {

        Zettelkasten zettelkasten = new Zettelkasten();
        zettelkasten.addMedium(new Buch("\"Duden 01. Die deutsche Rechtschreibung\"", 2004, "Bibliographisches Institut, Mannheim",
                "3-411-04013-0", "-"));
        zettelkasten.addMedium(new CD("\"1\"", "Apple (Bea (EMI)", "The Beatles"));
        zettelkasten.addMedium(new Zeitschrift("\"Der Spiegel\"", "0038-7452 ", 54, 6));
        zettelkasten.addMedium(new ElektronischesMedium("\"Hochschule Stralsund\"", "https://www.hochschule-stralsund.de"));

        /*
         * Schleife zum ausgeben aller Inhalte des Zettelkastens
         */
        for(Medium medium : zettelkasten){
            System.out.println(medium.calculateRepresentation());
        }

    }
}
