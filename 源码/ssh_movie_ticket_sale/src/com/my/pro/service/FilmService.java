package com.my.pro.service;

import com.my.pro.model.Film;
import com.my.pro.utils.Pager;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2020年04月24日 下午1:46:33 - 2020年0618日 15时16分34秒
 */
public interface FilmService extends BaseService<Film>{

	/**
	 * dao层分页查询
	 */
	Pager<Film> findPager(Film film);
}
