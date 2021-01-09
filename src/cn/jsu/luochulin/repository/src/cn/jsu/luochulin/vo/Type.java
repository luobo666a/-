package cn.jsu.luochulin.vo;
public class Type {
	private int ID;
	private String type;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Type(int iD, String type) {
		super();
		ID = iD;
		this.type = type;
	}
	@Override
	public String toString() {
		return "Type [ID=" + ID + ", type=" + type + "]";
	}
	
}
