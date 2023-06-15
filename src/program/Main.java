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
        System.out.println("=== Teste 3 : seller findByDepartment");
         seller1 = sellerDao.findAll();

        for (Seller c : seller1){
            System.out.println(c);
        }

        System.out.println("=== teste 4 : seller Insert ===");
        Seller newSeller = new Seller(null,"Alexandre","Alexandre@gmail.com",new Date(),5000.00,department);
        sellerDao.insert(newSeller);
        System.out.println(newSeller.getId());

        System.out.println();
        System.out.println("=== Teste 5: seller update ====");
        seller = sellerDao.findById(1);
        seller.setName("Carla alves");
        sellerDao.update(seller);
        System.out.println();
        System.out.println("Update confirmado");
    }


}