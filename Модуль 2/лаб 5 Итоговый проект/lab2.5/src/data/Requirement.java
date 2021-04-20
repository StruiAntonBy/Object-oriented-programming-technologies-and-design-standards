package data;

public class Requirement {
	private int Id;
	private int ProjectId;
	private String Description;
	private int TimeImplementation;
	private boolean MarkOfImplementation;
	private int Priority;
	private int ProbabilityOfChange;
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}

	public int getProjectId() {
		return ProjectId;
	}

	public void setProjectId(int projectId) {
		ProjectId = projectId;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getTimeImplementation() {
		return TimeImplementation;
	}

	public void setTimeImplementation(int timeImplementation) {
		TimeImplementation = timeImplementation;
	}

	public boolean isMarkOfImplementation() {
		return MarkOfImplementation;
	}

	public void setMarkOfImplementation(boolean markOfImplementation) {
		MarkOfImplementation = markOfImplementation;
	}

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	public int getProbabilityOfChange() {
		return ProbabilityOfChange;
	}

	public void setProbabilityOfChange(int probabilityOfChange) {
		ProbabilityOfChange = probabilityOfChange;
	}
	
}
