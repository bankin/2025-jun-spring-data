package bg.softuni._21_qa_demo.records.inputData;

//public class OrderDTO {
//    String shippingInfo;
//    boolean isBillingInfoEnabled;
//    Optional<String> billingInfo;
//}


public sealed interface OrderDTO permits OrderDTOWithBilling, OrderDTOWithoutBilling {
}
