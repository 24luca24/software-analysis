public class OrderedTodos extends Todos
{

	 public OrderedTodos(int nTasks) {
		  super(nTasks);
	 }
	 
	 // select the next task among pending tasks in order
	 @Override
	 protected synchronized int next() {
		  int nextTask = this.nextTask;
		  do {
				nextTask = (nextTask + 1) % done.length;
		  } while (nextTask != this.nextTask && isDone(nextTask));
		  // when nextTask == this.nextTask it means that all tasks are done
		  return nextTask;
	 }
	 
}
