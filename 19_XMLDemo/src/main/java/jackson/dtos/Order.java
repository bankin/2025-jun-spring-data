package jackson.dtos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.math.BigDecimal;
import java.util.List;

@JacksonXmlRootElement(localName = "order")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Order {

    @JacksonXmlElementWrapper(localName = "products")
    @JacksonXmlProperty(localName = "item")
    private List<Product> items;

    @JacksonXmlProperty(localName = "amount")
    private int count;

    @JacksonXmlProperty(localName = "total", isAttribute = true)
    private BigDecimal totalPrice;

    public Order(List<Product> items, int count, BigDecimal totalPrice) {
        this.items = items;
        this.count = count;
        this.totalPrice = totalPrice;
    }
}
