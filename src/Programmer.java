import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Programmer extends User {
    ArrayList<App> apps;

//    public Programmer(String name, int age/*, int money*/){
//        super(name, age,money);
//    }

    public Programmer(String username, String password){
        super(username, password);
        apps = new ArrayList<>();
    }

    public void getMenu(){
        if(!logged){
            System.out.println("------------------");
            System.out.println("|   Bem vindo!   |");
            System.out.println("------------------");
        }
        System.out.println("User: " + this.username + " | ID: " + this.ID);
        System.out.println("Opções: ");

        System.out.println("1. Ver Aplicações");
        System.out.println("2. Adicionar uma nova aplicação");
        System.out.println("3. Remover uma aplicação");
        System.out.println("4. Ver reviews");
        System.out.println("5. Logout");
        System.out.println("6. Sair");

        //Logged in
        logged = true;

        Scanner in = new Scanner(System.in);
        int number = 0;

        //Scan input
        if(in.hasNextInt()) {
            number = in.nextInt();
        }

        switch(number){
            case 1:
                printApps(apps);
                pressAnyKey();
                break;
            case 2:
                addApp();
                pressAnyKey();
                break;

            case 3:
                System.out.println("Not done yet 3");
                break;

            case 4:
                System.out.println("Not done yet 4");
                break;

            case 5:
                logged = false;
                break;

            case 6:
                System.exit(0);
                break;


            default:
                System.out.println("Opção Inválida! \nTente de novo:");
                break;
        }
        System.out.println("\n");
        System.out.println("------------------");
    }

    public void logOut(){
        logged = false;
    }

    public void addApp(){
        Scanner appInfo = new Scanner(System.in);

        String appName;
        double price;

        System.out.println("Nome da sua aplicação: ");
        appName = appInfo.nextLine();
        System.out.println("Preço: ");

        try {
            price = appInfo.nextDouble();
        } catch(InputMismatchException oof){
            System.out.println("Insert a valid number!");
            return;
        }

        App createApp = new App(appName, price, name);

        apps.add(createApp);
    }

    public void printApps(ArrayList<App> apps){
        if(apps.size() == 0){
            System.out.println("You have no apps yet! \nCreate one :) \n");
        }
        else{
            for(int i = 0; i < apps.size(); i++){
                if(i == 0){
                    System.out.println("--------------------------");
                    System.out.println("|  As minhas aplicações  |");
                    System.out.println("--------------------------");
                }
                System.out.println("--------------------------");
                System.out.println("Nome: " + apps.get(i).getName());
                System.out.println("Preco: " + apps.get(i).getPrice());
                System.out.println("--------------------------");
            }
        }
    }
}
