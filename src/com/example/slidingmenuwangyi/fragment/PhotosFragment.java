package com.example.slidingmenuwangyi.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.preparedtofun.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;


public class PhotosFragment extends Fragment {
	private ListView history_list;
	public PhotosFragment(){}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		setHasOptionsMenu(true);
		
		super.onCreate(savedInstanceState);
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_photos, container, false);
        history_list = (ListView)rootView.findViewById(R.id.history_list);
        initView();
        return rootView;
    }
	
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		super.onCreateOptionsMenu(menu, inflater);
	}
	
	private void initView(){
		/*SimpleAdapter adapter = new SimpleAdapter(getActivity(), getData(),
                R.layout.history_list_item, new String[] { "img", "title", "info" },
                new int[] { R.id.ls_item_imag, R.id.ls_item_position, R.id.ls_item_time });
		history_list.setAdapter(adapter);*/
	}
	
	 /*private List<Map<String, Object>> getData() {
	        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	        Map<String, Object> map = new HashMap<String, Object>();
	        map.put("img", R.drawable.huanlegu_pic1);
	        map.put("title", "凤舞九天");
	        map.put("info", "June 14th 9:00");
	        list.add(map);

	        map = new HashMap<String, Object>();
	        map.put("img", R.drawable.huanlegu_pic2);
	        map.put("title", "太阳神车");
	        map.put("info", "June 14th 9:50");
	        list.add(map);

	        map = new HashMap<String, Object>();
	        map.put("img", R.drawable.huanlegu_pic3);
	        map.put("title", "激流勇进");
	        map.put("info", "June 14th 10:40");
	        list.add(map);

	        map = new HashMap<String, Object>();
	        map.put("img", R.drawable.huanlegu_pic4);
	        map.put("title", "能量风暴");
	        map.put("info", "June 14th 13:40");
	        list.add(map);

	        map = new HashMap<String, Object>();
	        map.put("img", R.drawable.huanlegu_pic5);
	        map.put("title", "抢滩游戏");
	        map.put("info", "June 14th 16:10");
	        list.add(map);

	        return list;
	    }*/
}
