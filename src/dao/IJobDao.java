package dao;
import java.util.Job;
import model.Job;

public interface IJobDao {

	List<Job> getAllJobs();
	void addJob(Job jb);
	Job getJobById(int id);
	void updateJob(Job jb);
	void deactivateJob(int id);
	void deleteJob(int id);
}
