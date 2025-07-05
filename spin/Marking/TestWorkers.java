public class TestWorkers
{
	 public void testOrdered(int nWorkers) {
		  Workers workers = new Workers(nWorkers, true);
		  workers.go();
	 }

	 public void testParallel(int nWorkers) {
		  Workers workers = new Workers(nWorkers, false);
		  workers.go();
	 }

	 public static void main(String args[]) {
		  TestWorkers test = new TestWorkers();
		  test.testOrdered(1);
		  test.testOrdered(3);
		  test.testParallel(1);
		  test.testParallel(3);
	 }
	 
}
