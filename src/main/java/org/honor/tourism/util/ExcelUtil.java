package org.honor.tourism.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.honor.tourism.entity.Department;
import org.honor.tourism.entity.SysUser;
import org.honor.tourism.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 作者:修罗大人
 * 日期:Feb 13, 2017
 * 时间:2:55:56 PM
 */

public class ExcelUtil {
	
	/**
	 * 导出excel
	 * @param sheetName
	 * @param title
	 * @param values
	 * @param wb
	 * @return
	 */
	public static HSSFWorkbook getHSSFWorkbook(String sheetName,String []title,String [][]values, HSSFWorkbook wb){

		//1、创建一个workbook对应工作簿
		if (wb == null) {
			wb = new HSSFWorkbook();
		}
		
		//2、在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet(sheetName);
		
		//3、在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short 
		HSSFRow row = sheet.createRow(0);
		
		//4、创建单元格，并设置值表头 设置表头居中  
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		HSSFCell cell = null;
		///创建标题
		for (int i = 0; i < title.length; i++) 
		{
			cell = row.createCell(i);
			cell.setCellValue(title[i]);
			cell.setCellStyle(style);
		}
		
		//创建内容
        for(int i=0;i<values.length;i++){
            row = sheet.createRow(i + 1); 
            for(int j=0;j<values[i].length;j++){
                 row.createCell(j).setCellValue(values[i][j]);
            }
        }
		
		return wb;
	}

	/**
	 * 导入excel
	 * @param fileInputStream
	 * @return
	 */
	public static List<SysUser> inputExcel(InputStream inputStream,DepartmentRepository repository){
		
		List<SysUser> users = new ArrayList<SysUser>();
		try {
			HSSFWorkbook wb = new HSSFWorkbook(inputStream);
			SysUser user = null;
			
			//循环工作簿sheet
			
			for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++) 
			{
				HSSFSheet sheet = wb.getSheetAt(numSheet);
				if (sheet == null) continue;
				
				//循环row
				int rows = sheet.getLastRowNum() + 1;
				for (int rowIndex = 1; rowIndex < rows; rowIndex++) 
				{
					HSSFRow row = sheet.getRow(rowIndex);
					if (row != null) {
						user = new SysUser();
						HSSFCell id = row.getCell(0);
						HSSFCell name = row.getCell(1);
						HSSFCell username = row.getCell(2);
						HSSFCell departmentName = row.getCell(3);
						HSSFCell departmentId = row.getCell(4);
						HSSFCell duty = row.getCell(5);
						HSSFCell mobilePhone = row.getCell(6);
						HSSFCell phone = row.getCell(7);
						
						user.setName(getValue(name));
						user.setUsername(getValue(username));
						String deptId = getValue(departmentId);
						Department department = repository.findOne(deptId);
						user.setDepartment(department);
						user.setDuty(getValue(duty));
						user.setMobilePhone(getValue(mobilePhone));
						user.setPhone(getValue(phone));
						
						users.add(user);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	private static String getValue(HSSFCell hssfCell) {
		 if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
		     // 返回布尔类型的值
		     return String.valueOf(hssfCell.getBooleanCellValue());
		 } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
		     // 返回数值类型的值
		     return String.valueOf(hssfCell.getNumericCellValue());
		 } else {
		     // 返回字符串类型的值
		         return String.valueOf(hssfCell.getStringCellValue());
		}
	}
	
}
