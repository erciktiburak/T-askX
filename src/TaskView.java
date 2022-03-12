import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class TaskView implements ViewInterface {

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
				int taskId = resultSet.getInt("taskId");
				int userId = resultSet.getInt("userId");
				int createdBy = resultSet.getInt("createdBy");
				int updatedBy = resultSet.getInt("updatedBy");

				String title = resultSet.getString("title");
				String description = resultSet.getString("description");

				Date createdDate = resultSet.getDate("createdDate");
				
				// Display values
				System.out.print(taskId + "\t");
				System.out.print(userId + "\t");
				System.out.print(createdBy + "\t");
				System.out.print(updatedBy + "\t");
				System.out.print(title + "\t");
				System.out.print(description + "\t");
				System.out.print(createdDate + "\t");

System.out.print("\n");
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
		//Integer taskId = getInteger("taskId : ", true);
		String title = getString("title : ", true);

		Map<String, Object> whereParameters = new HashMap<>();
		//if (taskId != null) whereParameters.put("taskId", taskId);
		if (title != null) whereParameters.put("title", title);

		return whereParameters;
	}
	
	ViewData selectGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Task", "select", parameters);
	}

	ViewData insertGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("fieldNames", "title");
		List<Object> rows = new ArrayList<>();
		
		Integer taskId,userId,createdBy, updatedBy;
        String title, description;
        Date createdDate;
        do
        {
            System.out.println("Fields to insert:");

            taskId = getInteger("taskId :", true);
            
            userId = getInteger("userId :", true);
            createdBy = getInteger("createdBy :", true);
            updatedBy = getInteger("updatedBy :", true);
            title = getString("title : ", true);
            description = getString("description : ", true);
            createdDate = getDate("createdDate : ", true);


            System.out.println();

            if (title != null) {
                rows.add(new Task(title));
            }
        }
        while (title != null);

		
		parameters.put("rows", rows);
		
		return new ViewData("Task", "insert", parameters);
	}

	ViewData updateGUI(ModelData modelData) throws Exception {
		System.out.println("Fields to update:");
		String name = getString("title : ", true);
		System.out.println();
		
		Map<String, Object> updateParameters = new HashMap<>();
		if (name != null) updateParameters.put("title", name);
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("updateParameters", updateParameters);
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Task", "update", parameters);
	}

	ViewData deleteGUI(ModelData modelData) throws Exception {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("whereParameters", getWhereParameters());
		
		return new ViewData("Task", "delete", parameters);
	}

	@Override
	public String toString() {
		return "Task View";
	}		
}
