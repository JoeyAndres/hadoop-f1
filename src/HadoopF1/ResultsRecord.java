package HadoopF1;

import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.io.Text;

public class ResultsRecord {
	private String year;
	private String circuitId;
	private String constructorId;
	private String driverId;
	private String status;
	private int duration;
	private int position;
	
	public static ResultsRecord Parse(String record_str) {
		String[] record_components = record_str.split(",");
		
		ResultsRecord record = new ResultsRecord();
		record.year = record_components[0];
		record.circuitId = record_components[1];
		record.constructorId = record_components[2];
		record.driverId = record_components[3];
		record.status = record_components[4];
		
		try {		
			record.duration = Integer.parseInt(record_components[5]);
		} catch (NumberFormatException e) {
			record.duration = -1;
		}
		
		record.position = Integer.parseInt(record_components[6]);
		
		return record;
	}
	
	public static ResultsRecord Parse(Text record) {
		return Parse(record.toString());
	}
	
	public String getYear() {
		return year;
	}
	
	public String getCircuitId() {
		return circuitId;
	}
	
	public String getConstructorId() {
		return constructorId;
	}
	
	public String getDriverId() {
		return driverId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public int getPosition() {
		return position;
	}
}
