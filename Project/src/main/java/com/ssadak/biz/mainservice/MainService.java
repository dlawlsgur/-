package com.ssadak.biz.mainservice;

import java.util.List;

import com.ssadak.biz.chickenInfo.ChickenInfoVO;

public interface MainService {

	void insertBest(ChickenInfoVO vo);
	List<ChickenInfoVO> getList();
	
}