package org.honor.tourism.service.impl;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.honor.tourism.entity.Department;
import org.honor.tourism.entity.SysUser;
import org.honor.tourism.repository.DepartmentRepository;
import org.honor.tourism.repository.SysUserRepository;
import org.honor.tourism.service.DepartmentService;
import org.honor.tourism.util.ExcelUtil;
import org.honor.tourism.util.PDFUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.itextpdf.text.pdf.PdfWriter;

@Service
public class DepartmentServiceImpl extends CrudServiceImpl<Department> implements DepartmentService {
	
	@Autowired
	public DepartmentServiceImpl(JpaRepository<Department, String> repository) {
		super(repository);
		this.users = new ArrayList<SysUser>();
	}

	@Autowired
	private DepartmentRepository repository;
	
	@Autowired
	private SysUserRepository sysUserRepository;

	private List<SysUser> users;
	
	/**
	 * 查找子节点
	 * @param department
	 * @return List<Map<String,Object>>
	 */
	public List<Map<String,Object>> findChildren(Department department) {
		
		List<Map<String,Object>> retDepts = new ArrayList<Map<String,Object>>();
		List<Department> departments = new ArrayList<>();
				
		//根节点
		if (department == null) {
			departments = repository.findByParentDepartmentId(null);
		}else {
			departments = repository.findByParentDepartmentId(department.getId());
		}
		
		if (departments.size() != 0) 
		{
			for (Department departmentTemp : departments) {
				Map<String, Object> deptMap = new HashMap<>();
				deptMap.put("id", departmentTemp.getId());
				deptMap.put("departmentName", departmentTemp.getDepartmentName());
				
				List<Map<String, Object>> children = findChildren(departmentTemp);
				if (children.size() != 0) {
					//deptMap.put("children", children);
					deptMap.put("state","closed");
				}
				
				retDepts.add(deptMap);
			}
		}
		
		return retDepts;
	}
	
	/**
	 * 查找后代节点的员工,返回tree
	 * @param department
	 * @return List<Map<String,Object>>
	 */
	public List<Map<String,Object>> findProgenyUsers(Department department) {
		
		List<Map<String,Object>> retDepts = new ArrayList<Map<String,Object>>();
		List<Department> departments = new ArrayList<>();
				
		//根节点
		if (department == null) {
			departments = repository.findByParentDepartmentId(null);
		}else {
			departments = repository.findByParentDepartmentId(department.getId());
			List<SysUser> users = sysUserRepository.findByDepartmentId(department.getId());

			for (SysUser sysUser : users) {
				this.users.add(sysUser);
			}
		}
		
		if (departments.size() != 0) 
		{
			for (Department departmentTemp : departments) {
				Map<String, Object> deptMap = new HashMap<>();
				deptMap.put("id", departmentTemp.getId());
				deptMap.put("departmentName", departmentTemp.getDepartmentName());
				
				List<SysUser> users = sysUserRepository.findByDepartmentId(departmentTemp.getId());

				for (SysUser sysUser : users) {
					this.users.add(sysUser);
				}
				
				deptMap.put("users", users);
				
				List<Map<String, Object>> children = findProgenyUsers(departmentTemp);
				if (children.size() != 0) {
					deptMap.put("children", children);
					deptMap.put("state","closed");
				}
				
				retDepts.add(deptMap);
			}
		}
		
		return retDepts;
	}
	
	/**
	 * 查找后代节点的员工，返回list
	 * @param department
	 * @return List<Map<String,Object>>
	 */
	public List<SysUser> findUsers(Department department)	
	{
		this.users = new ArrayList<SysUser>();
		List<Map<String, Object>> depts = findProgenyUsers(department);
		return this.users;
	}
	
	/**
	 * 删除子节点
	 * @param department
	 * @return List<Map<String,Object>>
	 */
	public void deleteChildren(Department department) {

		List<Department> departments = new ArrayList<>();
				
		//根节点
		if (department == null) {
			departments = repository.findByParentDepartmentId(null);
		}else {
			departments = repository.findByParentDepartmentId(department.getId());
		}
		
		if (departments.size() != 0) 
		{
			for (Department departmentTemp : departments) 
			{
				deleteChildren(departmentTemp);
				repository.delete(departmentTemp);
			}
			repository.delete(department);
		}else {
			repository.delete(department);
		}
	}
	
	/**
	 * 根据条件查询部门
	 * @param departmentName
	 * @param parentDepartmentId
	 * @param delFlag
	 * @return
	 */
	public Page<Department> findDepts(String departmentName,String parentDepartmentId,String delFlag,Pageable pageable)
	{
		return repository.findDepts(departmentName, parentDepartmentId, delFlag,pageable);
	}
	
	/**
	 * 查询子部门
	 * @param parentDepartmentId
	 * @param pageable
	 * @return
	 */
	public Page<Department> findByParentDepartmentId(String parentDepartmentId,Pageable pageable)
	{
		List<Department> departments = repository.findByParentDepartmentId(parentDepartmentId);
		
		int startIndex = pageable.getPageNumber() * pageable.getPageSize();
		int pageSize = pageable.getPageSize();
		int total = departments.size();
		int endIndex = (startIndex + pageSize) > total ? total : (startIndex + pageSize);
		
		List<Department> departmentsTemp = new ArrayList<Department>();
		for (int i = startIndex; i < endIndex; i++) 
		{
			departmentsTemp.add(departments.get(i));
		}
		
		Page<Department> page = new PageImpl<Department>(departmentsTemp, pageable, total);
		
		return page;
	}
	
	/**
	 * 批量删除部门
	 * @param userIds
	 * @return
	 */
	public void deleteDepts(List<String> deptIds)
	{
		for (String id : deptIds) {
			
			Department department = repository.findOne(id);
			
			if (department != null) {
				deleteChildren(department);
			}
		}
	}

	@Override
	public List<Department> findAll()
	{
		return repository.findAll();
	}

	@Override
	public Department getOne(String id)
	{
		return repository.getOne(id);
	}

	@Override
	public Department findOne(String id)
	{
		return repository.findOne(id);
	}

	/**
	 * 查询子部门,不带分页
	 * @param parentDepartmentId
	 * @return
	 */
	@Override
	public List<Department> findByParentDepartmentId(String parentDepartmentId)
	{
		return repository.findByParentDepartmentId(parentDepartmentId);
	}

	/**
	 * 导出Deptexcel
	 * @param deptId
	 * @param response
	 */
	@Override
	public void outputDeptExcel(String deptId, HttpServletResponse response)
	{
		List<Department> departments = new ArrayList<Department>();
		
		String fileName = "部门-所有部门.xls"; //文件名 
		if (deptId == null || deptId.equals("")) {
			departments = findByParentDepartmentId(null);
		}else{
			departments = findByParentDepartmentId(deptId);
			Department department = findOne(deptId);
			fileName = "部门-"+department.getDepartmentName()+".xls"; //文件名 
		}
		
        String sheetName = "部门";//sheet名
        
        String []title = new String[]{"Id","部门名称","部门编号","上级部门"};//标题
        
        String [][]values = new String[departments.size()][];
        for(int i=0;i<departments.size();i++){
            values[i] = new String[title.length];
            //将对象内容转换成string
            Department obj = departments.get(i);
            values[i][0] = obj.getId()+"";
            values[i][1] = obj.getDepartmentName()+"";
            values[i][2] = obj.getDepartmentNumber()+"";
            values[i][3] = obj.getParentDepartment() == null ? "" : obj.getParentDepartment().getDepartmentName();
        }
        
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, values, null);
        
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
	 * 导出Deptpdf
	 * @param deptId
	 * @param response
	 */
	@Override
	public void outputDeptPDF(String deptId, HttpServletResponse response)
	{
		List<Department> departments = new ArrayList<Department>();
		
		String fileName = "部门-所有部门.pdf"; //文件名 
		if (deptId == null || deptId.equals("")) {
			departments = findByParentDepartmentId(null);
		}else{
			departments = findByParentDepartmentId(deptId);
			Department department = findOne(deptId);
			fileName = "部门-"+department.getDepartmentName()+".pdf"; //文件名 
		}
		
        String sheetName = "部门";//sheet名
        
        String []title = new String[]{"Id","部门名称","部门编号","上级部门"};//标题
        
        String [][]values = new String[departments.size()][];
        for(int i=0;i<departments.size();i++){
            values[i] = new String[title.length];
            //将对象内容转换成string
            Department obj = departments.get(i);
            values[i][0] = obj.getId()+"";
            values[i][1] = obj.getDepartmentName()+"";
            values[i][2] = obj.getDepartmentNumber()+"";
            values[i][3] = obj.getParentDepartment() == null ? "" : obj.getParentDepartment().getDepartmentName();
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
	 
}
