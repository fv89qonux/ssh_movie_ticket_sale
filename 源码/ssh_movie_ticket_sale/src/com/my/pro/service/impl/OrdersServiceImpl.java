/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2020年0618日 15时16分34秒
 */
package com.my.pro.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.pro.dao.OrdersDao;
import com.my.pro.model.Orders;
import com.my.pro.service.OrdersService;
import com.my.pro.utils.Pager;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2020年04月24日 下午1:46:33 - 2020年0618日 15时16分34秒
 */

@Service("ordersServiceImpl")
public class OrdersServiceImpl extends BaseServiceImpl<Orders> implements OrdersService{
	 
	@Autowired
	private OrdersDao ordersDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Orders> findPager(Orders orders) {
		return ordersDao.findPager(orders);
	}
	
	@Override
	public Pager<Orders> findByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return ordersDao.findByUserId(userId);
	}
	

	

}
