


class Priority {

	private int priorityId;
	private String name;

	
	Priority() {
		
	}
	Priority(  String name) {
	
		this.name = name;
	}
	Priority(int priorityId, String name) {
		this.priorityId = priorityId;
		this.name = name;
	}
	
	
	
	
	public int getPriorityId() {
		return priorityId;
	}


	public void setPriorityId(int priorityId) {
		this.priorityId = priorityId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "priorityId": return priorityId;
		case "name": return name;
		default: return null;
		}
	}
	
	@Override
	public String toString() {
		return priorityId + ", " + name;
	}
	
}
