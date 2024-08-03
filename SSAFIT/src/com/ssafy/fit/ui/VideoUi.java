package com.ssafy.fit.ui;

import com.ssafy.fit.util.*;
import com.ssafy.fit.model.*;
import com.ssafy.fit.model.dao.*;

import java.io.IOException;
import java.util.List;

public class VideoUi {
	private VideoDao videoDao = VideoDaoImpl.getInstance();
	private static VideoUi instance;
	
	private VideoUi() {}
	
	// Singleton 인스턴스 반환
	public static VideoUi getInstance() {
		if (instance == null) {
			instance = new VideoUi();
		}
		return instance;
	}
	
	SsafitUtil su = new SsafitUtil();
	
	public void service() {
		// 이거 뭐지...
	}
	
	private void listVideo() {
		List<Video> videos = null;
		try {
			videos = videoDao.selectVideo();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		su.printLine('-', 30);
		System.out.println("전 체  " + videos.size() + "개");
		su.printLine('-', 30);
		
		for(Video v : videos) {
			System.out.println(v.getNo() + "  " + v.getPart() + "  " + v.getTitle());
		}
		su.printLine('-', 30);
		System.out.println("1. 영상상세");
		System.out.println("0. 이전으로");
		su.printLine('-', 30);
	}
	

	private void detailVideo(int num) { // 입력받은 숫자에 따라 영상 상세로 이동
		Video video = videoDao.selectVideoByNo(num);
		if (video != null) {
			su.printLine('-', 30);
			System.out.println("번호 : " + video.getNo());
			System.out.println("제목 : " + video.getTitle());
			System.out.println("운동 : " + video.getPart());
			System.out.println("영상 URL : " + video.getUrl());
			su.printLine('-', 30);
			su.printLine('-', 30);
//			List<VideoReview> review = VideoReviewUi.getInstance().//리뷰리스트 가져오기
//			System.out.println("영상리뷰 : " + 리뷰 갯수); 
			su.printLine('-', 30);
//			for(Video v : videos) {
//				System.out.println(v.getNo() + "  " + v.getPart() + "  " + v.getTitle());
//			} --> 리뷰로 수정 필요
			su.printLine('-', 30);
			System.out.println("1. 리뷰등록");
			System.out.println("0. 이전으로");
			su.printLine('-', 30);
		} else {
			System.out.println("해당 번호의 영상이 없습니다.");
			return;
		}
	}
	
}
