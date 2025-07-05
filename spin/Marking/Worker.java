public class Worker implements Runnable
{
	 private int taskId;
	 private Todos todos;

	 public Worker(int taskId, Todos todos) {
		  this.taskId = taskId;
		  this.todos = todos;
	 }

	 public void run() {
		  while (!todos.doTask(taskId))
				;
	 }
	 
}
