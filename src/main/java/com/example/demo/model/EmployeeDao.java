package com.example.demo.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;

public class EmployeeDao {
	
	JdbcTemplate template;
	String sql;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	//create
	public Boolean saveEmployee(Employee e)
	{
		sql = "insert into emp_tb values(?,?,?)";
		return template.execute(sql,new PreparedStatementCallback<Boolean>(){

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, e.getId());
				ps.setString(2,e.getAddress());
				ps.setString(3,e.getName());
				
				return ps.execute();
			}
			
		});
	}
	
	//readAll
	public List<Employee> getAllEmployees() {
		
		sql = "select * from emp_tb";
		return template.query(sql, new ResultSetExtractor<List<Employee>>() {

			@Override
			public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				List<Employee> list = new ArrayList<Employee>();
				
				while(rs.next()) {
					Employee e = new Employee();
					e.setId(rs.getInt(1));
					e.setName(rs.getString(3));
					e.setAddress(rs.getString(2));
					list.add(e);
				}
				return list;
			}
			
		});
		
	}
	
	
	//Update Name 
	public Boolean updateEmployeeName(int id, String Name) {
		
		sql= "UPDATE EMP_TB SET NAME = ? WHERE ID = ?";
		
		return template.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				
				ps.setString(1, Name);
				ps.setInt(2, id);
				return ps.execute();
			}
			
		});
		
	}
	
	
	//Update Address 
		public Boolean updateEmployeeAddress(int id, String Address) {
			
			sql= "UPDATE EMP_TB SET ADDRESS = ? WHERE ID = ?";
			
			return template.execute(sql, new PreparedStatementCallback<Boolean>() {

				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
					// TODO Auto-generated method stub
					
					ps.setString(1, Address);
					ps.setInt(2, id);
					return ps.execute();
				}
				
			});
			
		}
	
	
	
	
	//deleteById
	public Boolean deleteEmployeeDetails(Employee e) {
		
		sql = "delete from emp_tb where id=?";
		return template.execute(sql, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, e.getId());
				return ps.execute();
			}
		});
		
	}
	
	
	
	

}
