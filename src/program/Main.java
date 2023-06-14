package program;

import model.entities.Department;
import model.entities.Seller;
import modeldao.DaoFactory;
import modeldao.SellerDao;

import java.util.Date;

public class Main {
    public static void main(String[] args) {


        SellerDao sellerDao = DaoFactory.createSellerDao();

        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
    }
}