public abstract class Users {
    private String name;
    private int age;
    private int ID;
    private String username;
    private String password;

    public Users(){

    }

    //Constructor that gathers user information
    public Users(String name, int age, int ID){
        this.name = name;
        this.age = age;
        this.ID = ID;
    }

    //Constructor that takes username and password
    public Users(String username, String password){
        this.username = username;
        this.password = password;
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
