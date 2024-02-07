package com.ssadak.biz.review;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.ssadak.biz.reviewInfo.ReviewInfoVO;
import org.springframework.jdbc.core.RowMapper;
public class PostRowMapper implements RowMapper<ReviewInfoVO> {
	public ReviewInfoVO mapRow(ResultSet rs,int rwNum) throws SQLException{
		

		

		
		ReviewInfoVO vo = new ReviewInfoVO();
		vo.setPost(rs.getString("post"));
		vo.setNickname(rs.getString("nickname"));
		vo.setId(rs.getString("id"));
		vo.setwTime(rs.getString("wTime"));
		vo.setCountNum(rs.getInt("countNum"));
		vo.setNum(rs.getInt("Num"));
		
	
		
	
		
	
	return vo;
}
}
