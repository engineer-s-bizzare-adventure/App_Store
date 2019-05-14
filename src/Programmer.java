import java.util.ArrayList;
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
        System.out.println("------------------");
        System.out.println("|   Bem vindo!   |");
        System.out.println("------------------");
        System.out.println("Opções: ");

        System.out.println("1. Ver Aplicações");
        System.out.println("2. Adicionar uma nova aplicação");
        System.out.println("3. Remover uma aplicação");
        System.out.println("4. Ver reviews");
        System.out.println("5. Sair");

        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        switch(number){
            case 1:
                printApps(apps);
                break;
            case 2:
                addApp();
                break;

            case 3:
                System.out.println("Not done yet 3");
                break;

            case 4:
                System.out.println("Not done yet 4");
                break;

            case 5:
                System.exit(0);
                break;

            default:
                System.out.println("ERRO");
                break;
        }
        System.out.println("\n");
        System.out.println("------------------");
    }

    public void addApp(){
        Scanner appInfo = new Scanner(System.in);

        String appName;
        double price;

        System.out.println("Nome da sua aplicação: ");
        appName = appInfo.nextLine();
        System.out.println("Preço: ");
        price = appInfo.nextDouble();

        App createApp = new App(appName, price, name);

        apps.add(createApp);
    }

    public void printApps(ArrayList<App> apps){
        for(int i = 0; i < apps.size(); i++){
            System.out.println("--------------------------");
            System.out.println("|  As minhas aplicações  |");
            System.out.println("--------------------------");
            System.out.println("Nome: " + apps.get(i).getName());
            System.out.println("Preco: " + apps.get(i).getPrice());
            System.out.println("--------------------------");
        }
    }
}
