import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;


public class Test {

	public static void main(String[] args) throws SchedulerException {
		// TODO Auto-generated method stub
		JobDetail jd = JobBuilder.newJob(job.class).withIdentity("my job", "g1").build();
		//Trigger t = TriggerBuilder.newTrigger().withIdentity("my trigger", "g1").withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(4).repeatForever()).build();  //for Simple Trigger
		Trigger t = TriggerBuilder.newTrigger().withIdentity("my trigger", "g1").withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *")).build();  //for Cron Trigger
		
		Scheduler sd = new StdSchedulerFactory().getScheduler();
		sd.scheduleJob(jd, t);
		sd.start();
	}

}
