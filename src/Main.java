import Usuario.Task;
import Usuario.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static User userLogged = null;
    public static Scanner scanner =  new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList();

        scanner = new Scanner(System.in);
        Boolean running = true;
        while(running){

            System.out.println("=== START ===");
            System.out.println("[1] Register");
            System.out.println("[2] Login");
            System.out.println("[3] Exit");
            System.out.print("Type your option: ");
            String option = scanner.nextLine();
            // Switch
            switch (option) {
                case "1": {
                    System.out.print("Register your email: ");
                    String email = scanner.nextLine();
                    System.out.print("Register your password: ");
                    String password = scanner.nextLine();

                    User user = new User();
                    user.setEmail(email);
                    user.setPassword(password);

                    ArrayList<Task> tasks = new ArrayList();
                    user.setTask(tasks);
                    users.add(user);
                    System.out.println(" -----> User was created successfully");
                    break;
                }
                case "2": {

                    System.out.println("=== LOGIN AREA === ");

                    System.out.print("Type your email: ");
                    String email = scanner.nextLine();
                    System.out.print("Type your password: ");
                    String password = scanner.nextLine();


                    boolean loginSucess = false;
                    for(User user : users){
                        String emailLogin = user.getEmail();
                        String passwordLogin = user.getPassword();

                        boolean emailCheck = email.equals(emailLogin);
                        boolean passwordCheck = password.equals(passwordLogin);

                        if(emailCheck && passwordCheck){
                            loginSucess = true;
                            userLogged = user;
                            break;
                        }
                    }
                    if(!loginSucess){
                        System.out.println("Password or email do not match");

                    }else {
                        System.out.println("Log in successfully");
                        homePage();
                    }

                    break;
                }

                case "3":{
                    running = false;
                    break;
                }

                default:
                    System.out.println("Error in system");
                    break;
            }
        }
    }
    public static void homePage(){
        boolean running = true;
        while(running){
            System.out.println("===== HOME PAGE =====");
            System.out.println("[1] Show Tasks");
            System.out.println("[2] Show completed tasks");
            System.out.println("[3] Show uncompleted tasks");
            System.out.println("[4] Add tasks");
            System.out.println("[5] Finish tasks");
            System.out.println("[6] Remove tasks");
            System.out.println("[7] logout");

            System.out.print("[8] Type your option: ");
            System.out.print("Type your option: ");
            String option = scanner.nextLine();

            //SWITCH
            switch (option) {
                case "1": {
                    System.out.println("===== TASKS =====");

                    ArrayList<Task> list = userLogged.getTask();
                    if(list.isEmpty()){
                        System.out.println("-----> Your list is empty");
                    }else {
                        for (int i = 0; i < list.size(); i++) {
                            Task t = list.get(i);
                            System.out.println("Task: " + i);
                            System.out.println("\t Title: " + t.getTitle());
                            System.out.println("\t Finished: " + t.isFinish());
                        }
                    }
                    break;
                }

                case "2": {
                    ArrayList<Task> list = userLogged.getTask();
                    ArrayList<Task> completedTasks = new ArrayList();

                    for (Task t : list) {
                        if (t.isFinish()) {
                            completedTasks.add(t);
                        }
                    }
                    if (completedTasks.isEmpty()) {
                        System.out.println("There are no completed tasks");
                    } else {
                        for (int i = 0; i < completedTasks.size(); i++) {
                            Task t = completedTasks.get(i);

                            System.out.println("Task: " + i);
                            System.out.println("\t Title: " + t.getTitle());
                            System.out.println("\t Finished: " + t.isFinish());
                        }
                    }
                }
                    break;

                case "3": {
                        ArrayList<Task> list = userLogged.getTask();
                        ArrayList<Task> unCompletedTasks = new ArrayList();

                        for(Task t : list){
                           if(!t.isFinish()){
                               unCompletedTasks.add(t);
                           }
                        }
                        if (unCompletedTasks.isEmpty()){
                        System.out.println("All tasks was finished");
                        }else {
                            for (int i = 0; i < unCompletedTasks.size(); i++) {
                                Task t = unCompletedTasks.get(i);

                                System.out.println("Task: " + i);
                                System.out.println("\t Title: " + t.getTitle());
                                System.out.println("\t Finished: " + t.isFinish());
                            }
                        }
                        break;
                }
                case "4": {
                    Task task = new Task();
                    System.out.print("Type de title of the task you want to add: ");
                    String titleAdded = scanner.nextLine();

                    task.setTitle(titleAdded);
                    task.setFinish(false);

                    userLogged.getTask().add(task);
                    System.out.println("------> Added Task");
                    break;
                }
                case "5": {
                    ArrayList<Task> list = userLogged.getTask();
                    ArrayList<Task> notfinished = new ArrayList();

                    for(Task t : list){
                        if(!t.isFinish()){
                            notfinished.add(t);
                        }
                    }
                    if(notfinished.isEmpty()){
                        System.out.println("Theres no tasks open");
                        homePage();
                    }else {
                        for (int i = 0; i < notfinished.size(); i++) {
                            Task t = notfinished.get(i);
                            System.out.println("["+ i +"]" + t.getTitle());
                        }
                        System.out.print("Enter the number of the task you want to finish: ");
                        int posicao = scanner.nextInt();
                        scanner.nextLine();
                        Task finishedTasks = notfinished.get(posicao);
                        finishedTasks.setFinish(true);
                    }
                    break;
                }
                case "6": {
                    ArrayList<Task> list = userLogged.getTask();

                    if(list.isEmpty()){
                        System.out.println("Theres no tasks open");
                        homePage();
                    }
                    for (int i = 0; i < list.size(); i++) {
                        Task t = list.get(i);
                        System.out.println("["+ i +"]" + t.getTitle());
                    }
                    System.out.print("Enter the number of the task you want to remove: ");
                    int posicao = scanner.nextInt();
                    scanner.nextLine();

                    list.remove(posicao);
                    break;
                }
                case "7": {
                    running = false;
                    break;
                }
                default:
                    break;
            }
        }
    }
}