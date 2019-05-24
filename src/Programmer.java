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
        System.out.println("5. Vendas totais");
        System.out.println("6. Logout");
        System.out.println("7. Actualizar pefil");
        System.out.println("8. Sair");

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
                totalEarnings(apps);
                break;

            case 6:
                logged = false;
                break;

            case 7:
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

            case 8:
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
        //Se a lista de aplicações estiver vazia..
        if(apps.size() == 0){
            System.out.println("You have no apps yet! \nCreate one :) \n");
        }
        else{
            //percorrer o array de apps
            for(int i = 0; i < apps.size(); i++){
                if(i == 0){
                    //Para este "banner" aparecer logo
                    System.out.println("--------------------------");
                    System.out.println("|  As minhas aplicações  |");
                    System.out.println("--------------------------");
                }
                //Print das informações
                System.out.println("--------------------------");
                System.out.println("Nome: " + apps.get(i).getName());
                System.out.println("Preco: " + apps.get(i).getPrice());
                System.out.println("Vendas: " + apps.get(i).getCountSales());
                System.out.println("--------------------------");
            }
        }
    }

    public void viewReviews(){
        Scanner input = new Scanner(System.in);

        String appName;

        //Para comparar com o outro nome que iremos tirar como referencia
        System.out.println("Nome da aplicação que deseja verificar os reviews: ");
        appName = input.nextLine();

        //Se a lista de aplicações estiver vazia..
        if(getApps().size() == 0){
            System.out.println("You have no apps yet! \nCreate one :) \n");
        }
        else
            for(int i = 0; i < getApps().size(); i++){
                //Aplicação para comparação
                App currentApp = getApps().get(i);
                //Se estes tiverem o mesmo nome
                if(currentApp.getName().equals(appName)){
                    //print das avaliações
                    currentApp.printReviews(App.getUserReviews());
                }
            }

    }

    public void totalEarnings(ArrayList<App> apps){
        //variável para guardar a quantidade de vendas
        int sumSales = 0;
        //variável para guardar o total ganho pelas vendas
        double totalEarned = 0;

        //percorrer a lista de apps
        for(int i = 0; i < apps.size(); i++){
            //Cálculo da quantidade de vendas e o valot total
            sumSales += apps.get(i).getCountSales();
            totalEarned += ((apps.get(i).getCountSales()) * apps.get(i).getPrice());
        }
        //Print dos valores
        System.out.println("Quantidade de vendas: " + sumSales);
        System.out.println("Quantidade ganho: " + totalEarned);
    }


    public ArrayList<App> getApps() {
        return apps;
    }
}
