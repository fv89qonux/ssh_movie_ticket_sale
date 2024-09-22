package com.my.pro.dao.impl;
import org.hibernate.Query;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2020年0618日 15时16分34秒
 */
import org.springframework.stereotype.Repository;
import com.my.pro.model.User;
import com.my.pro.utils.Pager;
import com.my.pro.base.impl.BaseDaoImpl;
import java.util.*;

import com.my.pro.model.*;
import com.my.pro.dao.*;
import com.my.pro.service.*;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2020年04月24日 下午1:46:33 - 2020年0618日 15时16分34秒
 */

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<User> findPager(User user) {
		if(!"".equals(user.getId() )){
	    	   String hql = "from User";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +user.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from User where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}

	 /**
     * 根据用户名查询该用户是否存在
     */
	@Override
	public User getByUserName(User user) {
		String hql = "from User bean where bean.loginName =:loginName and bean.isDelete=0";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("loginName", user.getLoginName());
		return (User)q.uniqueResult();
	}
	
	/**
	 * 根据用户名和密码查询
	 */
	@Override
	public User login(User user) {
		String hql = "from User bean where bean.loginName =:loginName and bean.passWord= :passWord and bean.isDelete=0";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("loginName", user.getLoginName());
		q.setParameter("passWord", user.getPassWord());
		return (User)q.uniqueResult();
	}
	
}
