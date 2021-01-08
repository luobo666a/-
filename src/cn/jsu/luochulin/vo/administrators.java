package cn.jsu.luochulin.vo;

public class administrators {
	/*管理员类，属性有管理员账号，管理员密码*/
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
