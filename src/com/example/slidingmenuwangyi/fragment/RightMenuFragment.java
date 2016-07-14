package com.example.slidingmenuwangyi.fragment;


import com.example.preparedtofun.R;
import com.example.preparedtofun.SOSToSecureActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


public class RightMenuFragment extends Fragment{
	private Button right_permsg_center_btn_msgpush;
	@Override
	public void onAttach(Activity activity) {
		
		super.onAttach(activity);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}
	
	@SuppressLint("InflateParams")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.fragment_right_menu, null);
		right_permsg_center_btn_msgpush = (Button)rootView.findViewById(R.id.right_permsg_center_btn_msgpush);
		right_permsg_center_btn_msgpush.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
				Intent intent = new Intent(getActivity(), SOSToSecureActivity.class);
				startActivity(intent); 
			}
		});
		findView(rootView);
		
		return rootView;
	}

	private void findView(View rootView) {
		
	}

}
