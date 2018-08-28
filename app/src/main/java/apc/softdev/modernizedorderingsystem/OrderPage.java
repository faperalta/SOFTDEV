package apc.softdev.modernizedorderingsystem;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    ArrayList<String> myArrayList = new ArrayList<>();
    private ListView listViewOrder;
    Firebase myFirebase;

    List<Order> orderList;

    private Button new_order_button;
    private Button checkout_button;
    private TextView tvTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        new_order_button = findViewById(R.id.new_order_button);
        checkout_button = findViewById(R.id.checkout_button);

        tvTable = (TextView)findViewById(R.id.tvTable);

        Intent intent1 = getIntent();
        String str = intent1.getStringExtra("message");
        tvTable.setText(str);



        String DeviceID = Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        Firebase.setAndroidContext(this);
        myFirebase = new Firebase("https://modernizedorderingsystem.firebaseio.com/Customer"
                + DeviceID + "/Orders");


        listViewOrder = findViewById(R.id.listViewOrder);
        orderList = new ArrayList<>();


        new_order_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                addorder();

            }
        });

        checkout_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                checkout();

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        myFirebase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                orderList.clear();
                for(DataSnapshot ordersSnapshot: dataSnapshot.getChildren()){
                    Order orders = ordersSnapshot.getValue(Order.class);

                    orderList.add(orders);
                }

                ArrayAdapter adapter = new OrderList(OrderPage.this, orderList);
                listViewOrder.setAdapter(adapter);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    private void addorder() {
        String str = tvTable.getText().toString();
        Intent intent1 = new Intent(getApplicationContext(), NewOrder.class);
        intent1.putExtra("message", str);

        startActivity(intent1);
    }

    private void checkout() {
        Intent intent = new Intent (this, CreditCard.class);
        startActivity(intent);
    }


}
