package com.ssafy.myhome.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.myhome.model.dao.InterestAreaDao;
import com.ssafy.myhome.model.dto.DongCommercialArea;
import com.ssafy.myhome.model.dto.InterestArea;
import com.ssafy.myhome.model.dto.Label;
import com.ssafy.myhome.model.vo.StoreTypeValue;
import com.ssafy.myhome.util.DBUtil;

public class InterestAreaDaoImpl implements InterestAreaDao {
	
	private DBUtil dbUtil = DBUtil.getInstance();
	
	private static InterestAreaDaoImpl instance;
	
	public InterestAreaDaoImpl() {
		
	}
	
	public static InterestAreaDaoImpl getInstance() {
		if (instance == null) {
			instance = new InterestAreaDaoImpl();
		}
		return instance;
	}

	@Override
	public int insertUserInterestAreaMapping(String userId, String dongCode) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		String sql = "insert into user_interest_area_mapping(userid, dongcode, is_main)\r\n" 
				+ "values(?,?,?)\r\n";
		
		try {
			conn = dbUtil.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, dongCode);
			pstmt.setInt(3, 0);
			
			res = pstmt.executeUpdate();
			return res;
			
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public ArrayList<InterestArea> selectInterestAreas(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<InterestArea> interestAreaList = new ArrayList<>();
		
		String sql = "select a.dongcode, sidoName, gugunName, dongName, lat, lng, b.is_main\r\n"
				+ "from baseaddress a, (select *\r\n"
				+ "from user_interest_area_mapping\r\n"
				+ "where userid = ?) b\r\n"
				+ "where a.dongcode = b.dongCode\r\n"
				+ "order by is_main desc, dongcode asc";
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				interestAreaList.add(new InterestArea(rs.getString(1), rs.getString(2), rs.getString(3), 
						rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		return interestAreaList;
	}

	@Override
	public int updateUserInteresetAreaMapping(String userId, String dongCode) throws SQLException {
		
		setUserInterestAreaMappingZero(userId);
		
		System.out.println(dongCode);
		System.out.println(userId);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int res = 0;
		
		String sql = "update user_interest_area_mapping\r\n"
				+ "set is_main = 1\r\n"
				+ "where userid = ? and dongCode = ?";
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, dongCode);
			
			res = pstmt.executeUpdate();
			
			return res;
			
		} finally {
			dbUtil.close(pstmt, conn);
		}
		
	}
	
	public void setUserInterestAreaMappingZero(String userId) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update user_interest_area_mapping\r\n"
				+ "set is_main = 0\r\n"
				+ "where userid = ?";
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			pstmt.executeUpdate();
			
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public int deleteUserInterestAreaMapping(String userId, String dongCode) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		
		String sql = "delete from user_interest_area_mapping\r\n"
				+ "where userid = ? and dongCode =?";
		
		try {
			conn = dbUtil.getConnection();
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, dongCode);
			
			res = pstmt.executeUpdate();
			return res;
		} finally {
			dbUtil.close(pstmt, conn);
		}
	}

	@Override
	public DongCommercialArea getCommercialLabel(String dongCode) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		DongCommercialArea dongCA = null;
		
		String sql = "SELECT d.dongCode, d.dongName, "
							+ "d.convenience_store, d.education, d.cafe, d.restaurant, d.health, d.market, "
							+ "d.avg_diff_convenience_store, d.avg_diff_education, d.avg_diff_cafe, d.avg_diff_restaurant, d.avg_diff_health, d.avg_diff_market, "
							+ "t.total_avg_convenience_store, t.total_avg_education, t.total_avg_cafe, t.total_avg_restaurant, t.total_avg_health, t.total_avg_market, "
							+ "l.label_id, l.name "
					+ "FROM total_avg t, "
						+ "dong_commercial_area d LEFT OUTER JOIN label l ON d.label_id = l.label_id "
					+ "WHERE dongCode = ?;";
		
		try {
			conn = dbUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dongCode);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dongCA = new DongCommercialArea(
						rs.getString(1), rs.getString(2), 
						rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8),
						new StoreTypeValue(rs.getDouble(9), rs.getDouble(10), rs.getDouble(11), rs.getDouble(12), rs.getDouble(13), rs.getDouble(14)),
						new StoreTypeValue(rs.getDouble(15), rs.getDouble(16), rs.getDouble(17), rs.getDouble(18), rs.getDouble(19), rs.getDouble(20)),
						new Label(rs.getString(21), rs.getString(22)));
			}
		} finally {
			dbUtil.close(rs, pstmt, conn);
		}
		
		return dongCA;
		
	}

}
