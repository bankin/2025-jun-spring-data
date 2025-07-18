package bg.softuni._21_qa_demo.records;

import bg.softuni._21_qa_demo.records.inputData.OrderDTO;
import bg.softuni._21_qa_demo.records.inputData.OrderDTOWithBilling;
import bg.softuni._21_qa_demo.records.inputData.OrderDTOWithoutBilling;

public class Main {

    public static void main(String[] args) {
        System.out.println("Working...");

        BasicCar basicCar = new BasicCar(10, "Suzuki", "Swift", FuelType.PETROL);
    }

    public void createOrder(OrderDTO orderDTO) {

        String res = switch (orderDTO) {
            case OrderDTOWithBilling a -> "Created";
            case OrderDTOWithoutBilling bb -> "Not Created";
        };
    }
}
