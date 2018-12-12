import java.util.*;
public class Main {
    public static void main(String [] args){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code
        ArrayList<Project> ProjectList = new ArrayList<>();
        ArrayList<Project> PastProjects = new ArrayList<>();
        ArrayList<Collaborator> CollaboratorsList = new ArrayList<>();
        ArrayList<Collaborator> TeachersList = new ArrayList<>();
        ArrayList<Publication> AllPublications = new ArrayList<>();
        ArrayList<Orientations> AllOrientations = new ArrayList<>();
        Main_menu:
        while (true){
            System.out.println("type 0 to exit");
            System.out.println("type 1 to create a project");
            System.out.println("type 2 to manage projects");
            System.out.println("type 3 to add a collaborator");
            System.out.println("type 4 to go to lab orientations");
            System.out.println("type 5 to go to publications");
            System.out.println("type 6 to see lab academic production report");
            System.out.println("type 7 to go to project consult");

            int option = scan.nextInt();
            scan.nextLine();

            if(option == 0){
                break;
            }//exit program
            else if(option == 1){

                if(TeachersList.size() == 0){
                    System.out.println("there are no teachers to create projects");
                    continue Main_menu;
                }
                Create_project(ProjectList, TeachersList, CollaboratorsList);

            }//creates a project
            else if(option == 2){
                Manage_menu(ProjectList, CollaboratorsList, PastProjects);
            }//manage a project
            else if(option == 3){
                Add_collaborator(CollaboratorsList, TeachersList);
            }//add a collaborator to the lab
            else if(option == 4){
                while(true){
                    System.out.println("type 0 to go back");
                    System.out.println("type 1 to create a orientation");
                    System.out.println("type 2 to see all orientations");
                    int choice = scan.nextInt();
                    scan.nextLine();
                    if(choice == 0){
                        break;
                    }
                    else if(choice == 1){
                        Create_orientation(AllOrientations, TeachersList);
                    }
                    else if(choice == 2){
                        Show_all_orientations(AllOrientations);
                    }
                }
            }//go to orientations
            else if(option == 5){
                while(true){
                    System.out.println("type 0 to go back");
                    System.out.println("type 1 to create a publication");
                    System.out.println("type 2 to see all publications");
                    int choice = scan.nextInt();
                    scan.nextLine();
                    if(choice == 0){
                        continue Main_menu;
                    }//go back
                    else if(choice == 1){
                        Create_publication(CollaboratorsList, AllPublications, ProjectList);
                    }
                    else if(choice == 2){
                        See_publications(AllPublications);
                    }
                }
            }//go to publications
            else if(option == 6){
                Show_academic_report(CollaboratorsList, ProjectList, PastProjects, AllPublications, AllOrientations);
            }//go to report
            else if(option == 7){
                ArrayList<Project> AllProjects = new ArrayList<>();

                for(int i = 0; i < ProjectList.size(); i++){
                    AllProjects.add(ProjectList.get(i));
                }
                for(int i = 0; i < PastProjects.size(); i++){
                    AllProjects.add(PastProjects.get(i));
                }
                Project_selection(AllProjects);
            }//project consult
        }
    }
//--------------------------------- CREATE A PROJECT --------------------------
    public static void Create_project (ArrayList<Project> ProjectList, ArrayList<Collaborator> TeachersList, ArrayList<Collaborator> CollaboratorsList){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code
        System.out.println("first choose a teacher to manage the project:");
        for (int i = 0; i < TeachersList.size(); i++){
            System.out.println(i+". "+TeachersList.get(i).getName());
        }
        int option = scan.nextInt();
        scan.nextLine();

        Project new_project = new Project();
        new_project.getCollaboratorsList().add(TeachersList.get(option));
        TeachersList.get(option).getYourCurrentProjects().add(new_project);
        System.out.println("type the name of the project:");
        String name = scan.nextLine();
        new_project.setName(name);
        System.out.println(new_project.getCollaboratorsList().get(0).getName()+" will now be managing "+name);
        System.out.println("type the initial date of project as follow: '00/00/00':");
        String initial_date = scan.nextLine();
        new_project.setInitial_date(initial_date);
        System.out.println("type end date of project as follow '00/00/00':");
        String end_date = scan.nextLine();
        new_project.setEnd_date(end_date);
        System.out.println("type the name of the financial agency supporting this project:");
        String financial_agency = scan.nextLine();
        new_project.setFinancial_agency(financial_agency);
        System.out.println("type the budget of the project:");
        double budget = scan.nextDouble();
        scan.nextLine();
        new_project.setBudget(budget);
        System.out.println("type the goal of this project:");
        String goal = scan.nextLine();
        new_project.setGoal(goal);
        System.out.println("type the description of the project and type enter when ready:");
        String description = scan.nextLine();
        new_project.setDescription(description);
        String status = "On elaboration";
        new_project.setStatus(status);
        System.out.println("the project was registered with success!");
        ProjectList.add(new_project);
    }
//--------------------------------- ADD COLLABORATOR  --------------------------
    public static void Add_collaborator(ArrayList<Collaborator> CollaboratorsList, ArrayList<Collaborator> TeachersList){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code
        System.out.println("type the name of new collaborator:");
        String name = scan.nextLine();
        System.out.println("type the collaborator´s email:");
        String email = scan.nextLine();
        System.out.println("type 1 if the collaborator is a graduation student");
        System.out.println("type 2 if the collaborator is a masters degree student");
        System.out.println("type 3 if the collaborator is a PhD student");
        System.out.println("type 4 if the collaborator is a teacher");
        System.out.println("type 5 if the collaborator is a researcher");
        int option = scan.nextInt();
        scan.nextLine();
        String type = "new string";
        if(option == 1){
            type = "graduation";
        }
        else if(option == 2){
            type = "masters";
        }
        else if(option == 3){
            type = "phd";
        }
        else if(option == 4){
            type = "teacher";
        }
        else if(option == 5){
            type = "researcher";
        }

        Collaborator new_collaborator = new Collaborator(name, type, email);
        if(option == 4){
            TeachersList.add(new_collaborator);
        }
        CollaboratorsList.add(new_collaborator);
    }
//--------------------------------- MANAGE PROJECTS  ----------------------------
    public static void Manage_menu(ArrayList<Project> ProjectList, ArrayList<Collaborator> CollaboratorsList, ArrayList<Project> PastProjects){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code
        while(true){
            System.out.println("choose a project to manage");
            System.out.println("or type -1 to go back:");
            for (int i = 0; i < ProjectList.size(); i++){
                System.out.println(i+". "+ProjectList.get(i).getName());
            }
            int option = scan.nextInt();
            if(option == -1){
                return;
            }
            else if(option >= 0 && option < ProjectList.size()){
                if(ProjectList.get(option).getStatus().equals("On elaboration")){
                    Manage_project_in_elaboration(ProjectList.get(option), CollaboratorsList);
                }
                else if(ProjectList.get(option).getStatus().equals("Ongoing")){
                    Manage_ongoing_project(ProjectList.get(option), PastProjects, ProjectList);
                }

            }
        }
    }
//----------------------------------------- MANAGE ELABORATION ------------------------------------
    public static void Manage_project_in_elaboration(Project Yourproject, ArrayList<Collaborator> CollaboratorList){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code
        Manage_manage:
        while(true){
            System.out.println("Name: "+Yourproject.getName());
            System.out.println("Status: "+Yourproject.getStatus());
            System.out.println("Description: "+Yourproject.getDescription());
            System.out.println("Goal: "+Yourproject.getGoal());
            System.out.println("Initial date: "+Yourproject.getInitial_date());
            System.out.println("End date: "+Yourproject.getEnd_date());
            System.out.println("Financial agency: "+Yourproject.getFinancial_agency());
            System.out.println("Budget: "+Yourproject.getBudget());
            System.out.println("Collaborators:");
            for(int i = 0; i < Yourproject.getCollaboratorsList().size(); i++){
                System.out.println(Yourproject.getCollaboratorsList().get(i).getName());
            }
            System.out.println("type 0 to go back");
            System.out.println("type 1 to change Status to 'Ongoing'");
            System.out.println("type 2 to add/remove Collaborators");
            int option = scan.nextInt();
            scan.nextLine();
            if(option == 0){
                return;
            }//go back
            else if(option == 1){
                int flag = 0;
                for(int i = 0; i < Yourproject.getCollaboratorsList().size(); i++){
                    if(Yourproject.getCollaboratorsList().get(i).getType() .equals("graduation")){
                        for(int j = 0; j < Yourproject.getCollaboratorsList().get(i).getYourCurrentProjects().size(); j++){
                            if(Yourproject.getCollaboratorsList().get(i).getYourCurrentProjects().get(j).getStatus().equals("Ongoing")){
                                flag++;
                            }
                            if(flag == 2){
                                System.out.println(Yourproject.getCollaboratorsList().get(i).getName()+" is a graduation student and has 2 Ongoing projects");
                                System.out.println("remove him to complete action or wait for him to finish a ongoing project.");
                                System.out.println("type any key to continue");
                                String oloko = scan.nextLine();
                                continue Manage_manage;
                            }
                        }
                        flag = 0;
                    }
                }
                String status = "Ongoing";
                Yourproject.setStatus(status);
                System.out.println("this project is now in 'ongoing' status.");
                System.out.println("type any key to continue");
                String oloko = scan.nextLine();
                return;
            }//change to ongoing if everyone is available
            else if(option == 2){
                OLOKO:
                while(true){
                    System.out.println("type 0 to go back");
                    System.out.println("type 1 if you want to add a collaborator to this project");
                    System.out.println("type 2 if you want to remove a collaborator to this project:");
                    int choice = scan.nextInt();
                    scan.nextLine();
                    if(choice == 0){
                        continue Manage_manage;
                    }//go back
                    else if(choice == 1){
                        System.out.println("choose a collaborator from this lab to add to this project");
                        for(int p = 0; p < CollaboratorList.size(); p++){
                            System.out.println(p+". "+CollaboratorList.get(p).getName());
                        }
                        int index = scan.nextInt();
                        for (int h = 0; h < Yourproject.getCollaboratorsList().size(); h++){
                            if(CollaboratorList.get(index).getName().equals(Yourproject.getCollaboratorsList().get(h).getName())){
                                System.out.println("this collaborator is already on this project!");
                                continue OLOKO;
                            }
                        }
                        Yourproject.getCollaboratorsList().add(CollaboratorList.get(index));
                        CollaboratorList.get(index).getYourCurrentProjects().add(Yourproject);
                        System.out.println(CollaboratorList.get(index).getName()+" is now on this project!");
                    }//add collaborator
                    else if(choice == 2){
                        System.out.println("choose a collaborator to remove from project:");
                        int teachers = 0;
                        for(int i = 0; i < Yourproject.getCollaboratorsList().size(); i++){
                            System.out.println(i+". "+Yourproject.getCollaboratorsList().get(i).getName());
                            if(Yourproject.getCollaboratorsList().get(i).getType().equals("teacher")){
                                teachers++;
                            }
                        }
                        int choice2 = scan.nextInt();
                        if(Yourproject.getCollaboratorsList().get(choice2).getType().equals("teacher") && teachers == 1){
                            System.out.println("you cannot remove "+Yourproject.getCollaboratorsList().get(choice2).getName()+" because its the only teacher on this project");
                            System.out.println("type a number to continue:");
                            choice2 = scan.nextInt();
                        }
                        else{
                            System.out.println(Yourproject.getCollaboratorsList().get(choice2).getName()+" is now removed from this project");
                            Yourproject.getCollaboratorsList().get(choice2).getYourCurrentProjects().remove(Yourproject);
                            Yourproject.getCollaboratorsList().remove(choice2);
                            continue Manage_manage;
                        }
                    }//remove collaborator
                }
            }//add/remove
        }
    }
//----------------------------------------- MANAGE ONGOING ----------------------------------------
    public static void Manage_ongoing_project(Project Yourproject, ArrayList<Project> PastProjects, ArrayList<Project> ProjectList){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code

        while(true){
            System.out.println("Name: "+Yourproject.getName());
            System.out.println("Status: "+Yourproject.getStatus());
            System.out.println("Description: "+Yourproject.getDescription());
            System.out.println("Goal: "+Yourproject.getGoal());
            System.out.println("Initial date: "+Yourproject.getInitial_date());
            System.out.println("End date: "+Yourproject.getEnd_date());
            System.out.println("Financial agency: "+Yourproject.getFinancial_agency());
            System.out.println("Budget: "+Yourproject.getBudget());
            System.out.println("Collaborators:");
            for(int i = 0; i < Yourproject.getCollaboratorsList().size(); i++){
                System.out.println(Yourproject.getCollaboratorsList().get(i).getName());
            }
            System.out.println("type -1 to go back");
            System.out.println("type -2 to change status to 'Complete'");
            int option = scan.nextInt();
            scan.nextLine();
            if(option == -1){
                break;
            }
            else if(option == -2){
                if(Yourproject.getProjectsPublications().size() > 0){
                    String status = "Complete";
                    Yourproject.setStatus(status);
                    PastProjects.add(Yourproject);
                    ProjectList.remove(Yourproject);
                    for(int i = 0; i < Yourproject.getCollaboratorsList().size(); i++){
                        Yourproject.getCollaboratorsList().get(i).getYourCurrentProjects().remove(Yourproject);
                        Yourproject.getCollaboratorsList().get(i).getYourPastProjects().add(Yourproject);
                    }
                    System.out.println("this project is now complete!");
                }
                else{
                    System.out.println("this projects have no publications to be complete");
                    System.out.println("type any key to exit");
                    String key = scan.nextLine();
                }
            }

        }
    }
//----------------------------------------- CREATE ORIENTATION ------------------
    public static void Create_orientation(ArrayList<Orientations> AllOrientations, ArrayList<Collaborator> TeachersList){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code

        System.out.println("what teacher is giving this orientation?");
        for(int i = 0; i < TeachersList.size(); i++){
            System.out.println(i+". "+TeachersList.get(i).getName());
        }
        int option = scan.nextInt();
        scan.nextLine();
        Orientations new_orientation = new Orientations();
        new_orientation.setAutor(TeachersList.get(option));
        System.out.println("write your orientation");
        System.out.println("type 'DONE' when done.");
        String string;
        while(true){
            string = scan.nextLine();
            if(string .equals("DONE")){
                break;
            }
            new_orientation.getOrientation().add(string);
        }
        TeachersList.get(option).getYourOrientations().add(new_orientation);
        AllOrientations.add(new_orientation);
        System.out.println("your orientation is published in this laboratory.");

    }
//----------------------------------------- SEE ORIENTATIONS ----------------------
    public static void Show_all_orientations(ArrayList<Orientations> AllOrientations){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code

        if(AllOrientations.size() < 1){
            System.out.println("this lab has no orientations");
            return;
        }

        for(int i = 0; i < AllOrientations.size(); i++){
            System.out.println("--------------------");
            System.out.println(AllOrientations.get(i).getAutor().getName()+":");
            for(int j = 0; j < AllOrientations.get(i).getOrientation().size(); j++){
                System.out.println(AllOrientations.get(i).getOrientation().get(j));
            }
        }
        System.out.println("type any key to go back");
        String string = scan.nextLine();
    }
//----------------------------------------- CREATE PUBLICATION ------------------
    public static void Create_publication(ArrayList<Collaborator> CollaboratorsList, ArrayList<Publication> AllPublications, ArrayList<Project> Projectslist){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code

        Publication new_publication = new Publication();

        while(true){

            System.out.println("who´s writing this publication?");
            System.out.println("type -1 when done");
            for(int i = 0; i < CollaboratorsList.size(); i++){
                System.out.println(i+". "+CollaboratorsList.get(i).getName());
            }
            int option = scan.nextInt();
            scan.nextLine();
            if(option == -1){
                break;
            }
            new_publication.getAutors().add(CollaboratorsList.get(option));
            CollaboratorsList.get(option).getYourPublications().add(new_publication);

        }

        System.out.println("type the title of this publication:");
        String title = scan.nextLine();
        new_publication.setName(title);
        System.out.println("type the name of the conference of publication:");
        title = scan.nextLine();
        new_publication.setConference_name(title);
        System.out.println("type the year of publication (ex '2018'):");
        int year = scan.nextInt();
        new_publication.setYear(year);
        System.out.println("type 1 if this publication is associated with a project from this laboratory");
        System.out.println("type 0 if its not (*note that the project need to be 'ongoing'*)");
        int choice = scan.nextInt();
        scan.nextLine();
        int yes = 0;
        if(choice == 1){
            System.out.println("what project is your publication associated with?");
            System.out.println("or type -1 to dismiss project association");
            for(int i = 0; i < Projectslist.size(); i++){
                if(Projectslist.get(i).getStatus().equals("Ongoing")){
                    System.out.println(i+". "+Projectslist.get(i).getName());
                }
            }
            int choice2 = scan.nextInt();
            scan.nextLine();
            if(choice2 >= 0 && choice2 < Projectslist.size()){
                yes = 1;
                new_publication.setProject(yes);
                new_publication.setProjectAssociated(Projectslist.get(choice2));
                Projectslist.get(choice2).getProjectsPublications().add(new_publication);
            }

        }
        else{
            new_publication.setProject(yes);
        }
        System.out.println("write your publication and type 'DONE' when done:");
        String string;
        while(true){
            string = scan.nextLine();
            if(string .equals("DONE")){
                break;
            }
            new_publication.getPublication().add(string);
        }
        AllPublications.add(new_publication);
        System.out.println("your publication is done!");
        System.out.println("type any key to continue:");
        string = scan.nextLine();
    }
//----------------------------------------- SEE PUBLICATIONS -----------------------
    public static void See_publications(ArrayList<Publication> AllPublications){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code

        while(true){
            System.out.println("choose a publication to see");
            System.out.println("or type -1 to go back:");
            for (int i = 0; i < AllPublications.size(); i++){
                System.out.println(i+". "+AllPublications.get(i).getName()+" Year: "+AllPublications.get(i).getYear());
            }
            int option = scan.nextInt();
            scan.nextLine();

            if(option == -1){
                break;
            }
            else if(option >= 0 && option < AllPublications.size()){
                System.out.println(" - Publication title: "+AllPublications.get(option).getName());
                System.out.println(" - Authors: ");
                for(int i = 0; i < AllPublications.get(option).getAutors().size(); i++){
                    System.out.println(AllPublications.get(option).getAutors().get(i).getName());
                }
                System.out.println(" - published in "+AllPublications.get(option).getConference_name()+" conference");
                System.out.println(" - year: "+AllPublications.get(option).getYear());
                if(AllPublications.get(option).getProject() == 1){
                    System.out.println(" - Project: "+AllPublications.get(option).getProjectAssociated().getName());
                }
                for(int i = 0; i < AllPublications.get(option).getPublication().size(); i++){
                    System.out.println(AllPublications.get(option).getPublication().get(i));
                }
                System.out.println("---------------------------------");
                System.out.println("type any key to continue");
                String string = scan.nextLine();
            }
        }
    }
//----------------------------------------- ACADEMIC REPORT ------------------------
    public static void Show_academic_report(ArrayList<Collaborator> CollaboratorsList, ArrayList<Project> ProjectList, ArrayList<Project> PastProjects, ArrayList<Publication> AllPublications, ArrayList<Orientations> AllOrientations){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code

        System.out.println("-- LABORATORY ACADEMIC PRODUCTIVITY REPORT --");
        System.out.println("Number of Collaborators: "+CollaboratorsList.size());
        int elab = 0;
        for(int i = 0; i < ProjectList.size(); i++){
            if(ProjectList.get(i).getStatus().equals("On elaboration")){
                elab++;
            }
        }
        System.out.println("Number of Projects 'On elaboration': "+elab);
        int ongoing = 0;
        for (int i = 0; i < ProjectList.size(); i++){
            if(ProjectList.get(i).getStatus().equals("Ongoing")){
                ongoing++;
            }
        }
        System.out.println("Number of 'Ongoing' Projects: "+ongoing);
        System.out.println("Number of 'Complete' Projects: "+PastProjects.size());
        int total = PastProjects.size() + ProjectList.size();
        System.out.println("Number of Projects in total: "+total);
        System.out.println("Number of Orientations: "+AllOrientations.size());
        System.out.println("Number of Publications: "+AllPublications.size());
        System.out.println("type any key to continue..");
        String string = scan.nextLine();
    }
//----------------------------------------- PROJECT SELECTION -----------------------
    public static void Project_selection(ArrayList<Project> AllProjects){
        Scanner scan = new Scanner(System.in); // creates a object called scan to scan inputs along the code

        System.out.println("choose a project to consult:");
        for(int i = 0; i < AllProjects.size(); i++){
            System.out.println(i+". "+AllProjects.get(i).getName());
        }
        int option = scan.nextInt();
        scan.nextLine();
        Consult_by_project(AllProjects.get(option));
    }
//----------------------------------------- PROJECT CONSULT ------------------------
    public static void Consult_by_project(Project Yourproject){

        System.out.println("Name: "+Yourproject.getName());
        System.out.println("Status: "+Yourproject.getStatus());
        System.out.println("Description: "+Yourproject.getDescription());
        System.out.println("Goal: "+Yourproject.getGoal());
        System.out.println("Initial date: "+Yourproject.getInitial_date());
        System.out.println("End date: "+Yourproject.getEnd_date());
        System.out.println("Financial agency: "+Yourproject.getFinancial_agency());
        System.out.println("Budget: "+Yourproject.getBudget());
        System.out.println("Collaborators:");
        for(int i = 0; i < Yourproject.getCollaboratorsList().size(); i++){
            System.out.println(Yourproject.getCollaboratorsList().get(i).getName());
        }
        //Sort publications out of bounderies
        Sort_publications(Yourproject.getProjectsPublications());


    }
//--------------------------------------- SORT PUBLICATIONS ------------------------
    public static void Sort_publications(ArrayList<Publication> PublicationList){
        ArrayList<Publication> SortedPublications = new ArrayList<>();
        int GreaterIndex = 0;
        int year = PublicationList.get(0).getYear();
        int size = PublicationList.size();
       while(true){

           for (int i = 0; i < size; i++){
               if(PublicationList.get(i).getYear() > year){
                   GreaterIndex = i;
                   year = PublicationList.get(i).getYear();
               }
           }
           SortedPublications.add(PublicationList.get(GreaterIndex));
           PublicationList.remove(GreaterIndex);
           GreaterIndex = 0;
           if(size != 1){
               year = PublicationList.get(0).getYear();
           }
           size--;
           if(PublicationList.size() == 0){
               break;
           }
       }
       PublicationList = SortedPublications;

       See_publications(SortedPublications);

    }
}


















