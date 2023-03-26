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

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	public Boolean saveEmployee(Employee e)
	{
		String Query = "insert into emp_tb values(?,?,?)";
		return template.execute(Query,new PreparedStatementCallback<Boolean>(){

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, e.getId());
				ps.setString(2,e.getName());
				ps.setString(3,e.getAddress());
				return ps.execute();
			}
			
		});
	}
	
	public List<Employee> getAllEmployees() {
		
		String sql = "select * from emp_tb";
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
	

}
