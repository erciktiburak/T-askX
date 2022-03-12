import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class UserRoleView implements ViewInterface {

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
				int roleId = resultSet.getInt("roleId");
				String name = resultSet.getString("name");
				
				// Display values
				System.out.print(roleId + "\t");
				System.out.print(name + "\t");
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
		Integer roleId = getInteger("role ID : ", true);
		String name = getString("name : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (roleId != null) whereParameters.put("roleId", roleId);
		if (name != null) whereParameters.put("name", name);
		
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("UserRole", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "name");

		List<Object> rows = new ArrayList<>();
		
		String name;
		do
		{
			System.out.println("Fields to insert:");
			name = getString("name : ", true);
			System.out.println();
					
			if (name != null) {
				rows.add(new UserRole(name));
			}
		}
		while (name != null);
		
		parameters.put("rows", rows);
		
		return new ViewData("UserRole", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		String name = getString("name : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (name != null) updateParameters.put("name", name);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("UserRole", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("UserRole", "delete", parameters);
	}

	@Override
	public String toString() {
		return "UserRole View";
	}		
}
