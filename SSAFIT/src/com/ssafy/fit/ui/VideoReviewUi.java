package com.ssafy.fit.ui;

import java.util.Arrays;
import java.util.Scanner;

import com.ssafy.fit.model.VideoReview;
import com.ssafy.fit.model.dao.VideoReviewDao;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;

public class VideoReviewUi {
	private VideoReviewDao videoReviewDao;
	private static VideoReviewUi instance;
	private int videoNo;
	
	Scanner sc = new Scanner(System.in);

	private VideoReviewUi() {}
	
	public VideoReviewUi getInstance(int videoNo) {
		return instance;
	}
	
	public void service() {
		System.out.println("1. 리뷰 보기");
		System.out.println("2. 리뷰 등록하기");
		System.out.println("0. 종료");
		System.out.println("======================");
		System.out.print("메뉴를 선택하세요: ");
		
		OUT: while(true) {
			int menu = sc.nextInt();
			switch(menu) {
				case 1: 
					listReview();
					break OUT;
				case 2:
					registReview();
					break OUT;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					break OUT;
				default:
					System.out.println("잘못된 선택입니다. 다시 시도하세요.");
			}
		}
	}
	
	private void listReview() {
		System.out.println("[ 리뷰 ]");
		int videoNo = VideoReview.getVideoNo();
		VideoReviewDaoImpl reviews = VideoReviewDaoImpl.getInstance();
		System.out.println(reviews.selectReview(videoNo).toString());	// .toString() 맞나?
	}
	
	// 수정 필
	private void registReview() {
		System.out.println("리뷰를 입력하세요: ");
		String review_content = sc.nextLine();
		VideoReviewDaoImpl instance = VideoReviewDaoImpl.getInstance();
		
		instance.insertReview(review_content);

		
	}
}
