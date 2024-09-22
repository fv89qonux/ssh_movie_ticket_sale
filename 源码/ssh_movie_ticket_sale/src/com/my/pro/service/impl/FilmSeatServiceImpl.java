/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2020年0618日 15时16分34秒
 */
package com.my.pro.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.pro.dao.FilmSeatDao;
import com.my.pro.model.FilmSeat;
import com.my.pro.service.FilmSeatService;
import com.my.pro.utils.Pager;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2020年04月24日 下午1:46:33 - 2020年0618日 15时16分34秒
 */

@Service("filmSeatServiceImpl")
public class FilmSeatServiceImpl extends BaseServiceImpl<FilmSeat> implements FilmSeatService{
	 
	@Autowired
	private FilmSeatDao filmSeatDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<FilmSeat> findPager(FilmSeat filmSeat) {
		return filmSeatDao.findPager(filmSeat);
	}
	

	

}
