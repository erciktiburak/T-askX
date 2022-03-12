class UserRole {

	private int roleId;
	private String name;
	
	UserRole() {
		
	}
	
	UserRole(String name) {
		this.name = name;
	}

	UserRole(int roleId, String name) {
		this.roleId = roleId;
		this.name = name;
	}
	

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getByName(String attributeName) {
		switch (attributeName) {
		case "roleId": return roleId;
		case "name": return name;
		default: return null;
		}
	}
	
	@Override
	public String toString() {
		return roleId + ", " + name;
	}
	
}
