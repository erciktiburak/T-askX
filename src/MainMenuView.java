import java.util.*;

class MainMenuView implements ViewInterface {

	@Override
	public ViewData create(ModelData modelData, String functionName, String operationName) throws Exception {

		Integer choice;
		do {
			System.out.println("1. Show all task lists");
			System.out.println("2. Show tasks");
			System.out.println("3. Add a task");
			System.out.println("4. Update a task");
			System.out.println("5. Delete a task");
			System.out.println("6. Quit");
			System.out.println();

			choice = getInteger("Please enter your choice : ", false);
		} 
		while (choice == null || choice < 1 || choice > 6);
		
		
		Map<String, Object> userInput = new HashMap<>();
		userInput.put("mainMenuChoice", choice);
		
		switch (choice.intValue()) {
		case 1: operationName = "select";		break;
		case 2: operationName = "select.gui";	break;
		case 3: operationName = "insert.gui";	break;
		case 4: operationName = "update.gui";	break;
		case 5: operationName = "delete.gui";	break;
		default: return new ViewData(null, null);
		}
		
		return new ViewData("Task", operationName, new HashMap<>());
	}

	@Override
	public String toString() {
		return "Main Menu View";
	}		
}