package com.chinasofti.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chinasofti.dao.CustomerDao;
import com.chinasofti.domain.Bill;
import com.chinasofti.domain.Clothes;
import com.chinasofti.domain.Customer;
import com.chinasofti.domain.Season;
import com.chinasofti.util.DBUtil;

public class CustomerDaoImpl implements CustomerDao {//顾客dao层
	private  DBUtil db=new DBUtil();

	@Override
	public Customer selectByCtid(int ctid) throws SQLException {
		Customer customer = new Customer();
		String sql="select * from client where ctid="+ctid;
		ResultSet r = db.query(sql);
		if(r.next()){
			customer.setCtid(r.getInt("ctid"));
			customer.setCtpassword(r.getString("ctpassword"));
			customer.setCvip(r.getInt("cvip"));
			customer.setBalance(r.getDouble("balance"));
			customer.setFrozen(r.getInt("frozen"));
			customer.setCtname(r.getString("ctname"));
		}
		return customer;

	}
	
	@Override
	public Clothes selectByClid(int clid) throws SQLException{
		String sql="select * from clothes where clid="+clid;
		ResultSet r = db.query(sql);
		Clothes clothes = new Clothes();
		Season season = new Season();
		if(r.next()){
			clothes.setClid(r.getInt("clid"));
			clothes.setClname(r.getString("clname"));
			clothes.setPrice(r.getDouble("price"));
			clothes.setSeaid(r.getInt("seaid"));
		}
		String sql2="select * from season where seaid="+clothes.getSeaid();
		ResultSet r2 = db.query(sql2);
		if(r2.next()){
			season.setSeaid(r2.getInt("seaid"));
			season.setSeaname(r2.getString("seaname"));
			clothes.setSea(season);
		}
		return clothes;
	}

	@Override
	public boolean deleteByClid(int clid) throws SQLException{
		String sql="delete from bill where clid="+clid;
		int i = db.update(sql);
		return i>0;
	}

	@Override
	public List<Bill> selectAllBill() throws SQLException {
		List<Bill> list = new ArrayList<Bill>();
		String sql="select * from Bill";
		ResultSet r = db.query(sql);
		boolean c;
		while(c=r.next()){
			Bill bill = new Bill();
			Clothes clothes = new Clothes();
			Season season = new Season();
			if(c){
				bill.setBid(r.getInt("bid"));
				bill.setClid(r.getInt("clid"));
				bill.setBnum(r.getInt("bnum"));
				bill.setBsum(r.getDouble("bsum"));
				}
			String sql2="select * from clothes where clid="+bill.getClid();
			ResultSet r2 = db.query(sql2);
			if(r2.next()){
				clothes.setClid(r2.getInt("clid"));
				clothes.setClname(r2.getString("clname"));
				clothes.setPrice(r2.getDouble("price"));
				clothes.setSeaid(r2.getInt("seaid"));
				bill.setClo(clothes);
			}
			String sql3="select * from season where seaid="+clothes.getSeaid();
			ResultSet r3 = db.query(sql3);
			if(r3.next()){
				season.setSeaid(r3.getInt("seaid"));
				season.setSeaname(r3.getString("seaname"));
				clothes.setSea(season);
			}
			list.add(bill);
		}
		
		return list;
	}
	
	@Override
	public List<Clothes> selectAllClothes() throws SQLException {
		List<Clothes> list = new ArrayList<Clothes>();
		String sql="select * from clothes";
		ResultSet r = db.query(sql);
		boolean c;
		while(c=r.next()){
			Clothes clothes = new Clothes();
			Season season = new Season();
			if(c){
				clothes.setClid(r.getInt("clid"));
				clothes.setClname(r.getString("clname"));
				clothes.setPrice(r.getDouble("price"));
				clothes.setSeaid(r.getInt("seaid"));
			}
			String sql2="select * from season where seaid="+clothes.getSeaid();
			ResultSet r2 = db.query(sql2);
			if(r2.next()){
				season.setSeaid(r2.getInt("seaid"));
				season.setSeaname(r2.getString("seaname"));
				clothes.setSea(season);
			}
			list.add(clothes);
		}
		
		return list;
	}
	
	@Override
	public boolean addBill(int clid,int bnum) throws SQLException {
		Clothes clo = this.selectByClid(clid);
		double bsum=0;
		bsum=clo.getPrice()*bnum;
		String sql="insert into Bill(bid,clid,bnum,bsum) values(sq.nextval,?,?,?)";
		int i;
		i=this.db.update(sql,clid,bnum,bsum);
		
		return i>0;
	}
	
	@Override
	public boolean updateBill(int clid, int bnum) throws SQLException {
		String sql="update bill set bnum=?,bsum=? where clid=?";
		return db.update(sql, bnum,this.selectByClid(clid).getPrice()*bnum,clid)>0;
	}

	
	@Override
	public boolean updateCtpassword(String str,int ctid) throws SQLException {
 		String sql="update client set ctpassword=? where ctid=?";
		int i = db.update(sql, str,ctid);
		return i>0;
	}

	@Override
	public List<Clothes> selectLikeClname(String str) throws SQLException {
		List<Clothes> list = new ArrayList<Clothes>();
		String sql="select * from clothes where clname like ?";
		ResultSet r = db.query(sql, "%"+str+"%");
		boolean b;
		while(b=r.next()){
			Clothes clothes = new Clothes();
			Season season = new Season();
			if(b){
					clothes.setClid(r.getInt("clid"));
					clothes.setClname(r.getString("clname"));
					clothes.setPrice(r.getDouble("price"));
					clothes.setSeaid(r.getInt("seaid"));
			}
			String sql2="select * from season where seaid="+clothes.getSeaid();
			ResultSet r2 = db.query(sql2);
			if(r2.next()){
				season.setSeaid(r2.getInt("seaid"));
				season.setSeaname(r2.getString("seaname"));
				clothes.setSea(season);
			}
			list.add(clothes);
			
		}
		return list;
	}

}
