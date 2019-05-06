import java.util.Scanner;

public class AppStore {
    public static void main(String[] args) {
        userInterface();
    }

    private static void userInterface(){
        System.out.println("------------------");
        System.out.println("|  AppStore ALP  |");
        System.out.println("------------------");
        System.out.println("Para fazer login, clique 1");
        System.out.println("Não tem conta? Registe-se! Clique 2");

        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        switch(number){
            case 1:
                System.out.println("Username: ");
                System.out.println("Password: ");
                break;
            case 2:
                System.out.println("Insira um username: ");
                System.out.println("Insira uma password: ");
                break;

            default:
                System.out.println("ERRO");
                break;
        }
        System.out.println("\n");
        System.out.println("------------------");
   }
}
