package jaxb.dtos;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "addressBook")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressBook {

    @XmlElement(name = "address")
    List<Address> addressList;

    public AddressBook() {}

    @Override
    public String toString() {
        return "AddressBook{" +
                "addressList=" + addressList +
                '}';
    }
}
