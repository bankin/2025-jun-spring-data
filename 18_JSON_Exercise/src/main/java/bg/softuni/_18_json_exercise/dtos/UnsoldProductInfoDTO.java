package bg.softuni._18_json_exercise.dtos;

import bg.softuni._18_json_exercise.entities.Product;

public class UnsoldProductInfoDTO {
    private String name;
    private double price;
    private String seller;

    public UnsoldProductInfoDTO() {}

    public UnsoldProductInfoDTO(Product product) {
        this.name = product.getName();
        this.price = product.getPrice().doubleValue();

        if (product.getSeller().getFirstName() != null) {
            this.seller = product.getSeller().getFirstName() + " " + product.getSeller().getLastName();
        } else {
            this.seller = product.getSeller().getLastName();
        }
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

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
