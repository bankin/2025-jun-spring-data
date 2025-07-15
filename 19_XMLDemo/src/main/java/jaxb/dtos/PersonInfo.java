package jaxb.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "person-info")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersonInfo {
    @XmlElement(name = "info")
    private Person person;

    @XmlElementWrapper(name = "order-list")
    @XmlElement(name = "order")
    private List<Order> orders;

    public PersonInfo() {}

    public PersonInfo(Person person, List<Order> orders) {
        this.person = person;
        this.orders = orders;
    }
}
