package cn.jsu.luochulin.vo;

import java.io.Serializable;

public class commodity implements Serializable {
	/*��Ʒ�࣬��������Ʒ�������࣬��Ʒ�������۸�*/
	private String name;//��Ʒ��
	private String type;//����
	private int numble;//��Ʒ����
	private int price;//�۸�
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNumble() {
		return numble;
	}
	public void setNumble(int numble) {
		this.numble = numble;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public commodity(String name, String type, int numble, int price) {
		super();
		this.name = name;
		this.type = type;
		this.numble = numble;
		this.price = price;
	}
	@Override
	public String toString() {
		return "��Ʒ��" + name + "	����=" + type + "	����" + numble + "	�۸�" + price;
	}
}