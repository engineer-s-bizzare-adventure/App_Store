import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class AppStore {
    //Static porque este pertence à classe, e não ao objeto
    static ArrayList<User> users = new ArrayList<>();
    static String SaveList[] = new String[] {};
    // static final String filePath = "D:\\Allonan\\Universidade\\POO\\Project\\src\\save.txt";
    static final String filePath = "C:\\Users\\luisa\\Desktop\\app_store\\src\\save.txt";

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


        //Scanner for login
        Scanner login = new Scanner(System.in);
        Scanner register = new Scanner(System.in);

        //Boolean for menu loop
        boolean menu = true;
        String username;
        String password;

        //Checks if successfully logged in
        boolean loggedin_check = false;
        boolean goodLogin = false;

        while(menu) {

            //Scanner to use options
            Scanner in = new Scanner(System.in);
            int number = 0;

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
                                loggedin_check = true;
                                goodLogin = true;
                                while(loggedin_check){
                                    currentUser.getMenu();
                                    if(!currentUser.state()){
                                        loggedin_check = false;
                                        System.out.println("Logged out from: " + currentUser.getID());
                                    }
                                }
                                //End the loop since we have found the user
                                break;
                            }
                        } catch (NullPointerException ripUserLogin) {
                            System.out.println("Erro no login: " + ripUserLogin.getMessage());
                        }
                    }
                    if(!goodLogin){
                        System.out.println("Username ou Password incorreta. \nTente de novo. \n");
                    }
                    break;

                case 2:
                    System.out.println("Insira um username: ");
                    username = register.nextLine();

                    System.out.println("Insira uma password: ");
                    password = register.nextLine();

                    Scanner type = new Scanner(System.in);
                    System.out.println("Pressiona 1 para se registar como cliente ou 2 para programador");

                    int userType;

                    if(type.hasNextInt()) {
                        userType = type.nextInt();

                        if(userType == 1){
                            addNewClient(username,password);
                        }
                        if(userType == 2){
                            addNewProgrammer(username, password);
                        }
                        else{
                            System.out.println("Opção inválida");
                        }
                    }

                    else {
                        System.out.println("Introduza um numero valido");
                    }
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
                    System.out.println("Input not available \nTry again:");
                    in.next();
                    break;
            }
        }
        System.out.println("\n");
        System.out.println("------------------");
   }

    public static void addNewProgrammer(String username, String password){
         Programmer type = new Programmer(username, password);
        users.add(type);
    }
    public static void addNewClient(String username, String password){
        Client type = new Client(username, password);
        users.add(type);
    }


    public static void saveFile(String filePath) throws IOException {
        FileWriter fw = new FileWriter(filePath);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        for (int i = 0; i < users.size(); i++) {
            pw.println(users.get(i).saveInfo());
        }

        pw.close();
    }

    public static void loadFile(String filePath) throws IOException{
        boolean loaded = false;
        int counter = 0;
        ArrayList<String> Info = new ArrayList<>();
        //In case the file doesn't exist
        try {
            FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr);

            String linha;

            while((linha=br.readLine())!=null && !loaded) {
                linha = br.readLine();
                Info.add(linha);

                if (linha == null){
                    counter++;
                    if (counter == 2){
                        loaded = true;
                    }
                    //return loadInfo(Info);
                }

                else{
                    counter = 0;
                }

            }

            br.close();
        }

        catch (IOException e) {
            System.out.println("Erro ao abrir ficheiro:" + e );
        }


    }


}
