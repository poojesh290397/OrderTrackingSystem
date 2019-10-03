package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dto.Order;
import com.ltil.utilities.ConnectionManager;

public class OrderDaoImpl implements OrderDao {
private Connection connection = ConnectionManager.getConnection();
private Statement stat = null;
private ResultSet rs= null;
private String sql2 = "select * from orders where id=?";
private PreparedStatement ps =  null;

	@Override
	public List<Order> getAllOrders() {
		Order o = null;
		List <Order> list1 = new ArrayList<>();
		try
		{
	    stat = connection.createStatement();
	   String sql = "select * from orders";
	   rs = stat.executeQuery(sql);
	   while (rs.next())
	   {
		  o=new Order(rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getInt(4));
		  list1.add(o);
		 System.out.println(rs.getDate(2));
		 System.out.println(o.getDor());
			   }
	   		}
		catch(SQLException sq)
		{
			sq.printStackTrace();
		}
		return list1;
	}

	@Override
	public Order getOrderById(int id) {
		Order o = null;
    try {
		ps = connection.prepareStatement(sql2);
    ps.setInt(1, id);
     rs = ps.executeQuery();
     while (rs.next())
     {
    	 
    	 o=new Order(rs.getInt(1),rs.getDate(2),rs.getInt(3),rs.getInt(4));
 		
    	 
     }
    
    }
    catch(SQLException sq)
    {
    	sq.printStackTrace();
    }
	return o;
	}

	@Override
	public Order addOrder(Order o) {
		String sql3 = "insert into orders values(?,?,?,?)";
		try {
		ps = connection.prepareStatement(sql3);
		int newid=getMaxOrderid()+1;
		ps.setInt(1,newid);
		ps.setDate(2, o.getDor());
		ps.setInt(3,o.getQty());
		ps.setInt(4, o.getProdid());
		
		
		int res = ps.executeUpdate();
		if(res==1)
		{
			connection.commit();
			return o;
		}
		}
		catch(SQLException sq)
		{
			sq.printStackTrace();;
		}
		
		return null;
	}

	@Override
	public Order delOrder(int id) {
		String sql4  = "delete orders where id = ?";
		try {
			ps = connection.prepareStatement(sql4);
			ps.setInt(1, id);
			
			
			int res = ps.executeUpdate();
			if(res==1)
			{
				connection.commit();
				return getOrderById(id); 
			}
			}
			catch(SQLException sq)
			{
				sq.printStackTrace();;
			}
			
			return null;
		}
		
	

	@Override
	public Order updOrder(Order o) {
	String sql5 =  "update orders "
			+ "set qty = ?,"
			+ "prodid = ?,"
			+ "dor = ?"
			+ " where id = ?";
	
	try {
		ps = connection.prepareStatement(sql5);
		
		ps.setInt(1,o.getQty());
		ps.setInt(2, o.getProdid());
		ps.setDate(3, o.getDor());
		ps.setInt(4,o.getId());

		
		int res = ps.executeUpdate();
		if(res==1)
		{
			connection.commit();
			return o;
		}
		}
		catch(SQLException sq)
		{
			sq.printStackTrace();;
		}
		
		return null;
	

	}

	@Override
	public int getMaxOrderid() {
	String sql6 = "select max(id) from orders";
   int maxcount=0;
	try
	{
		stat = connection.createStatement();
		rs = stat.executeQuery(sql6);
		while(rs.next())
		{
			
			 maxcount =  rs.getInt(1);
		}
		
	}
	catch(SQLException sq) {
		sq.printStackTrace();
	}
	return maxcount;
	}


	}
	


