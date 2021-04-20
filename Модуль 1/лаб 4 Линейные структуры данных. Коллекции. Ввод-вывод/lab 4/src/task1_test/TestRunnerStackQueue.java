package task1_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestRunnerStackQueue {

	@Test
	void testStack() {
		task1.Stack stack=new task1.Stack(10);
		stack.add("$");
		Assert.assertEquals("$",stack.pop());
	}
	
	@Test
	void testQueue() {
		task1.Queue queue=new task1.Queue();
		task1.Item it=new task1.Item(1);
		queue.add(it);
		Assert.assertEquals(1,queue.pop());
	}
	
	@Test
	void testRunner() {
		task1.Queue queue=new task1.Queue();
		task1.Item it=new task1.Item(1);
		queue.add(it);
		task1.Stack inputStack=new task1.Stack(10);
		Assert.assertEquals(false,task1.Runner.processingQueue(queue, inputStack));
	}
	
}
