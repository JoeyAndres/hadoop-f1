package HadoopF1.MostTeamFinished;

import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

public class MostTeamFinishedRunner extends Configured implements Tool {
	
	@Override
	public int run(String[] args) throws Exception {
		if (args.length != 2) {
			System.err.println("Usage: HadoopF1.MostTeamFinishedRunner <input path> <output path>");
			System.exit(-1);
		}

		Job job = new Job();
		job.setJarByClass(MostTeamFinishedRunner.class);
		job.setJobName("Max temperature");

		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));

		job.setMapperClass(MostTeamFinishedMapper.class);
		job.setReducerClass(MostTeamFinishedReducer.class);

		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		return job.waitForCompletion(true) ? 0 : 1;
	}
	
	public static void main(String[] args) throws Exception {
	    int exitCode = ToolRunner.run(new MostTeamFinishedRunner(), args);
	    System.exit(exitCode);
	}
}
