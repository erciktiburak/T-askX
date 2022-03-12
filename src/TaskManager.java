class TaskManager {

	private int managerId;
	private int roleId;
	private String name;
	private String surname;
	private String phone;
	private String email;
	private int deptId;

	
		
	public TaskManager() {
		super();
	}
	


	
	public TaskManager(String name, String surname, String phone, String email) {
		super();
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
	}

	


	public TaskManager(int managerId, int roleId, String name, String surname, String phone, String email, int deptId) {
		super();
		this.managerId = managerId;
		this.roleId = roleId;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.email = email;
		this.deptId = deptId;
	}




	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "managerId": return managerId;
		case "roleId": return roleId;
		case "name": return name;
		case "surname": return surname;
		case "phone": return phone;
		case "email": return email;
		case "deptId": return deptId;

		default: return null;
		}
	}
	
	@Override
	public String toString() {
		return managerId + ", " + roleId + ", " + name + ", " + surname + ", " 
				+ phone + ", " + email + ", " + deptId;
	}
	
}
