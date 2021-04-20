package task3;

import by.vsu.mf.ai.ssd.strings.Job;
import by.vsu.mf.ai.ssd.strings.Manager;
import task2.input_and_output;

public class mytask2beautiful {

	public static void main(String[] args) {
		Job job = new Job() {
            public void perform(StringBuilder str) {
            	str=input_and_output.transform(str);
        	}
        };
        Manager.createWindow(job);
	}

}
