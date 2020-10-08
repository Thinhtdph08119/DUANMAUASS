package com.example.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.DAO.NguoiDungDAO;
import com.example.myapplication.NguoiDungActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.NguoiDung;

import java.util.List;

public class NguoiDungRecyclerAdapter extends RecyclerView.Adapter<NguoiDungRecyclerAdapter.RecyclerHolderView> {
    private Context context;
    private List<NguoiDung> arrNguoiDung;
    private LayoutInflater inflater;
    NguoiDungDAO nguoiDungDAO;

    public NguoiDungRecyclerAdapter(Context context, List<NguoiDung> arrNguoiDung)
    {

        this.context = context;
        this.arrNguoiDung = arrNguoiDung;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        nguoiDungDAO = new NguoiDungDAO(context);
    }

    @Override
    public int getItemCount() {
        return arrNguoiDung.size();
    }

    //gan du lieu
    @Override
    public void onBindViewHolder(RecyclerHolderView recyclerHolderView, final int position) {
        final NguoiDung nguoiDung = arrNguoiDung.get(position);
        recyclerHolderView.tvName.setText(nguoiDung.getUserName());
        recyclerHolderView.tvPhone.setText(nguoiDung.getPhone());
        recyclerHolderView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NguoiDung nguoiDung1= arrNguoiDung.get(position);
                Intent intent=new Intent(context, NguoiDungActivity.class);

                Bundle bundle=new Bundle();
                bundle.putString("userName",nguoiDung1.getUserName());
                bundle.putString("password",nguoiDung1.getPassword());
                bundle.putString("phone",nguoiDung1.getPhone());
                bundle.putString("hoTen",nguoiDung1.getHoTen());
                intent.putExtra("bun",bundle);
                Toast.makeText(context,"sua",Toast.LENGTH_LONG).show();
                context.startActivity(intent);
            }
        });

    }
    //tao view
    @Override
    public RecyclerHolderView onCreateViewHolder(ViewGroup viewGroup, final int i) {
        View view = inflater.inflate(R.layout.item_nguoi_dung,null);
        RecyclerHolderView  view1 = new RecyclerHolderView(view);
        view1.ivIcon = (ImageView)view.findViewById(R.id.ivIcon);
        view1.tvName = (TextView)view.findViewById(R.id.tvName);
        view1.tvPhone = (TextView)view.findViewById(R.id.tvPhone);
        view1.ivDelete = (ImageView)view.findViewById(R.id.ivDelete);
        view1.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //lay duoc vi tri item
                nguoiDungDAO.deleteNguoiDung(arrNguoiDung.get(i).getUserName());
               NguoiDung nguoiDung= arrNguoiDung.get(i);
               arrNguoiDung.remove(nguoiDung);
               notifyDataSetChanged();
            }
        });

        return view1;
    }



    public class RecyclerHolderView extends RecyclerView.ViewHolder{

        ImageView ivIcon;
        TextView tvName;
        TextView tvPhone;
        ImageView ivDelete;

        public RecyclerHolderView(View itemView) {
            super(itemView);
            this.ivIcon = ivIcon;
            this.tvName = tvName;
            this.tvPhone = tvPhone;
            this.ivDelete = ivDelete;
        }
    }
}
