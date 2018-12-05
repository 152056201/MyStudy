package cn.yh.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.yh.dao.ICityDAO;
import cn.yh.dbc.DatabaseConnection;
import cn.yh.vo.City;

public class CityDaoImpl implements ICityDAO{
	private Connection conn;
	private PreparedStatement ps;
	public CityDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public List<City> findAllByPro(Integer pid) throws Exception {
		List<City> list = new ArrayList<City>();
		String sql = " select cid,city,pid from city where pid=? ";
		this.ps = this.conn.prepareStatement(sql);
		this.ps.setInt(1, pid);
		ResultSet rs = this.ps.executeQuery();
		while(rs.next()) {
			City vo = new City();
			vo.setCid(rs.getInt(1));
			vo.setCity(rs.getString(2));
			vo.setPid(rs.getInt(3));
			list.add(vo);
		}
		return list;
	}
	public static void main(String[] args) {
		CityDaoImpl cdi = new CityDaoImpl(new DatabaseConnection().getConn());
		List<City> list;
		try {
			list = cdi.findAllByPro(6);
			for (City city : list) {
				System.out.println("城市编号："+city.getCid()+",名称："+city.getCity()+"省号："+city.getPid());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
