import java.io.*;

public class BinaryPersistency implements Persistency {


    public static void save(Zettelkasten zk, String dateiname) {
        try {
            FileOutputStream fos = new FileOutputStream(dateiname+".ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(zk);
            oos.close();
            fos.close();
        }catch (IOException ioe){
            System.out.println("Datei konnte nicht erstellt werden");
        }

    }
    @Override
    public Zettelkasten load(String dateiname) {
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
