package program;

import model.entities.Department;
import model.entities.Seller;
import modeldao.DaoFactory;
import modeldao.SellerDao;

import java.util.Date;

public class Main {
    public static void main(String[] args) {


        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Teste 1 : seller findById ===");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);
    }
}