import java.util.ArrayList;
import java.util.Random;

public abstract class User {
    protected String name, username, password;
    protected int age;
    protected int ID;
    protected String review;
    protected boolean subscribed;

    private int max,min;
    protected int randomID;
    protected boolean logged = false;





    //Constructor that takes username and password
    protected User(String username, String password){
        this.username = username;
        this.password = password;
        this.ID = createRandomID();
    }

    protected int createRandomID(){
        max = 999999;
        min = 100000;
        Random randomNumber = new Random();
        randomID = randomNumber.nextInt((max - min) + 1) + min;

        for (int i = 0; i < AppStore.users.size() ; i++) {
            if (randomID == AppStore.users.get(i).getID()){
                randomID = randomNumber.nextInt((max - min) + 1) + min;
                i=-1;
                System.out.println("Generating new ID");
            }
        }

        System.out.println("Unique ID for user created: " + randomID);
        return randomID;
    }


    //Gets & Sets

    protected String getUsername(){
        return username;
    }

    protected void setUsername(String username){
        this.username = username;
    }

    protected String getPassword(){
        return password;
    }

    protected void setPassword(String password){
        this.password = password;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected int getAge() {
        return age;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    protected int getID() {
        return ID;
    }

    protected void setID(int ID) {
        this.ID = ID;
    }

    protected String getReview() {return review;}

    public void setReview(String review) {this.review= review;}

    protected void setSubscribed(boolean state){
        this.subscribed = state;
    }

    protected boolean isSubscribed(){
        return subscribed;
    }
    protected String saveInfo(){
        String info = getUsername() + "\n" + getPassword() + "\n" + getID() + "\n" + getName() + "\n" + getAge() + "\n";
        return info;

    }

    protected String reviewInfo(){
        String review = getReview() + "\n";
        return review;

    }


    protected boolean state(){
        return logged;
    }

    protected void pressAnyKey(){
        System.out.println("Pressione uma tecla para continuar...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }


    protected abstract void printApps(ArrayList<App> apps);
    protected abstract void getMenu();

    public String toString(){
        String output="";
        if (name != null){
            output = "Nome: " + name + "\n";
        }
        else{
            output += "Nome: Não inserido\n";
        }
        if (age != 0){
            output += "Idade: " + age + "\n";
        }
        else{
            output += "Idade: Não inserida\n";
        }
        output += "ID: " + ID + "\n";
        return output; }
}
