import java.util.Scanner;

public class Client extends Users {
    private double money;


    public Client(String username, int age , String password, double money){
        super(username, age,password);
        this.money = money;
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
        System.out.println("------------------");
        System.out.println("|   Bem vindo!   |");
        System.out.println("------------------");
        System.out.println("Opções: ");

        System.out.println("1. Ver aplicações adquiridas");
        System.out.println("2. Comprar aplicação");
        System.out.println("3. Fazer um review");
        System.out.println("4. Remover um review");
        System.out.println("5. Ver fundos");
        System.out.println("6. Sair");

        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        switch(number){
            case 1:
                System.out.println("Not done yet 1");
                break;
            case 2:
                System.out.println("Not done yet 2");
                break;

            case 3:
                System.out.println("Not done yet 3");
                break;

            case 4:
                System.out.println("Not done yet 4");
                break;

            case 5:
                System.out.println(money);
                break;

            case 6:
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


