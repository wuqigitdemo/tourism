package org.honor.tourism.util;

import java.io.FileOutputStream;
import java.io.OutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 作者:修罗大人
 * 日期:Feb 13, 2017
 * 时间:4:34:25 PM
 */

public class PDFUtil {
	public static PdfWriter getPDFWriter(String []title,String [][]values,OutputStream os) {
		Document document =new Document(PageSize.A4,50,50,30,20);
		
		PdfWriter writer = null;
		try {
            writer = PdfWriter.getInstance(document,os);
            
            document.open();

            PdfPTable table = new PdfPTable(title.length); 
            
            table.setWidthPercentage(100); // Width 100%
            table.setSpacingBefore(10f); // Space before table
            table.setSpacingAfter(10f); // Space after table

            // Set Column widths
//            float[] columnWidths = { 1f, 1f, 1f,1f };
//            table.setWidths(columnWidths);

            BaseFont baseFont = BaseFont.createFont("STSongStd-Light","UniGB-UCS2-H",false);
		    Font font = new Font(baseFont); 
		    
            //创建标题
            for (int i = 0; i < title.length; i++) 
			{
            	PdfPCell cell = new PdfPCell(new Paragraph(title[i],font));
            	//cell.setBorderColor(BaseColor.BLUE);
            	//cell.setPaddingLeft(10);
            	cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            	cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            	table.addCell(cell);
			}
		    
	        //创建内容
		    for(int i=0;i<values.length;i++){
		        for(int j=0;j<values[i].length;j++){
		      	  PdfPCell cell = new PdfPCell(new Paragraph(values[i][j],font));
		      	  cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		       	  cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		       	  table.addCell(cell);
		        }
		    }
	        
            document.add(table);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return writer;
	}
}
