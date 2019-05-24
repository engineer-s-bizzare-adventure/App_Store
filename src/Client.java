import java.util.ArrayList;
import java.util.Scanner;

public class Client extends User {
    private double money;
    ArrayList<App> ownedApps;


    public Client(String username, String password, double money){
        super(username, password);
        this.money = money;
        ownedApps = new ArrayList<>();
    }

    public double addMoney(){
            System.out.println("Insira o valor que deseja adicionar à sua conta: ");

            Scanner in = new Scanner(System.in);
            int value = in.nextInt();

            if(value > 0){
                money += value;
            }
            return money;
    }

    public void buyApp(ArrayList<App> app){
        Scanner input = new Scanner(System.in);

        String appName;

        System.out.println("Nome da aplicação que deseja comprar: ");
        appName = input.nextLine();

        for(int i=0; i < app.size(); i++) {
            App selectedApp = app.get(i);
            if(selectedApp.getName().equals(appName)){
                //Remove o dinheiro
                money-= selectedApp.getPrice();
                //Adiciona a app à lista
                ownedApps.add(selectedApp);
            }
        }
    }

    public void printApps(ArrayList<App> apps){
        if(apps.size() == 0){
            System.out.println("You have no apps yet! \nBuy one :) \n");
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

    public void printTotalApps(ArrayList<App> apps){
        if(apps.size() == 0){
            System.out.println("Não existem aplicações de momento!");
        }
        else{
            for(int i = 0; i < apps.size(); i++){
                if(i == 0){
                    System.out.println("--------------------------");
                    System.out.println("|       Aplicações:      |");
                    System.out.println("--------------------------");
                }
                System.out.println("--------------------------");
                System.out.println("Nome: " + apps.get(i).getName());
                System.out.println("Preco: " + apps.get(i).getPrice());
                System.out.println("Programador: " + apps.get(i).getProgrammerName());
                System.out.println("--------------------------");
            }
        }
    }

    public void reviewApps(ArrayList<App> apps, ArrayList<AppRating> reviews){
        Scanner input = new Scanner(System.in);

        String appName;
        int rating;
        String comment;

        System.out.println("Introduza o nome da app que deseja avaliar: ");
        appName = input.nextLine();

        //Percorrer o arraylist
        for(int i = 0; i < apps.size(); i++){
            //App para comparar com o que o utilizador insere
            App currentApp = apps.get(i);
            //Se estes tiverem o mesmo nome(...)
            if(currentApp.getName().equals(appName)){
                Scanner secondInput = new Scanner(System.in);

                System.out.println("Avaliação 1-5: ");
                rating = input.nextInt();

                System.out.println("Comentário: ");
                comment = secondInput.nextLine();

                //Criação do objeto AppRating
                AppRating createReview = new AppRating(rating, comment, this.name);
                //Adicionar ao ArrayList de reviews dentro da classe app
                reviews.add(createReview);
            }
            else
                System.out.println("Erro!");
        }
    }

    public void getMenu(){
        if(!logged){
            System.out.println("------------------");
            System.out.println("|   Bem vindo!   |");
            System.out.println("------------------");
        }
        System.out.println("User: " + this.username + " | ID: " + this.ID);
        if(this.name != null && this.age != 0){
            System.out.println("Name: " + this.name + " | Age: " + this.age);
        }
        System.out.println("\nOpções: ");
        System.out.println("1. Ver apps");
        System.out.println("2. Ver aplicações adquiridas");
        System.out.println("3. Comprar aplicação");
        System.out.println("4. Fazer um review");
        System.out.println("5. Remover um review");
        System.out.println("6. Ver fundos");
        System.out.println("7. Adicionar fundos");
        System.out.println("8. Actualizar pefil");
        System.out.println("9. Logout");
        System.out.println("10. Sair");

        //Logged in
        logged = true;

        Scanner in = new Scanner(System.in);
        int number=0;

        //Scan input
        if(in.hasNextInt()) {
            number = in.nextInt();
        }

        switch(number){
            case 1:
                printTotalApps(AppStore.getTotalApps());
                break;
            case 2:
                printApps(ownedApps);
                break;
            case 3:
                buyApp(AppStore.getTotalApps());
                break;
            case 4:
                reviewApps(ownedApps, App.getUserReviews());
                break;
            case 5:
                System.out.println(money);
                break;
            case 6:
                logged = false;
                break;
            case 7:
                addMoney();
                break;
            case 8:
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
            case 9:
                logged = false;
                break;
            case 10:
                System.exit(0);
                break;
            default:
                System.out.println("ERRO");
                break;
        }
        System.out.println("\n");
        System.out.println("------------------");
    }

}


