package HadoopF1.MostTeamFinished;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import HadoopF1.ResultsRecord;

public class MostTeamFinishedMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		ResultsRecord resultsParser = ResultsRecord.Parse(value);
		
		int finishCount = resultsParser.getStatus().equals("Finished") ? 1 : 0;
		context.write(
				new Text(resultsParser.getConstructorId()), 
				new IntWritable(finishCount));
	}
}
