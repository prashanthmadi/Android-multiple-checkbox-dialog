package com.example.testproj;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

public class MultipleCheckBoxAdapter extends ArrayAdapter<String> {

	Context context;
	int layoutResourceId;
	List<String> input;
	ArrayAdapterClickHelper clickHelper;

	public MultipleCheckBoxAdapter(Context context, int layoutResourceId,
			List<String> input, ArrayAdapterClickHelper clickHelper) {
		super(context, layoutResourceId, input);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.input = input;
		this.clickHelper = clickHelper;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View view = inflater.inflate(layoutResourceId, null);
		CheckBox checkbox = (CheckBox) view.findViewById(R.id.checkBox1);
		final int clickPosition = position;
		checkbox.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {				
				clickHelper.clickDelegate(clickPosition,((CheckBox)view).isChecked());
			}
		});

		return view;

	}

}
