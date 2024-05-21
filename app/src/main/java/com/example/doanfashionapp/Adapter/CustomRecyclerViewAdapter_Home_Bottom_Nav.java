package com.example.doanfashionapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanfashionapp.DTO.SanPham;
import com.example.doanfashionapp.Interface.SelectListener;
import com.example.doanfashionapp.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class CustomRecyclerViewAdapter_Home_Bottom_Nav extends RecyclerView.Adapter<CustomRecyclerViewAdapter_Home_Bottom_Nav.ViewHolder> {
    private ArrayList<SanPham> listSP;
    private Context context;



    public CustomRecyclerViewAdapter_Home_Bottom_Nav(ArrayList<SanPham> listSP, Context context) {
        this.listSP = listSP;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context1=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context1);
        View view=inflater.inflate(R.layout.custom_recyclerview_home_bottom_nav,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SanPham sp = listSP.get(position);
        if (sp!=null){
            holder.txtTenSP.setText(sp.getTenSanPham());
            Locale locale =new Locale("vi","VN");
            NumberFormat format=NumberFormat.getInstance(locale);
            holder.txtGiaSP.setText(format.format(sp.getGiaSanPham())+" đ");
            holder.imageSP.setImageResource(sp.getIdAnhSanPham());
        }
    }

    @Override
    public int getItemCount() {
        return listSP.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View itemview;
        public TextView txtGiaSP;
        public TextView txtTenSP;
        public ImageView imageSP;

        public ImageButton imageFavorite;

        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            itemview = itemView;
            txtGiaSP = (TextView) itemView.findViewById(R.id.txtGiaSP);
            txtTenSP = (TextView) itemView.findViewById(R.id.txtTenSP);
            imageSP = (ImageView) itemView.findViewById(R.id.imageSP);
            imageFavorite = (ImageButton) itemView.findViewById(R.id.imageFavorite);
            linearLayout=(LinearLayout) itemView.findViewById(R.id.recyclerViewMainLayout);
            imageFavorite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), " Demo function", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
