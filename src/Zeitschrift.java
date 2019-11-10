/**
 * Klasse Zeitschrift
 * @author Shamil Gradov
 */
public class Zeitschrift extends Medium {

    private String issn;
    private int volume;
    private int nummer;
    /**
     * Methode zur Wiedergabe der ISSN
     * @return issn der Zeitschrift
     */
    public String getISSN() {
        return issn;
    }
    /**
     *  ISSN neuen Wert zuweisen
     * @param _issn neuer wert der issn
     */
    private void setISSN(String _issn) {
        issn = _issn;
    }

    public int getVolume() {
        return volume;
    }

    private void setVolume(int _volume) {
        volume = _volume;
    }

    public int getNummer() {
        return nummer;
    }

    private void setNummer(int _nummer) {
        nummer = _nummer;
    }
    /**
     * Konstruktor der Klasse Zeitschrift
     * @param _titel
     * @param _issn
     * @param _volume
     * @param _nummer
     */
    public Zeitschrift(String _titel, String _issn, int _volume, int _nummer) {
        super(_titel);
        setISSN(_issn);
        setVolume(_volume);
        setNummer(_nummer);
    }
    /**
     * Methode um Parameter der Klasse Zeitschrift als Zeichenkette auszugeben
     * @return Ausgabe der Repraesentation des Mediums Zeitschrift in Stringform
     */
    public String calculateRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getTitel());
        sb.append(" ISSN: ");
        sb.append(issn);
        sb.append(" Volume: ");
        sb.append(volume);
        sb.append(" Nummer: ");
        sb.append(nummer);
        return sb.toString();
    }
}
