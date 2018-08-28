package apc.softdev.modernizedorderingsystem;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class OrderList extends ArrayAdapter<Order> {
    private Activity context;
    private List<Order> orderList;

    public OrderList(Activity context, List<Order> orderList){
        super(context, R.layout.list_layout, orderList);
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView tvName = (TextView) listViewItem.findViewById(R.id.tvName);
        TextView tvQua = (TextView) listViewItem.findViewById(R.id.tvQua);

        Order order = orderList.get(position);

        tvName.setText(order.getOrderName());
        tvQua.setText(order.getOrderQuantity());

        return listViewItem;
    }
}
