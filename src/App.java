import java.util.ArrayList;

public class App {
    private String name;
    private String programmerName;
    private double price;
    protected static String review;
    protected static int rating;
    protected double score;

    public App(String name, double price, String programmerName){
        this.name = name;
        this.price = price;
        this.programmerName = programmerName;
    }

    //Array que guarda os comentarios
    static ArrayList<App> reviews = new ArrayList<>();
    static final String reviewPath = "C:\\Users\\pedro\\Desktop\\app_store\\src\\reviews.txt";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getReview() {return review;}

    public void setReview(String review) {this.review = review;}

    public String reviewInfo(){
        String review = getReview() + "\n";
        return review;

    }

    public int getRating(){
        return rating;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

}
