package jaxb.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlElement(name = "firstName")
    private String name;

    @XmlElement
    private String country;

    @XmlAttribute
    private String city;

    public Person() {}

    public Person(String name, String country, String city) {
        this.name = name;
        this.country = country;
        this.city = city;
    }
}
