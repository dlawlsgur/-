package com.ssadak.biz.review;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.ssadak.biz.reviewInfo.ReviewInfoVO;
import org.springframework.jdbc.core.RowMapper;

public class ReviewRowMapper implements RowMapper<ReviewInfoVO> {

	public ReviewInfoVO mapRow(ResultSet rs,int rwNum) throws SQLException{
		

		

		
			ReviewInfoVO vo = new ReviewInfoVO();
			vo.setTitle(rs.getString("title"));
			vo.setNickname(rs.getString("nickname"));
			vo.setId(rs.getString("id"));
			vo.setwTime(rs.getString("wTime"));
			vo.setWriting(rs.getString("writing"));
			vo.setCountNum(rs.getInt("countNum"));
			vo.setPagename(rs.getString("pagename"));
			vo.setRef(rs.getString("ref"));
			
		
			
		
			
		
		return vo;
	}
	
}
