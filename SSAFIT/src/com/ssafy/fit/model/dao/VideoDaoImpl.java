package com.ssafy.fit.model.dao;

import com.ssafy.fit.model.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;

public class VideoDaoImpl implements VideoDao{
	private List<Video> list = new ArrayList<>();
	private static VideoDaoImpl instance;
	private VideoDaoImpl() {}
	
	public static VideoDaoImpl getInstance() {
		if (instance == null) {
			instance = new VideoDaoImpl();
		}
		return instance;
	}

	@Override
	public List<Video> selectVideo() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("data/video.json")));
		String str = null;// 한줄씩 읽어오기 위한 임시 변수
		StringBuilder sb = new StringBuilder(); // 한줄씩 읽고 합쳐줘야함
		while ((str = br.readLine()) != null) {
			sb.append(str); // 한줄씩 이어붙이기
		}
		// 해당 while문을 빠져나오면 sb에는 모든 문자열이 저장되어있음
		Gson gson = new Gson();
		
		Video[] listarr = gson.fromJson(sb.toString(), Video[].class); // gson으로 json 파일 변환해서 받은 문자 Video 배열에 삽입
		
		for (Video video : listarr) {
			list.add(video); // Video 배열 내용 list에 추가
		}
		
		return list;
	}
	
	@Override
	public Video selectVideoByNo(int no) {
		try {
			for (Video video : list) // 검색 할 Video List 가져오기
				if (video.getNo() == no) // 리스트 내의 no와 검색 대상 no가 동일하면 해당 video 반환
					return video;
		} catch (Exception e) {
			e.printStackTrace(); // 없을 시 에러 출력 -> but 보안에 취약 | 실제 서비스 구현시에는 사용 지양하기
		}
		return null;
	}

}
