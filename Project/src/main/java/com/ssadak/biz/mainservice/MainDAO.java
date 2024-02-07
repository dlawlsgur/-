package com.ssadak.biz.mainservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ssadak.biz.chickenInfo.ChickenInfoVO;

@Repository
public class MainDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private String UPDATE = "update list set pagename=?,url=?,price=? where groupnum = ? and countnum = ?";
	private String LIST = "select * from list";
	
	public void update(ChickenInfoVO vo) {
		
		jdbcTemplate.update(UPDATE,vo.getMenu(),vo.getRef(),vo.getPrice(),vo.getGroup(),vo.getCount());
	}
	public List<ChickenInfoVO> getList(){
		return jdbcTemplate.query(LIST,new ListMapper());
	}
	
}
