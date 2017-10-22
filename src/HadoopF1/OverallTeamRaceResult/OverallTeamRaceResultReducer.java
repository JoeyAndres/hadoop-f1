package HadoopF1.OverallTeamRaceResult;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class OverallTeamRaceResultReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

	@Override
	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {

		int sumFinish = 0;
		for (IntWritable value : values) {
			sumFinish += value.get();
		}
		context.write(key, new IntWritable(sumFinish));
	}
}
