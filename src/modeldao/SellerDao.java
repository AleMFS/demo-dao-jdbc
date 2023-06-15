package modeldao;


import model.entities.Department;
import model.entities.Seller;

import java.util.List;

public interface SellerDao {
    void inset(Seller seller);
    void update(Seller seller);
    void deleteById(Integer id);
    Seller findById(Integer id);
    List<Seller> findAll();
    List<Seller> findByDepartment(Department department);
}
