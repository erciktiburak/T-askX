import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class TaskManagerView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {
		
		switch(operationName) {
		case "select": return selectOperation(modelData);	
		case "insert": return insertOperation(modelData);	
		case "update": return updateOperation(modelData);	
		case "delete": return deleteOperation(modelData);	
		case "select.gui": return selectGUI(modelData);
		case "insert.gui": return insertGUI(modelData);
		case "update.gui": return updateGUI(modelData);
		case "delete.gui": return deleteGUI(modelData);
		}
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData selectOperation(ModelData modelData) throws Exception {
		ResultSet resultSet = modelData.resultSet;
		
		if (resultSet != null) {
			while (resultSet.next()) {
				// Retrieve by column name
				int managerId = resultSet.getInt("managerId");
				int roleId = resultSet.getInt("roleId");
				String name = resultSet.getString("name");
				String surname = resultSet.getString("surname");
				String phone = resultSet.getString("phone");
				String email = resultSet.getString("email");
				int deptId = resultSet.getInt("deptId");
				
				System.out.print(managerId + "\t");
				System.out.print(roleId + "\t");
				System.out.print(name + "\t");
				System.out.print(surname + "\t");
				System.out.print(phone + "\t");
				System.out.print(email + "\t");
				System.out.println(deptId);
			}
			resultSet.close();	
		}
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData insertOperation(ModelData modelData) throws Exception {
		System.out.println("Number of inserted rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}

	ViewData updateOperation(ModelData modelData) throws Exception {
		System.out.println("Number of updated rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}
	
	ViewData deleteOperation(ModelData modelData) throws Exception {
		System.out.println("Number of deleted rows is " + modelData.recordCount);
		
		return new ViewData("MainMenu", "");
	}	

	Map<String, Object> getWhereParameters() throws Exception {
		System.out.println("Filter conditions:");
		Integer managerId = getInteger("manager ID : ", true);
		Integer roleId = getInteger("role ID : ", true);
		String name = getString("name : ", true);
		String surname = getString("surname : ", true);
		String phone = getString("phone : ", true);
		String email = getString("email : ", true);
		Integer deptId = getInteger("dept ID : ", true);

		
		Map<String, Object> whereParameters = new HashMap<>();
		if (managerId != null) whereParameters.put("managerId", managerId);
		if (roleId != null) whereParameters.put("roleId", roleId);
		if (name != null) whereParameters.put("name", name);
		if (surname != null) whereParameters.put("surname", surname);
		if (phone != null) whereParameters.put("phone", phone);
		if (email != null) whereParameters.put("email", email);
		if (deptId != null) whereParameters.put("deptId", deptId);

		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("TaskManager", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "name, surname");

		List<Object> rows = new ArrayList<>();
		
		String name, surname, phone, email;
		do
		{
			System.out.println("Fields to insert:");
			name = getString("name", true);
			surname = getString("surname : ", true);
			phone = getString("surname : ", true);
			email = getString("surname : ", true);
			System.out.println();
					
			if (name != null && name != null) {
				rows.add(new TaskManager(name, surname, phone,email));
			}
		}
		while (name != null && surname != null);
		
		parameters.put("rows", rows);
		
		return new ViewData("TaskManager", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		String name = getString("Name : ", true);
		String surname = getString("surname : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (name != null) updateParameters.put("name", name);
		if (surname != null) updateParameters.put("surname", surname);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("TaskManager", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("TaskManager", "delete", parameters);
	}

	@Override
	public String toString() {
		return "TaskManager View";
	}		
}
