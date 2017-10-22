package HadoopF1.OverallTeamRaceResult;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import HadoopF1.ResultsRecord;

public class OverallTeamRaceResultMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	static private int MAXIMUM_DRIVER_COUNT = 50;
	
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		ResultsRecord resultsParser = ResultsRecord.Parse(value);
		
		int position = MAXIMUM_DRIVER_COUNT - resultsParser.getPosition();
		context.write(
				new Text(resultsParser.getConstructorId()), 
				new IntWritable(position));
	}
}
