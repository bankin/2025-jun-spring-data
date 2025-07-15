package jaxb.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;

import java.math.BigDecimal;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
public class Order {

    @XmlElement(name = "order-id")
    private String orderId;

    @XmlElement
    private BigDecimal price;

    @XmlElement(name = "created-at")
    private LocalDate createdAt;

    public Order() {}

    public Order(String orderId, BigDecimal price, LocalDate createdAt) {
        this.orderId = orderId;
        this.price = price;
        this.createdAt = createdAt;
    }
}
