/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2020年0618日 15时16分34秒
 */
package com.my.pro.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.pro.dao.UserDao;
import com.my.pro.model.User;
import com.my.pro.service.UserService;
import com.my.pro.utils.Pager;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2020年04月24日 下午1:46:33 - 2020年0618日 15时16分34秒
 */

@Service("userServiceImpl")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	 
	@Autowired
	private UserDao userDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<User> findPager(User user) {
		return userDao.findPager(user);
	}
	
	@Override
	public User getByUserName(User user) {
		// TODO Auto-generated method stub
		return userDao.getByUserName(user);
	}
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}
	

	

}
