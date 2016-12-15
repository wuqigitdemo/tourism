package org.honor.tourism.util;

/**
 * easyui分页参数
 * 
 * @author keiwu
 *
 */
public class EasyuiPage {

	private Integer page;
	private Integer rows;
	
	public Integer getPage() {
		Integer retPage = new Integer(page);
		retPage-=1;
		if (retPage < 0) {
			return 0;
		}
		return retPage;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

}
