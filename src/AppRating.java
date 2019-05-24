
public class AppRating {
    private int rating;
    private String comment;
    private String personName;

    public AppRating(){
        setRating(0);
        setComment("");
        setPersonName("");
    }

    public AppRating(int rating, String comment, String personName){
        this.setRating(rating);
        this.setComment(comment);
        this.setPersonName(personName);
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
