package cn.jsu.luochulin.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Workbook;

import cn.jsu.luochulin.dao.CoreFunctions;
import cn.jsu.luochulin.vo.commodity;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class ImportExcelDataChildfrm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImportExcelDataChildfrm frame = new ImportExcelDataChildfrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ImportExcelDataChildfrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ImportExcelDataChildfrm.class.getResource("/icon/\u5BFC\u5165\u6570\u636E\u56FE\u6807.png")));
		setTitle("\u5BFC\u5165Excel\u6570\u636E");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {// 重绘面板背景
				// 创建一个未初始化的图像图标，参考API
				ImageIcon icon = new ImageIcon("source" + File.separator + "/icon/登录背景.jpg");
				// 绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("\u5BFC\u5165Excel\u6570\u636E");
		btnNewButton.setIcon(new ImageIcon(ImportExcelDataChildfrm.class.getResource("/icon/\u5BFC\u5165\u6570\u636E\u56FE\u6807.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser(new File("."));//实例化文件选择框，"."表示当前项目文件位置
				jfc.setDialogTitle("导入数据");//设置标题，此行代码可选
				jfc.setApproveButtonText("选择Excel数据");//设置 “确定”按钮文字，可选
				jfc.setAcceptAllFileFilterUsed(false);//设置文件类型为全部文件不能用，可选
				FileNameExtensionFilter filter = new FileNameExtensionFilter("excel文件(*.xls,*.xlsx)", "xls","xlsx"); //限制文件只能显示xls\xlsx格式的文件
				jfc.addChoosableFileFilter(filter);//增加文件过滤，可选
				int result =jfc.showOpenDialog(null);//打开文件选择框
				if(result==JFileChooser.APPROVE_OPTION) {//如果文件选择框点击了确定按钮
				  File file=jfc.getSelectedFile();//获取选择文件
				  //通过上述程序获取此文件所有行，见下页PPT
				}
				File file=jfc.getSelectedFile();//获取选择的文件
				try(Workbook wb = new CoreFunctions().getWorkbook(file)){//创建工作簿对象
				    Vector<commodity> arr=new CoreFunctions().getExcelData(wb);//获取第一个工作表中的数据行
				  for(commodity a:arr) {//遍历每一行数据
				    new CoreFunctions().modifycommodity(a.getName(), a.getType(), a.getNumble(), a.getPrice()+1);
				  }
				  JOptionPane.showMessageDialog(null, "导入数据成功");
				  }catch(Exception e2) {
				    e2.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(109, 118, 209, 71);
		desktopPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u60A8\u53EF\u4EE5\u5728\u6B64\u754C\u9762\u5BFC\u5165Excel\u6570\u636E");
		lblNewLabel.setBounds(56, 54, 312, 28);
		desktopPane.add(lblNewLabel);
	}
}
