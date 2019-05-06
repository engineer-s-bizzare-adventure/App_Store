public class Users {
    private String name;
    private int age;
    private int ID;

    public Users(String name, int age, int ID){
        this.name = name;
        this.age = age;
        this.ID = ID;
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

    public String toString(){
        String output="";
        output = "Nome: " + name + "\n";
        output += "Idade: " + age + "\n";
        output += "ID: " + ID + "\n";
        return output;
    }
}
