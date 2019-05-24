import java.util.ArrayList;

public class App {
    private String name;
    private String programmerName;
    private double price;
    private int countSales;
    private static ArrayList<AppRating> userReviews;


    protected App(String name, double price, String programmerName){
        this.name = name;
        this.price = price;
        this.programmerName = programmerName;
        userReviews = new ArrayList<>();
    }

    protected String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    protected String getProgrammerName(){return programmerName;}

    protected int getCountSales(){return countSales;}

    protected static ArrayList<AppRating> getUserReviews() {
        return userReviews;
    }

    protected void printReviews(ArrayList<AppRating> reviews){
        if(reviews.size() == 0){
            System.out.println("You have no apps yet! \nCreate one :) \n");
        }
        else{
            for(int i = 0; i < reviews.size(); i++){
                if(i == 0){
                    System.out.println("--------------------------");
                    System.out.println("|        REVIEWS         |");
                    System.out.println("--------------------------");
                }
                System.out.println("--------------------------");
                System.out.println("Nome: " + reviews.get(i).getPersonName());
                System.out.println("Classificação: " + reviews.get(i).getRating());
                System.out.println("Comentário: " + reviews.get(i).getComment());
                System.out.println("--------------------------");
            }
        }
    }

    protected int appSale(){
        return countSales++;
    }
}
