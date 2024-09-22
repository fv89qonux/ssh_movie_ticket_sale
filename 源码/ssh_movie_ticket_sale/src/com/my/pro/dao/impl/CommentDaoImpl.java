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
import com.my.pro.dao.CommentDao;
import com.my.pro.model.Comment;
import com.my.pro.utils.Pager;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2020年04月24日 下午1:46:33 - 2020年0618日 15时16分34秒
 */

@Repository
public class CommentDaoImpl extends BaseDaoImpl<Comment> implements CommentDao{
	
 /**
  * 分页查询
  */
	@Override
	public Pager<Comment> findPager(Comment comment) {
		if(!"".equals(comment.getId() )){
	    	   String hql = "from Comment";
	    	   Map<String,Object> alias = new HashMap<String,Object>();
	   		   alias.put("1", "%" +comment.getId()+ "%" );
	   		  return findByAlias(hql, alias);
	       }else{
	    	   String hql = "from Comment where 1=1 order by id desc ";
				return findByAlias(hql, null);
	       }
	}
	
}
