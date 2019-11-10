import java.util.ArrayList;

/**
 * Klasse Buch
 *
 * @author Shamil Gradov
 */
public class Buch extends Medium {
    /**
     * Variable Erscheinungsjahr, Verlag, ISBN, Verfasser
     */
    private int erscheinungsjahr;
    private String verlag;
    private String isbn;
    private String verfasser;

    /**
     * @param _titel
     * @param _erscheinungsjahr
     * @param _verlag
     * @param _isbn
     * @param _verfasser
     */
    public Buch(String _titel, int _erscheinungsjahr, String _verlag, String _isbn, String _verfasser) {
        super(_titel);
        setErscheinungsjahr(_erscheinungsjahr);
        setVerlag(_verlag);
        setISBN(_isbn);
        setVerfasser(_verfasser);

    }

    private static int[] convertIntegers(ArrayList<Integer> integers) {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = integers.get(i);
        }
        return ret;
    }

    /**
     * Methode um zu überprüfen ob die ISBN 10 stellig ist und korrekt
     *
     * @param isbn
     * @return true or false, je nach ergebnis
     */
    private static boolean checkISBN10(int[] isbn) {
        if (isbn.length < 10) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i <= isbn.length; i++) {
            sum += i * isbn[i - 1];
        }
        if (sum % 11 == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Methode um zu überprüfen ob die ISBN 13 stellig ist und korrekt
     *
     * @param isbn
     * @return true or false, je nach ergebnis
     */
    private static boolean checkISBN13(int[] isbn) {
        if (isbn.length < 13) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i < isbn.length; i++) {
            if (i % 2 == 0) {
                sum += isbn[i - 1] * 3;
            } else {
                sum += isbn[i - 1];
            }
        }
        int lastDigit = sum % 10;
        int check = (10 - lastDigit) % 10;
        if (isbn[isbn.length - 1] == check) {
            return true;
        } else {
            return false;
        }
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    private void setErscheinungsjahr(int _erscheinungsjahr) {
        erscheinungsjahr = _erscheinungsjahr;
    }

    public String getVerlag() {
        return verlag;
    }

    private void setVerlag(String _verlag) {
        verlag = _verlag;
    }

    public String getISBN() {
        return isbn;
    }

    private void setISBN(String _isbn) {

        ArrayList<Integer> arrlist = new ArrayList<Integer>();
        for (int i = 0; i < _isbn.length(); i++) {
            char c = _isbn.charAt(i);
            if (c != '-') {
                arrlist.add(c - '0'); //Zieh encoding von 0 vom encoding wert von c ab und daraus erschließt sich dann der Integer Wert
            }
        }
        int[] array = convertIntegers(arrlist);
        if (array.length == 10) {
            if (checkISBN10(array)) {
                isbn = _isbn;
                System.out.println("gültige 10 stellige ISBN gesetzt");
            }
        } else if (array.length == 13) {
            if (checkISBN13(array)) {
                isbn = _isbn;
                System.out.println("gültige 13 stellige ISBN gesetzt");

            }
        } else {
            System.out.println("ungueltige ISBN");
        }

    }

    public String getVerfasser() {
        return verfasser;
    }

    private void setVerfasser(String _verfasser) {
        verfasser = _verfasser;
    }

    /**
     * Methode um Parameter der Klasse Buch als Zeichenkette auszugeben
     *
     * @return Ausgabe der Repraesentation des Mediums Buch in Stringform
     */
    public String calculateRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getTitel());
        sb.append(" Erscheinungsjahr: ");
        sb.append(erscheinungsjahr);
        sb.append(" Verlag: ");
        sb.append(verlag);
        sb.append(" ISBN: ");
        sb.append(isbn);
        sb.append(" Verfasser: ");
        sb.append(verfasser);
        return sb.toString();

    }

}
