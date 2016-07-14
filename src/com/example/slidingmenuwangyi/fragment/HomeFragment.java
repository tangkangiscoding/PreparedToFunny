package com.example.slidingmenuwangyi.fragment;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.preparedtofun.MainActivity;
import com.example.preparedtofun.R;
import com.example.slidingmenuwangyi.adapter.ContentFragmentPagerAdapter;
import com.example.slidingmenuwangyi.entity.ContentBean;

@SuppressLint("InflateParams")
public class HomeFragment extends Fragment {
	
	private ViewPager mViewPager;
	private View view1, view2, view3;
	private Button btnsos;
	private List<View> viewList;// view����
	private List<String> titleList;  //�����б�����  
	
	private static final String[] titles = {"One","Two","Three","Four","Five"};
	private List<ContentBean> list = new ArrayList<ContentBean>();
	private ContentFragmentPagerAdapter mAdapter;
	
	public HomeFragment(){}
	
	@SuppressWarnings("deprecation")
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        mViewPager = (ViewPager) rootView.findViewById(R.id.mViewPager);
		PagerTabStrip mPagerTabStrip = (PagerTabStrip) rootView.findViewById(R.id.mPagerTabStrip);
		mPagerTabStrip.setTabIndicatorColor(getResources().getColor(R.color.select_text_color)); 
        LayoutInflater inflater1 = getActivity().getLayoutInflater();  
        view1 = inflater1.inflate(R.layout.mainlayout1, null);  
        view2 = inflater1.inflate(R.layout.mainlayout2, null);  
        view3 = inflater1.inflate(R.layout.mainlayout3, null);  
        
        btnsos = (Button)view3.findViewById(R.id.tosos);
        viewList = new ArrayList<View>();// ��Ҫ��ҳ��ʾ��Viewװ��������  
        viewList.add(view1);  
        viewList.add(view2);  
        viewList.add(view3);  
          
        titleList = new ArrayList<String>();// ÿ��ҳ���Title����  
        titleList.add("����֮��");  
        titleList.add("����֮��"); 
        titleList.add("����֮��"); 
        //titleList.add("���");  
        initData();
        //findView(rootView);
        
        return rootView;
    }

	private void initData() {
		
		for(int i=0;i<titles.length;i++){
			
			ContentBean cb = new ContentBean();
			cb.setTitle(titles[i]);
			cb.setContent(titles[i]+"_"+(i+1));
			
			list.add(cb);
		}
		btnsos.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������

				Intent intent = new Intent(getActivity(), MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);    
			}
		});
		
		PagerAdapter pagerAdapter = new PagerAdapter() {  
			  
            @Override  
            public boolean isViewFromObject(View arg0, Object arg1) {  
                // TODO Auto-generated method stub  
                //���ݴ�����key���ҵ�view,�ж��봫���Ĳ���View arg0�ǲ���ͬһ����ͼ  
                return arg0 == viewList.get((int)Integer.parseInt(arg1.toString()));  
            }  
  
            @Override  
            public int getCount() {  
                // TODO Auto-generated method stub  
                return viewList.size();  
            }  
  
            @Override  
            public void destroyItem(ViewGroup container, int position,  
                    Object object) {  
                // TODO Auto-generated method stub  
                container.removeView(viewList.get(position));  
            }  
  
            @Override  
            public Object instantiateItem(ViewGroup container, int position) {  
                // TODO Auto-generated method stub  
                container.addView(viewList.get(position));  
                  
                //�ѵ�ǰ������ͼ��λ�ã�position����ΪKey����ȥ  
                return position;  
            }  
              
            @Override  
            public CharSequence getPageTitle(int position) {  
                // TODO Auto-generated method stub  
                return titleList.get(position);  
            }  
        };  
  
        mViewPager.setAdapter(pagerAdapter); 
		
	}

	/*private void findView(View rootView) {
		
		mViewPager = (ViewPager) rootView.findViewById(R.id.mViewPager);
		
		PagerTabStrip mPagerTabStrip = (PagerTabStrip) rootView.findViewById(R.id.mPagerTabStrip);
		mPagerTabStrip.setTabIndicatorColor(getResources().getColor(R.color.select_text_color)); 
		
		mAdapter = new ContentFragmentPagerAdapter(getActivity().getSupportFragmentManager(),list);
		mViewPager.setAdapter(mAdapter);
	}*/
	
	@Override
	public void onStart() {
		
		if(mAdapter!=null){
			mAdapter.notifyDataSetChanged();
		}
		
		super.onStart();
	}
}
