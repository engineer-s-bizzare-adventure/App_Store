import java.io.File;
import java.io.IOException;


public class AppRating {



    //System.out.println("A sua review:" + apps.get.geReview() ) ;

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



}
