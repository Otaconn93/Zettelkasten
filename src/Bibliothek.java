import java.util.ArrayList;
import java.util.Scanner;

/**
 * Klasse Bibliothek
 *
 * @author Shamil Gradov
 */
public class Bibliothek {
    public static boolean laufend = true;

    public static void main(String[] args) {

        //Scanner fuer User Input
        Scanner sc = new Scanner(System.in);


        //Zettelkasten instanzieren
        Zettelkasten zettelkasten = new Zettelkasten();


        //Medien dem Zettelkasten hinzufügen
        zettelkasten.addMedium(new Buch("\"Duden 01. Die deutsche Rechtschreibung\"", 2004, "Bibliographisches Institut, Mannheim",
                "3-411-04013-0", "-"));
        zettelkasten.addMedium(new CD("\"1\"", "Apple (Bea (EMI)", "The Beatles"));
        zettelkasten.addMedium(new Zeitschrift("\"Der Spiegel\"", "0038-7452 ", 54, 6));
        zettelkasten.addMedium(new ElektronischesMedium("\"Hochschule Stralsund\"", "https://www.hochschule-stralsund.de"));



        //Konsolenanweisungen fuer die verschiedenen Methoden
        while (laufend) {
            System.out.println("Welche Operation soll durchgefuehrt werden");
            System.out.println("a - Ausgabe des Zettelkastens");
            System.out.println("b - Medium hinzufuegen");
            System.out.println("s - Zettelkastenarray sortieren");
            System.out.println("p - Medien speichern und laden");
            System.out.println("r - Medium suchen");
            System.out.println("d - Medium löschen");
            System.out.println();
            System.out.println("e - Programm beenden");

            String input = sc.nextLine();

            switch (input.charAt(0)) {
                //Ausgabe des Zettelkastens
                case 'a':
                    ausgabeZK(zettelkasten);
                    sc.nextLine();
                    break;
                //Zettelkasten sortieren
                case 's':
                    System.out.println();
                    System.out.println("Aufsteigend(a) oder Absteigend(d)?:");
                    input = sc.nextLine();
                    switch (input.charAt(0)) {
                        case 'a':
                            zettelkasten.sort("A-Z");
                            ausgabeZK(zettelkasten);
                            break;
                        case 'd':
                            zettelkasten.sort("Z-A");
                            ausgabeZK(zettelkasten);
                            break;
                        default:
                            System.out.println("Ungültige Eingabe!");
                            break;
                    }
                    break;
                //Eine Txt Datei schreiben und eine Binary Datei schreiben und Binary Datei einlesen
                case 'p':
                    //Datei erstellen HumanReadablePersistency test
                    System.out.println("Wie ist der Name der zu speichernden Datei?");
                    HumanReadablePersistency.save(zettelkasten, sc.nextLine());

                    //BinaryPersistency Testen
                    System.out.println("Wie lautet der name der zu speichernden Binary Datei");
                    BinaryPersistency.save(zettelkasten, sc.nextLine());
                    System.out.println("Welche Binary Datei soll geladen werden");
                    Zettelkasten output = BinaryPersistency.load(sc.nextLine());
                    assert output != null;
                    for (Medium medium : output) {
                        System.out.println(medium.calculateRepresentation());
                    }
                    break;
                //nach einem bestimmtem Medium suchen
                case 'r':
                    ArrayList<Medium> findmedium = zettelkasten.findMedium(sc.nextLine());
                    for (Medium m : findmedium) {
                        System.out.println(m.calculateRepresentation());
                    }
                    break;
                //Medium entfernen
                case 'd':
                    input = sc.nextLine();
                    ArrayList<Medium> findm = zettelkasten.findMedium(input);
                    for (Medium m : findm) {
                        System.out.println(m.calculateRepresentation());
                    }
                    try {
                        zettelkasten.dropMedium(input, false);
                    } catch (DuplicateEntryException e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        findm = zettelkasten.findMedium(input);
                        for (Medium m : findm) {
                            System.out.println(m.calculateRepresentation());
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Medium wurde entfernt");
                    }
                    break;
                case 'e':
                    laufend = false;
                    break;
                // Beispielmedium hinzufügen
                case 'b':
                    zettelkasten.addMedium(new CD("\"1\"", "Placeholder Label", "The Placeholders"));
                    System.out.println("Beispiel-CD '1' hinzugefügt!");
                    sc.nextLine();
                    break;
                //Bei ungültiger Eingabe aus dem Program gehen
                default:
                    System.out.println("Ungültige Eingabe!");
                    sc.nextLine();
                    break;
            }
        }

    }
    //Methode um den Zettelkasten auf der Konsole auszugeben
    public static void ausgabeZK(Zettelkasten zk) {
        for (Medium m : zk) {
            System.out.println(m.calculateRepresentation());
            System.out.println();
        }
    }
}
