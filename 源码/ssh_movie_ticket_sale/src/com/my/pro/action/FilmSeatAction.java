package com.my.pro.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.my.pro.utils.Pager;
import com.opensymphony.xwork2.ModelDriven;

import net.sf.json.JSONObject;

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

@Controller("filmSeatAction")
@Scope("prototype")
public class FilmSeatAction extends ActionSupport implements ModelDriven<FilmSeat>{
	
	private static final long serialVersionUID = 1L;

	//==========model==============
	  private FilmSeat filmSeat;
		@Override
		public FilmSeat getModel() {
			if(filmSeat==null) filmSeat = new FilmSeat();
			return filmSeat;	
		}
		//==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private FilmSeatService filmSeatService;
	
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
	private Integer filmId;
	 //============文件上传end=========================================================
			
	 //-------------------------华丽分割线---------------------------------------------//
	 public Integer getFilmId() {
		return filmId;
	}
	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}
	//=============公=======共=======方=======法==========区=========start============//
	/**|
	 * 根据影片id查询座位表
	 * @throws IOException
	 */
    public void getFilmSeatById() throws IOException{
    	 HttpServletResponse resp = ServletActionContext.getResponse();
         resp.setContentType("application/json;charset=UTF-8");
         PrintWriter out = null;
         JSONObject json  = new JSONObject();
    	 String hql="from FilmSeat bean where bean.film.id =:filmId";
    	 Map<String,Object> alias = new HashMap<String,Object>();
		 alias.put("filmId", filmId);
	     List<FilmSeat> filmSeatList=filmSeatService.getByHQL(hql, alias);
		 json.put("result", filmSeatList);
	    out = resp.getWriter();
        out.write(json.toString());
    }
    
	/**
	 * 列表分页查询
	 */
	public String filmSeat(){
	    Map<String,Object> alias = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from FilmSeat where 1=1 ");
		sb = sb.append("order by id desc");
		Pager<FilmSeat> pagers = filmSeatService.findByAlias(sb.toString(),alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("Obj", filmSeat);
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
		filmSeatService.save(filmSeat);
		ActionContext.getContext().put("url", "/filmSeat_filmSeat.do");
		return "redirect";
	}
	
	/**
	 * 查看详情页面
	 * @return
	 */
	public String view(){
		FilmSeat n = filmSeatService.getById(filmSeat.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public String update(){
		FilmSeat n = filmSeatService.getById(filmSeat.getId());
		ActionContext.getContext().put("Obj", n);
		return SUCCESS;
	}
    
	/**
	 * 执行修改
	 * @return
	 */
	public String exUpdate(){
		FilmSeat n = filmSeatService.getById(filmSeat.getId());
		filmSeatService.update(n);
		ActionContext.getContext().put("url", "/filmSeat_filmSeat.do");
		return "redirect";
	}
	
	
	/**
	 * 删除
	 * @return
	 */
	public String delete(){
		filmSeatService.delete(filmSeat.getId());
		ActionContext.getContext().put("url", "/filmSeat_filmSeat.do");
		return "redirect";
	}
	
	//=============公=======共=======方=======法==========区=========end============//
	
	 //-------------------------华丽分割线---------------------------------------------//
	
	 //=============自=======定=======义=========方=======法==========区=========start============//
	
	
	
	
	//=============自=======定=======义=========方=======法==========区=========end============//
		
	
	
}
