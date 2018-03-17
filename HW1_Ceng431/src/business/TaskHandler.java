package business;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import data_access.TaskReader;

//Simple class that handles tasks
public class TaskHandler {
	
	/*	Reads the probabilities from a file via TaskReader, returns the result of a task
		according to the probability given. */
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
