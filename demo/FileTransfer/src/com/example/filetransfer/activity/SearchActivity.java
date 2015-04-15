package com.example.filetransfer.activity;


import com.example.filetransfer.application.myApplication;
import com.example.filetransfer.data.MsgConst;
import com.example.filetransfer.net.NetHelper;
import com.example.filetransfer.view.SearchDevicesView;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class SearchActivity extends Activity {
	private NetHelper mNetHelper;
	private myApplication mApplication;
	private SearchDevicesView search_device_view;
	private TextView mTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		mApplication = (myApplication) getApplication();
		mNetHelper=mApplication.getNetHelper();
		mApplication.setHandler(searchHandler);
		mNetHelper.startSearch();
		findViews();
		search_device_view.setSearching(true);
		search_device_view.setWillNotDraw(false);
	}
	private void findViews()
	{
		search_device_view = (SearchDevicesView) findViewById(R.id.search_device_view);
		mTextView=(TextView)findViewById(R.id.textView1);
	}
	@Override  
    protected void onResume() {  
        super.onResume();  
        mApplication.setHandler(searchHandler);  
    }  

	private Handler searchHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch(msg.what){
			case MsgConst.CHANGEUSERS:
				freshUsers();
				break;
			}
		}

	};

	private void freshUsers() {
		// TODO Auto-generated method stub
		int count = mNetHelper.getUserCount();
		mTextView.setText("搜索到"+count+"位在线用户");
	}
}
