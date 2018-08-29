package apc.softdev.modernizedorderingsystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter{

    private int imageViews[];
    private String tvMealName[];
    private String tvPrice1[];
    private Context context;
    private LayoutInflater inflater;

    public GridAdapter(Context context, int imageViews[], String tvMealName[], String tvPrice1[]){

        this.context=context;
        this.imageViews=imageViews;
        this.tvMealName=tvMealName;
        this.tvPrice1=tvPrice1;

    }


    @Override
    public int getCount() {
        return tvMealName.length;
    }

    @Override
    public Object getItem(int i) {
        return tvMealName[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View gridView = view;


        if(view == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            gridView = inflater.inflate(R.layout.custom_layout,null);

        }

        ImageView imageView = gridView.findViewById(R.id.imageViews);

        TextView tvPrices = gridView.findViewById(R.id.tvPrice1);

        TextView tvMealNam = gridView.findViewById(R.id.tvMealName);

        imageView.setImageResource(imageViews[i]);

        tvPrices.setText(tvPrice1[i]);

        tvMealNam.setText(tvMealName[i]);




        return gridView;

        }
    }