import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class StatusView implements ViewInterface {

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
				int statusId = resultSet.getInt("statusId");
				String statusName = resultSet.getString("statusName");
				String statusDescription = resultSet.getString("statusDescription");				
				// Display values
				System.out.print(statusId + "\t");
				System.out.print(statusName + "\t");
				System.out.print(statusDescription + "\t");
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
		Integer statusId = getInteger("statusId : ", true);
		String statusName = getString("statusName : ", true);
		String statusDescription = getString("statusDescription : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (statusId != null) whereParameters.put("statusId", statusId);
		if (statusName != null) whereParameters.put("statusName", statusName);
		if (statusDescription != null) whereParameters.put("statusDescription", statusDescription);
		
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Status", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "statusName, statusDescription");

		List<Object> rows = new ArrayList<>();
		
		String name;
		do
		{
			System.out.println("Fields to insert:");
			name = getString("statusName : ", true);
			System.out.println();
					
			if (name != null ) {
				rows.add(new Status(name));
			}
		}
		while (name != null);
		
		parameters.put("rows", rows);
		
		return new ViewData("Status", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		String statusName = getString("statusName : ", true);
		String statusDescription = getString("statusDescription : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (statusName != null) updateParameters.put("Name", statusName);
		if (statusDescription != null) updateParameters.put("statusDescription", statusDescription);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Status", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Status", "delete", parameters);
	}

	@Override
	public String toString() {
		return "Status View";
	}		
}
