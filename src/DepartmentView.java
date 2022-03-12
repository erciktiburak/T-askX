import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class DepartmentView implements ViewInterface {

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
				int deptId = resultSet.getInt("deptId");
				String deptName = resultSet.getString("deptName");
				String deptDescription = resultSet.getString("deptDescription");
				
				System.out.print(deptId + "\t");
				System.out.print(deptName + "\t");
				System.out.print(deptDescription + "\t");
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
		Integer deptId = getInteger("dept ID : ", true);
		String deptName = getString("deptName : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (deptId != null) whereParameters.put("deptId", deptId);
		if (deptName != null) whereParameters.put("deptName", deptName);
		
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Department", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "deptName");

		List<Object> rows = new ArrayList<>();
		
		String deptName;
		do
		{
			System.out.println("Fields to insert:");
			deptName = getString("deptName : ", true);
			System.out.println();
					
			if (deptName != null) {
				rows.add(new Department(deptName));
			}
		}
		while (deptName != null);
		
		parameters.put("rows", rows);
		
		return new ViewData("Department", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		String deptName = getString("deptName : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (deptName != null) updateParameters.put("deptName", deptName);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Department", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Department", "delete", parameters);
	}

	@Override
	public String toString() {
		return "Department View";
	}		
}
