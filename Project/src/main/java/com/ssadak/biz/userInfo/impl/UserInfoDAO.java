package com.ssadak.biz.userInfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ssadak.biz.userInfo.UserInfoVO;

@Repository
public class UserInfoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private String USER_INSERT = "insert into user(id,pw,age,sex,phone,email,nickname) values(?,?,?,?,?,?,?)";
	private String USER_UPDATE = "update user set age=?,phone=?,nickname=? where id = ?";
	private String USER_DELETE = "delete user where id=?";
	private String USER_INFO = "SELECT * from user where id=? AND pw=?";
	private String USER_FIND_ID = "SELECT * from user where phone=? AND email=?";
	private String USER_FIND_PW = "SELECT * from user where id=?";
	private String SER = "SELECT * from user_ref where id=? and pagename = ? and ref = ?";
	private String REF = "insert into user_ref(pagename,id,ref) values(?,?,?)";
	private String DELREF = "DELETE FROM USER_REF WHERE PAGENAME = ?";
	private String ZZIMLIST = "select * from user_ref where id = ?";
	private String GET_REF = "select * from user_ref where pagename = ?";
	
	
	
	
	public void insertUser(UserInfoVO vo) {
		jdbcTemplate.update(USER_INSERT,vo.getId(),vo.getPw(),vo.getAge(),vo.getSex(),vo.getPhone(),vo.getEmail(),vo.getNickname());
	}
	public void updateUser(UserInfoVO vo) {
		jdbcTemplate.update(USER_UPDATE,vo.getAge(),vo.getPhone(),vo.getNickname(),vo.getId());
	}
	public void deleteUser(UserInfoVO vo) {
		jdbcTemplate.update(USER_DELETE,vo.getId());
	}
	public UserInfoVO infoUser(UserInfoVO vo) {
		
		try {
			return jdbcTemplate.queryForObject(USER_INFO, new Object[]{vo.getId(), vo.getPw()}, new UserRowMapper());
		}catch(EmptyResultDataAccessException e) {
			
			return null;
		}
	}
	public UserInfoVO findId(UserInfoVO vo) {
		try {
			return jdbcTemplate.queryForObject(USER_FIND_ID, new Object[]{vo.getPhone(), vo.getEmail()}, new UserRowMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	public UserInfoVO findPw(UserInfoVO vo) {
		try {
			return jdbcTemplate.queryForObject(USER_FIND_PW, new Object[]{vo.getId()}, new UserRowMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	public void addRef(UserInfoVO vo) {
		
		jdbcTemplate.update(REF,vo.getPagename(),vo.getId(),vo.getRef());
		
	
	}
	public String serRef(UserInfoVO vo) {
		try{
			return ""+jdbcTemplate.queryForObject(SER, new Object[]{vo.getId(),vo.getPagename(),vo.getRef()}, new RefRowMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	public void delRef(UserInfoVO vo) {
		jdbcTemplate.update(DELREF,vo.getPagename());
	
	}
	public List<UserInfoVO> zzimList(UserInfoVO vo){
		
		try {
			return jdbcTemplate.query(ZZIMLIST,new Object[]{vo.getId()},new RefRowMapper());
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	public String getRef(String page) {
		
		try {
			UserInfoVO vo = jdbcTemplate.queryForObject(GET_REF,new Object[] {page},new RefRowMapper());
		
			String ref = vo.getRef();
			return ref;
		}catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	
	
	

	
}

