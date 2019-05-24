import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client extends User {
    ArrayList<App> ownedApps;

    //scanner que faz o input das reviews
    Scanner comment = new Scanner(System.in);
    Scanner rate = new Scanner(System.in);

    public Client(String name, int age, int money){
        super(name, age, money);

    }

    public Client(String username, String password){
        super(username, password);
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

    public void getMenu(){
        if(!logged){
            System.out.println("------------------");
            System.out.println("|   Bem vindo!   |");
            System.out.println("------------------");
        }
        System.out.println("User: " + this.username + " | ID: " + this.ID);
        System.out.println("Opções: ");

        System.out.println("1. Ver aplicações adquiridas");
        System.out.println("2. Comprar aplicação");
        System.out.println("3. Fazer um review");
        System.out.println("4. Remover um review");
        System.out.println("5. Ver fundos");
        System.out.println("6. Logout");
        System.out.println("7. Sair");

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
                System.out.println("Not done yet 1");
                break;
            case 2:
                System.out.println("Not done yet 2");
                break;

            case 3:
                System.out.print("Escreva o seu comentario: ");
                App.review = comment.nextLine();

                System.out.print("De 1 a 5 o quanto gosta da aplicação: ");
                App.rating = rate.nextInt();
                do {
                    System.out.print("introduza um valor entre 1 a 5 ");
                }
                    while (App.rating<1 || App.rating>5);

                AppRating.addNewReview(App.reviews);
                System.out.println("O seu comentário e score foi guardado");

                try {
                    AppRating.saveReview(App.reviewPath);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;



            case 4:
                System.out.println("Not done yet 4");
                break;
            case 5:
                System.out.println(money);
                break;
            case 6:
                logged = false;
                break;
            case 7:
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


