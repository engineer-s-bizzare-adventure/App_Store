import java.util.Scanner;

public class Client extends Users {
    private double money;

    public Client(String name, int age, int ID, double money){
        super(name, age, ID);
        this.money = money;
    }

    public void addMoney(){
            System.out.println("Insira o valor que deseja adicionar à sua conta: ");

            Scanner in = new Scanner(System.in);
            int value = in.nextInt();

            if(value > 0){
                money += value;
            }
    }

}


