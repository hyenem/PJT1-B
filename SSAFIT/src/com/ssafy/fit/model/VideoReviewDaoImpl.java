package com.ssafy.fit.model;

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
        videoReview.setReviewNo(++reviewNo);
        List<VideoReview> reviews = videoReviewDb.getOrDefault(videoNo, new ArrayList<>());
        reviews.add(videoReview);
        videoReviewDb.put(videoNo, reviews);
        return videoNo;
    }
	
	public List<VideoReview> selectReview(int videoNo) {
		return videoReviewDb.getOrDefault(videoNo, new ArrayList<>());
	}
	
    public String getAllReviews() {
        Collection<List<VideoReview>> reviewsCollection = videoReviewDb.values();
        List<List<VideoReview>> reviewsList = new ArrayList<>(reviewsCollection);
        return Arrays.toString(reviewsList.toArray());
    }
	
	
}
