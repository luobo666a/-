package cn.jsu.luochulin.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.jsu.luochulin.dao.CoreFunctions;

import java.awt.Toolkit;
import java.io.File;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**向数据库的商品表中添加新商品修改已有商品信息，修改商品窗口*/
public class ModifyChildfrm extends JFrame {
	
	private JPanel contentPane;
	private JTextField name;
	private JTextField type;
	private JTextField numble;
	private JTextField price;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifyChildfrm frame = new ModifyChildfrm();
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
	public ModifyChildfrm() {
		setTitle("\u4FEE\u6539\u548C\u589E\u52A0\u65B0\u5546\u54C1");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModifyChildfrm.class.getResource("/icon/\u4FEE\u6539\u5546\u54C1\u56FE\u6807.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 527, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JDesktopPane desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {//重绘面板背景
				//创建一个未初始化的图像图标，参考API
				ImageIcon icon=new ImageIcon("source"+File.separator+"/icon/进货窗体背景.jpg");
				//绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u60A8\u60F3\u4FEE\u6539\u7684\u5546\u54C1\u540D\u6216\u589E\u52A0\u7684\u65B0\u5546\u54C1\u7684\u5546\u54C1\u540D\uFF1A");
		lblNewLabel.setBounds(14, 19, 313, 32);
		desktopPane.add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(319, 23, 134, 24);
		desktopPane.add(name);
		name.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u4FEE\u6539\u540E\u7C7B\u578B\uFF1A");
		lblNewLabel_1.setBounds(31, 64, 128, 32);
		desktopPane.add(lblNewLabel_1);
		
		type = new JTextField();
		type.setBounds(154, 68, 112, 24);
		desktopPane.add(type);
		type.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u4FEE\u6539\u540E\u6570\u91CF \uFF1A");
		lblNewLabel_2.setBounds(31, 119, 109, 18);
		desktopPane.add(lblNewLabel_2);
		
		numble = new JTextField();
		numble.setBounds(154, 116, 112, 24);
		desktopPane.add(numble);
		numble.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u4FEE\u6539\u540E\u4EF7\u683C\uFF1A");
		lblNewLabel_3.setBounds(31, 166, 109, 18);
		desktopPane.add(lblNewLabel_3);
		
		price = new JTextField();
		price.setBounds(154, 163, 112, 24);
		desktopPane.add(price);
		price.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(ModifyChildfrm.class.getResource("/icon/\u4FEE\u6539\u5546\u54C1\u56FE\u6807.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name1=name.getText();
				String type1=type.getText();
				int numble1=Integer.valueOf(numble.getText());
				int price1=Integer.valueOf(price.getText());	
				try {
					new CoreFunctions().modifycommodity(name1,type1,numble1,price1);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "进货成功！");
			}
		});
		btnNewButton.setBounds(153, 209, 113, 41);
		desktopPane.add(btnNewButton);
	}
}
