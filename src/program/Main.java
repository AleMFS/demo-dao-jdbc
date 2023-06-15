package program;

import model.entities.Department;
import model.entities.Seller;
import modeldao.DaoFactory;
import modeldao.SellerDao;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== Teste 1 : seller findById ===");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== Teste 2 : seller findByDepartment");
        Department department = new Department(2,null);
        List<Seller> seller1 = sellerDao.findByDepartment(department);

        for (Seller c : seller1){
            System.out.println(c);
        }
    }
}