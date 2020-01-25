package com.nt.service;

import com.nt.dao.LoginDao;
import com.nt.service.LoginService;

public class LoginDaoImpl implements LoginService {
	private LoginDao dao;
	public void setDao(LoginDao dao) {
		this.dao = dao;
	}
	@Override
	public boolean authenticate(String user, String pwd) throws Exception{
		int count=0;
		if(user.equals("")|| pwd.equals(""))
			throw new IllegalArgumentException("Provide proper inputs");
			//use dao
			count=dao.verify(user,pwd);
			if(count==0)
				return false;
			else
				return true;
	}
    
	}


