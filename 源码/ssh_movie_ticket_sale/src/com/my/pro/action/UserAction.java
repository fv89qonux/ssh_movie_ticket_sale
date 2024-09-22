package com.my.pro.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.my.pro.utils.Pager;
import net.sf.json.JSONObject;
import com.opensymphony.xwork2.ModelDriven;
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

@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	private static final long serialVersionUID = 1L;

	//==========model==============
	  private User user;
		@Override
		public User getModel() {
			if(user==null) user = new User();
			return user;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private UserService userService;
	
	//依赖注入 end  dao/service/===
	
	//-------------------------华丽分割线---------------------------------------------
	
	//============自定义参数start=============
	
	//============自定义参数end=============
	
	//-------------------------华丽分割线---------------------------------------------
	
	//============文件上传start=======================================================
	private File file;
	//提交过来的file的名字
    private String fileFileName;
    //提交过来的file的MIME类型
    private String fileContentType;
    public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	 //============文件上传end=========================================================
			
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============公=======共=======方=======法==========区=========start============//
	//注册
    public void register() throws IOException{
    	 HttpServletResponse resp = ServletActionContext.getResponse();
         resp.setContentType("application/json;charset=UTF-8");
         PrintWriter out = null;
         JSONObject json  = new JSONObject();
    	String hql="from User bean where bean.loginName =:loginName and bean.isDelete=0  ";
    	 Map<String,Object> alias = new HashMap<String,Object>();
		    alias.put("loginName", user.getLoginName() );
	     List<User> userList=userService.getByHQL(hql, alias);
	    if(userList.size() != 0){
	    	 json.put("result", 2);//该用户存在
			}else{
				userService.save(user);
				 json.put("result", 1);//注册成功
			}
	    out = resp.getWriter();
        out.write(json.toString());
    }
			
    //登录 
    public void login() throws IOException{
        HttpServletResponse resp = ServletActionContext.getResponse();
        resp.setContentType("application/json;charset=UTF-8");
        PrintWriter out = null;
        JSONObject json  = new JSONObject();
        User u1 =userService.getByUserName(user);
        User u =userService.login(user);
    	if(u1==null){
    		 json.put("result", 3); //该用户不存在
    	}else{
		   if(u!=null){
	        	 json.put("result", 1); //登录成功
	        	 ActionContext ac = ActionContext.getContext();
	 			 Map session1 = ac.getSession();
	 			session1.remove("loginName");
	 			session1.remove("userId");
	 			session1.remove("user");
	        	 HttpSession session =ServletActionContext.getRequest().getSession();
	  			session.setAttribute("loginName", u.getLoginName());
	  			session.setAttribute("userId", u.getId());
	  			session.setAttribute("user", u);
	        }else{
	        	json.put("result",2);//密码错误
	        }
    	}
         out = resp.getWriter();
         out.write(json.toString());
		
    }    
	
    /**
	 * 前台查看个人信息跳转页面
	 * @return
	 */
	public String findUserInfo(){
		User sessionUser = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		ActionContext.getContext().put("user", sessionUser);
		return "findUserInfo";
	}
	
   /**
    * 个人信息修改执行
    * @throws IOException
    */
    public void change() throws IOException{
    	 HttpServletResponse resp = ServletActionContext.getResponse();
         resp.setContentType("application/json;charset=UTF-8");
         PrintWriter out = null;
         JSONObject json  = new JSONObject();
         User n = userService.getById(user.getId());
         n.setRealName(user.getRealName());
	 	 n.setPhone(user.getPhone());
	 	 n.setPassWord(user.getPassWord());
 	     userService.update(n);
 	    User u = userService.getById(user.getId());
 	    json.put("result", 1); //修改成功
 	    HttpSession session =ServletActionContext.getRequest().getSession();
		session.setAttribute("loginName", u.getLoginName());
		session.setAttribute("userId", u.getId());
		session.setAttribute("user", u);
	    out = resp.getWriter();
        out.write(json.toString());
    }
	
	
	/**
	 * 列表分页查询
	 */
	public String user(){
		    Map<String,Object> alias = new HashMap<String,Object>();
			StringBuffer sb = new StringBuffer();
			sb = sb.append("from User where 1=1 and isDelete=0");
			if(user.getLoginName()!=null&& !"".equals(user.getLoginName() )){
				 sb.append(" and loginName like :loginName");
				 alias.put("loginName", "%"+user.getLoginName()+"%" );
			}
			sb = sb.append(" order by id desc");
		Pager<User> pagers = userService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("user", user);
		return SUCCESS;
    }
	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	public String add(){
		return SUCCESS;
	}
	
	/**
	 * 执行添加
	 * @return
	 */
	public String exAdd(){
		userService.save(user);
		ActionContext.getContext().put("url", "/user_user.do");
		return "redirect";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		User n = userService.getById(user.getId());
		ActionContext.getContext().put("user", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		User n = userService.getById(user.getId());
		ActionContext.getContext().put("user", n);
		return SUCCESS;
	}
    
	/**
	 * 执行修改
	 * @return
	 */
	public String exUpdate(){
		User n = userService.getById(user.getId());
		n.setPhone(user.getPhone());
		n.setPassWord(user.getPassWord());
		userService.update(n);
		ActionContext.getContext().put("url", "/user_user.do");
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		User u = userService.getById(user.getId());
		System.out.println(u.getLoginName());
		u.setIsDelete(1);
		userService.update(u);
		ActionContext.getContext().put("url", "/user_user.do");
		return "redirect";
	}
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
