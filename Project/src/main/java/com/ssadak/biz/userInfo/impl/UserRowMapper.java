package com.ssadak.biz.userInfo.impl;

import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;


import com.ssadak.biz.userInfo.UserInfoVO;

public class UserRowMapper implements RowMapper<UserInfoVO> {
	
	public UserInfoVO mapRow(ResultSet rs, int rwNum) throws SQLException {
		
		UserInfoVO vo = new UserInfoVO();
		vo.setId(rs.getString("id"));
		vo.setPw(rs.getString("pw"));
		vo.setAge(rs.getString("age"));
		vo.setSex(rs.getString("sex"));
		vo.setEmail(rs.getString("email"));
		vo.setNickname(rs.getString("nickname"));
		vo.setPhone(rs.getString("phone"));
		
		
		
		
	    return vo;
		
	}

}
