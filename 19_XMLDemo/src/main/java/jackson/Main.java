package jackson;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import jackson.dtos.Customer;
import jackson.dtos.CustomerList;
import jackson.dtos.Order;
import jackson.dtos.Product;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

//        Product product = new Product("TV", "Sony");
//        Order order = new Order(List.of(product, product), 10, BigDecimal.TEN);
//        xmlMapper.writeValue(System.out, order);

        CustomerList list = xmlMapper.readValue(System.in, CustomerList.class);
        System.out.println();

//        Customer c = new Customer("Pesho", 100.22);
//        Customer c2 = new Customer("Gosho", 10033.22);
//        CustomerList customerList = new CustomerList(List.of(c, c2));
//
//        xmlMapper.writeValue(System.out, customerList);

    }
}
