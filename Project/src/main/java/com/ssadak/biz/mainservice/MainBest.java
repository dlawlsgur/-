package com.ssadak.biz.mainservice;

import java.util.List;

import com.ssadak.biz.chickenInfo.ChickenInfoVO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssadak.biz.chickenInfo.ChickenInfoVO;
@Service("mainService")
public class MainBest implements MainService {

	@Autowired
	private MainDAO dao;
	@Override
	public void insertBest(ChickenInfoVO vo) {
	
		dao.update(vo);
	}
	public List<ChickenInfoVO> getList(){
		
		
		return dao.getList();
	}

}
