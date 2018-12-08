import java.util.ArrayList;

public class Publication {

    private ArrayList<Collaborator> Autors = new ArrayList<>();
    private String name;
    private String conference_name;
    private String year;
    private ArrayList<String> publication = new ArrayList<>();
    private int project;
    private Project ProjectAssociated;


    public ArrayList<String> getPublication() {
        return publication;
    }

    public void setPublication(ArrayList<String> publication) {
        this.publication = publication;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public ArrayList<Collaborator> getAutors() {
        return Autors;
    }

    public void setAutors(ArrayList<Collaborator> autors) {
        Autors = autors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getConference_name() {
        return conference_name;
    }

    public void setConference_name(String conference_name) {
        this.conference_name = conference_name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Project getProjectAssociated() {
        return ProjectAssociated;
    }

    public void setProjectAssociated(Project projectAssociated) {
        ProjectAssociated = projectAssociated;
    }
}
