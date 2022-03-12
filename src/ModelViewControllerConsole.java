import java.util.*;


public class ModelViewControllerConsole {

	public static void main(String[] args) throws Exception {
		// Connect to database
		connectToDatabase();

		
		// Model View Controller (MVC)
		// Router knows all the controllers
		Map<String, Controller> router = new HashMap<>();		
		router.put("MainMenu", new Controller(new MainMenuView(), new NopModel()));
		router.put("ToDoList", new Controller(new ToDoListView(), new ToDoListModel()));
		router.put("Department", new Controller(new DepartmentView(), new DepartmentModel()));
		router.put("Priority", new Controller(new PriorityView(), new PriorityModel()));
		router.put("Status", new Controller(new StatusView(), new StatusModel()));
		router.put("Task", new Controller(new TaskView(), new TaskModel()));
		router.put("TaskManager", new Controller(new TaskManagerView(), new TaskManagerModel()));
		router.put("UserRole", new Controller(new UserRoleView(), new UserRoleModel()));
		
		ViewData viewData = new ViewData("MainMenu", "");		
		do {
			// Model, View, and Controller
			Controller controller = router.get(viewData.functionName);
			ModelData modelData = controller.executeModel(viewData);
			viewData = controller.getView(modelData, viewData.functionName, viewData.operationName);
			
			System.out.println();
			System.out.println("-------------------------------------------------");
			System.out.println();
		}
		while (viewData.functionName != null);
		
		System.out.println();
		System.out.println();
		System.out.println("Program is ended...");


		// Disconnect from database
		disconnectFromDatabase();
	}

	
	public static void connectToDatabase() {
		DatabaseUtilities.host = "localhost:1433";
		DatabaseUtilities.databaseName = "taskmanagement";
		
		try {
			DatabaseUtilities.getConnection();
		}
		catch(Exception e) {
			System.out.println("Exception occured : " + e);
			return;
		}		
	}
	
	public static void disconnectFromDatabase() {
		try {
			DatabaseUtilities.disconnect();
		}
		catch(Exception e) {
			System.out.println("Error disconnecting from database : " + e);
			return;
		}		
	}
	
}
