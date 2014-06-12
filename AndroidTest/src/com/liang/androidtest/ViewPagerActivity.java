package com.liang.androidtest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ViewPagerActivity extends Activity {
	private View view1,view2,view3;
	private List<View> viewList = new ArrayList<View>();
	private ViewPager viewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager);
		
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		
		getLayoutInflater();
		LayoutInflater li = LayoutInflater.from(this);
		view1 = li.inflate(R.layout.page_one, null);
		view2 = li.inflate(R.layout.page_two, null);
		view3 = li.inflate(R.layout.page_three, null);
		
		viewList.add(view1);
		viewList.add(view2);
		viewList.add(view3);
		
		MyViewPagerAdapter adapter = new MyViewPagerAdapter(viewList);
		
		viewPager.setAdapter(adapter);
	}
	
	public class MyViewPagerAdapter extends PagerAdapter{
		private List<View> mListViews;
		
		public MyViewPagerAdapter(List<View> mListViews) {
			this.mListViews = mListViews;//构造方法，参数是我们的页卡，这样比较方便。
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) 	{	
			container.removeView(mListViews.get(position));//删除页卡
		}


		@Override
		public Object instantiateItem(ViewGroup container, int position) {	//这个方法用来实例化页卡		
			 container.addView(mListViews.get(position), 0);//添加页卡
			 return mListViews.get(position);
		}

		@Override
		public int getCount() {			
			return  mListViews.size();//返回页卡的数量
		}
		
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {			
			return arg0==arg1;//官方提示这样写
		}
	}
}
