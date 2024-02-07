package com.ssadak.biz.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.ssadak.biz.reviewInfo.ReviewInfoVO;
import java.util.List;




@Repository
public class ReviewDAO {

	@Autowired 
	private JdbcTemplate jdbcTemplate;
	
	private String REVIEW_INSERT = "insert into review(id,nickname,title,writing,pagename,ref,wTime) values(?,?,?,?,?,?,now())";
	private String REVIEW_REINSERT = "insert into post(id,nickname,post,countNum,wTime) values(?,?,?,?,now())";
	private String REVIEW_UPDATE = "update review set title = ?,writing = ?,wTime = now() where countNum=?";
	private String REVIEW_DELETE = "delete from review where countNum = ?";
	private String REVIEW_LIST = "SELECT * from review order by wTime asc limit 10 offset ?";
	private String REVIEW_INFO = "SELECT * from review where countNum=?";
	private String POST = "SELECT * FROM post WHERE countNum = ?";
	private String REF = "SELECT *  FROM USER_REF WHERE PAGENAME = ?";
	private String GET_NUM = "select count(*) from review";
	

	public List<ReviewInfoVO> getList(int num) {
		
		return jdbcTemplate.query(REVIEW_LIST,new Object[]{num},new ReviewRowMapper());
	}
	
	
	public void insertReview(ReviewInfoVO vo) {
		
		jdbcTemplate.update(REVIEW_INSERT,vo.getId(),vo.getNickname(),vo.getTitle(),vo.getWriting(),vo.getPagename(),vo.getRef()); 
		
	}
	public void reinsertReview(ReviewInfoVO vo) {
		
		jdbcTemplate.update(REVIEW_REINSERT,vo.getId(),vo.getNickname(),vo.getPost(),vo.getCountNum());
	
	}
	public void updateReview(ReviewInfoVO vo) {
		jdbcTemplate.update(REVIEW_UPDATE,vo.getTitle(),vo.getWriting(),vo.getCountNum());
	}
	public void deleteReview(ReviewInfoVO vo) {
		jdbcTemplate.update(REVIEW_DELETE,vo.getId(),vo.getTitle());
	}
	public ReviewInfoVO infoReview(ReviewInfoVO vo) {
		
		return jdbcTemplate.queryForObject(REVIEW_INFO,new Object[] {vo.getCountNum()},new ReviewRowMapper());
	}
	public List<ReviewInfoVO> infoPost(ReviewInfoVO vo) {
		
		return jdbcTemplate.query(POST,new Object[] {vo.getCountNum()},new PostRowMapper());
	}
	public int getPageNum() {
		try {
			return jdbcTemplate.queryForObject(GET_NUM, Integer.class);
		}catch(EmptyResultDataAccessException e) {
			return 0;
		}
	}

	
}
