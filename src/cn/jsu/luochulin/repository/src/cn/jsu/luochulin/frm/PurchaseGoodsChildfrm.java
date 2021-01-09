package cn.jsu.luochulin.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.jsu.luochulin.dao.CoreFunctions;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PurchaseGoodsChildfrm extends JFrame {

	private JPanel contentPane;
	private JTextField commodityname;
	private JTextField commoditynumble;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseGoodsChildfrm frame = new PurchaseGoodsChildfrm();
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
	public PurchaseGoodsChildfrm() {
		setTitle("\u8D2D\u4E70\u5546\u54C1");
		setIconImage(Toolkit.getDefaultToolkit().getImage(PurchaseGoodsChildfrm.class.getResource("/icon/\u8D2D\u4E70\u5546\u54C1\u56FE\u6807.png")));
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
				ImageIcon icon = new ImageIcon("source" + File.separator + "/icon/进货背景.jpg");
				// 绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u60A8\u60F3\u8D2D\u4E70\u7684\u5546\u54C1\u540D\uFF1A");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(52, 44, 170, 26);
		desktopPane.add(lblNewLabel);
		
		commodityname = new JTextField();
		commodityname.setBounds(255, 45, 120, 24);
		desktopPane.add(commodityname);
		commodityname.setColumns(10);
		
		JButton btnNewButton = new JButton("\u8D2D\u4E70\u5546\u54C1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=commodityname.getText();
				int numble=Integer.valueOf(commoditynumble.getText());
				new CoreFunctions().Purchasegoods(name, numble);
			}
		});
		btnNewButton.setIcon(new ImageIcon(PurchaseGoodsChildfrm.class.getResource("/icon/\u8D2D\u4E70\u5546\u54C1\u56FE\u6807.png")));
		btnNewButton.setBounds(93, 143, 129, 36);
		desktopPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u60A8\u60F3\u8D2D\u4E70\u7684\u5546\u54C1\u7684\u6570\u91CF\uFF1A");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(30, 97, 192, 18);
		desktopPane.add(lblNewLabel_1);
		
		commoditynumble = new JTextField();
		commoditynumble.setBounds(255, 94, 120, 24);
		desktopPane.add(commoditynumble);
		commoditynumble.setColumns(10);
	}
}
