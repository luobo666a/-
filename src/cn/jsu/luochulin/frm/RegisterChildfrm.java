package cn.jsu.luochulin.frm;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
/**注册管理员账号，将管理员账号存入文件，用\t隔开方便读入*/
public class RegisterChildfrm extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private static RegisterChildfrm cframe = null;//定义子窗体为私有
	//静态公开方法，只产生一个对象，synchronized保证线程案例
	public static synchronized RegisterChildfrm GetInstance() {
		if (cframe == null) {
			cframe = new RegisterChildfrm ();
		}
		return cframe;
}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterChildfrm frame = new RegisterChildfrm();
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
	public RegisterChildfrm() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegisterChildfrm.class.getResource("/icon/\u6CE8\u518C\u7BA1\u7406\u5458\u56FE\u6807.png")));
		setTitle("\u6CE8\u518C\u7BA1\u7406\u5458\u8D26\u53F7");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 661, 296);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel.setBounds(45, 23, 72, 41);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(45, 77, 72, 41);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 20));
		textField.setBounds(121, 30, 293, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.PLAIN, 20));
		textField_1.setBounds(121, 84, 293, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel Tip1 = new JLabel("");
		Tip1.setForeground(Color.RED);
		Tip1.setFont(new Font("宋体", Font.PLAIN, 20));
		Tip1.setBounds(448, 30, 214, 33);
		contentPane.add(Tip1);

		JLabel Tip2 = new JLabel("");
		Tip2.setToolTipText("");
		Tip2.setForeground(Color.RED);
		Tip2.setFont(new Font("宋体", Font.PLAIN, 20));
		Tip2.setBounds(448, 84, 214, 29);
		contentPane.add(Tip2);

		// 给JTextField添加焦点事件
		textField.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				String t1 = textField.getText();// 账号
				String t2 = textField_1.getText();// 密码

				Boolean flag = true;
				if (t1.length() == 0) {
					Tip1.setText("账号不能为空");
					flag = false;
				} else if (!t1.matches("\\d+")) {
					Tip1.setText("账号必须为整数");
					flag = false;
				} else {
					Tip1.setText("");
				}
			}
		});

		textField.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {

				if (e.getKeyChar() == KeyEvent.VK_ENTER) {

					textField_1.requestFocus();

				}
			}
		});
		// 给JTextField添加焦点事件
		textField_1.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) {
				String t2 = textField_1.getText();// 密码

				if (t2.length() == 0) {
					Tip2.setText("密码不能为空");
				} else {
					Tip2.setText("");
				}
			}
		});
		textField_1.addKeyListener(new KeyAdapter() {

			public void keyPressed(KeyEvent e) {
			}
		});

		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.setIcon(new ImageIcon(RegisterChildfrm.class.getResource("/icon/\u6CE8\u518C\u7BA1\u7406\u5458\u56FE\u6807.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String t1 = textField.getText();// 账号
				String t2 = textField_1.getText();// 密码

				Boolean flag = true;
				if (t1.length() == 0) {
					Tip1.setText("账号不能为空");
					flag = false;
				} else if (!t1.matches("\\d+")) {
					Tip1.setText("账号必须为整数");
					flag = false;
				} else {
					Tip1.setText("");
				}

				if (t2.length() == 0) {
					Tip2.setText("密码不能为空");
					flag = false;
				} else {
					Tip2.setText("");
				}
				if (flag) {

					addtotxt(t1, t2);
					textField.setText("");
					textField_1.setText("");

				}

			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(45, 150, 113, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(RegisterChildfrm.class.getResource("/icon/zzpic16850.jpg")));
		lblNewLabel_2.setBounds(0, 0, 676, 249);
		contentPane.add(lblNewLabel_2);

	}

/**创建管理员账号方法，使用FileWriter类实现文件的写入*/
	public static void addtotxt(String t1, String t2) {
		//该这里的路径
		File file = new File("Supermarket management system.txt");
		try (FileWriter fw = new FileWriter(file, true);
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);) {
			String row = null;

			while ((row = br.readLine())!=null) {

				if(row.contains(t1)) {
					JOptionPane.showMessageDialog(null, "此账号已存在，不能增加");
					return;
				}
			}

			fw.write(t1 + "\t" + t2 + "\n");
			JOptionPane.showMessageDialog(null, "管理员账号注册成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
}


