package com.ssafy.fit.model.dao;

import java.util.*;

import com.ssafy.fit.model.VideoReview;

public class VideoReviewDaoImpl implements VideoReviewDao{
	private int reviewNo;
	private Map<Integer, List<VideoReview>> videoReviewDb = new HashMap<>();
	private static VideoReviewDaoImpl instance;
	
	private VideoReviewDaoImpl() {}
	
	public static VideoReviewDaoImpl getInstance() {
		if (instance == null)
			instance = new VideoReviewDaoImpl();
		return instance;
	}
	
	public int insertReview(VideoReview videoReview) {
		int videoNo = videoReview.getVideoNo();
		List<VideoReview> reviews = videoReviewDb.getOrDefault(videoNo, new ArrayList<>());
		reviews.add(videoReview);
		return videoNo;
	}
	
	public List<VideoReview> selectReview(int videoNo) {
		return videoReviewDb.getOrDefault(videoNo, new ArrayList<>());
	}
	

}
