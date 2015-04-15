package com.example.filetransfer.data;

public class User {
	private String Ip;
	private int fileState;
	private int processRate;
	
	public void setIp(String ip)
	{
		this.Ip = ip;
	}
	public String getIp()
	{
		return Ip;
	}
	public void setfileState(int state)
	{
		this.fileState = state; 
	}
	public int getFileState()
	{
		return fileState;
	}
	public void setProcessRate(int rate)
	{
		this.processRate = rate;
	}
	public int getProcessRate()
	{
		return processRate;
	}
}
