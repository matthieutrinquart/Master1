package com.example.tpmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdaptateur1  extends BaseAdapter {
    private Context context;
    private List<String> list;
    private LayoutInflater inflater;

    public ListAdaptateur1(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public String getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.listview_adaptateur1,null);
        TextView Text1 = view.findViewById(R.id.textexo2);

        String s = getItem(i);
        Text1.setText(s);

        return view;
    }
}
