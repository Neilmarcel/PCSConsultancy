package model;

public class Job {
	private int JobId;
	private String JobTitle;
	private String JobDescription;
	private String CompanyName;
	private String Location;
	private String role;
	private String KeySkill;
	private String Salary;
	private String Activate;
	//default constructor methods
	public Job() {
		
	}
	//parameterized constructor method
	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}
	public Job(String jobTitle, String jobDescription, String companyName, String location, String role,
			String keySkill, String salary) {
		super();
		JobTitle = jobTitle;
		JobDescription = jobDescription;
		CompanyName = companyName;
		Location = location;
		this.role = role;
		KeySkill = keySkill;
		Salary = salary;
	}
	public int getJobId() {
		return JobId;
	}
	public void setJobId(int jobId) {
		JobId = jobId;
	}
	public String getJobDescription() {
		return JobDescription;
	}
	public void setJobDescription(String jobDescription) {
		JobDescription = jobDescription;
	}
	public String getCompanyName() {
		return CompanyName;
	}
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getKeySkill() {
		return KeySkill;
	}
	public void setKeySkill(String keySkill) {
		KeySkill = keySkill;
	}
	public String getSalary() {
		return Salary;
	}
	public void setSalary(String salary) {
		Salary = salary;
	}
	public String getActivate() {
		return Activate;
	}
	public void setActivate(String activate) {
		Activate = activate;
	}
	public String getJobTitle() {
		return JobTitle;
	}
	@Override
	public String toString() {
		return "Job [JobId=" + JobId + ", JobTitle=" + JobTitle + ", JobDescription=" + JobDescription
				+ ", CompanyName=" + CompanyName + ", Location=" + Location + ", role=" + role + ", KeySkill="
				+ KeySkill + ", Salary=" + Salary + ", Activate=" + Activate + "]";
	}
}
