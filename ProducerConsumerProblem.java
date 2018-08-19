package existingProject;

import java.util.LinkedList;

public class ProducerConsumerProblem {
	
	public static void main(String[] args) throws InterruptedException {
		
		Proces ps = new Proces();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
			
				try {
					ps.Producer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
			
				try {
					ps.Consumer();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		});

		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
	
	static class Proces{
		
		LinkedList<Integer> list = new LinkedList<>();
		private final int capacity = 2;
						
		private void Producer() throws InterruptedException {
			int value = 0;
			while (true) {
				
			synchronized (this) {
				
				while(list.size() == capacity)
					wait();
				
				list.add(++value);
				
				System.out.println("Adding Value to the List.. "+ value);
				
				notify();
			}
			
			Thread.sleep(1000);
		}
			
	}
		
		private void Consumer() throws InterruptedException {
			
		while (true) {
			
			synchronized (this) {
				
				while(list.isEmpty())
					wait();
				
				int removeIndex = list.removeFirst();
				
				System.out.println("Value Removed From the list..  "+ removeIndex);
				
				notify();
			}
			
			Thread.sleep(1000);
		}}

		
	}
}
