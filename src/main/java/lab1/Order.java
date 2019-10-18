package lab1;

import java.util.Date;
import java.util.List;

//Заказ
class Order{
    Customer customers;
    private List<Worker> workers;
    Product products;
    Date date;
    private String OrderStatus;//когда берем продукт сл склада изменять его кол-во на складе и изменить здесть статус заказа

    public List<Worker> getWorkers() {
        return workers;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    void addWorker (Worker worker){
        if (!workers.contains(worker)) {
            workers.add(worker);
        }
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }

    public Customer getCustomers() {
        return customers;
    }

    public void setCustomers(Customer customers) {
        this.customers = customers;
    }
}
