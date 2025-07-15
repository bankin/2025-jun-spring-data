import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;

public class Main {

    @SneakyThrows
    public static void main(String[] args) {
        Person person = new Person("Pesho", "Gosohov", 74);
        System.out.println(person.getFirstName());
        System.out.println(person);

        Order order = new Order("#123231", "Somebody", 12.44);

        System.out.println(order.getCustomerName());
        System.out.println(order);

        Item tyre = new Item("Tyre", 10.3, true);
        System.out.println(tyre.name());
        System.out.println(tyre);

        Item.class.getDeclaredConstructor().newInstance();
    }
}
