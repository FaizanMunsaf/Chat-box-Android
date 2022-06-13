package com.example.firebase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MylistAdapter extends BaseAdapter {
    List<UserModel> userModellist;
    Context context;
    LayoutInflater Inflater;


    public MylistAdapter(List<UserModel> userModellist, Context context) {
        this.userModellist = userModellist;
        this.context = context;
        Inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return userModellist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = Inflater.inflate(R.layout.customlist,null);
        TextView sendmsg = view.findViewById(R.id.sendmsg);

        sendmsg.setText(userModellist.get(i).getMessage());
        return view;
    }
}
