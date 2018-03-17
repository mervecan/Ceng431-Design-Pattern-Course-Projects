package business;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import data_access.TaskReader;

public class TaskHandler {
	
	public static Result result(Tasks task) throws NumberFormatException, IOException {
		TaskReader tr = new TaskReader();
		HashMap<String, Double> taskMap = tr.readTasksProbablities();
		Double probability = taskMap.get(task.name());
		Random r = new Random();
		double randomValue = r.nextDouble();
		if(randomValue < probability) {
			return Result.SUCCESS;
		}
		return Result.FAILURE;	
	}
}
