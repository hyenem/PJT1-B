package com.ssafy.fit.ui;


import com.ssafy.fit.model.dao.IUserManager;
import com.ssafy.fit.model.dao.UserManagerImpl;

public class MainUi {
	public void service() {
		UserUi user = UserUi.getInstance();
		System.out.println("-------SSAFIT과 함께 건강을 지켜요!-------");
		while(true) {
			user.service();
		}
		
	}
	
//	public void exit() {
//		IUserManager userDao = UserManagerImpl.getInstance();
//		userDao.
//	}
}
