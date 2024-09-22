/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2020年0618日 15时16分34秒
 */
package com.my.pro.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.pro.dao.OrderItemDao;
import com.my.pro.model.OrderItem;
import com.my.pro.service.OrderItemService;
import com.my.pro.utils.Pager;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2020年04月24日 下午1:46:33 - 2020年0618日 15时16分34秒
 */

@Service("orderItemServiceImpl")
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItem> implements OrderItemService{
	 
	@Autowired
	private OrderItemDao orderItemDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<OrderItem> findPager(OrderItem orderItem) {
		return orderItemDao.findPager(orderItem);
	}
	@Override
	public Pager<OrderItem> findByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return orderItemDao.findByUserId(userId);
	}
	

	

}
