package cn.jsu.luochulin.vo;

public class administrators {
	/*����Ա�࣬�����й���Ա�˺ţ�����Ա����*/
private String accountNumber;
private String password;
public String getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public administrators(String accountNumber, String password) {
	super();
	this.accountNumber = accountNumber;
	this.password = password;
}
@Override
public String toString() {
	return accountNumber + "	" + password;
}

}
