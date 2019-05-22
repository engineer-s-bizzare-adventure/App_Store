import java.io.*;
import java.util.ArrayList;



public class AppRating {

    //Array que guarda os comentarios
    static ArrayList<App> reviews = new ArrayList<>();
    static final String reviewPath = "C:\\Users\\pedro\\Desktop\\app_store\\src\\reviews.txt";



    //System.out.println("A sua review:" + apps.get.geReview() ) ;

    /*
    public void CreateReview() {
        try{
            File myObj = new File("review.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch(IOException e)

        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

     */

    //código para guardar um ficheiro com os comentarios
    public static void saveReview(String reviewPath) throws IOException {
        FileWriter fw = new FileWriter(reviewPath);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        for (int i = 0; i < reviews.size(); i++) {
            pw.println(reviews.get(i).reviewInfo());
        }

        pw.close();
    }

    public static void addNewReview(App review) {

        reviews.add(review);
    }




}
