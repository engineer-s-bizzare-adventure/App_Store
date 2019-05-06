import java.util.Scanner;

public class Programmers extends Users {

    public Programmers(String name, int age, int ID){
        super(name, age, ID);
    }

    public Programmers(String username, String password){
        super(username, password);
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
