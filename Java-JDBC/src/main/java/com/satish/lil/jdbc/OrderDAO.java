package com.satish.lil.jdbc;

import com.satish.lil.jdbc.util.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;

public class OrderDAO extends DataAccessObject<Order> {
    private final String COMPLEX_QUERY = "SELECT o.order_id, o.creation_date, o.total_due, o.status, c.customer_id, c.first_name, c.last_name, c.email, c.phone,c.address, c.city, c.state, c.zipcode, s.salesperson_id, s.first_name, s.last_name, s.email, s.phone, s.address, s.city, s.state, s.zipcode, oi.order_item_id, oi.order_id, oi.quantity, p.product_id, p.code, p.name, p.size, p.variety, p.price, p.status FROM orders o JOIN customer c ON o.customer_id = c.customer_id JOIN salesperson s ON s.salesperson_id = o.salesperson_id JOIN order_item oi ON oi.order_id = o.order_id JOIN product p ON p.product_id = oi.product_id WHERE o.order_id = ?";

    public OrderDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Order findById(long id) {
        Order order = null;
        try(PreparedStatement statement = this.connection.prepareStatement(COMPLEX_QUERY)) {
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            CustomerInfo customerInfo = null;
            SalepersonInfo salepersonInfo = null;
            List<OrderItem> orderItems = new ArrayList<>();
            while(resultSet.next()) {
                int index = 1;
                if(order == null) {
                    order = new Order();
                    order.setOrderId(resultSet.getLong(index++));
                    order.setCreationDate(new Date(resultSet.getDate(index++).getTime()));
                    order.setTotalDue(resultSet.getBigDecimal(index++));
                    order.setStatus(resultSet.getString(index++));
                } else {
                    index = 5;
                }
                if(customerInfo == null) {
                    customerInfo = new CustomerInfo();
                    customerInfo.setCustomerId(resultSet.getLong(index++));
                    customerInfo.setFirstName(resultSet.getString(index++));
                    customerInfo.setLastName(resultSet.getString(index++));
                    customerInfo.setEmail(resultSet.getString(index++));
                    customerInfo.setPhone(resultSet.getString(index++));
                    customerInfo.setAddress(resultSet.getString(index++));
                    customerInfo.setCity(resultSet.getString(index++));
                    customerInfo.setState(resultSet.getString(index++));
                    customerInfo.setZipcode(resultSet.getString(index++));
                } else {
                    index = 14;
                }
                if(salepersonInfo == null) {
                    salepersonInfo = new SalepersonInfo();
                    salepersonInfo.setSalespersonId(resultSet.getLong(index++));
                    salepersonInfo.setFirstName(resultSet.getString(index++));
                    salepersonInfo.setLastName(resultSet.getString(index++));
                    salepersonInfo.setEmail(resultSet.getString(index++));
                    salepersonInfo.setPhone(resultSet.getString(index++));
                    salepersonInfo.setAddress(resultSet.getString(index++));
                    salepersonInfo.setCity(resultSet.getString(index++));
                    salepersonInfo.setState(resultSet.getString(index++));
                    salepersonInfo.setZipcode(resultSet.getString(index++));
                } else {
                    index = 23;
                }
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderItemId(resultSet.getLong(index++));
                orderItem.setOrderId(resultSet.getLong(index++));
                orderItem.setQuantity(resultSet.getInt(index++));
                Product product = new Product();
                product.setProductId(resultSet.getLong(index++));
                product.setCode(resultSet.getString(index++));
                product.setName(resultSet.getString(index++));
                product.setSize(resultSet.getInt(index++));
                product.setVariety(resultSet.getString(index++));
                product.setPrice(resultSet.getBigDecimal(index++));
                product.setStatus(resultSet.getString(index));
                orderItem.setProduct(product);
                orderItems.add(orderItem);
            }
            if(order != null) {
                order.setOrderItems(orderItems);
                order.setCustomerInfo(customerInfo);
                order.setSalespersonInfo(salepersonInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        return List.of();
    }

    @Override
    public Order update(Order dto) {
        return null;
    }

    @Override
    public Order create(Order dto) {
        return null;
    }

    @Override
    public void delete(long id) {

    }
}
