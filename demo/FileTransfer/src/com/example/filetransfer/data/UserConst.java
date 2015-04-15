package com.example.filetransfer.data;

public class UserConst {
	public static final int NOFILETRANSFER  = 0xFF;	//无文件传送状态
	public static final int SENDINGFILE = 0xFE;		//正在发送文件状态
	public static final int RECEIVINGFILE = 0xFD;		//正在接收文件状态
	public static final int PAUSERECEIVEFILE = 0xFC;		//正在发送文件状态
}
