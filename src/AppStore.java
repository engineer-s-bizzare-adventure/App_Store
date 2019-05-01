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

        if(number == 1){
            System.out.println("Username: ");
            //Função para verificar se tal username existe
            System.out.println("Palavra passe: ");
            //Ver se o password coincide
        }
        else if(number == 2){
            System.out.println("Insira um username: ");
            //Função para guardar username
            System.out.println("Insira uma palavra passe");
            //Função para guardar password
        }
        else{
            System.out.println("ERRO");
        }

        System.out.println("------------------");
    }
}
