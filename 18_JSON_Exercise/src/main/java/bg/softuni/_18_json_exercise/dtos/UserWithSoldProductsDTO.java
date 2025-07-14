package bg.softuni._18_json_exercise.dtos;

import java.util.List;

public class UserWithSoldProductsDTO {
    private String firstName;
    private String lastName;
    private List<SoldProductDTO> soldProducts;

    public UserWithSoldProductsDTO() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<SoldProductDTO> getSoldProducts() {
        return soldProducts;
    }

    public void setSoldProducts(List<SoldProductDTO> soldProducts) {
        this.soldProducts = soldProducts;
    }
}
