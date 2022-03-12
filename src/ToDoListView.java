import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class ToDoListView implements ViewInterface {

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
				int toDoId = resultSet.getInt("toDoId");
				String toDoName = resultSet.getString("toDoName");
				String description = resultSet.getString("description");
				int statusId = resultSet.getInt("statusId");
				int priorityId = resultSet.getInt("priorityId");
				Date startDate = resultSet.getDate("startDate");
				Date estimatedDate = resultSet.getDate("estimatedDate");
				Date modifiedDate = resultSet.getDate("modifiedDate");
				Date completedDate = resultSet.getDate("completedDate");
				int managerId = resultSet.getInt("managerId");
				int taskId = resultSet.getInt("taskId");

				
				// Display values
				System.out.print(toDoId + "\t");
				System.out.print(toDoName + "\t");
				System.out.print(description + "\t");
				System.out.print(statusId + "\t");
				System.out.print(priorityId + "\t");
				System.out.print(startDate + "\t");
				System.out.print(estimatedDate + "\t");
				System.out.print(modifiedDate + "\t");
				System.out.print(completedDate + "\t");
				System.out.print(managerId + "\t");
				System.out.println(taskId);
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
		Integer toDoId = getInteger("toDoId : ", true);
		String toDoName = getString("toDoName : ", true);
		
		Map<String, Object> whereParameters = new HashMap<>();
		if (toDoId != null) whereParameters.put("toDoId", toDoId);
		if (toDoName != null) whereParameters.put("toDoName", toDoName);
		
		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("ToDoList", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "toDoName");
         String toDoName;
		List<Object> rows = new ArrayList<>();
		do
		{
			System.out.println("Fields to insert:");
			Integer toDoId=getInteger("toDoId :", true);
			toDoName = getString("toDoName : ", true);
			System.out.println();
					
			if (toDoName != null) {
				rows.add(new ToDoList(toDoName));
			}
		}
		while (toDoName != null);
		
		parameters.put("rows", rows);
		
		return new ViewData("ToDoList", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		String toDoName = getString("toDoName : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (toDoName != null) updateParameters.put("toDoName", toDoName);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("ToDoList", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("ToDoList", "delete", parameters);
	}

	@Override
	public String toString() {
		return "ToDoList View";
	}		
}