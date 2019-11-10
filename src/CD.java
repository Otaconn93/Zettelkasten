/**
 * Klasse CD
 * @author Shamil Gradov
 */
public class CD extends Medium {

    private String label;
    private String Kuenstler;

    public String getLabel() {
        return label;
    }

    public void setLabel(String _label) {
        this.label = _label;
    }

    public String getKuenstler() {
        return Kuenstler;
    }

    private void setKuenstler(String kuenstler) {
        Kuenstler = kuenstler;
    }

    public CD(String _titel, String _label, String _kuenstler) {
        super(_titel);
        setLabel(_label);
        setKuenstler(_kuenstler);
    }
    /**
     * Methode um Parameter der Klasse CD als Zeichenkette auszugeben
     * @return Ausgabe der Repraesentation des Mediums CD in Stringform
     */
    public String calculateRepresentation() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getTitel());
        sb.append(" Label: ");
        sb.append(label);
        sb.append(" Künstler: ");
        sb.append(Kuenstler);
        return sb.toString();
    }
}
