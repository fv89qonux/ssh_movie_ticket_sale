package com.my.pro.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2020年0618日 15时16分34秒
 */
import org.springframework.stereotype.Repository;
import com.my.pro.model.Orders;
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
public class OrdersDaoImpl extends BaseDaoImpl<Orders> implements OrdersDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<Orders> findPager(Orders orders) {
		if(!"".equals(orders.getId() )){
	    	   String hql = "from Orders";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +orders.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Orders where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}

	@Override
	public Pager<Orders> findByUserId(Integer userId) {
		  String hql = "from Orders where user.id  = :userId and isDelete=0 order by id desc";
   	      Map<String,Object> alias = new HashMap<String,Object>();
  		   alias.put("userId", userId );
  		  return findByAlias(hql, alias);
	}
	
}
