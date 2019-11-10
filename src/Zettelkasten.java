import java.util.*;

public class Zettelkasten implements Iterable<Medium> {

    private ArrayList<Medium> myZettelkasten = new ArrayList<Medium>();
    private boolean sortiert = false;

    public void addMedium(Medium medium){
        myZettelkasten.add(medium);
        sortiert = false;
    }
    public void dropMedium(String parameter){
        for (Medium m: myZettelkasten) {
            if(m.getTitel().contains(parameter)){
                myZettelkasten.remove(m);
                sortiert=false;
                break;
            }
        }
    }
    public Medium findMedium(String _titel){
        for(Medium medium : myZettelkasten){
            if(medium.getTitel().contains(_titel)){
                return medium;
            }
        }
        return null;
    }

    public void sort(String parameter){
        if(sortiert==true){
            System.out.println("Ist bereits sortiert");
        }else{
            if(parameter.equals("A-Z")) {
                Collections.sort(myZettelkasten, (a, z) -> a.getTitel().compareTo(z.getTitel()));
                sortiert=true;
            }else if(parameter.equals("Z-A")) {
                Collections.sort(myZettelkasten, (a,z) -> z.getTitel().compareTo(a.getTitel()));
                sortiert = true;
            }else{
                System.out.println("Keine gültige Sortiermethode eingegeben. Zettelkasten wurde nicht sortiert");
            }
        }
    }

    @Override
    public Iterator<Medium> iterator() {
        return myZettelkasten.listIterator();
    }
}
