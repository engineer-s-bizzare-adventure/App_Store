public class App {
    private String name;
    private String programmerName;
    private double price;

    public App(String name, double price, String programmerName){
        this.name = name;
        this.price = price;
        this.programmerName = programmerName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
