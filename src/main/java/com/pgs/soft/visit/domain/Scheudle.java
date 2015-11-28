package main.java.com.pgs.soft.visit.domain;


@Entity
@Table(name="scheudle")
public class Scheudle {

	
	@Id
	@GeneratedValue
	private
	long idScheudle;
	
	@NotNull
	private
	long idEmployeeFK;
	
	@NotNull
	private
	String startTime;
	
	@NotNull
	private
	String endTime;
	
	
	//Konstruktory
	public Scheudle(){
		super();
		
	}
	
	//Setters & Getters
	public long getIdScheudle() {
		return idScheudle;
	}

	public void setIdScheudle(long idScheudle) {
		this.idScheudle = idScheudle;
	}

	public long getIdEmployeeFK() {
		return idEmployeeFK;
	}

	public void setIdEmployeeFK(long idEmployeeFK) {
		this.idEmployeeFK = idEmployeeFK;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	
}
