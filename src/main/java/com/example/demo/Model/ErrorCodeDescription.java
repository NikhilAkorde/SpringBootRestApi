package com.example.demo.Model;

import java.util.Map;

public class ErrorCodeDescription {
private int status;
private String error;
private String message;
private String timeStamp;
private String trace;


public ErrorCodeDescription(int status,Map<String, Object> errorAtribute)
{
	this.status=status;
	this.error=(String) errorAtribute.get("error");
	this.message=(String) errorAtribute.get("message");
	this.timeStamp=(String) errorAtribute.get("timeStamp");
	this.trace = (String) errorAtribute.get("trace");
}

public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public String getError() {
	return error;
}
public void setError(String error) {
	this.error = error;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getTimeStamp() {
	return timeStamp;
}
public void setTimeStamp(String timeStamp) {
	this.timeStamp = timeStamp;
}
public String getTrace() {
	return trace;
}
public void setTrace(String trace) {
	this.trace = trace;
}




}
