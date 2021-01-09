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
	/**���Ĺ����࣬ʵ�����ݿ������ɾ���飬�ġ�*/
	 private Connection conn = null;
	    private PreparedStatement stmt = null;
	    /**�����ݿ�����������Ʒ��Ϣ���޸�ԭ����Ʒ����Ϣ*/
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
	    /**�����ݿ��в�����Ʒ��Ϣ,���ز��ҵ���Ʒ������*/
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
	    /**�����ݿ���ɾ����Ʒ*/
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
	    /**������ѯ����commodity�����������ݵ���jtable�����չʾ������Vector���Ϸ���Ϊʵ����commodity*/
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
	    /**��������,���ַ���ƴ����ʵ��ִ��sql���*/
	    public void Purchase(String name,int numble) {
	    	int numbleOn=selectnumble(name)+numble;
	    	String sql="update carrot.commodity set numble = "+numbleOn+" where name = '"+name+"'";
	    	DatabaseConnectionMySql DbCM=new DatabaseConnectionMySql();
            conn = DbCM.getConnection();
            try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "�����ɹ�");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    /**��ȡExcel����е����ݣ������ݴ���Vector�����з��ؼ���*/
	    public Vector<commodity> getExcelData(Workbook wb) {
	    	  Vector<commodity> commodity=new Vector<commodity>();
	    	  Sheet sheet=wb.getSheetAt(0);//�õ�Excel��1�����������
	    	  for(int i=1;i<sheet.getPhysicalNumberOfRows();i++) {//���������������������У��ӵ�2�п�ʼ����1��Ϊ�б���
	    	    Row row=sheet.getRow(i);//�õ�Excel������ĵ�1��
	    	    Cell cell=row.getCell(0);//��ȡ��һ�е�һ����Ԫ��
	    	    cell.setCellType(CellType.STRING);//���õ�Ԫ������Ϊ�ַ���
	    	    String name=cell.getStringCellValue();//��ȡ��Ԫ���ֵ
	    	    String type=row.getCell(1).toString();	    	    
	    	    int numble=(int)row.getCell(2).getNumericCellValue();
	    	    double price1=Double.valueOf(row.getCell(3).toString());
	    	    int price = (int)price1;
	    	    Collections.addAll(commodity, new commodity(name,type,numble,price));//���ĳ�е����е�Ԫ������
	    	  }
	    	  return commodity;
	    	}
	  /**��ȡexcel�ĵ����󣬲���Ϊָ��excel�ļ�*/
	    public Workbook getWorkbook(File file) throws FileNotFoundException, IOException {
	      Workbook wb=null;
	      if(file.getName().endsWith("xls")) {//����excel������ѡ��ͬ������ʵ�����ĵ�����
	        wb=new HSSFWorkbook(new FileInputStream(file));
	      }else if(file.getName().endsWith("xlsx")) {
	        wb=new XSSFWorkbook(new FileInputStream(file));
	      }
	      return wb;
	    }
	    /**��ӡ����*/
	    public void PrintExcel() throws IOException {
	    	  File file=new File("D:\\eclipse\\��ҵ\\Supermarket management system\\��ӡ���洢�ļ���/commodity.xlsx");//��λҪ������excel�ļ�
	    	  Workbook workbook=new XSSFWorkbook();//��������������
	    	  Sheet sheet = workbook.createSheet("��Ʒ��Ϣ��");//�������������
	    	  Row title = sheet.createRow(0);// �����ж����±��0��ʼ   	  
	    	  Cell c1 = title.createCell(0);//������Ԫ�񣬴�0��ʼ
	    	  c1.setCellValue("name");//��Ԫ����������
	    	  Cell c2 = title.createCell(1);
	    	  c2.setCellValue("type");
	    	  Cell c3 = title.createCell(2);
	    	  c3.setCellValue("numble");
	    	  Cell c4 = title.createCell(3);
	    	  c4.setCellValue("price");
	    	  Vector<commodity> a=Exhibitiondata();
	    	  int i=1;
	    	  for(commodity b:a) {
	    		  Row row = sheet.createRow(i);// �����ж����±��0��ʼ
	  			Cell cell1 = row.createCell(0);// ������Ԫ�񣬴�0��ʼ
	  			cell1.setCellValue(b.getName());
	  			Cell cell2 = row.createCell(1);
	  			cell2.setCellValue(b.getType());
	  			Cell cell3 = row.createCell(2);
	  			cell3.setCellValue(b.getNumble());
	  			Cell cell4 = row.createCell(3);
	  			cell4.setCellValue(b.getPrice());
	  			i++;
	    	  }
	    	  FileOutputStream fos=new FileOutputStream(file);//�������������
	    	  workbook.write(fos);//������д�뵽ָ����excel�ĵ�
	    	  fos.close();
	    	  JOptionPane.showMessageDialog(null, "��ӡExcel���ɹ�");
	    	}
	    /**������Ʒ����*/
	    public void Purchasegoods(String name,int numble) {
	    	int numbleOn=selectnumble(name)-numble;
	    	String sql="update carrot.commodity set numble = "+numbleOn+" where name = '"+name+"'";
	    	DatabaseConnectionMySql DbCM=new DatabaseConnectionMySql();
            conn = DbCM.getConnection();
            try {
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "������Ʒ�ɹ�");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}

