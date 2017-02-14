package org.honor.tourism.service.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.honor.tourism.entity.Department;
import org.honor.tourism.entity.SysUser;
import org.honor.tourism.repository.DepartmentRepository;
import org.honor.tourism.repository.SysUserRepository;
import org.honor.tourism.service.SysUserService;
import org.honor.tourism.util.EasyuiResult;
import org.honor.tourism.util.ExcelUtil;
import org.honor.tourism.util.PDFUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfWriter;

/**
 * 作者:修罗大人
 * 日期:Feb 8, 2017
 * 时间:9:29:12 AM
 * SysUserServiceImpl
 */
@Service
public class SysUserServiceImpl extends CrudServiceImpl<SysUser> implements SysUserService {
	
	@Autowired
	public SysUserServiceImpl(JpaRepository<SysUser, String> repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private SysUserRepository repository;
	
	@Autowired
	private DepartmentRepository deptRepository;

	@Override
	public SysUser save(SysUser sysUser) {
		return repository.save(sysUser);
	}

	@Override
	public SysUser findByLogin() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
			    .getAuthentication()
			    .getPrincipal();
		String username = userDetails.getUsername();
		return repository.findByUsername(username);
	}
	
	/**
	 * 批量删除员工
	 * @param userIds
	 * @return
	 */
	public void deleteUsers(List<String> userIds)
	{
		for (String id : userIds) {
			repository.delete(id);
		}
	}
	
	/**
	 * 根据条件查询员工
	 * @param name
	 * @param username
	 * @param deptId
	 */
	public Page<SysUser> findUsersByNameAndUsernameAndDeptId(String name,String username,String deptId,Pageable pageable)
	{
		return repository.findUsersByNameAndUsernameAndDeptId(name, username, deptId,pageable);
	}

	/**
	 * 初始化员工密码
	 * @param userId
	 * @param passwrod
	 * @return
	 */
	@Override
	public SysUser resetPassword(String userId, String passwrod)
	{
		SysUser user = repository.findOne(userId);
		
		if (user != null) {
			user.setPassword(passwrod);
			return repository.save(user);
		}
		
		return null;
	}

	/** 导出usersexcel
	 * @param fileName
	 * @param users
	 * @param response
	 */
	@Override
	public void outputUsersExcel(String fileName,List<SysUser> users, HttpServletResponse response)
	{
       String []title = new String[]{"Id","姓名","用户名","所属部门","部门ID","职务","手机","电话"};//标题
       
       String [][]values = new String[users.size()][];
       for(int i=0;i<users.size();i++){
           values[i] = new String[title.length];
           //将对象内容转换成string
           SysUser obj = users.get(i);
           values[i][0] = obj.getId()+"";
           values[i][1] = obj.getName()+"";
           values[i][2] = obj.getUsername()+"";
           values[i][3] = obj.getDepartment() == null ? "" : obj.getDepartment().getDepartmentName();
           values[i][4] = obj.getDepartment() == null ? "" : obj.getDepartment().getId();
           values[i][5] = obj.getDuty()+"";
           values[i][6] = obj.getMobilePhone()+"";
           values[i][7] = obj.getPhone()+"";
       }
       
       HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook("用户", title, values, null);
       
       //将文件存到指定位置  
       try {  
       	 fileName = new String(fileName.getBytes(),"ISO_8859_1");
	    	 response.setContentType("application/octet-stream;charset=ISO_8859_1");  
	         response.setHeader("Content-Disposition", "attachment;filename="+ fileName); 
	         OutputStream os = response.getOutputStream();  
	         wb.write(os);  
	         os.flush();  
	         os.close();  
       } catch (Exception e) {  
            e.printStackTrace();  
       }
	}

	/**
	 * 导出usersPDF
	 * @param deptId
	 * @param response
	 */
	@Override
	public void outputUsersPDF(String fileName,List<SysUser> users,HttpServletResponse response)
	{
		String []title = new String[]{"Id","姓名","用户名","所属部门","职务","手机","电话"};//标题
	       
       String [][]values = new String[users.size()][];
       for(int i=0;i<users.size();i++){
           values[i] = new String[title.length];
           //将对象内容转换成string
           SysUser obj = users.get(i);
           values[i][0] = obj.getId()+"";
           values[i][1] = obj.getName()+"";
           values[i][2] = obj.getUsername()+"";
           values[i][3] = obj.getDepartment() == null ? "" : obj.getDepartment().getDepartmentName();
           values[i][4] = obj.getDuty()+"";
           values[i][5] = obj.getMobilePhone()+"";
           values[i][6] = obj.getPhone()+"";
       }
        
        //将文件存到指定位置  
        try {  
        	 fileName = new String(fileName.getBytes(),"ISO_8859_1");
	    	 response.setContentType("application/octet-stream;charset=ISO_8859_1");  
	         response.setHeader("Content-Disposition", "attachment;filename="+ fileName); 
	         OutputStream os = response.getOutputStream();  
	         PdfWriter pdfWriter = PDFUtil.getPDFWriter(title, values, os);
	         os.flush();  
	         os.close();  
	         pdfWriter.close();
        } catch (Exception e) {  
             e.printStackTrace();  
        }
	}

	/**
	 * 导入员工excel
	 * @param fileInputStream
	 * @return
	 */
	public void inputUsersExcel (InputStream inputStream) throws Exception {
		
		List<SysUser> users = ExcelUtil.inputExcel(inputStream,deptRepository);

		for (SysUser sysUser : users) {
			repository.save(sysUser);
		}
	}
	
}
