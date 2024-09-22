package com.my.pro.service;

import com.my.pro.model.Admin;
import com.my.pro.utils.Pager;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.dao.*;
import com.my.pro.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2020年04月24日 下午1:46:33 - 2020年0618日 15时16分33秒
 */
public interface AdminService extends BaseService<Admin>{

	/**
	 * dao层分页查询
	 */
	Pager<Admin> findPager(Admin admin);

	Admin getByUserName(Admin admin);

	Admin login(Admin admin);
}
