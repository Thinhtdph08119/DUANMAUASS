package com.example.myapplication.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.DAO.NguoiDungDAO;
import com.example.myapplication.R;
import com.example.myapplication.model.NguoiDung;

import java.util.List;

public class NguoiDungAdapter extends BaseAdapter {
    public Activity context;
    public List<NguoiDung> arrNguoiDung;
    public LayoutInflater inflater;
    NguoiDungDAO nguoiDungDAO;

    public NguoiDungAdapter(Activity context, List<NguoiDung> arrNguoiDung)
    {
        super();
        this.context = context;
        this.arrNguoiDung = arrNguoiDung;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        nguoiDungDAO = new NguoiDungDAO(context);

    }

    @Override
    public int getCount() {
        return arrNguoiDung.size();
    }

    @Override
    public Object getItem(int position) {
        return arrNguoiDung.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null)
        {
            holder = new ViewHolder();
            convertView= inflater.inflate(R.layout.item_nguoi_dung,null);
            holder.img = (ImageView)convertView.findViewById(R.id.ivIcon);
            holder.txtName = (TextView)convertView.findViewById(R.id.tvName);
            holder.txtPhone = (TextView)convertView.findViewById(R.id.tvPhone);
            holder.imgDelete = (ImageView)convertView.findViewById(R.id.ivDelete);

            holder.imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Intent intent = new Intent(context, NguoiDungActivity.class);
                    NguoiDung nguoiDung = arrNguoiDung.get(position);
                    arrNguoiDung.remove(nguoiDung);
                    notifyDataSetChanged();

                }
            });
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)convertView.getTag();
        }

        NguoiDung nguoiDung = arrNguoiDung.get(position);
        holder.txtName.setText(nguoiDung.getUserName());
        holder.txtPhone.setText(nguoiDung.getPhone());

        return convertView;
    }

    public static class ViewHolder{
        public ImageView img;
        public TextView txtName;
        public TextView txtPhone;
        public ImageView imgDelete;

    }


}
