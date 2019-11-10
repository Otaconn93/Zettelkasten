import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Zettelkasten implements Iterable<Medium> {

    private ArrayList<Medium> myZettelkasten = new ArrayList<Medium>();
    private boolean sortiert = false;
    private Scanner sc = new Scanner(System.in);

    public void addMedium(Medium medium){
        myZettelkasten.add(medium);
        sortiert = false;
    }
    public void dropMedium(String parameter){
        for (Medium m: myZettelkasten) {
            if(m.getTitel().contains(parameter)){
                myZettelkasten.remove(m);
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

    public void sort(){
        if(sortiert==true){
            System.out.println("Ist bereits sortiert");
        }else{
            //Wie sortier ich den bumms
            sortiert=true;
        }
    }

    @Override
    public Iterator<Medium> iterator() {
        return myZettelkasten.listIterator();
    }
}
