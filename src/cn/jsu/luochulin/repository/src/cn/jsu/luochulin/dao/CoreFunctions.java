package cn.jsu.luochulin.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.jsu.luochulin.dbc.DatabaseConnectionMySql;
import cn.jsu.luochulin.vo.commodity;

public class CoreFunctions {
	/**核心功能类，实现数据库的增，删，查，改。*/
	 private Connection conn = null;
	    private PreparedStatement stmt = null;
	    /**向数据库中增加新商品信息和修改原有商品的信息*/
	    public void modifycommodity(String name,String type,int numble,int price) throws SQLException {
	    	String sql = "replace into carrot.commodity(name,type,numble,price)values(?,?,?,?)";
	    	DatabaseConnectionMySql DbCM=new DatabaseConnectionMySql();
	    	conn=DbCM.getConnection();
	    	stmt = conn.prepareStatement(sql);
            stmt.setString(1,name);
            stmt.setString(2,type);
            stmt.setInt(3,numble);
            stmt.setInt(4,price);
            stmt.executeUpdate(); 
	    }
	    /**在数据库中查找商品信息,返回查找的商品的数量*/
	    public int selectnumble(String name){
	    	String sql = "select * from carrot.commodity where name = ? ";
	    	try{
	    		DatabaseConnectionMySql DbCM=new DatabaseConnectionMySql();
	            conn = DbCM.getConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1,name);
	            ResultSet rs = stmt.executeQuery();
	            if(rs.next()) {
	            	int numble1=rs.getInt(3);
	            	return numble1;
	            }
	        } catch (Exception e)
	        {
	            e.printStackTrace();
	        }
			return 0;
	    }
	    /**在数据库中删除商品*/
	    public void deletecommodity(String name) {
	    	String sql = "delete from carrot.commodity where name = ?";
	    	try{
	    		DatabaseConnectionMySql DbCM=new DatabaseConnectionMySql();
	            conn = DbCM.getConnection();
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1,name);
	            stmt.executeUpdate();
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        }
	    }
	    /**遍历查询整张commodity表，将表中数据导入jtable表格中展示，返回Vector集合泛型为实体类commodity*/
	    public Vector<commodity> Exhibitiondata(){
	    	String sql = "select * from carrot.commodity";
	    	Vector<commodity> data=new Vector<commodity>();
	    	DatabaseConnectionMySql DbCM=new DatabaseConnectionMySql();
	    	conn = DbCM.getConnection();
            try {
				stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					String name2=rs.getString(1);
	            	String type2=rs.getString(2);
	            	int numble2=Integer.valueOf(rs.getString(3));
	            	int price2=Integer.valueOf(rs.getString(4));
	            	Collections.addAll(data, new commodity(name2,type2,numble2,price2));
				}
				return data;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	    	
	    }
	    /**进货函数,用字符串拼接来实现执行sql语句*/
	    public void Purchase(String name,int numble) {
	    	int numbleOn=selectnumble(name)+numble;
	    	String sql="update carrot.commodity set numble = "+numbleOn+" where name = '"+name+"'";
	    	DatabaseConnectionMySql DbCM=new DatabaseConnectionMySql();
            conn = DbCM.getConnection();
            try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "进货成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    /**读取Excel表格中的数据，将数据存入Vector集合中返回集合*/
	    public Vector<commodity> getExcelData(Workbook wb) {
	    	  Vector<commodity> commodity=new Vector<commodity>();
	    	  Sheet sheet=wb.getSheetAt(0);//得到Excel第1个工作表对象
	    	  for(int i=1;i<sheet.getPhysicalNumberOfRows();i++) {//遍历工作表中所有数据行，从第2行开始，第1行为列标题
	    	    Row row=sheet.getRow(i);//得到Excel工作表的第1行
	    	    Cell cell=row.getCell(0);//获取第一行第一个单元格
	    	    cell.setCellType(CellType.STRING);//设置单元格类型为字符串
	    	    String name=cell.getStringCellValue();//获取单元格的值
	    	    String type=row.getCell(1).toString();	    	    
	    	    int numble=(int)row.getCell(2).getNumericCellValue();
	    	    double price1=Double.valueOf(row.getCell(3).toString());
	    	    int price = (int)price1;
	    	    Collections.addAll(commodity, new commodity(name,type,numble,price));//输出某行的所有单元格内容
	    	  }
	    	  return commodity;
	    	}
	  /**获取excel文档对象，参数为指定excel文件*/
	    public Workbook getWorkbook(File file) throws FileNotFoundException, IOException {
	      Workbook wb=null;
	      if(file.getName().endsWith("xls")) {//根据excel的类型选择不同的子类实例化文档对象
	        wb=new HSSFWorkbook(new FileInputStream(file));
	      }else if(file.getName().endsWith("xlsx")) {
	        wb=new XSSFWorkbook(new FileInputStream(file));
	      }
	      return wb;
	    }
	    /**打印函数*/
	    public void PrintExcel() throws IOException {
	    	  File file=new File("D:\\eclipse\\作业\\Supermarket management system\\打印表格存储文件夹/commodity.xlsx");//定位要操作的excel文件
	    	  Workbook workbook=new XSSFWorkbook();//创建工作簿对象
	    	  Sheet sheet = workbook.createSheet("商品信息表");//创建工作表对象
	    	  Row title = sheet.createRow(0);// 创建行对象，下标从0开始   	  
	    	  Cell c1 = title.createCell(0);//创建单元格，从0开始
	    	  c1.setCellValue("name");//单元格设置内容
	    	  Cell c2 = title.createCell(1);
	    	  c2.setCellValue("type");
	    	  Cell c3 = title.createCell(2);
	    	  c3.setCellValue("numble");
	    	  Cell c4 = title.createCell(3);
	    	  c4.setCellValue("price");
	    	  Vector<commodity> a=Exhibitiondata();
	    	  int i=1;
	    	  for(commodity b:a) {
	    		  Row row = sheet.createRow(i);// 创建行对象，下标从0开始
	  			Cell cell1 = row.createCell(0);// 创建单元格，从0开始
	  			cell1.setCellValue(b.getName());
	  			Cell cell2 = row.createCell(1);
	  			cell2.setCellValue(b.getType());
	  			Cell cell3 = row.createCell(2);
	  			cell3.setCellValue(b.getNumble());
	  			Cell cell4 = row.createCell(3);
	  			cell4.setCellValue(b.getPrice());
	  			i++;
	    	  }
	    	  FileOutputStream fos=new FileOutputStream(file);//创建输出流对象
	    	  workbook.write(fos);//将内容写入到指定的excel文档
	    	  fos.close();
	    	  JOptionPane.showMessageDialog(null, "打印Excel表格成功");
	    	}
	    /**购买商品函数*/
	    public void Purchasegoods(String name,int numble) {
	    	int numbleOn=selectnumble(name)-numble;
	    	String sql="update carrot.commodity set numble = "+numbleOn+" where name = '"+name+"'";
	    	DatabaseConnectionMySql DbCM=new DatabaseConnectionMySql();
            conn = DbCM.getConnection();
            try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "购买商品成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}

