import java.util.ArrayList;
import java.util.Random;

public abstract class User {
    private String name, username, password;
    private int age;
    private int ID;
    private int max,min;
    public User(){

    }

    //Constructor that gathers user information
    public User(String name, int age, int ID){
        this.name = name;
        this.age = age;
        this.ID = createRandomID();
    }

    //Constructor that takes username and password
    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public int createRandomID(){
        max = 99999;
        min = 10000;
        Random randomNumber = new Random();
        int randomID = randomNumber.nextInt((max - min) + 1) + min;

        //MISSING LOOP TO CHECK FOR EXISTING ID'S ON EXISTING USERS
        //LIST WITH REGISTERED USERS IS NEEDED FOR THIS

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

    public abstract void getMenu();

//    public String toString(){
//        String output="";
//        output = "Nome: " + name + "\n";
//        output += "Idade: " + age + "\n";
//        output += "ID: " + ID + "\n";
//        return output;
//    }
}
