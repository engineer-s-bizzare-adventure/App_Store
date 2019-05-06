import java.util.Scanner;

public class AppStore {

    public static void main(String[] args) {
        //Temporary
        Users[] AppStoreUsers = {new Programmers("Fred","12345"),
                                 new Programmers("Ricardo", "milos"),
                                 new Client("Bob", "1234")};

        userInterface(AppStoreUsers);
    }

    private static void userInterface(Users[]AppStoreUsers){
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

        switch(number){
            case 1:
                System.out.println("Username: ");
                String username = login.nextLine();
                System.out.println("Password: ");
                String password = login.nextLine();

                //Going through user array
                for(int i = 0; i < AppStoreUsers.length; i++){
                    //If username and password are the same..
                    if(AppStoreUsers[i].getUsername().equals(username) &&
                        AppStoreUsers[i].getPassword().equals(password)){
                        AppStoreUsers[i].getMenu();

                        //End the loop since we have found the user
                        break;
                    }
                }
                break;
            case 2:
                System.out.println("Insira um username: ");
                System.out.println("Insira uma password: ");
                break;

            default:
                System.out.println("ERRO");
                break;
        }
        System.out.println("\n");
        System.out.println("------------------");
   }
}
