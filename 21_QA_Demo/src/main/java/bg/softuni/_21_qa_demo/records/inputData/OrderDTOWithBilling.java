package bg.softuni._21_qa_demo.records.inputData;


public record OrderDTOWithBilling(String shipping, String billing) implements OrderDTO {
}

