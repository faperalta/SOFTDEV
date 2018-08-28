package apc.softdev.modernizedorderingsystem;

public class Order {

    String orderName;
    String orderQuantity;



    public Order(){

    }

    public Order(String orderName, String orderQuantity) {

        this.orderName = orderName;
        this.orderQuantity = orderQuantity;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getOrderQuantity() {
        return orderQuantity;
    }
}
