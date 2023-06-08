package modeldao;

import model.entities.Department;

import java.util.List;

public interface DepartmentDao {
    void inset(Department department);
    void update(Department department);
    void deleteById(Integer id);
    Department findById(Integer id);
    List<Department> findAll();
}