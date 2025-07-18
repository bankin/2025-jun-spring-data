package bg.softuni._21_qa_demo.records.car;

public interface Car {
    String make();
    String model();
}

record Suzuki(String model) implements Car {
    @Override
    public String make() {
        return "Suzuki";
    }
}
