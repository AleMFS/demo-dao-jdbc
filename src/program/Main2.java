package program;

import model.entities.Department;
import model.entities.Seller;
import modeldao.DaoFactory;
import modeldao.DepartmentDao;
import modeldao.SellerDao;

import java.util.Date;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {


        DepartmentDao departmentDao =  DaoFactory.createDepartmentDao();

        System.out.println("=== Teste 1 : seller findById ===");
        Department department = departmentDao.findById(3);
        System.out.println(department);

        Department department1 = new Department(null,"Gamer");
        departmentDao.insert(department1);

        department = departmentDao.findById(5);
        department.setName("Jogos");
        departmentDao.update(department);
        System.out.println("foi modificado para :"+ department.getName());

    }


}