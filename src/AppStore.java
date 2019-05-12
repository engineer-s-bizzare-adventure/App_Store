import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class AppStore {
    //Static porque este pertence à classe, e não ao objeto
    static ArrayList<User> users = new ArrayList<>();
    static final String filePath = "C:\\save.txt";

    public static void main(String[] args) throws IOException {

        userInterface();

    }
    /*

        Users user1 = new Users("João",123456);
        (adicionar a classe onde os Users ficam registados quando tiver feito)
        (adicionar o corpo quando estiver feito).addUsers(user1);
        System.out.println((classe onde fica guardada).toString());
    */

    private static void userInterface() throws IOException {
        System.out.println("------------------");
        System.out.println("|  AppStore ALP  |");
        System.out.println("------------------");
        System.out.println("Já tem conta? Faça login!");
        System.out.println("Não tem conta? Registe-se!");

        //Scanner to use options
        Scanner in = new Scanner(System.in);
        int number = 0;

        //Scanner for login
        Scanner login = new Scanner(System.in);
        Scanner register = new Scanner(System.in);
        //Boolean for menu loop
        boolean menu = true;
        String username;
        String password;

        while(menu) {
            System.out.println("Login: 1 | Sign up: 2 | Save: 3 | Load:4 | Exit: 5");

            //Scan input
            if(in.hasNextInt()) {

                number = in.nextInt();
            }


            switch(number) {
                case 1:
                    System.out.println("Username: ");
                    username = login.nextLine();
                    System.out.println("Password: ");
                    password = login.nextLine();

                    //Going through user array
                    for (int i = 0; i < users.size(); i++) {
                        try {
                            User currentUser = users.get(i);
                            //If username and password are the same..
                            if (currentUser.getUsername().equals(username) && currentUser.getPassword().equals(password)) {
                                System.out.println("Bemvindo");
                                currentUser.getMenu();

                                //End the loop since we have found the user
                                break;
                            }
                        } catch (NullPointerException ripUserLogin) {
                            System.out.println("Erro no login: " + ripUserLogin.getMessage());
                        }
                    }
                    System.out.println("Username ou Password incorreta. \nTente de novo. \n");
                    break;

                case 2:
                    System.out.println("Insira um username: ");
                    username = register.nextLine();

                    System.out.println("Insira uma password: ");
                    password = register.nextLine();

                    Client clientReg = new Client(username, password);

                    users.add(clientReg);
                    saveFile(filePath);
                    break;

                case 3:
                    System.out.println("Save:");
                    saveFile(filePath);
                    break;

                case 4:
                    System.out.println("Load:");
                    loadFile(filePath);
                    break;

                case 5:
                    System.out.println("Saindo..");
                    menu=false;
                    break;

                default:
                    System.out.println("Menu Error");
                    break;
            }
        }
        System.out.println("\n");
        System.out.println("------------------");
   }

    public static void saveFile(String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        for (int i = 0; i < users.size() ; i++) {

            pw.println(users.get(i).getID());
        }

        pw.close();
    }

    public static void loadFile(String filePath) throws IOException{

        //Caso o ficheiro não existir
        try {

            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String linha = br.readLine();
            int num = Integer.parseInt(linha);

            while (linha != null) {

                linha = br.readLine();
            }

            br.close();
        }

        catch (IOException e) {
            System.out.println("A message de erro foi:" + e );
        }


    }
}
