
/**
 * Abstrakte Klasse Medium
 * Veerbt das Feld Titel
 * @author Shamil Gradov
 */
public abstract class Medium {
    private String titel;

    //Getter und Setter Methoden für die abstrakte Klasse Medium

    public String getTitel() {
        return titel;
    }

    private void setTitel(String _titel) {
        titel = _titel;
    }

    /**
     * Konstruktor der abstrakten Klasse Medium
     *
     * @param _titel
     */
    public Medium(String _titel) {
        setTitel(_titel);
    }

    /**
     *  Methode zur Ausgabe des Titels der Klasse Medium
     * @return Ausgabe der Repraesentation des Mediums in Stringform
     */
    public String calculateRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append(titel);
        return sb.toString();

    }
}
