/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date - 2020年0618日 15时16分34秒
 */
package com.my.pro.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.my.pro.dao.CommentDao;
import com.my.pro.model.Comment;
import com.my.pro.service.CommentService;
import com.my.pro.utils.Pager;

/**
 * @ClassName:  
 * @Description: 
 * @author administrator
 * @date 2020年04月24日 下午1:46:33 - 2020年0618日 15时16分34秒
 */

@Service("commentServiceImpl")
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService{
	 
	@Autowired
	private CommentDao commentDao;
	/**
	 * dao分页查询
	 * @param user
	 * @return
	 */
	@Override
	public Pager<Comment> findPager(Comment comment) {
		return commentDao.findPager(comment);
	}
	

	

}
