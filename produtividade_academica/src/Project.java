import java.util.ArrayList;

public class Project {
    private String name;
    private String initial_date;
    private String end_date;
    private String financial_agency;
    private double budget;
    private String goal;
    private String description;
    private ArrayList<Collaborator> CollaboratorsList = new ArrayList<>();
    private ArrayList<Publication> ProjectsPublications = new ArrayList<>();
    private String status;

    public ArrayList<Publication> getProjectsPublications() {
        return ProjectsPublications;
    }

    public void setProjectsPublications(ArrayList<Publication> projectsPublications) {
        ProjectsPublications = projectsPublications;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInitial_date() {
        return initial_date;
    }

    public void setInitial_date(String initial_date) {
        this.initial_date = initial_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getFinancial_agency() {
        return financial_agency;
    }

    public void setFinancial_agency(String financial_agency) {
        this.financial_agency = financial_agency;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public ArrayList<Collaborator> getCollaboratorsList() {
        return CollaboratorsList;
    }

    public void setCollaboratorsList(ArrayList<Collaborator> collaboratorsList) {
        CollaboratorsList = collaboratorsList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
