package cn.yh.dao.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Mr.Y
 *
 * @param <K>
 * @param <V>
 */
public abstract class AbstractDAOImpl {
	protected Connection conn;
	public AbstractDAOImpl(Connection conn){
		this.conn = conn;
	}
	public boolean doRemoveHandle(Set<?> ids,String tableName,String IdName) throws Exception{
		if(ids.size()==0||ids==null){
			return false;
		}
		StringBuffer sql = new StringBuffer();
		sql.append(" delete from ").append(tableName).append(" where ").append(IdName).append(" in( " );
		Iterator<?> ite = ids.iterator();
		while(ite.hasNext()){
			sql.append(ite.next()).append(",");
		}
		sql.delete(sql.length()-1, sql.length()).append(")");
		PreparedStatement ps = this.conn.prepareStatement(sql.toString());
		return ps.executeUpdate()==ids.size();
	}
	/**
	 * ͨ
	 * @return
	 */
	//public abstract String getTableName();
	/**
	 *
	 * @return
	 */
	//public abstract String getIdName();
	public Integer AllCountHandle(String tableName,String column,String keyword) throws Exception{
		String sql = "select count(empno) from "+tableName+" where "+column+" like ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "%"+keyword+"%");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			return rs.getInt(1);
		}
		return 0;
	}
	
}
