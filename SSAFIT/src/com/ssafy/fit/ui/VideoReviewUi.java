package com.ssafy.fit.ui;

import java.util.Arrays;

import com.ssafy.fit.model.VideoReview;
import com.ssafy.fit.model.dao.UserManagerImpl;
import com.ssafy.fit.model.dao.VideoReviewDao;
import com.ssafy.fit.model.dao.VideoReviewDaoImpl;
import com.ssafy.fit.util.SsafitUtil;

public class VideoReviewUi {
    private VideoReviewDao videoReviewDao;
    private static VideoReviewUi instance;
    private int videoNo;
    
    private SsafitUtil Util = new SsafitUtil();

    private VideoReviewUi() {
        videoReviewDao = VideoReviewDaoImpl.getInstance();
    }

    public static VideoReviewUi getInstance(int videoNo) {
        if (instance == null) {
            instance = new VideoReviewUi();
        }
        instance.videoNo = videoNo;
        return instance;
    }

    public void service() {
        
        while (true) {
			System.out.println("-----------------리뷰 메뉴----------------");
            System.out.println("1. 리뷰 보기");
            System.out.println("2. 리뷰 등록하기");
            System.out.println("0. 종료");
			System.out.println("---------------------------------------");
            int menu = Util.inputInt("메뉴를 선택하세요: ");
            switch(menu) {
                case 1: 
                    listReview();
                    return;
                case 2:
                    registReview();
                    return;
                case 0:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }

    private void listReview() {
        VideoReviewDaoImpl reviews = VideoReviewDaoImpl.getInstance();
        if (reviews.selectReview(videoNo).isEmpty()) 
        	System.out.println("등록된 리뷰가 없습니다.\n---------------------------------------");
        else {
        	System.out.println("[ 리뷰 ]");
        	System.out.println(reviews);
    		System.out.println("---------------------------------------");
        }
      System.out.println("-----------------메뉴--------------------");
      System.out.println("1. 뒤로 가기");
      System.out.println("2. 종료");
      while(true) {
	      int choice = Util.inputInt("메뉴를 선택하세요: ");
	      switch (choice) {
	          case 1:
	              // 뒤로 가기
	              service();
	              break;
	          case 2:
	              System.out.println("프로그램을 종료합니다.");
	              System.exit(0);
	              break;
	      	}
      	}
    }

    private void registReview() {
        String reviewContent = Util.input("리뷰를 입력하세요: ");
        VideoReview review = new VideoReview();
        review.setContent(reviewContent);
        review.setVideoNo(videoNo);
//        review.setNickName(reviewContent);
//        review.setReviewNo(videoNo);
        

        videoReviewDao.insertReview(review);
		System.out.println("---------------------------------------");
        System.out.println("리뷰가 등록되었습니다.");
        
		System.out.println("---------------------------------------");
        System.out.println("1. 뒤로 가기");
        System.out.println("2. 종료");
		System.out.println("---------------------------------------");
        
        while(true) {
  	      int choice = Util.inputInt("메뉴를 선택하세요: ");
  	      switch (choice) {
  	          case 1:
  	              // 뒤로 가기
  	              service();
  	              break;
  	          case 2:
  	        	  UserManagerImpl instance = UserManagerImpl.getInstance();
  	        	  instance.saveUserData();
  	              System.out.println("프로그램을 종료합니다.");
  	              System.exit(0);
  	              break;
  	      	}
        }
    
    }
}
