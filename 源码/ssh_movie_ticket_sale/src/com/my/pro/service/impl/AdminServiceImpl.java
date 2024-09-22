/**
	 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2020年0618日 15时16分33秒
 */
package com.my.pro.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.pro.dao.AdminDao;
import com.my.pro.model.Admin;
import com.my.pro.service.AdminService;
import com.my.pro.utils.Pager;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2020年04月24日 下午1:46:33 - 2020年0618日 15时16分33秒
 */

@Service("adminServiceImpl")	
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService{
	 
	@Autowired
	private AdminDao adminDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Admin> findPager(Admin admin) {
		return adminDao.findPager(admin);
	}
	@Override
	public Admin getByUserName(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.getByUserName(admin);
	}
	
	
	@Override
	public Admin login(Admin admin) {
	 Admin ad = new Admin();
	 ad.setAdminName(admin.getAdminName());
	 ad.setPassWord(admin.getPassWord());
	 return adminDao.login(ad);
	}

	

}
