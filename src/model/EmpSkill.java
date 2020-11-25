package model;

public class EmpSkill {
	private int ESId;
	private int empId;
	private int SkillId;
	private int ExpYear;
	//default constructor methods
	public EmpSkill() {
			
	}
	//parameterized constructor method
	public EmpSkill(int empId, int skillId, int expYear) {
		super();
		this.empId = empId;
		SkillId = skillId;
		ExpYear = expYear;
	}
	public int getESId() {
		return ESId;
	}
	public void setESId(int eSId) {
		ESId = eSId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getSkillId() {
		return SkillId;
	}
	public void setSkillId(int skillId) {
		SkillId = skillId;
	}
	public int getExpYear() {
		return ExpYear;
	}
	public void setExpYear(String readLine) {
		ExpYear = getExpYear();
		
	}
	@Override
	public String toString() {
		return "EmpSkill [ESId=" + ESId + ", empId=" + empId + ", SkillId=" + SkillId + ", ExpYear=" + ExpYear + "]";
	}
}
