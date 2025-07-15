package jackson.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.math.BigDecimal;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Customer {

    @JacksonXmlProperty
    private String name;

    @JacksonXmlProperty
    private double totalSpent;

    public Customer() {}

    public Customer(String name, double totalSpent) {
        this.name = name;
        this.totalSpent = totalSpent;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", totalSpent=" + totalSpent +
                '}';
    }
}
