package pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataObject {
	
	private int year;
	private double price;
	private String CPUmodel;
	private String color;
	private String Harddisksize;

	
	public void setYear(int year) {
		this.year=year;
	}
	
	public int getYear() {
		  return year;
		}
	
	public void setPrice(double price) {
		this.price=price;
	}
	
	public double getPrice() {
		  return price;
		}
	
	@JsonProperty("CPU model")
	public void setCPUmodel(String CPUmodel) {
		this.CPUmodel=CPUmodel;
	}
	
	@JsonProperty("CPU model")
	public String getCPUmodel() {
		  return CPUmodel;
		}
	
	@JsonProperty("Hard disk size")
	public void setHarddisksize(String Harddisksize) {
		this.Harddisksize=Harddisksize;
	}
	
	@JsonProperty("Hard disk size")
	public String getHarddisksize() {
		  return Harddisksize;
		}

	public void setColor(String color) {
		this.color=color;
	}
	
	public String getcolor() {
		  return color;
		}
	


}
