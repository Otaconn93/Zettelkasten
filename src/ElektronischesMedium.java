import java.net.URL;

/**
 * Klasse ElektronischesMedium
 *
 * @author Shamil Gradov
 */
public class ElektronischesMedium extends Medium {

    private String url;

    /**
     * Konstruktor der Klasse ElektronischesMedium
     *
     * @param _titel
     * @param _url
     */
    public ElektronischesMedium(String _titel, String _url) {
        super(_titel);
        setURL(_url);
    }

    /**
     * Methode um zu prüfen ob die URL korrekt ist
     *
     * @param urlString
     * @return true wenn erfolgreich oder false wenn die URL nicht übereinstimmt
     */
    private static boolean checkURL(String urlString) {
        try {
            URL url = new URL(urlString);
            url.toURI();
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    public String getURL() {
        return url;
    }

    /**
     * Methode zum setzen der URL
     *
     * @param _url
     */
    public void setURL(String _url) {

        if (checkURL(_url)) {
            url = _url;
            System.out.println("gültige URL gesetzt");
        } else {
            System.out.println("ungültige url");
        }
    }

    /**
     * Methode um Parameter der Klasse ElektronischenMediums als Zeichenkette auszugeben
     *
     * @return Ausgabe der Repraesentation des ElektronischenMediums in Stringform
     */
    public String calculateRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getTitel());
        sb.append(": ");
        sb.append(url);
        return sb.toString();
    }
}
