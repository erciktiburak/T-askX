


class Status {

	private int statusId;
	private String statusName;
	private String statusDescription;	
	
	Status() {
		
	}
	
	Status(String statusName) {
		this.statusName = statusName;
	}

	Status(int statusId, String statusName, String statusDescription) {
		this.statusId = statusId;
		this.statusName = statusName;
		this.statusDescription = statusDescription;
	}
	
	
	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "statusId": return statusId;
		case "statusName": return statusName;
		case "statusDescription": return statusDescription;
		default: return null;
		}
	}
	
	@Override
	public String toString() {
		return statusId + ", " + statusName + ", " + statusDescription ;
	}
	
}
