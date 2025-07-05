import java.util.ArrayList;

public class Workers
{
	 private int nTasks;
	 private Todos todos;

	 public Workers(int nWorkers, boolean ordered) {
		  this.nTasks = nWorkers;
		  if (ordered)
				todos = new OrderedTodos(this.nTasks);
		  else
				todos = new RandomTodos(this.nTasks);
	 }
	 
	 public void go() {
		  ArrayList<Thread> workers = new ArrayList<>();
		  // spawn all threads
		  for (int taskId = 0; taskId < nTasks; taskId++) {
				Worker worker = new Worker(taskId, todos);
				Thread workerThread = new Thread(worker);
				workers.add(workerThread);
				workerThread.start();
		  }
		  // wait for all threads to terminate
		  for (Thread workerThread: workers) {
				try {
					 workerThread.join();
				} catch (InterruptedException exc) {
					 System.out.println("Thread interrupted");
				}
		  }
		  System.out.println("All workers terminated.");
	 }
}
