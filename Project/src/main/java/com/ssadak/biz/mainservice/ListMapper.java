package com.ssadak.biz.mainservice;

import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;
import java.sql.SQLException;


import com.ssadak.biz.chickenInfo.ChickenInfoVO;

public class ListMapper implements RowMapper<ChickenInfoVO> {

public ChickenInfoVO mapRow(ResultSet rs, int rwNum) throws SQLException {
		
		ChickenInfoVO vo = new ChickenInfoVO();
		vo.setMenu(rs.getString("pagename"));
		vo.setPrice(rs.getString("price"));
		vo.setRef(rs.getString("url"));
		vo.setGroup(rs.getString("groupnum"));
		vo.setCount(rs.getString("countnum"));
		
		
		
		
	    return vo;
		
	}
}
