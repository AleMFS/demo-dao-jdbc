package modeldaoimpl;

import db.DB;
import db.DbException;
import model.entities.Department;
import modeldao.DepartmentDao;

import java.sql.*;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection conn;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Department department) {
        PreparedStatement st = null;

        try{
            st = conn.prepareStatement(
                    "INSERT INTO department "
                            +"(Name) "
                            +"VALUES "
                            +"(?)", Statement.RETURN_GENERATED_KEYS);
            st.setString(1,department.getName());
            int arrowsEffect = st.executeUpdate();
            if(arrowsEffect > 0){
                ResultSet rs = st.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    department.setId(id);
                }
                DB.closeResultSet(rs);
            }else{
                throw new DbException("Nenhuma linha modificada");
            }
        }
        catch (SQLException e){
            throw new DbException("Erro na linha do insert");
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void update(Department department) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement(
                    "SELECT * "
                    +"FROM department "
                    +"WHERE Id = ?");
            st.setInt(1,id);
            rs = st.executeQuery();

            if(rs.next()){
                Department dep = instantiateDepartment(rs);
                return dep;
            }
            return null;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public List<Department> findAll() {
        return null;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;
    }
}
