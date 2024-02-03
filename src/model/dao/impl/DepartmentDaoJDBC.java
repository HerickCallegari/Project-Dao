package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao{

	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		try {
	
			st = conn.prepareStatement("INSERT INTO department"
					+ " (Id, Name) VALUES (?, ?);");
			
			st.setInt(1, obj.getId());
			st.setString(2, obj.getName());
			
			st.execute();
			
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public void update(Department obj) {
	}

	@Override
	public void delete(Integer id) {
		PreparedStatement st = null;
		try {
				st = conn.prepareStatement("Delete from department "
						+ "where id = ?;");
				
				st.setInt(1, id);
				
				st.execute();
				
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Department findById(Integer id) {

		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement("select * from department where Id = ?");
			st.setInt(1, id);
			
			rs = st.executeQuery();
			
			if ( rs.next()) {
				Department dp = new Department();
				dp.setId(rs.getInt("Id"));
				dp.setName(rs.getString("Name"));
				return dp;
				
			}
		}catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeResultSet(rs);
			DB.closeStatement(st);
		}
		return null;
		
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
