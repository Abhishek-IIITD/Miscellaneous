import java.text.ParseException;
import java.util.Date;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;


public class Test {
	public static void main(String args[]) throws SchedulerException, ParseException{
		JobDetail jd = new JobDetail();
		jd.setName("My JobDetail");
		jd.setJobClass(MyJob.class);
		
		//SimpleTrigger t = new SimpleTrigger(); //Simple Trigger is used if we want to schedule a certain job only at a specific time and then we want to continue for some time.
		CronTrigger t = new CronTrigger();//Cron Trigger is used if we want to schedule a particular job according to a calendar date like scheduling job every month.
		t.setName("My Trigger");
		t.setStartTime(new Date(System.currentTimeMillis()));
		//t.setRepeatInterval(3000);               //for SimpleTrigger
		//t.setRepeatCount(t.REPEAT_INDEFINITELY);  //for SimpleTrigger
		t.setCronExpression("0 0/1 * 1/1 * ? *");  //we have to set exp for the time period at which we want to 
											  //run the particular job. This method contains cron exp 
												//for every minute
		
		Scheduler sd = new StdSchedulerFactory().getScheduler();
		sd.scheduleJob(jd, t);
		sd.start();
	}
}
