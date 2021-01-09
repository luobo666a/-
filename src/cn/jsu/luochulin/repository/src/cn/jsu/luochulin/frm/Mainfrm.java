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
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
/** 主窗体窗口 */
public class Mainfrm extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainfrm frame = new Mainfrm();
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
	public Mainfrm() {
		setResizable(false);
		setTitle("\u8D85\u5E02\u7BA1\u7406\u7CFB\u7EDF");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Mainfrm.class.getResource(
				"/icon/\u5343\u5E93\u7F51_\u690D\u7269\u7684\u53F6\u5B50\u56FE\u6807_\u5143\u7D20\u7F16\u53F712031916_\u526F\u672C.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 846, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JDesktopPane desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {// 重绘面板背景
				// 创建一个未初始化的图像图标，参考API
				ImageIcon icon = new ImageIcon("source" + File.separator + "/icon/主窗体背景.jpg");
				// 绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};

		contentPane.add(desktopPane, BorderLayout.CENTER);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 830, 38);
		desktopPane.add(menuBar);

		JMenu mnNewMenu = new JMenu("\u8D27\u54C1\u7BA1\u7406");
		mnNewMenu.setIcon(new ImageIcon(Mainfrm.class.getResource("/icon/\u8D27\u54C1\u7BA1\u7406\u56FE\u6807.png")));
		mnNewMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("\u8FDB\u8D27");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseChildfrm a=new PurchaseChildfrm();
				a.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u4FEE\u6539\u5546\u54C1\u4FE1\u606F");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyChildfrm a=new ModifyChildfrm();
				a.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u5220\u9664\u5546\u54C1");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteChildfrm a1=new DeleteChildfrm();
				a1.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenu mnNewMenu_1 = new JMenu("\u67E5\u8BE2\u5546\u54C1\u4FE1\u606F");
		mnNewMenu_1.setIcon(new ImageIcon(Mainfrm.class.getResource("/icon/\u67E5\u8BE2\u5546\u54C1\u56FE\u6807.png")));
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u67E5\u8BE2\u4ECA\u65E5\u5546\u54C1\u4FE1\u606F");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryChildfrm a = new QueryChildfrm();
				a.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("\u6253\u5370\u5546\u54C1\u4FE1\u606F");
		mnNewMenu_2.setIcon(new ImageIcon(Mainfrm.class.getResource("/icon/\u6253\u5370\u56FE\u6807.png")));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("\u6253\u5370\u5546\u54C1\u4FE1\u606F");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new CoreFunctions().PrintExcel();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("\u8D2D\u4E70\u5546\u54C1");
		mnNewMenu_3.setIcon(new ImageIcon(Mainfrm.class.getResource("/icon/\u8D2D\u4E70\u5546\u54C1\u56FE\u6807.png")));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u8D2D\u4E70\u5546\u54C1");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseGoodsChildfrm a=new PurchaseGoodsChildfrm();
				a.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_5);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(-13, 36, 843, 47);
		desktopPane.add(toolBar);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteChildfrm a=new DeleteChildfrm();
				a.setVisible(true);
			}
		});
		
		JButton btnNewButton_4 = new JButton("");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PurchaseChildfrm a=new PurchaseChildfrm();
				a.setVisible(true);
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(Mainfrm.class.getResource("/icon/\u8FDB\u8D27\u56FE\u6807.png")));
		toolBar.add(btnNewButton_4);
		btnNewButton_1.setIcon(new ImageIcon(Mainfrm.class.getResource("/icon/\u5220\u9664\u5546\u54C1\u56FE\u6807.png")));
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryChildfrm a=new QueryChildfrm();
				a.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Mainfrm.class.getResource("/icon/\u67E5\u8BE2\u5546\u54C1\u56FE\u6807.png")));
		toolBar.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyChildfrm a=new ModifyChildfrm();
				a.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Mainfrm.class.getResource("/icon/\u4FEE\u6539\u5546\u54C1\u56FE\u6807.png")));
		toolBar.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImportExcelDataChildfrm a=new ImportExcelDataChildfrm();
				a.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Mainfrm.class.getResource("/icon/\u5BFC\u5165\u6570\u636E\u56FE\u6807.png")));
		toolBar.add(btnNewButton);
	}
}
