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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
/**删除商品窗口*/
public class DeleteChildfrm extends JFrame {
         
	private JPanel contentPane;
	private JTextField commodityname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteChildfrm frame = new DeleteChildfrm();
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
	public DeleteChildfrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteChildfrm.class.getResource("/icon/\u5220\u9664\u5546\u54C1\u56FE\u6807.png")));
		setTitle("\u5220\u9664\u5546\u54C1");
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
				ImageIcon icon = new ImageIcon("source" + File.separator + "/icon/主窗体背景.jpg");
				// 绘制指定图像中已缩放到适合指定矩形内部的图像，参考API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u60A8\u60F3\u5220\u9664\u7684\u5546\u54C1\u7684\u5546\u54C1\u540D\uFF1A");
		lblNewLabel.setBounds(32, 49, 225, 18);
		desktopPane.add(lblNewLabel);
		
		commodityname = new JTextField();
		commodityname.setBounds(256, 46, 132, 24);
		desktopPane.add(commodityname);
		commodityname.setColumns(10);
		
		JButton btnNewButton = new JButton("\u5220\u9664");
		btnNewButton.setIcon(new ImageIcon(DeleteChildfrm.class.getResource("/icon/\u5220\u9664\u5546\u54C1\u56FE\u6807.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=commodityname.getText();
				new CoreFunctions().deletecommodity(name);
				JOptionPane.showMessageDialog(null, "删除商品成功！");
			}
		});
		btnNewButton.setBounds(63, 126, 132, 37);
		desktopPane.add(btnNewButton);
	}

}
