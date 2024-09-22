package com.my.pro.dao;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2020年0618日 15时16分34秒
 */
import com.my.pro.utils.Pager;
import com.my.pro.base.BaseDao;
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


public interface OrderItemDao extends BaseDao<OrderItem>{
	
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	Pager<OrderItem> findPager(OrderItem orderItem);

	Pager<OrderItem> findByUserId(Integer userId);
}
