import java.util.Date;


class ToDoList {

	private int toDoId;
	private String toDoName;
	private String description;
	private int statusId;
	private int priorityId;
	private Date startDate;	
	private Date estimatedDate;	
	private Date modifiedDate;	
	private Date completedDate;	
	private int managerId;
	private int taskId;

	ToDoList() {
		
	}
	
	public ToDoList(String toDoName) {
		super();
		this.toDoName = toDoName;
	}

	public ToDoList(int toDoId, String toDoName, String description, int statusId, int priorityId, Date startDate,
			Date estimatedDate, Date modifiedDate, Date completedDate, int managerId, int taskId) {
		super();
		this.toDoId = toDoId;
		this.toDoName = toDoName;
		this.description = description;
		this.statusId = statusId;
		this.priorityId = priorityId;
		this.startDate = startDate;
		this.estimatedDate = estimatedDate;
		this.modifiedDate = modifiedDate;
		this.completedDate = completedDate;
		this.managerId = managerId;
		this.taskId = taskId;
	}

	
	
	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getToDoId() {
		return toDoId;
	}

	public void setToDoId(int toDoId) {
		this.toDoId = toDoId;
	}

	public String getTaskName() {
		return toDoName;
	}

	public void setTaskName(String toDoName) {
		this.toDoName = toDoName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getPriorityId() {
		return priorityId;
	}

	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEstimatedDate() {
		return estimatedDate;
	}

	public void setEstimatedDate(Date estimatedDate) {
		this.estimatedDate = estimatedDate;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "toDoId": return toDoId;
		case "toDoName": return toDoName;
		case "description": return description;
		case "statusId": return statusId;
		case "priorityId": return priorityId;
		case "startDate": return startDate;
		case "estimatedDate": return estimatedDate;
		case "modifiedDate": return modifiedDate;
		case "completedDate": return completedDate;
		case "managerId": return managerId;
		case "taskId": return taskId;

		default: return null;
		}
	}
	
	@Override
	public String toString() {
		return toDoId + ", " + toDoName + ", " + description + ", " + statusId + ", " +priorityId + ", " +
				startDate + ", " +estimatedDate + ", " +modifiedDate + ", "  +completedDate + ", "  + managerId + ", " +taskId;
	}
	
}