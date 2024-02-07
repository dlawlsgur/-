package com.ssadak.biz.userInfo.impl;

import java.util.List;

import com.ssadak.biz.userInfo.UserInfoVO;

public interface UserService {

	
	 void insertUser(UserInfoVO vo);
	 void updatetUser(UserInfoVO vo);
	 void deletetUser(UserInfoVO vo);
	 UserInfoVO infoUser(UserInfoVO vo);
	 UserInfoVO findId(UserInfoVO vo);
	 UserInfoVO findPw(UserInfoVO vo);
	 void addRef(UserInfoVO vo);
	 String serRef(UserInfoVO vo);
	 void delRef(UserInfoVO vo);
	 List<UserInfoVO> zzimList(UserInfoVO vo);
	 String getRef(String page);
	 void zzimdel(UserInfoVO vo);
	
	 
	
}
