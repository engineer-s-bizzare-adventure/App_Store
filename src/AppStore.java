import java.util.ArrayList;
import java.util.Scanner;

public class AppStore {
    //Static porque este pertence à classe, e não ao objeto
    static ArrayList<User> users = new ArrayList<User>();

    public static void main(String[] args) {
        while(true){
            userInterface();
        }
    }
    /*

        Users user1 = new Users("João",123456);
        (adicionar a classe onde os Users ficam registados quando tiver feito)
        (adicionar o corpo quando estiver feito).addUsers(user1);
        System.out.println((classe onde fica guardada).toString());
    */

    private static void userInterface(){
        System.out.println("------------------");
        System.out.println("|  AppStore ALP  |");
        System.out.println("------------------");
        System.out.println("Para fazer login, clique 1");
        System.out.println("Não tem conta? Registe-se! Clique 2");

        //Scanner to use options
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        //Scanner for login
        Scanner login = new Scanner(System.in);

        //Scanner for register
        Scanner register = new Scanner(System.in);

        String username;
        String password;

        switch(number){
            case 1:
                System.out.println("Username: ");
                username = login.nextLine();
                System.out.println("Password: ");
                password = login.nextLine();

                //Going through user array
                for(int i = 0; i < users.size(); i++){
                    User currentUser = users.get(i);
                    //If username and password are the same..
                    if(currentUser.getUsername().equals(username) &&
                        currentUser.getPassword().equals(password)){
                        currentUser.getMenu();

                        //End the loop since we have found the user
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Insira um username: ");
                username = register.nextLine();


                System.out.println("Insira uma password: ");
                password = register.nextLine();

                Client clientReg = new Client(username, password);

                users.add(clientReg);

                break;
            default:
                System.out.println("ERRO");
                break;
        }
        System.out.println("\n");
        System.out.println("------------------");
   }
}
