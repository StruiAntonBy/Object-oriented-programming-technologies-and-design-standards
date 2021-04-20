package task2_test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import task2.input_and_output;

class in_and_out {

	@Test
	void test() {
		StringBuilder res=new StringBuilder("нольодиндватричетырепятьшестьсемьвосемьдевять");
		StringBuilder ret=task2.input_and_output.transform(new StringBuilder("0123456789"));
		String result=new String(res);
		String returnn=new String(ret);
		assertEquals(result,returnn);
	}

}
