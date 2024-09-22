/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2020年0618日 15时16分34秒
 */
package com.my.pro.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.pro.dao.FilmDao;
import com.my.pro.model.Film;
import com.my.pro.service.FilmService;
import com.my.pro.utils.Pager;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2020年04月24日 下午1:46:33 - 2020年0618日 15时16分34秒
 */

@Service("filmServiceImpl")
public class FilmServiceImpl extends BaseServiceImpl<Film> implements FilmService{
	 
	@Autowired
	private FilmDao filmDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Film> findPager(Film film) {
		return filmDao.findPager(film);
	}
	

	

}
