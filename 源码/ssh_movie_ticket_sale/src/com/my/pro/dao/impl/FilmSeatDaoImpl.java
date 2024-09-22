package com.my.pro.dao.impl;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2020年0618日 15时16分34秒
 */
import org.springframework.stereotype.Repository;

import com.my.pro.base.impl.BaseDaoImpl;
import com.my.pro.dao.FilmSeatDao;
import com.my.pro.model.FilmSeat;
import com.my.pro.utils.Pager;
/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2020年04月24日 下午1:46:33 - 2020年0618日 15时16分34秒
 */

@Repository
public class FilmSeatDaoImpl extends BaseDaoImpl<FilmSeat> implements FilmSeatDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<FilmSeat> findPager(FilmSeat filmSeat) {
		if(!"".equals(filmSeat.getId() )){
	    	   String hql = "from FilmSeat";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +filmSeat.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from FilmSeat where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
