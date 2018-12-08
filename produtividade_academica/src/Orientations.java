import java.util.ArrayList;

public class Orientations {

    private Collaborator autor;
    private ArrayList<String> orientation = new ArrayList<>();


    public Collaborator getAutor() {
        return autor;
    }

    public void setAutor(Collaborator autor) {
        this.autor = autor;
    }

    public ArrayList<String> getOrientation() {
        return orientation;
    }

    public void setOrientation(ArrayList<String> orientation) {
        this.orientation = orientation;
    }
}
