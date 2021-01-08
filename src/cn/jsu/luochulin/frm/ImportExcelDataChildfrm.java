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
			public void paintComponent(Graphics g) {// �ػ���屳��
				// ����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon = new ImageIcon("source" + File.separator + "/icon/��¼����.jpg");
				// ����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("\u5BFC\u5165Excel\u6570\u636E");
		btnNewButton.setIcon(new ImageIcon(ImportExcelDataChildfrm.class.getResource("/icon/\u5BFC\u5165\u6570\u636E\u56FE\u6807.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc=new JFileChooser(new File("."));//ʵ�����ļ�ѡ���"."��ʾ��ǰ��Ŀ�ļ�λ��
				jfc.setDialogTitle("��������");//���ñ��⣬���д����ѡ
				jfc.setApproveButtonText("ѡ��Excel����");//���� ��ȷ������ť���֣���ѡ
				jfc.setAcceptAllFileFilterUsed(false);//�����ļ�����Ϊȫ���ļ������ã���ѡ
				FileNameExtensionFilter filter = new FileNameExtensionFilter("excel�ļ�(*.xls,*.xlsx)", "xls","xlsx"); //�����ļ�ֻ����ʾxls\xlsx��ʽ���ļ�
				jfc.addChoosableFileFilter(filter);//�����ļ����ˣ���ѡ
				int result =jfc.showOpenDialog(null);//���ļ�ѡ���
				if(result==JFileChooser.APPROVE_OPTION) {//����ļ�ѡ�������ȷ����ť
				  File file=jfc.getSelectedFile();//��ȡѡ���ļ�
				  //ͨ�����������ȡ���ļ������У�����ҳPPT
				}
				File file=jfc.getSelectedFile();//��ȡѡ����ļ�
				try(Workbook wb = new CoreFunctions().getWorkbook(file)){//��������������
				    Vector<commodity> arr=new CoreFunctions().getExcelData(wb);//��ȡ��һ���������е�������
				  for(commodity a:arr) {//����ÿһ������
				    new CoreFunctions().modifycommodity(a.getName(), a.getType(), a.getNumble(), a.getPrice()+1);
				  }
				  JOptionPane.showMessageDialog(null, "�������ݳɹ�");
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
