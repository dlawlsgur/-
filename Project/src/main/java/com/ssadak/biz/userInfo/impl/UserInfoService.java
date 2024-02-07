package com.ssadak.biz.userInfo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssadak.biz.userInfo.UserInfoVO;


@Service("service")
public class UserInfoService implements UserService {

	@Autowired
	private UserInfoDAO dao;
	@Override
	public void insertUser(UserInfoVO vo) {
		// TODO Auto-generated method stub
		dao.insertUser(vo);
	}

	@Override
	public void updatetUser(UserInfoVO vo) {
		// TODO Auto-generated method stub
		dao.updateUser(vo);
	}

	@Override
	public void deletetUser(UserInfoVO vo) {
		// TODO Auto-generated method stub
		dao.deleteUser(vo);
	}

	@Override
	public UserInfoVO infoUser(UserInfoVO vo) {
		// TODO Auto-generated method stub
		return dao.infoUser(vo);
	}
	@Override
	public UserInfoVO findId(UserInfoVO vo) {
		return dao.findId(vo);
	}
	@Override
	public UserInfoVO findPw(UserInfoVO vo) {
		return dao.findPw(vo);
	}
	public void addRef(UserInfoVO vo) {
		dao.addRef(vo);
	}
	public String serRef(UserInfoVO vo) {
		return dao.serRef(vo);
	}
	public void delRef(UserInfoVO vo) {
		dao.delRef(vo);
	}
	public List<UserInfoVO> zzimList(UserInfoVO vo){
		
		return dao.zzimList(vo);
	}
	public String getRef(String page) {
		
		return dao.getRef(page);
	}
	public void zzimdel(UserInfoVO vo) {
		
		
		 dao.delRef(vo);
	}
	
}
