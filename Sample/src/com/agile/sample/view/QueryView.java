package com.agile.sample.view;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

import com.agile.sample.R;
import com.decade.agile.DZAgileView;
import com.decade.framework.DZBaseViewActivity;

public class QueryView extends DZAgileView{
	private Context context;

	public QueryView(ViewGroup root, DZBaseViewActivity parent) {
		super(root, parent);
		context = getContext();
	}
 
	@Override
	protected void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected View create() {
		View view = inflateView(R.layout.query_view, null);
		initViews(view);
		return view;
	}
	
	public void initViews(View view) {
		
	}

	@Override
	protected void start(Object arg0) {
		setTopTitleText("查询");
	}
	
	@Override
	protected boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return false;
		}
		return super.onKeyDown(keyCode, event);
	}

}
