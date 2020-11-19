package dao;
import java.util.List;
import model.Skill;

public interface ISkillDao {

	List<Skill> getAllSkills();
	void addSkill(Skill ski);
	Skill getSkillById(int id);
	void updateSkill(Skill ski);
	void deactivateSkill(int id);
	void deleteSkill(int id);
}
