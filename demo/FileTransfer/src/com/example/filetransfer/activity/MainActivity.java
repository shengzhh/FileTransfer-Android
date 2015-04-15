package com.example.filetransfer.activity;

import java.util.List;
import java.util.Map;

import com.example.filetransfer.adapter.ListViewAdapter;
import com.example.filetransfer.application.myApplication;
import com.example.filetransfer.data.User;
import com.example.filetransfer.net.NetHelper;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	
	private Button searchbtn;
	private ListView userlist;
	private NetHelper mNetHelper;
	private myApplication mApplication;
	private Map<String,User> users;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViews();
		mApplication = (myApplication) getApplication();
		mNetHelper = new NetHelper();
		mApplication.setNetHelper(mNetHelper);
		mApplication.setHandler(mainHandler);
		if(!isWifiActive()){	//若wifi没有打开，提示
        	Toast.makeText(this, R.string.wifi_fail, Toast.LENGTH_LONG).show();
        }
		searchbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intents = new Intent(MainActivity.this,SearchActivity.class);
				startActivity(intents);
			}
		});
	}
	private void refreshListView()
	{
		Map<String,User> users = mNetHelper.getUsers();
		List<User> lists = sortUsers(users);
		ListViewAdapter myAdapter = new ListViewAdapter(this,lists);
		userlist.setAdapter(myAdapter);
	}
	private List<User> sortUsers(Map<String, User> users2) {
		// TODO Auto-generated method stub
		return null;
	}
	private void findViews() {
		// TODO Auto-generated method stub
		searchbtn = (Button)findViewById(R.id.btn_search);
		userlist=(ListView) findViewById(R.id.listView);
	}
	private boolean isWifiActive() {
		// TODO Auto-generated method stub
		ConnectivityManager mConnectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		if(mConnectivity != null){
			NetworkInfo[] infos = mConnectivity.getAllNetworkInfo();
			
			if(infos != null){
				for(NetworkInfo ni: infos){
					if("WIFI".equals(ni.getTypeName()) && ni.isConnected())
						return true;
				}
			}
		}
		return false;
	}
	@Override  
    protected void onResume() {  
        super.onResume();  
       // mApplication.setHandler(mainHandler);  
    }  

	private Handler mainHandler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			
		}
	};
	
}
