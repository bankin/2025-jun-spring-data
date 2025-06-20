package bg.softuni.orm;

import bg.softuni.orm.annotations.Column;
import bg.softuni.orm.annotations.Entity;
import bg.softuni.orm.annotations.Id;
import bg.softuni.orm.exceptions.ORMException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class EntityManager<E> implements DbContext<E> {
    private final Connection connection;

    public EntityManager(Connection connection) {
        this.connection = connection;
    }

    @Override
    public boolean persist(E entity) throws IllegalAccessException, SQLException {
        // TODO: Check if this is an @Entity class
        Field idField = getIdField(entity);
        int id = getIdFieldValue(entity, idField);

        if (id == 0) {
            return doInsert(entity);
        }

        return false;
//        return doUpdate(entity);
    }

    private boolean doInsert(E entity) throws SQLException {
        String insertTemplate = "INSERT INTO %s (%s) VALUES (%s)";

        String tableName = getTableName(entity.getClass());
        String columnNames = getColumnNamesWithoutId(entity);
        String values = getValuesWithoutId(entity);

        String sql = String.format(insertTemplate, tableName, columnNames, values);

        return this.connection.prepareStatement(sql).executeUpdate() > 0;
    }

    private String getValuesWithoutId(E entity) { // orderId - 5, amount - 20, createdAt - 2025-02-04..
        return Arrays.stream(entity
            .getClass()
            .getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class)) // [orderId, amount, createdAt]
                .filter(field -> !field.isAnnotationPresent(Id.class)) // [amount, createdAt]
                .map(field -> { // [20, 2025-02-04..]
                    try {
                        field.setAccessible(true);
                        return field.get(entity);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .map(Object::toString) // ["20", "2025-02-04.."]
                .map(s -> "'" + s + "'")
                .collect(Collectors.joining(",")); // "20", "2025-02-04.."
    }

    // TODO: Add default if name in @Column is missing
    private String getColumnNamesWithoutId(E entity) { // orderId, amount, createdAt
        return Arrays.stream(entity
            .getClass()
            .getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(Column.class)) // [orderId, amount, createdAt]
                .filter(field -> !field.isAnnotationPresent(Id.class)) // [amount, createdAt]
                .map(field -> field.getAnnotation(Column.class).name()) // [amount, created_at]
                .collect(Collectors.joining(",")); // amount, created_at
    }

    private String getTableName(Class<?> clazz) {
        Entity annotation = clazz
                .getAnnotation(Entity.class);

        if (annotation == null) {
            throw new ORMException("Entities must have @Entity annotation");
        }

        return annotation.name();
    }

    private int getIdFieldValue(E entity, Field idField) throws IllegalAccessException {
        idField.setAccessible(true);
        Object value = idField.get(entity);

        return Integer.parseInt(value.toString());
    }

    private Field getIdField(E entity) {
        Optional<Field> idField = Arrays.stream(entity
                        .getClass() // User | Order
                        .getDeclaredFields()) // id, username, age, registration | orderId, amount, createdAt
                .filter(field -> field.isAnnotationPresent(Id.class))
                .findFirst();

        if (idField.isEmpty()) {
            throw new ORMException("Entity without @Id field");
        }

        return idField.get();
    }

    @Override
    public Iterable<E> find(Class<E> clazz) {
        return find(clazz, null);
    }

    @Override
    public Iterable<E> find(Class<E> clazz, String where) {
        return null;
    }

    @Override
    public E findFirst(Class<E> clazz) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return findFirst(clazz, null);
    }

    @Override
    public E findFirst(Class<E> clazz, String where) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String selectQuery = "SELECT * FROM %s %s LIMIT 1";
        String tableName = getTableName(clazz);

        String computedWhere = where == null ? "" : "WHERE " + where;

        String sql = String.format(selectQuery, tableName, computedWhere);

        ResultSet result = connection.prepareStatement(sql).executeQuery();

        boolean hasElement = result.next();

        if (!hasElement) {
            return null;
        }

         return fillEntity(result, clazz);
    }

    private E fillEntity(ResultSet result, Class<E> clazz) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // Create new object
        E resultEntity = clazz.getConstructor().newInstance();

        Arrays.stream(clazz.getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Column.class))
                .forEach(f -> {
                    try {
                        fillField(resultEntity, result, f);
                    } catch (SQLException | IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                });

        return resultEntity;
    }

    private void fillField(E entity, ResultSet result, Field field) throws SQLException, IllegalAccessException {
        String columnName = field.getAnnotation(Column.class).name(); // "order_id"

        String dbValue = result.getString(columnName);
        Object value = getValueWithCorrectType(field.getType(), dbValue);

        field.setAccessible(true);
        field.set(entity, value);
    }

    private Object getValueWithCorrectType(Class<?> type, String dbValue) {
        if (type == int.class || type == Integer.class) {
            return Integer.parseInt(dbValue);
        } else if (type == double.class || type == Double.class) {
            return Double.parseDouble(dbValue);
        } else if (type == String.class) {
            return dbValue;
        } else if (type == LocalDate.class) {
            return LocalDate.parse(dbValue);
        }

        throw new ORMException("Unsupported data type " + type);
    }
}
