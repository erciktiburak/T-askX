class Department {

	private int deptId;
	private String deptName;
	private String deptDescription;
	
	Department() {
		
	}
	
	public Department(String deptName) {
		super();
		this.deptName = deptName;
	}
	
	public Department(int deptId, String deptName, String deptDescription) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptDescription = deptDescription;
	}


	
	public int getDeptId() {
		return deptId;
	}


	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}


	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}


	public String getDeptDescription() {
		return deptDescription;
	}


	public void setDeptDescription(String deptDescription) {
		this.deptDescription = deptDescription;
	}


	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "deptId": return deptId;
		case "deptName": return deptName;
		case "deptDescription": return deptDescription;
		default: return null;
		}
	}
	
	@Override
	public String toString() {
		return deptId + ", " + deptName + ", " + deptDescription;
	}
	
}
