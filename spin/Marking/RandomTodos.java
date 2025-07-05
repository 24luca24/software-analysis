import java.util.Random;
import java.util.ArrayList;


public class RandomTodos extends Todos
{

	 public RandomTodos(int nTasks) {
		  super(nTasks);
	 }
	 
	 // randomly select the next task among pending tasks
	 @Override
	 protected synchronized int next() {
		  ArrayList <Integer> available = new ArrayList<>();
		  for (int k = 0; k < done.length; k++) {
				if (!isDone(k))
					 available.add(k);
		  }
		  if (available.size() == 0)
				return 0;
		  Random rand = new Random();
		  return available.get(rand.nextInt(available.size()));
	 }
	 
}
