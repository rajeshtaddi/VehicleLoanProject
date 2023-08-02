package VehicleLoan;

public class Loan{
	private String vehicleModel;
private double price;
private double tentureOfLoan;
private final float interestRate=0.00720f;//8.65
private double downPayment;
private int creditScore;
//private double principalAmount;
private String name;
private String userId;
private String passWord;
private int age;
private double salary;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getPassWord() {
	return passWord;
}
public void setPassWord(String passWord) {
	this.passWord = passWord;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public void setCreditScore(int creditScore) {
	this.creditScore=creditScore;
}
public int getCreditScore() {
	return creditScore;
}
public String getVehicleModel() {
	return vehicleModel;
}
public void setVehicleModel(String vehicleModel) {
	this.vehicleModel = vehicleModel;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public double getTentureOfLoan() {
	return tentureOfLoan;
}
public void setTentureOfLoan(double tentureOfLoan) {
	this.tentureOfLoan = tentureOfLoan;
}
public double getInterestRate() {
	return interestRate;
}
public double getDownPayment() {
	return downPayment;
}
public void setDownPayment(double downPayment) {
	this.downPayment = downPayment;
}
double CalculateEMI(Loan obj) {
	double p=obj.price-obj.downPayment;
	float r=obj.interestRate;
	double t=(obj.tentureOfLoan)*12;
	double emi=(p*r*Math.pow(1+r,t))/(Math.pow(1+r,t)-1);
	return emi;
}
public String toString() {
	return "Loan [vehicleModel=" + vehicleModel + ", price=" + price + ", tentureOfLoan=" + tentureOfLoan
			+ ", interestRate=" + interestRate + ", downPayment=" + downPayment + ", creditScore=" + creditScore
			+ "]";
}

}