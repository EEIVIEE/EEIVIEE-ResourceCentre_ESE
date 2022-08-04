
public class Tuition{
private String tuitionCode;
private String tuitionTitle;
private String subjectGroupName;
private String tuitionDescription;
private String tuitionDuration;
private String preRequisite;

public Tuition(String tuitionCode, String tuitionTitle, String subjectGroupName, String tuitionDescription,
		String tuitionDuration, String preRequisite) {
	super();
	this.tuitionCode = tuitionCode;
	this.tuitionTitle = tuitionTitle;
	this.subjectGroupName = subjectGroupName;
	this.tuitionDescription = tuitionDescription;
	this.tuitionDuration = tuitionDuration;
	this.preRequisite = preRequisite;
}
public String getTuitionCode() {
	return tuitionCode;
}
public String getTuitionTitle() {
	return tuitionTitle;
}
public String getSubjectGroupName() {
	return subjectGroupName;
}
public String getTuitionDescription() {
	return tuitionDescription;
}
public String getTuitionDuration() {
	return tuitionDuration;
}
public String getPreRequisite() {
	return preRequisite;
}
public void setTuitionCode(String tuitionCode) {
	this.tuitionCode = tuitionCode;
}
public void setTuitionTitle(String tuitionTitle) {
	this.tuitionTitle = tuitionTitle;
}
public void setSubjectGroupName(String subjectGroupName) {
	this.subjectGroupName = subjectGroupName;
}
public void setTuitionDescription(String tuitionDescription) {
	this.tuitionDescription = tuitionDescription;
}
public void setTuitionDuration(String tuitionDuration) {
	this.tuitionDuration = tuitionDuration;
}
public void setPreRequisite(String preRequisite) {
	this.preRequisite = preRequisite;
}


	
	
}

