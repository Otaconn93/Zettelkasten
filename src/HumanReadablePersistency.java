import java.io.*;
/**
 * @author Shamil Gradov
 */
public abstract class HumanReadablePersistency implements Persistency {

    public static void save(Zettelkasten zk, String dateiname) {
        try {
            File file = new File(dateiname+".txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            for(Medium m : zk){
                bw.write(m.calculateRepresentation()+System.lineSeparator());
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("File konnte nicht geschrieben werden");
        }
    }


    public static Zettelkasten load(String dateiname) throws NoSuchMethodException {
        throw new NoSuchMethodException("Methode nicht implementiert");
    }
}
