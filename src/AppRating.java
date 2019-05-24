import java.io.*;




public class AppRating {





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

        for (int i = 0; i < App.reviews.size(); i++) {
            pw.println(App.reviews.get(i).reviewInfo());
        }

        pw.close();
    }

    public static void addNewReview(App review) {

        App.reviews.add(review);
    }


    public  void deleteReview(int index){
        if ( index >=0 && index < App.reviews.size() ){
            App.reviews.remove(index);
            System.out.println("o seu comentario foi removido: ");
        }
        else {
            System.out.println("não foi possivel encontrar este comentario: ");
        }
    }

}
