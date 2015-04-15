package com.example.filetransfer.adapter;

import java.util.List;

import com.example.filetransfer.activity.R;
import com.example.filetransfer.data.User;
import com.example.filetransfer.data.UserConst;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter{
	private Context context;
	private List<User> lists;
	private LayoutInflater layoutInflater;
	
	public ListViewAdapter(Context context,List<User> lists){
		this.context = context;
		this.lists = lists;
		layoutInflater = LayoutInflater.from(this.context);
	}
	
	@Override
	public int getCount(){
		return lists.size();
	}
	
	@Override
	public Object getItem(int position){
		return lists.get(position);
	}
	
	@Override
	public long getItemId(int position){
		return position;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
	
		ListItemView listItemView;
		if(convertView == null){
			convertView = layoutInflater.inflate(R.layout.itemview,null);
			listItemView = new ListItemView();
			listItemView.mTextView = (TextView) convertView.findViewById(R.id.ip_txt);
			listItemView.mButton1 = (Button) convertView.findViewById(R.id.btn_send);
			listItemView.mRelativeLayout = (RelativeLayout) convertView.findViewById(R.id.item_layout2);
			listItemView.mProgressBar = (ProgressBar) convertView.findViewById(R.id.file_pro);
			listItemView.mButton2 = (Button) convertView.findViewById(R.id.btn_ctrpro);
			convertView.setTag(listItemView);
		}else{
			listItemView = (ListItemView) convertView.getTag();
		}
		User user = lists.get(position);
		listItemView.mTextView.setText(user.getIp());
		switch(user.getFileState()){
		case UserConst.NOFILETRANSFER:
			listItemView.mButton1.setVisibility(View.VISIBLE);
			listItemView.mRelativeLayout.setVisibility(View.GONE);
			break;
		case UserConst.SENDINGFILE:
			listItemView.mRelativeLayout.setVisibility(View.VISIBLE);
			listItemView.mButton1.setVisibility(View.GONE);
			listItemView.mProgressBar.setProgress(user.getProcessRate());
			listItemView.mButton2.setText(context.getResources().getString(R.string.cancel));
		case UserConst.RECEIVINGFILE:
			listItemView.mRelativeLayout.setVisibility(View.VISIBLE);
			listItemView.mButton1.setVisibility(View.GONE);
			listItemView.mProgressBar.setProgress(user.getProcessRate());
			listItemView.mButton2.setText(context.getResources().getString(R.string.pause));
		case UserConst.PAUSERECEIVEFILE:
			listItemView.mRelativeLayout.setVisibility(View.VISIBLE);
			listItemView.mButton1.setVisibility(View.GONE);
			listItemView.mProgressBar.setProgress(user.getProcessRate());
			listItemView.mButton2.setText(context.getResources().getString(R.string.resume));
			break;
		}
		
		
		return convertView;
	}
	class ListItemView{
		TextView mTextView;
		Button mButton1;
		RelativeLayout mRelativeLayout;
		ProgressBar mProgressBar;
		Button mButton2;
	}
}
