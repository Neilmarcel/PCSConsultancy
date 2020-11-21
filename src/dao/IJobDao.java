package dao;
import java.util.List;
import model.Job;

public interface IJobDao {

	List<Job> getAllJobs();
	void addJob(Job jb);
	Job getJobById(int id);
	void updateJob(Job jb);
	void deactivateJob(Job jb);
	void deleteJob(int id);
}
