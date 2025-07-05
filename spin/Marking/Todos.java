public abstract class Todos
{
	 // done[k] == task #k has been done
	 protected volatile boolean[] done;
	 
	 // index of next task to be done
	 protected volatile int nextTask;
	 
	 public Todos(int nTasks) {
		  if (nTasks <= 0)
				throw new Error("At least one task is needed.");
		  // default initialization: all false
		  done = new boolean[nTasks];
		  nextTask = 0;
	 }

	 // is `taskId` the next task to be done?
	 public synchronized boolean isNext(int taskId) {
		  return nextTask == taskId;
	 }

	 // is `taskId` already marked as done?
	 public synchronized boolean isDone(int taskId) {
		  return done[taskId];
	 }

	 // next task to be completed among the pending tasks
	 abstract protected int next();

	 // if the `nextTask` is `taskId`, mark it as done, move to `next()` task
	 // and return true; otherwise, return false
	 public synchronized boolean doTask(int taskId) {
		  if (taskId != nextTask)
				return false;
		  done[taskId] = true;
		  System.out.println("Task " + taskId + " done.");
		  nextTask = next();
		  return true;
	 }
	 
}
