package bg.softuni._21_qa_demo.records;

import java.util.Objects;

public record BasicCar(int id, String make, String model, FuelType fuelType) {
    double getRunDistance() {
        return 10.9;
    }
}

final class CarC {
    private int id;
    private String make;
    private String model;
    private FuelType fuelType;

    public CarC(int id, String make, String model, FuelType fuelType) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.fuelType = fuelType;
    }

    public int getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarC carC = (CarC) o;
        return id == carC.id && Objects.equals(make, carC.make) && Objects.equals(model, carC.model) && fuelType == carC.fuelType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, make, model, fuelType);
    }

    @Override
    public String toString() {
        return "CarC{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", fuelType=" + fuelType +
                '}';
    }
}