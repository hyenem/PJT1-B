package com.ssafy.fit.test;

import com.ssafy.fit.model.dao.UserManagerImpl;
import com.ssafy.fit.ui.MainUi;

public class SsafitApplication {

	public static void main(String[] args) {
		UserManagerImpl usermanager = UserManagerImpl.getInstance();
		usermanager.loadUserData();
		
		MainUi main = new MainUi();
		main.service();

	}

}
