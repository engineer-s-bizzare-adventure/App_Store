import java.util.ArrayList;
import java.util.Random;

public abstract class User {
    protected String name, username, password;
    protected int age;
    protected int ID;
    protected String review;

    private int max,min;
    protected int randomID;
    public boolean logged = false;

    public User(){

    }

    //Constructor that gathers user information
    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    //Constructor that takes username and password
    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.ID = createRandomID();
    }

    public int createRandomID(){
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

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getReview() {return review;}

    public void setReview(String review) {this.review= review;}

    public String saveInfo(){
        String info = getUsername() + "\n" + getPassword() + "\n" + getID() + "\n" + getName() + "\n" + getAge() + "\n";
        return info;

    }

    public String reviewInfo(){
        String review = getReview() + "\n";
        return review;

    }


    public boolean state(){
        return logged;
    }

    public void pressAnyKey(){
        System.out.println("Pressione uma tecla para continuar...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }


    public abstract void printApps(ArrayList<App> apps);
    public abstract void getMenu();

//    public String toString(){
//        String output="";
//        output = "Nome: " + name + "\n";
//        output += "Idade: " + age + "\n";
//        output += "ID: " + ID + "\n";
//        return output;
//    }
}
