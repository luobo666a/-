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
/**查询窗口，读取表中数据转换成Vector集合，加载到DefaultTableModel数据模型，JTable表格使用此数据模型*/
public class QueryChildfrm extends JFrame {
	
	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型
	private JTextField txtKey;

	public static void main(String[] args) {
		QueryChildfrm frame = new QueryChildfrm();// 实例化窗体
		frame.setLocationRelativeTo(null);// 窗体居中
		frame.setVisible(true);// 窗体可见
	}

	/**
	 * 定义构造方法创建窗体及组件.
	 */
	public QueryChildfrm() {
		setTitle("\u67E5\u8BE2\u5546\u54C1\u4FE1\u606F");
		setIconImage(Toolkit.getDefaultToolkit().getImage(QueryChildfrm.class.getResource("/icon/\u67E5\u8BE2\u5546\u54C1\u56FE\u6807.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 设置窗体关闭按钮
		setBounds(100, 100, 612, 399);// 设置窗体位置与大小
		contentPane = new JPanel();// 实例化内容面板
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		setContentPane(contentPane);// 将窗体默认面板

		// 设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(0, 78, 594, 274);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

		// 使用动态数组数据（列标题与行数据）
		Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "商品名", "类型", "数量","价格");
//		使用静态数据创建DefaultTableModel数据模型
		Vector<commodity> data=new CoreFunctions().Exhibitiondata();
		Vector<Vector> data1=new Vector<Vector>();
		for(commodity a1:data) {
			Vector A=new Vector();
			Collections.addAll(A,a1.getName(),a1.getType(),a1.getNumble(),a1.getPrice());
			Collections.addAll(data1,A);
		}

//		使用静态数据创建DefaultTableModel数据模型
		model = new DefaultTableModel(data1, titles) {// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
			public Class getColumnClass(int column) {//获取列的类型
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		TableRowSorter sorter = new TableRowSorter<DefaultTableModel>(model);//设置排序器
		table.setRowSorter(sorter);//设置表格的排序器
		ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();//设置排序的集合，
		sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));//设置第一种排序方式：第1个参数2，为排序字段，指明为3第个字段cj，第2个参数为升序
		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));//如果第一种排序有相同值，设置第二种排序方式：第1个参数0，为排序字段，指明为1第个字段xh，第2个参数为升序
		sorter.setSortKeys(sortKeys);//设置排序器的排序规则

		scrollPane.setViewportView(table);// 设置使用滚动面板显示表格，如果不使用滚动面板显示，则表格的列标题无法显示
		
		JLabel lblKey = new JLabel("\u8BF7\u8F93\u5165\u60A8\u8981\u67E5\u627E\u7684\u5546\u54C1\u7684\u5173\u952E\u5B57\uFF1A");
		lblKey.setBounds(14, 29, 248, 20);
		contentPane.add(lblKey);
		
		txtKey = new JTextField();
		txtKey.setBounds(241, 28, 155, 21);
		contentPane.add(txtKey);
		txtKey.setColumns(10);
		
		JButton btnFind = new JButton("查找");
		btnFind.setIcon(new ImageIcon(QueryChildfrm.class.getResource("/icon/\u67E5\u8BE2\u5546\u54C1\u56FE\u6807.png")));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key=txtKey.getText().trim();//获取输入关键字文本框的值
				if(key.length()!=0) {
					sorter.setRowFilter(RowFilter.regexFilter(key));//是否包含输入框的值
				}else {
					sorter.setRowFilter(null);//不过滤，显示所有数据
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
