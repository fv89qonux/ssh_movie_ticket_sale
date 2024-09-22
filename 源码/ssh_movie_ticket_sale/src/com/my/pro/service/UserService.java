package com.my.pro.service;

import com.my.pro.model.User;
import com.my.pro.utils.Pager;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2020年04月24日 下午1:46:33 - 2020年0618日 15时16分34秒
 */
public interface UserService extends BaseService<User>{

	/**
	 * dao层分页查询
	 */
	Pager<User> findPager(User user);

	User getByUserName(User user);

	User login(User user);
}
