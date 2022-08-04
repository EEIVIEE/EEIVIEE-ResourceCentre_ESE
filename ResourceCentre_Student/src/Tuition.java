
public class Tuition extends Item{
private String description;

	public Tuition(String tuitionCode, String tuitionName, String description) {
		super(tuitionCode, tuitionName);
		this.description = description;
	}
    //o
	public String getDescription() {
		return description;
	}
	
	public String toString(){
		String output = "";
		return output;
	}
}

