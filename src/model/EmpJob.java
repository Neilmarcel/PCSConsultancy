package model;

public class EmpJob {
	private int EJId;
	private int EmpId;
    private int JobId;
    private int Recruited;
  //default constructor methods
    public EmpJob() {
    	
    }
  //parameterized constructor method
	public EmpJob(int empId, int jobId, int recruited) {
		super();
		EmpId = empId;
		JobId = jobId;
		Recruited = recruited;
	}
	public int getEJId() {
		return EJId;
	}
	public void setEJId(int eJId) {
		EJId = eJId;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public int getJobId() {
		return JobId;
	}
	public void setJobId(int jobId) {
		JobId = jobId;
	}
	public int getRecruited() {
		return Recruited;
	}
	public void setRecruited(int recruited) {
		Recruited = recruited;
	}
	@Override
	public String toString() {
		return "EmpJob [EJId=" + EJId + ", EmpId=" + EmpId + ", JobId=" + JobId + ", Recruited=" + Recruited + "]";
	}
    
}
