package program;

import model.entities.Department;
import model.entities.Seller;
import modeldao.DaoFactory;
import modeldao.SellerDao;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Department obj = new Department(1,"books");
        Seller seller = new Seller(21,"bob","bob@gmail.com",new Date(),3000.00,obj);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(seller);
    }
}