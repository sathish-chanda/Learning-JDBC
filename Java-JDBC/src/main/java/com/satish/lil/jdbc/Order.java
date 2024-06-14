package com.satish.lil.jdbc;

import com.satish.lil.jdbc.util.DataTransferObject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order implements DataTransferObject {
    private long orderId;
    private Date creationDate;
    private BigDecimal totalDue;
    private String status;
    private CustomerInfo customerInfo;
    private SalepersonInfo salespersonInfo;
    private List<OrderItem> orderItems;

    public long getOrderId() {
        return orderId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public BigDecimal getTotalDue() {
        return totalDue;
    }

    public String getStatus() {
        return status;
    }

    public CustomerInfo getCustomerInfo() {
        return customerInfo;
    }

    public SalepersonInfo getSalespersonInfo() {
        return salespersonInfo;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setTotalDue(BigDecimal totalDue) {
        this.totalDue = totalDue;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomerInfo(CustomerInfo customerInfo) {
        this.customerInfo = customerInfo;
    }

    public void setSalespersonInfo(SalepersonInfo salespersonInfo) {
        this.salespersonInfo = salespersonInfo;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public long getId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", creationDate=" + creationDate +
                ", totalDue=" + totalDue +
                ", status='" + status + '\'' +
                ", customerInfo=" + customerInfo +
                ", salespersonInfo=" + salespersonInfo +
                ", orderItems=" + orderItems +
                '}';
    }
}

class CustomerInfo {
    private long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipcode;

    @Override
    public String toString() {
        return "CustomerInfo{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public long getCustomerId() {
        return customerId;
    }
}
class SalepersonInfo {
    private long salespersonId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipcode;

    public void setSalespersonId(long salespersonId) {
        this.salespersonId = salespersonId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "SalepersonInfo{" +
                "salespersonId=" + salespersonId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode='" + zipcode + '\'' +
                '}';
    }
}

class OrderItem {
    private long orderItemId;
    private long orderId;
    private Product product;
    private int quantity;

    public void setOrderItemId(long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", orderId=" + orderId +
                ", productId=" + product +
                ", quantity=" + quantity +
                '}';
    }
}

class Product {
    private long productId;
    private String code;
    private String name;
    private int size;
    private String variety;
    private BigDecimal price;
    private String status;

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", variety='" + variety + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
}