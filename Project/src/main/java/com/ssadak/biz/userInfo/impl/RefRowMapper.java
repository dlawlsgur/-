package com.ssadak.biz.userInfo.impl;

import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;


import com.ssadak.biz.userInfo.UserInfoVO;

public class RefRowMapper implements RowMapper<UserInfoVO> {
	
	public UserInfoVO mapRow(ResultSet rs, int rwNum) throws SQLException {
		
		UserInfoVO vo = new UserInfoVO();
		vo.setPagename(rs.getString("pagename"));
		vo.setId(rs.getString("id"));
		vo.setRef(rs.getString("ref"));
		
		
		
	    return vo;
		
	}

}
