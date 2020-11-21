package dao;
import java.util.List;
import model.Skill;

public interface ISkillDao {

	List<Skill> getAllSkills();
	void addSkill(Skill ski);
	Skill getSkillById(int id);
	void updateSkill(Skill ski);
	void deactivateSkill(Skill ski);
	void deleteSkill(int id);
}
