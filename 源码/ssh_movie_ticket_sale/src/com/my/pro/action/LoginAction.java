package com.my.pro.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.my.pro.model.Film;
import com.my.pro.service.FilmService;
import com.my.pro.utils.Pager;
import com.opensymphony.xwork2.ActionContext;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction {
	
	 private int role;
	 
	 private String name;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	 @Autowired
	 private  FilmService  filmService;
	 
	 
	//首页
	public String index() {
		if(role==1){
			//影片推荐列表
			 Map<String,Object> alias = new HashMap<String,Object>();
				StringBuffer sb = new StringBuffer();
				sb = sb.append("from Film where 1=1 and isRecommend=1 and isDelete=0");
				if(name!=null&& !"".equals(name)){
					 sb.append(" and name like :name");
					 alias.put("name", "%"+name+"%" );
				}
				sb = sb.append(" order by id desc");
			List<Film> recommendItemList = filmService.getByHQL(sb.toString(),alias);
			if(recommendItemList!=null && recommendItemList.size()>0){
				if(recommendItemList.size()<= 8){
					ActionContext.getContext().put("recommendItemList", recommendItemList);
				}else{
					ActionContext.getContext().put("recommendItemList", recommendItemList.subList(0, 8));
				}
			}else{
				ActionContext.getContext().put("recommendItemList", recommendItemList);
			}
			//所有电影列表
			Map<String, Object> alias1 = new HashMap<String, Object>();
			StringBuffer sb1 = new StringBuffer();
			sb1 = sb1.append("from Film where 1=1 and isDelete=0");
			if (name != null && !"".equals(name)) {
				sb1.append(" and name like :name");
				alias1.put("name", "%" + name + "%");
			}
			sb1 = sb1.append(" order by id desc");
			Pager<Film> pagers = filmService.findByAlias(sb1.toString(), alias1);
			ActionContext.getContext().put("pagers", pagers);
			return "userIndex";
		}else{
			return "manageIndex";
		}
	}
	//登陆页面
	public String login() {
		if(role==1){
			return "userLogin";
		}else{
			return "manageLogin";
		}
	}
	   //注册页面(只有前台有注册)
		public String register() {
			return "userRegister";
		}
	
	  //退出
	public String tuichu() {
		if(role==1){
			ActionContext ac = ActionContext.getContext();
			Map session = ac.getSession();
			session.remove("loginName");
			session.remove("userId");
			session.remove("user");
			return "userLogin";
		}else{
			ActionContext ac = ActionContext.getContext();
			Map session = ac.getSession();
			session.remove("adminName");
			session.remove("adminId");
			return "manageLogin";
		}
	
	}
}
