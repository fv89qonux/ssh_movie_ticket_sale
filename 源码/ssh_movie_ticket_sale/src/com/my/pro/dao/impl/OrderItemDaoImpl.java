package com.my.pro.dao.impl;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2020年0618日 15时16分34秒
 */
import org.springframework.stereotype.Repository;
import com.my.pro.model.OrderItem;
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
public class OrderItemDaoImpl extends BaseDaoImpl<OrderItem> implements OrderItemDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<OrderItem> findPager(OrderItem orderItem) {
		if(!"".equals(orderItem.getId() )){
	    	   String hql = "from OrderItem";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +orderItem.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from OrderItem where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}

	@Override
	public Pager<OrderItem> findByUserId(Integer userId) {
		String hql = "from OrderItem oi  where oi.orders.user.id = :userId and oi.orders.isDelete=0";
		Map<String,Object> alias = new HashMap<String,Object>();
		   alias.put("userId", userId );
		return findByAlias(hql, alias);
	}
}
