package dao;
import java.util.List;
import model.EmpJob;

public interface IEmpJobDao {

	List<EmpJob> getAllEmpJobs();
	void addEmpJob(EmpJob ejb);
	EmpJob getEmpJobById(int id);
	void updateEmpJob(EmpJob ejb);
	void deleteEmpJob(int id);
}
