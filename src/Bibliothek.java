import java.util.Scanner;

/**
 * Klasse Bibliothek
 *
 * @author Shamil Gradov
 */
public class Bibliothek {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Zettelkasten instanzieren
        Zettelkasten zettelkasten = new Zettelkasten();
        //Medien dem Zettelkasten hinzufügen
        zettelkasten.addMedium(new Buch("\"Duden 01. Die deutsche Rechtschreibung\"", 2004, "Bibliographisches Institut, Mannheim",
                "3-411-04013-0", "-"));
        zettelkasten.addMedium(new CD("\"1\"", "Apple (Bea (EMI)", "The Beatles"));
        zettelkasten.addMedium(new Zeitschrift("\"Der Spiegel\"", "0038-7452 ", 54, 6));
        zettelkasten.addMedium(new ElektronischesMedium("\"Hochschule Stralsund\"", "https://www.hochschule-stralsund.de"));
        //Zettelkasten sortieren
        System.out.println("Wie soll die Liste sortiert werden? (A-Z) (Z-A)");
        zettelkasten.sort(sc.nextLine());
        zettelkasten.sort("Z-A");
        /*
         * Schleife zum ausgeben aller Inhalte des Zettelkastens
         */
        for (Medium medium : zettelkasten) {
            System.out.println(medium.calculateRepresentation());
        }
        HumanReadablePersistency.save(zettelkasten,"zettelkasten");
    }
}
