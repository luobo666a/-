package cn.jsu.luochulin.frm;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
/**登录和注册窗口*/
public class SignInAndRegisterfrm extends JFrame {
              
	private JPanel contentPane;
	private JTextField AccountNumber;
	private JTextField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignInAndRegisterfrm frame = new SignInAndRegisterfrm();
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
	public SignInAndRegisterfrm() {
		setResizable(false);
		setTitle("\u767B\u5F55\u7A97\u53E3");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignInAndRegisterfrm.class.getResource("/icon/\u5343\u5E93\u7F51_\u690D\u7269\u7684\u53F6\u5B50\u56FE\u6807_\u5143\u7D20\u7F16\u53F712031916_\u526F\u672C.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7BA1\u7406\u5458\u8D26\u53F7\uFF1A");
		lblNewLabel.setBounds(48, 57, 98, 18);
		contentPane.add(lblNewLabel);
		
		AccountNumber = new JTextField();
		AccountNumber.setBounds(160, 54, 159, 24);
		contentPane.add(AccountNumber);
		AccountNumber.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7BA1\u7406\u5458\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(48, 128, 98, 18);
		contentPane.add(lblNewLabel_1);
		
		Password = new JTextField();
		Password.setBounds(160, 125, 159, 24);
		contentPane.add(Password);
		Password.setColumns(10);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setIcon(new ImageIcon(SignInAndRegisterfrm.class.getResource("/icon/\u767B\u5F55\u7BA1\u7406\u5458\u56FE\u6807.png")));
		btnNewButton.addActionListener(new ActionListener() {
			/**判断账号密码方法，接收文本框输入的字段使用BufferedReader一行一行读取文件存入字符串数组中 判断管理员账号密码*/
			public void actionPerformed(ActionEvent e) {
				boolean flog=false;
				File file=new File("Supermarket management system.txt");
				try {
					BufferedReader br = new BufferedReader(new FileReader(file));
					String AccountNumber1=AccountNumber.getText();
					String Password1=Password.getText();
					String a=null;
					try {
						while((a=br.readLine())!=null) {
							String[] s1 = a.split("\t");
							if(AccountNumber1.equalsIgnoreCase(s1[0])&&Password1.equalsIgnoreCase(s1[1])) {
								flog=true;
								break;
							}
						}
						if(flog==true) {
							Mainfrm a1=new Mainfrm();
							a1.setVisible(true);
						}else {
							JOptionPane.showMessageDialog(null, "密码错误");
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}//登录按钮 通过BufferedReader一行一行读取文件存入字符串数组中 判断管理员账号密码
		});
		btnNewButton.setBounds(33, 185, 113, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6CE8\u518C");
		btnNewButton_1.setIcon(new ImageIcon(SignInAndRegisterfrm.class.getResource("/icon/\u6CE8\u518C\u7BA1\u7406\u5458\u56FE\u6807.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterChildfrm a1=new RegisterChildfrm();
				a1.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(259, 185, 113, 41);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SignInAndRegisterfrm.class.getResource("/icon/\u767B\u5F55\u80CC\u666F.jpg")));
		lblNewLabel_2.setBounds(0, 0, 444, 265);
		contentPane.add(lblNewLabel_2);
	}
}
