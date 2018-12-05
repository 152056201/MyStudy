package cn.yh.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.yh.dao.IProviencesDAO;
/*import cn.yh.dbc.DatabaseConnection;*/
import cn.yh.vo.Provinces;

public class ProvicneDaoImpl implements IProviencesDAO{
	private Connection conn;
	private PreparedStatement ps;
	public ProvicneDaoImpl(Connection conn) {
		this.conn = conn;
	}
	@Override
	public List<Provinces> findAll() throws Exception {
		List<Provinces> list = new ArrayList<>();
		String sql = " select pid,title from provincial ";
		this.ps = this.conn.prepareStatement(sql);
		ResultSet rs = this.ps.executeQuery();
		while(rs.next()) {
			Provinces vo = new Provinces();
			vo.setPid(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			list.add(vo);
		}
		return list;
	}	
	/*public static void main(String[] args) {
		ProvicneDaoImpl pdi = new ProvicneDaoImpl(new DatabaseConnection().getConn());
		try {
			List<Provinces> list = pdi.findAll();
			for (Provinces provinces : list) {
				System.out.println("Ê¡ºÅ£º"+provinces.getPid()+",Ãû³Æ£º"+provinces.getTitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	
}
