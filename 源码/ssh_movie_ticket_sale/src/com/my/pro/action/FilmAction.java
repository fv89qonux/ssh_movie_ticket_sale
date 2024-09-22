package com.my.pro.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Scope;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.my.pro.utils.Pager;
import com.my.pro.utils.UUIDUtils;
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

@Controller("filmAction")
@Scope("prototype")
public class FilmAction extends ActionSupport implements ModelDriven<Film> {

	private static final long serialVersionUID = 1L;

	// ==========model==============
	private Film film;

	@Override
	public Film getModel() {
		if (film == null)
			film = new Film();
		return film;
	}

	// ==========model==============
	/**
	 * 依赖注入 start dao/service/===
	 */
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private FilmSeatService filmSeatService;
	
	@Autowired
	private CommentService commentService;

	// 依赖注入 end dao/service/===

	// -------------------------华丽分割线---------------------------------------------

	// ============自定义参数start=============

	// ============自定义参数end=============

	// -------------------------华丽分割线---------------------------------------------

	// ============文件上传start=======================================================
	private File file;
	// 提交过来的file的名字
	private String fileFileName;
	// 提交过来的file的MIME类型
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
	// ============文件上传end=========================================================

	// -------------------------华丽分割线---------------------------------------------//

	// =============公=======共=======方=======法==========区=========start============//
	
	/**
	 * 根据电影的ID进行查询影片:执行方法
	 */
	public String findByPid() {
		Film f = filmService.getById(film.getId());
		ActionContext.getContext().put("product", f);
		 String hql = "from Comment where  film.id  = :filmId  and isDelete=0 order by id desc";
   	     Map<String,Object> alias = new HashMap<String,Object>();
  		 alias.put("filmId", film.getId());
  		 List< Comment> cList = commentService.getByHQL(hql, alias);
  		 ActionContext.getContext().put("cList", cList);
		return "findByPid";
	}
	
	
	
	/**
	 * 列表分页查询
	 */
	public String film() {
		Map<String, Object> alias = new HashMap<String, Object>();
		StringBuffer sb = new StringBuffer();
		sb = sb.append("from Film where 1=1 and isDelete=0");
		if (film.getName() != null && !"".equals(film.getName())) {
			sb.append(" and name like :name");
			alias.put("name", "%" + film.getName() + "%");
		}
		sb = sb.append(" order by id desc");
		Pager<Film> pagers = filmService.findByAlias(sb.toString(), alias);
		ActionContext.getContext().put("pagers", pagers);
		ActionContext.getContext().put("film", film);
		return SUCCESS;
	}

	/**
	 * 跳转到添加页面
	 * 
	 * @return
	 */
	public String add() {
		return SUCCESS;
	}

	/**
	 * 执行添加
	 * 
	 * @return
	 * @throws Exception
	 */
	public String exAdd() throws Exception {
		// 图片上传
		String root = Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(0,Thread.currentThread().getContextClassLoader().getResource("").getPath().length()-16)
+"/upload";
		InputStream is = new FileInputStream(file);
		fileFileName = UUIDUtils.create() + fileFileName;
		OutputStream os = new FileOutputStream(new File(root, fileFileName));
		System.out.println("fileFileName: " + fileFileName);
		System.out.println("file: " + file.getName());
		System.out.println("file: " + file.getPath());
		byte[] buffer = new byte[500];
		int length = 0;
		while (-1 != (length = is.read(buffer, 0, buffer.length))) {
			os.write(buffer);
		}
		os.close();
		is.close();
		film.setImage("\\upload\\" + fileFileName);
		filmService.save(film);
		FilmSeat  filmSeat=new FilmSeat();
		filmSeat.setFilm(film);
		filmSeatService.save(filmSeat);//向中间表中插入座位
		ActionContext.getContext().put("url", "/film_film.do");
		return "redirect";

	}

	/**
	 * 查看详情页面
	 * 
	 * @return
	 */
	public String view() {
		Film n = filmService.getById(film.getId());
		ActionContext.getContext().put("film", n);
		return SUCCESS;
	}

	/**
	 * 跳转修改页面
	 * 
	 * @return
	 */
	public String update() {
		Film n = filmService.getById(film.getId());
		ActionContext.getContext().put("film", n);
		return SUCCESS;
	}

	/**
	 * 执行修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String exUpdate() throws Exception {
		Film f = filmService.getById(film.getId());
		if (file != null) {
			// 图片上传
			String root = Thread.currentThread().getContextClassLoader().getResource("").getPath().substring(0,Thread.currentThread().getContextClassLoader().getResource("").getPath().length()-16)
					+"/upload";
			InputStream is = new FileInputStream(file);
			fileFileName = UUIDUtils.create() + fileFileName;
			OutputStream os = new FileOutputStream(new File(root, fileFileName));
			System.out.println("fileFileName: " + fileFileName);
			System.out.println("file: " + file.getName());
			System.out.println("file: " + file.getPath());
			byte[] buffer = new byte[500];
			int length = 0;
			while (-1 != (length = is.read(buffer, 0, buffer.length))) {
				os.write(buffer);
			}
			os.close();
			is.close();
			f.setImage("\\upload\\" + fileFileName);
		} else {
			film.setImage(f.getImage());
		}
		f.setEndTime(film.getEndTime());
		f.setName(film.getName());
		f.setPrice(film.getPrice());
		f.setRemark(film.getRemark());
		f.setStartTime(film.getStartTime());
		f.setIsDelete(film.getIsDelete());
		f.setIsRecommend(film.getIsRecommend());
		filmService.update(f);
		ActionContext.getContext().put("url", "/film_film.do");
		return "redirect";
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	public String delete() {
		filmSeatService.updateByHql("delete  from FilmSeat film where  film.id = "+film.getId());
		filmService.delete(film.getId());
		ActionContext.getContext().put("url", "/film_film.do");
		return "redirect";
	}

	// =============公=======共=======方=======法==========区=========end============//

	// -------------------------华丽分割线---------------------------------------------//

	// =============自=======定=======义=========方=======法==========区=========start============//

	// =============自=======定=======义=========方=======法==========区=========end============//

}
