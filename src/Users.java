import java.util.ArrayList;
import java.util.Random;

import java.util.ArrayList;

public abstract class Users {
    protected String name;
    protected int age;
    protected int ID;
    protected int max,min;
    protected String username;
    protected String password;
    protected double money;

    protected ArrayList<Users> userReg;

    public Users(){

    }

    //Constructor that gathers user information
    public Users(String username, int age, String password,double money){
        this.username = username;
        this.age = age;
        this.ID = createRandomID();
        this.password = password;
        this.money = money;
    }

    //Constructor that takes username and password
    public Users(String username, String password){
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

    //Gets & Sets ---------------------------------------------------------------------

    public String getUsername(){
        return this.username;
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

    public ArrayList<Users> getUserReg(){
        return userReg;
    }

    //Abstract functions

    public abstract void getMenu();

    //Register

    public void addNewProgrammer(Programmers obj){
        userReg.add(obj);
    }

    public void addNewClient(Client obj){
        userReg.add(obj);
    }
}
