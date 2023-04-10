public class Participant {
	
//initializations
private String name, birthday, phone, address;
private int money = 0;
private Boolean hasLifeline_DD = true, hasLifeline_50 = true;

//constructing Participant object
public Participant(String input0,String input1,String input2, String input3) {
name = input0;
birthday = input1;
phone = input2;
address = input3;
money = 0;
}

//getters and setters
public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getBirthday() {
	return birthday;
}

public void setBirthday(String birthday) {
	this.birthday = birthday;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getMoney() {
	return money;
}

public void setMoney(int money) {
	this.money = money;
}

public Boolean hasLifeline_DD() {
	return hasLifeline_DD;
}

public Boolean hasLifeline_50() {
	return hasLifeline_50;
}

public void setLifeline_DD(Boolean hasLifeline_DD) {
	this.hasLifeline_DD = hasLifeline_DD;
}

public void setLifeline_50(Boolean hasLifeline_50) {
	this.hasLifeline_50 = hasLifeline_50;
}


}