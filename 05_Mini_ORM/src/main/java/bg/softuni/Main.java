package bg.softuni;

import bg.softuni.entities.Order;
import bg.softuni.entities.User;
import bg.softuni.orm.EntityManager;
import bg.softuni.orm.MyConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws SQLException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        User user = new User("bankin", 20, LocalDate.now());
        Order order = new Order(20, LocalDate.now());

        MyConnector.createConnection("root", "12345", "mini_orm");
        Connection connection = MyConnector.getConnection();

        EntityManager<User> userEm = new EntityManager<>(connection);
        EntityManager<Order> orderEm = new EntityManager<>(connection);

//        userEm.persist(user);
//        orderEm.persist(order);

        User fromDb = userEm.findFirst(User.class, "id = 2");
//        User fromDb2 = userEm.findFirst(User.class);

//        System.out.println(fromDb2.getUsername()); // bankin

//        Order first = orderEm.findFirst(Order.class);

//        System.out.println(first.getOrderId());

//        Iterable<User> users = userEm.find(User.class);
//
//        users.forEach(u -> System.out.println(u.getUsername()));

        fromDb.setUsername("edited22");
        userEm.persist(fromDb);
    }
}