package model;
import model.Employee;
import model.Skill;
public class EmpSkill extends Employee {
	private int ESId;
	private int EmployeeId;
	private int SkillId;
	private int ExpYear;
	//default constructor methods
	public EmpSkill() {
			
	}
	//parameterized constructor method
	
	public int getESId() {
		return ESId;
	}
	public EmpSkill(int employeeId, int skillId, int expYear) {
		super();
		EmployeeId = employeeId;
		SkillId = skillId;
		ExpYear = expYear;
	}
	public void setESId(int eSId) {
		ESId = eSId;
	}
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
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
	public void setExpYear(int expYear) {
		ExpYear = expYear;
	}
	@Override
	public String toString() {
		return "EmpSkill [ESId=" + ESId + ", EmployeeId=" + ESId + ", SkillId=" + ESId + ", ExpYear=" + ExpYear
				+ "]";
	}
}
