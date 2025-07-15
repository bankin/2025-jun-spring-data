package jaxb;

import jaxb.dtos.AddressBook;
import jaxb.dtos.Order;
import jaxb.dtos.Person;
import jaxb.dtos.PersonInfo;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JAXBException {
//        writeXML();

        readXML();
    }

    private static void readXML() throws JAXBException {
        JAXBContext addressContext = JAXBContext.newInstance(AddressBook.class);
        Unmarshaller unmarshaller = addressContext.createUnmarshaller();

        AddressBook parsed = (AddressBook) unmarshaller.unmarshal(System.in);

        System.out.println(parsed);
    }

    private static void writeXML() throws JAXBException {
        Person person = new Person("Pesho", "BG", "Varna");

        JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
        Marshaller personMarshaller = jaxbContext.createMarshaller();
        personMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        personMarshaller.marshal(person, System.out);

        JAXBContext infoJaxbContext = JAXBContext.newInstance(PersonInfo.class);
        Marshaller infoMarshaller = infoJaxbContext.createMarshaller();
        infoMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        Order order = new Order("123", BigDecimal.TEN, LocalDate.now());
        Order order2 = new Order("33", BigDecimal.ONE, LocalDate.now());

        PersonInfo info = new PersonInfo(person, List.of(order, order2));
        infoMarshaller.marshal(info, System.out);
    }
}
