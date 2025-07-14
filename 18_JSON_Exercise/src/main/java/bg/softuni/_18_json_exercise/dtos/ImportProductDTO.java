package bg.softuni._18_json_exercise.dtos;

public class ImportProductDTO {
    private String name;
    private double price;

    public ImportProductDTO() {}

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
