package com.ssadak.biz.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssadak.biz.reviewInfo.ReviewInfoVO;
@Service("reService")
public class ReviewMainService implements ReviewService {

	
	@Autowired
	private ReviewDAO dao;
	
	@Override
	public List<ReviewInfoVO> getList(int num) {
		
		return dao.getList(num);
		
	}

	@Override
	public void insertReview(ReviewInfoVO vo) {
		dao.insertReview(vo);

	}
	public void reinsertReview(ReviewInfoVO vo) {
		dao.reinsertReview(vo);
	}
	@Override
	public void updateReview(ReviewInfoVO vo) {
		// TODO Auto-generated method stub
		dao.updateReview(vo);
	}

	@Override
	public void deleteReview(ReviewInfoVO vo) {
		// TODO Auto-generated method stub
		dao.deleteReview(vo);
	}

	@Override
	public ReviewInfoVO infoReview(ReviewInfoVO vo) {
		// TODO Auto-generated method stub
		return dao.infoReview(vo);
	}
	public List<ReviewInfoVO> infoPost(ReviewInfoVO vo) {
		return dao.infoPost(vo);
	}
	public int getPageNum() {
		return dao.getPageNum();
	}
	



}
