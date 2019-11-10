import java.io.*;
/**
 * @author Shamil Gradov
 */
public class BinaryPersistency implements Persistency {


    public static void save(Zettelkasten zk, String dateiname) {
        try {

            File file = new File(dateiname);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(zk);
                oos.flush();
                oos.close();

        }catch (IOException ioe){
            System.out.println("Datei konnte nicht erstellt werden");
        }

    }

    public static Zettelkasten load(String dateiname) {
        try{
            FileInputStream fis = new FileInputStream(dateiname);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Zettelkasten datei = (Zettelkasten) ois.readObject();
            return datei;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("File konnte nicht gefunden werden");
        }
        return null;
    }
}
