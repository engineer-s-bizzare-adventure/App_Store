import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Programmer extends User {
    private ArrayList<App> apps;

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
        System.out.println("6. Actualizar pefil");
        System.out.println("7. Sair");

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
                printApps(getApps());
                pressAnyKey();
                break;
            case 2:
                addApp();
                pressAnyKey();
                break;

            case 3:
                removeApp();
                break;

            case 4:
                viewReviews();
                break;

            case 5:
                logged = false;
                break;

            case 6:
                Scanner nome = new Scanner(System.in);
                System.out.println("Insira o seu nome:");
                name = nome.nextLine();
                Scanner idade = new Scanner(System.in);
                System.out.println("Insira a sua idade:");
                if(in.hasNextInt()) {
                    age = idade.nextInt();
                }
                else{
                    System.out.println("Insira realmente uma idade!");
                }
                setName(name);
                setAge(age);
                break;

            case 7:
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

        //colocar na lista do programador
        getApps().add(createApp);
        //Colocar na lista geral para as apps
        AppStore.getTotalApps().add(createApp);
    }

    public void removeApp(){
        Scanner input = new Scanner(System.in);

        String appName;

        System.out.println("Nome da aplicação que deseja remover: ");
        appName = input.nextLine();

        if(getApps().size() == 0){
            System.out.println("You have no apps yet! \nCreate one :) \n");
        }
        else
            for(int i = 0; i < getApps().size(); i++){
                App currentApp = getApps().get(i);
                    if(currentApp.getName().equals(appName)){
                        //Remover da lista do programador
                        getApps().remove(i);
                        //Remover da lista geral
                        AppStore.getTotalApps().remove(i);
                    }
            }
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
            TotalAppsEarning();
        }
    }

    private void TotalAppsEarning(){
        double total=0;

        for(int i = 0; i < apps.size(); i++ ){
            total += apps.get(i).getPrice() ;
        }
        System.out.println("Obteve um valor de : " + total+"€ pelas suas aplicações");
    }

    public void viewReviews(){
        Scanner input = new Scanner(System.in);

        String appName;

        System.out.println("Nome da aplicação que deseja verificar os reviews: ");
        appName = input.nextLine();

        if(getApps().size() == 0){
            System.out.println("You have no apps yet! \nCreate one :) \n");
        }
        else
            for(int i = 0; i < getApps().size(); i++){
                App currentApp = getApps().get(i);
                if(currentApp.getName().equals(appName)){
                    currentApp.printReviews(App.getUserReviews());
                }
            }

    }


    public ArrayList<App> getApps() {
        return apps;
    }
}
