package com.omansh.Dialer;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Omansh on 9/5/2017.
 */

public class MyAdapter extends BaseAdapter {

    Context mContext;
    ArrayList<Contact> mlistofContacts;

    public MyAdapter(Context Context,ArrayList<Contact> listofContacts){

        this.mContext=Context;
        this.mlistofContacts=listofContacts;
    }


    @Override
    public int getCount() {
        return mlistofContacts.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder;
        if(convertView==null){
            holder=new Holder();
            convertView=View.inflate(mContext,R.layout.list_item,null);
            holder.txtName= (TextView) convertView.findViewById(R.id.txtname);
            holder.txtPhoneNumber= (TextView) convertView.findViewById(R.id.txtPhoneNumber);
            holder.txtEmailId= (TextView) convertView.findViewById(R.id.txtEmail);
            holder.txtAddress= (TextView) convertView.findViewById(R.id.txtAddress);
        }else{
            holder= (Holder) convertView.getTag();
        }
        //Contact contact=mlistofContacts.get(position);
        holder.txtName.setText(mlistofContacts.get(position).getName());
        holder.txtPhoneNumber.setText(mlistofContacts.get(position).getPhoneNumber());
        holder.txtEmailId.setText(mlistofContacts.get(position).getEmailId());
        holder.txtAddress.setText(mlistofContacts.get(position).getAddress());
        return convertView;
    }

    class Holder{
        TextView txtName,txtPhoneNumber,txtEmailId,txtAddress;
    }
}
