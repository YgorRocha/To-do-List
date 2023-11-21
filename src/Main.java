import Usuario.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static User userLogged = null;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //Criar uma arrayList que irá guardar meus usuarios
        ArrayList<User> users = new ArrayList();

        //Instanciar um método que lê dados
         scanner = new Scanner(System.in);
        boolean running = true;

        //Opções que o usuario tem
        while (running) {
            System.out.println("===Begging===");
            System.out.println("[1] Register");
            System.out.println("[2] Login");
            System.out.println("[3] Exit");
            System.out.println("Type your option: ");

            String opcao = scanner.nextLine();
            //Switch
            switch (opcao) {
                case "1": {
                    System.out.println("====REGISTER====");
                    System.out.println("Type your email: ");
                    String email =  scanner.nextLine();
                    System.out.println("Type your name: ");
                    String name = scanner.nextLine();
                    System.out.println("Type your password: ");
                    String password = scanner.nextLine();

                    User user = new User();
                    user.setEmail(email);
                    user.setName(name);
                    user.setPassword(password);

                    users.add(user);
                    System.out.println("User has been create successfully");
                    break;
                }
                case "2": {
                    System.out.println("===Loggin===");
                    System.out.print("Type your email: ");
                    String email = scanner.nextLine();
                    System.out.print("Type your password");
                    String password = scanner.nextLine();

                    boolean loginSucess = false;
                    for(User user : users){

                        String userEmail = user.getEmail();
                        String userPassword = user.getPassword();

                        boolean emailCheck = email.equals(userEmail);
                        boolean passwordCheck = password.equals(userPassword);

                        if(emailCheck && passwordCheck){
                            loginSucess = true;
                            userLogged = user;
                            break;
                        }

                    }
                    if(!loginSucess){
                        System.out.println("---> Incorrect");
                    }else {
                        System.out.println("---> You are logged in");
                        homePage();
                    }
                    break;
                }
                case "3": {
                    running = false;
                    System.out.println("Ending program");
                    break;
                }
                default: {
                    break;
                }
            }

        }

    }
    public static void homePage() {
        boolean running = true;

        //prox passos do usuario

        while (running) {
            System.out.println("===HOME PAGE===");
            System.out.println("[1] Show Tasks");
            System.out.println("[2] Show completed tasks");
            System.out.println("[3] Show uncompleted tasks");
            System.out.println("[4] Add tasks");
            System.out.println("[5] Remove tasks");
            System.out.println("[6] Finish tasks");
            System.out.println("[7] logout");
            System.out.print("[8] Type your option: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Número é 1");
                    break;
                case "2":
                    System.out.println("Número é 2");
                    break;
                case "3":
                    System.out.println("Número é 3");
                    break;
                case "4":
                     /*Arrays<Task> taskAdded = new ArrayList();*/

                    System.out.println("Número é 3");
                    break;
                case "5":
                    System.out.println("Número é 3");
                    break;
                case "6":
                    System.out.println("Número é 3");
                    break;
                case "7":
                    running = false;
                    System.out.println("logging out");
                    break;
                default:

                    break;
            }
        }
    }

}