package cn.jsu.luochulin.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.jsu.luochulin.dao.CoreFunctions;

import java.awt.Toolkit;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
/**进货子窗口*/
public class PurchaseChildfrm extends JFrame {
              
	private JPanel contentPane;
	private JTextField CommodityName;
	private JTextField CommodityNumble;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseChildfrm frame = new PurchaseChildfrm();
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
	public PurchaseChildfrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(PurchaseChildfrm.class.getResource("/icon/\u8FDB\u8D27\u56FE\u6807.png")));
		setTitle("\u8FDB\u8D27");
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
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u5546\u54C1\u540D\uFF1A");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(34, 27, 120, 26);
		desktopPane.add(lblNewLabel);
		
		CommodityName = new JTextField();
		CommodityName.setBounds(159, 28, 120, 24);
		desktopPane.add(CommodityName);
		CommodityName.setColumns(10);
		
		CommodityNumble = new JTextField();
		CommodityNumble.setBounds(159, 92, 120, 26);
		desktopPane.add(CommodityNumble);
		CommodityNumble.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u8F93\u5165\u8FDB\u8D27\u6570\u91CF\uFF1A");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(34, 96, 120, 26);
		desktopPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u8FDB\u8D27");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name1=CommodityName.getText();
				int numble1=Integer.valueOf(CommodityNumble.getText());
				new CoreFunctions().Purchase(name1, numble1);
			}
		});
		btnNewButton.setIcon(new ImageIcon(PurchaseChildfrm.class.getResource("/icon/\u8FDB\u8D27\u56FE\u6807.png")));
		btnNewButton.setBounds(166, 166, 113, 36);
		desktopPane.add(btnNewButton);
	}
}
