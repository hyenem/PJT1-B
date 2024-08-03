package com.ssafy.fit.model;

public class VideoReview {
	static int videoNo;
	static int reviewNo;
	static String nickName;
	static String content;
	
	public static int getVideoNo() {
		return videoNo;
	}
	
	public static void setVideoNo(int videoNo) {
		VideoReview.videoNo = videoNo;
	}
	
	public static int getReviewNo() {
		return reviewNo;
	}
	
	public static void setReviewNo(int reviewNo) {
		VideoReview.reviewNo = reviewNo;
	}
	
	public static String getNickName() {
		return nickName;
	}
	
	public static void setNickName(String nickName) {
		VideoReview.nickName = nickName;
	}
	public static String getContent() {
		return content;
	}
	public static void setContent(String content) {
		VideoReview.content = content;
	}
	
	
}
