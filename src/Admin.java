import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {

    public Admin(String username, String password){
        this.username = username;
        this.password = password;
    }

    public void getMenu(){
        //Apresenta bem vindo na primera vez que entra
        if(!logged){
            System.out.println("------------------");
            System.out.println("|   Bem vindo!   |");
            System.out.println("------------------");
        }

        System.out.println("User: " + this.username + " | ID: " + this.ID);

        //Verificar se o têm nome ou idade
        if(this.name != null && this.age != 0){
            System.out.println("Name: " + this.name + " | Age: " + this.age);
        }
        System.out.println("\nOpções: ");
        System.out.println("1. Ver apps");
        System.out.println("2. Ver dinheiro ganho total");
        System.out.println("3. Ver utilizadores");
        System.out.println("4. Logout");
        System.out.println("5. Sair");

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
                printApps(AppStore.getTotalApps());
                break;
            case 2:
                calculateEarnings(AppStore.getTotalApps());
                break;
            case 3:
                printUsers(AppStore.users);
                break;
            case 4:
                logged = false;
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

    public void printApps(ArrayList<App> apps){
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

    public void printUsers(ArrayList<User> users){
        if(users.size() == 0){
            System.out.println("Não existem utilizadores de momento!");
        }
        else{
            for(int i = 0; i < users.size(); i++){
                if(i == 0){
                    System.out.println("--------------------------");
                    System.out.println("|      Utilizadores:      |");
                    System.out.println("--------------------------");
                }
                System.out.println("--------------------------");
                System.out.println("Username: " + users.get(i).getUsername());
                System.out.println("Nome: " + users.get(i).getName());
                System.out.println("Idade: " + users.get(i).getAge());
                System.out.println("--------------------------");
            }
        }
    }

    public void calculateEarnings(ArrayList<App> apps){
        int sumSales = 0;
        double totalEarned = 0;

        for(int i = 0; i < apps.size(); i++){
            sumSales += apps.get(i).getCountSales();
            totalEarned += ((apps.get(i).getCountSales()) * apps.get(i).getPrice());
        }
        System.out.println("Quantidade de vendas: " + sumSales);
        System.out.println("Quantidade ganho: " + totalEarned);
    }

}
