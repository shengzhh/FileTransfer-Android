package com.example.filetransfer.application;


import com.example.filetransfer.net.NetHelper;

import android.app.Application;
import android.os.Handler;

public class myApplication extends Application {
	
    
	private NetHelper mNetHelper=null;
	private Handler handler=null;
    @Override
    public void onCreate()
    {
        super.onCreate();
    }
    
    public void setNetHelper(NetHelper netHelper)
    {
    	mNetHelper = netHelper;
    }
    public NetHelper getNetHelper()
    {
    	return mNetHelper;
    }
    public void setHandler(Handler mHandler)
    {
    	handler = mHandler;
    }
    public Handler getHandler()
    {
    	return handler;
    }
}
