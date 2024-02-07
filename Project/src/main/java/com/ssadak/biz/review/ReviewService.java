package com.ssadak.biz.review;

import java.util.List;

import com.ssadak.biz.reviewInfo.ReviewInfoVO;

public interface ReviewService {
	
	public List<ReviewInfoVO> getList(int num);
	public void insertReview(ReviewInfoVO vo);
	public void reinsertReview(ReviewInfoVO vo);
	public void updateReview(ReviewInfoVO vo);
	public void deleteReview(ReviewInfoVO vo);
	public ReviewInfoVO infoReview(ReviewInfoVO vo);
	public List<ReviewInfoVO> infoPost(ReviewInfoVO vo);
	public int getPageNum();
	
	
	
}
