import java.util.ArrayList;

public class Collaborator {
    private String name;
    private String type;
    private String email;
    private ArrayList<Project> YourCurrentProjects = new ArrayList<>();
    private ArrayList<Project> YourPastProjects = new ArrayList<>();
    private ArrayList<Publication> YourPublications = new ArrayList<>();
    private ArrayList<Orientations> YourOrientations = new ArrayList<>();

    public Collaborator(String name, String type, String email) {
        this.name = name;
        this.type = type;
        this.email = email;
    }

    public ArrayList<Orientations> getYourOrientations() {
        return YourOrientations;
    }

    public void setYourOrientations(ArrayList<Orientations> yourOrientations) {
        YourOrientations = yourOrientations;
    }

    public ArrayList<Publication> getYourPublications() {
        return YourPublications;
    }

    public void setYourPublications(ArrayList<Publication> yourPublications) {
        YourPublications = yourPublications;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Project> getYourCurrentProjects() {
        return YourCurrentProjects;
    }

    public void setYourCurrentProjects(ArrayList<Project> yourCurrentProjects) {
        YourCurrentProjects = yourCurrentProjects;
    }

    public ArrayList<Project> getYourPastProjects() {
        return YourPastProjects;
    }

    public void setYourPastProjects(ArrayList<Project> yourPastProjects) {
        YourPastProjects = yourPastProjects;
    }
}
