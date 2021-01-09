package cn.jsu.luochulin.vo;

import java.io.Serializable;

public class commodity implements Serializable {
	/*商品类，属性有商品名，种类，商品数量，价格*/
	private String name;//商品名
	private String type;//种类
	private int numble;//商品数量
	private int price;//价格
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
		return "商品名" + name + "	类型=" + type + "	数量" + numble + "	价格" + price;
	}
}