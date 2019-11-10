import java.io.Serializable;
import java.util.*;

/**
 * @author Shamil Gradov
 */
public class Zettelkasten implements Iterable<Medium>, Serializable {

    private ArrayList<Medium> myZettelkasten = new ArrayList<Medium>();
    private boolean sortiert = false;

    //Hinzufuegen von Medien
    public void addMedium(Medium medium) {
        myZettelkasten.add(medium);
        sortiert = false;
    }

    //loeschen von Medien
    public void dropMedium(String parameter, boolean deleteall) throws DuplicateEntryException {
        ArrayList arList = findMedium(parameter);
        if (deleteall) {
            for (Medium m : myZettelkasten) {
                if (m.getTitel().contains(parameter)) {
                    myZettelkasten.remove(m);
                }
            }
            sortiert = false;
        } else {

            if (arList.size() > 1) {
                throw new DuplicateEntryException("duplicate Entries");
            } else {
                for (Medium m : myZettelkasten) {
                    if (m.getTitel().contains(parameter)) {
                        myZettelkasten.remove(m);
                        sortiert = false;
                        break;
                    }
                }
            }
        }
    }


    //nach einem Medium suchen
    public ArrayList<Medium> findMedium(String _titel) {
        ArrayList<Medium> generic = new ArrayList<Medium>();
        for (Medium medium : myZettelkasten) {
            if (medium.getTitel().contains(_titel)) {
                generic.add(medium);
            }
        }
        if (generic.size() == 0) {
            System.out.println("Keine Medien vorhanden");
            return null;
        }
        return generic;
    }

    public void sort(String parameter) {
        if (sortiert == true) {
            System.out.println("Ist bereits sortiert");
        } else {
            if (parameter.equals("A-Z")) {
                myZettelkasten.sort((a, z) -> a.getTitel().compareTo(z.getTitel()));
                sortiert = true;
            } else if (parameter.equals("Z-A")) {
                myZettelkasten.sort((a, z) -> z.getTitel().compareTo(a.getTitel()));
                sortiert = true;
            } else {
                System.out.println("Keine gültige Sortiermethode eingegeben. Zettelkasten wurde nicht sortiert");
            }
        }
    }

    @Override
    public Iterator<Medium> iterator() {
        return myZettelkasten.listIterator();
    }
}
