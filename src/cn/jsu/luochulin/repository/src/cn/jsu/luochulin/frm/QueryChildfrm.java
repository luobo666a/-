package cn.jsu.luochulin.frm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import cn.jsu.luochulin.dao.CoreFunctions;
import cn.jsu.luochulin.vo.commodity;

import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Toolkit;
/**��ѯ���ڣ���ȡ��������ת����Vector���ϣ����ص�DefaultTableModel����ģ�ͣ�JTable���ʹ�ô�����ģ��*/
public class QueryChildfrm extends JFrame {
	
	private JPanel contentPane;// ���崰��������壬���ø����
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private JTextField txtKey;

	public static void main(String[] args) {
		QueryChildfrm frame = new QueryChildfrm();// ʵ��������
		frame.setLocationRelativeTo(null);// �������
		frame.setVisible(true);// ����ɼ�
	}

	/**
	 * ���幹�췽���������弰���.
	 */
	public QueryChildfrm() {
		setTitle("\u67E5\u8BE2\u5546\u54C1\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage(QueryChildfrm.class.getResource("/icon/\u67E5\u8BE2\u5546\u54C1\u56FE\u6807.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// ���ô���رհ�ť
		setBounds(100, 100, 612, 399);// ���ô���λ�����С
		contentPane = new JPanel();// ʵ�����������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		setContentPane(contentPane);// ������Ĭ�����

		// ���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(0, 78, 594, 274);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		Vector<String> titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "��Ʒ��", "����", "����","�۸�");
//		ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		Vector<commodity> data=new CoreFunctions().Exhibitiondata();
		Vector<Vector> data1=new Vector<Vector>();
		for(commodity a1:data) {
			Vector A=new Vector();
			Collections.addAll(A,a1.getName(),a1.getType(),a1.getNumble(),a1.getPrice());
			Collections.addAll(data1,A);
		}

//		ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		model = new DefaultTableModel(data1, titles) {// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
			public Class getColumnClass(int column) {//��ȡ�е�����
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//����������
		table.setRowSorter(sorter);//���ñ���������
		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();//��������ļ��ϣ�
		sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));//���õ�һ������ʽ����1������2��Ϊ�����ֶΣ�ָ��Ϊ3�ڸ��ֶ�cj����2������Ϊ����
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));//�����һ����������ֵͬ�����õڶ�������ʽ����1������0��Ϊ�����ֶΣ�ָ��Ϊ1�ڸ��ֶ�xh����2������Ϊ����
		sorter.setSortKeys(sortKeys);//�������������������

		scrollPane.setViewportView(table);// ����ʹ�ù��������ʾ��������ʹ�ù��������ʾ��������б����޷���ʾ
		
		JLabel lblKey = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u627E\u7684\u5546\u54C1\u7684\u5173\u952E\u5B57\uFF1A");
		lblKey.setBounds(14, 29, 248, 20);
		contentPane.add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setBounds(241, 28, 155, 21);
		contentPane.add(txtKey);
		txtKey.setColumns(10);
		
		JButton btnFind = new JButton("����");
		btnFind.setIcon(new ImageIcon(QueryChildfrm.class.getResource("/icon/\u67E5\u8BE2\u5546\u54C1\u56FE\u6807.png")));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=txtKey.getText().trim();//��ȡ����ؼ����ı����ֵ
				if(key.length()!=0) {
					sorter.setRowFilter(RowFilter.regexFilter(key));//�Ƿ����������ֵ
				}else {
					sorter.setRowFilter(null);//�����ˣ���ʾ��������
				}
				
			}
		});
		btnFind.setBounds(439, 27, 141, 32);
		contentPane.add(btnFind);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(QueryChildfrm.class.getResource("/icon/\u4E3B\u7A97\u4F53\u80CC\u666F.jpg")));
		lblNewLabel.setBounds(0, -2, 594, 354);
		contentPane.add(lblNewLabel);
	}
}
