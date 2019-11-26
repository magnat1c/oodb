package lab5;

import lab1.Customer;

import java.util.List;

public class Lab5Main {
    public static void main(String[] args) {
        Lab5Repository service = new Lab5Repository();
        service.saveDB(new Customer("fail","rsfg","4534534","fbdfgn@gmail.com"));
        service.saveDB(new Customer("jsdfsd","rdtytsfg","67567567","fbdfgn@gmail.com"));

        List<Customer> customerList = service.fromDB();
        for (int i=0;i<customerList.size();i++){
            System.out.println(customerList.get(i).toString());
        }
    }
}
