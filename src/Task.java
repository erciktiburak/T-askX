import java.util.Date;

class Task {

	private int taskId;
	private int userId;
	private int createdBy;
	private int updatedBy;
	private String title;
	private String description;
	private Date createdDate;
	
	
	
	Task() {
		
	}
	
	
	public Task(String title) {
        super();
        this.title = title;
    }


	


	public Task(int taskId, int userId, int createdBy, int updatedBy, String title, String description,
			Date createdDate) {
		super();
		this.taskId = taskId;
		this.userId = userId;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.title = title;
		this.description = description;
		this.createdDate = createdDate;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public int getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "taskId": return taskId;
		case "userId": return userId;

		case "createdBy": return createdBy;
		case "updatedBy": return updatedBy;
		case "title": return title;
		case "description": return description;
		case "createdDate": return createdDate;



		default: return null;
		}
	}
	
	@Override
	public String toString() {
		return taskId + ", " + userId + ", " + createdBy+ ", " + updatedBy + ", " + title + ", " + description+", "+createdDate ;
	}
	
}
