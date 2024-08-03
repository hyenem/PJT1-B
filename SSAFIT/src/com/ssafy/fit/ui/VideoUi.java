package com.ssafy.fit.ui;

import com.ssafy.fit.model.*;
import com.ssafy.fit.model.dao.*;
import com.ssafy.fit.util.*;

import java.util.List;

public class VideoUi {
	private VideoDao videoDao = VideoDaoImpl.getInstance();
	private static VideoUi instance;
	
	private VideoUi() {}

	public static VideoUi getInstance() {
		if (instance == null) {
			instance = new VideoUi();
		}
		return instance;
	}
	
	public void listVideo() {
		
	}
	
}
