package com.my.pro.dao.impl;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Query;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2020年0618日 15时16分33秒
 */
import org.springframework.stereotype.Repository;

import com.my.pro.base.impl.BaseDaoImpl;
import com.my.pro.dao.AdminDao;
import com.my.pro.model.Admin;
import com.my.pro.utils.Pager;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2020年04月24日 下午1:46:33 - 2020年0618日 15时16分33秒
 */

@Repository
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<Admin> findPager(Admin admin) {
		if(!"".equals(admin.getId() )){
	    	   String hql = "from Admin";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +admin.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Admin where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
	 /**
     * 根据用户名查询该用户是否存在
     */
	@Override
	public Admin getByUserName(Admin admin) {
		String hql = "from Admin bean where bean.adminName =:adminName and bean.isDelete=0";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("adminName", admin.getAdminName());
		return (Admin)q.uniqueResult();
	}

	/**
	 * 根据用户名和密码查询
	 */
	public Admin login(Admin admin) {
		String hql = "from Admin bean where bean.adminName =:adminName and bean.passWord= :passWord and bean.isDelete=0";
		Query q =this.getSession().createQuery(hql);
		q.setParameter("adminName", admin.getAdminName());
		q.setParameter("passWord", admin.getPassWord());
		return (Admin)q.uniqueResult();
	}

	
}
