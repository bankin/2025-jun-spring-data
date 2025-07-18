package bg.softuni._21_qa_demo.services;

import org.springframework.stereotype.Service;

@Service
public class OrdersService {

    // inputDTO
    public void createOrder() {
        // Request Customer -> customerRepository.findBy...(...);
        // Items in stock?
        // ...
        // order.setCustomer(customer)
        // Create order -> orderRepository.save(order);
        // ..
        // orders in customer are not auto updated!!!
        // if (customer.getOrders().size() > 10) { ... }
    }

    public void importData() {
        // Read data from file or
        // Pass file directly to parser

        // ImportDTO[]

        // validate

        // print err or persist + print success
    }
}
