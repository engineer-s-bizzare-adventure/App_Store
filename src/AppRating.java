
public class AppRating {
    private int rating;
    private String comment;
    private String personName;



    protected AppRating(int rating, String comment, String personName){
        this.setRating(rating);
        this.setComment(comment);
        this.setPersonName(personName);
    }


    protected int getRating() {
        return rating;
    }

    protected void setRating(int rating) {
        this.rating = rating;
    }

    protected String getComment() {
        return comment;
    }

    protected void setComment(String comment) {
        this.comment = comment;
    }

    protected String getPersonName() {
        return personName;
    }

    protected void setPersonName(String personName) {
        this.personName = personName;
    }
}
