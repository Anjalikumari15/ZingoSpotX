package com.example.android.zingospotx;;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
        import android.widget.AdapterView.OnItemSelectedListener;

        import com.example.android.zingospotx.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import POJOs.ReturnDetails;

public class MainActivity extends Activity implements OnItemSelectedListener{
    Button b1;
    String item = "";
    String extra = "";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        final Intent in = getIntent();


        Log.d("abc", "onCreate: "+in);
        Log.d("abc", "onCreate: "+in.toString());



        final EditText prod_name,batch_no,exp,mfg,mrp;
        prod_name = (EditText)findViewById(R.id.product_name);
        batch_no = (EditText)findViewById(R.id.batch_no);
        exp = (EditText)findViewById(R.id.exp_date);
        mfg = (EditText)findViewById(R.id.mfg_date);
        mrp = (EditText)findViewById(R.id.mrp);

        TextView tvbarcode = (TextView)findViewById(R.id.tvBarcode);

        if(in.hasExtra("barcode")) {
            tvbarcode.setText(in.getStringExtra("barcode"));
        }




        Button b = (Button)findViewById(R.id.submit);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Log.d("abc", "onClick: has extra");
                    String prodname = prod_name.getText().toString();
                    final String batchno = batch_no.getText().toString();
                    final String expdate = exp.getText().toString();
                    final String mfgdate = mfg.getText().toString();
                    String mrprice = mrp.getText().toString();

                    final DatabaseReference dbReference = FirebaseDatabase.getInstance()
                            .getReference();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
                    String currentDateandTime = sdf.format(new Date());
                    ReturnDetails rDetails = new ReturnDetails();
                    rDetails.setBarcode(in.getStringExtra("barcode"));
                    rDetails.setBatchno(batchno);
                    rDetails.setCreated_at(currentDateandTime);
                    rDetails.setExp(expdate);
                    rDetails.setMfg(mfgdate);
                    rDetails.setMrp(mrprice);
                    rDetails.setPname(prodname);
                    rDetails.setReason("damaged");
                    rDetails.setRetailerId("r1");
                    rDetails.setDistributorId("d1");
                    dbReference.child("Returns").push().setValue(rDetails);

                    Toast.makeText(MainActivity.this, "Items added to the cart",
                            Toast.LENGTH_SHORT).show();

                /*if(in.hasExtra("barcode")) {
                    Log.d("abc", "onClick: submit has extra");

                    dbReference.child("temp").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Log.d("abc", "onDataChange: ");
                            for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                                ReturnDetails rd = (ReturnDetails) dataSnapshot1.getValue();
                                Log.d("abc", "onDataChange:  yayye"+rd);
                                dbReference.child("Returns").push().setValue(rd);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                    dbReference.child("temp").removeValue();

                }*/

            }

        });

        Button btnScan = findViewById(R.id.scanbarcode);
        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("abc", "onClick: ");

                Intent intent = new Intent(MainActivity.this, BarcodeActivity.class);
                startActivity(intent);
            }
        });
        Button btnAdd = findViewById(R.id.addItem);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String prodname = prod_name.getText().toString();
                final String batchno = batch_no.getText().toString();
                final String expdate = exp.getText().toString();
                final String mfgdate = mfg.getText().toString();
                String mrprice = mrp.getText().toString();

                DatabaseReference dbReference = FirebaseDatabase.getInstance()
                        .getReference();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
                String currentDateandTime = sdf.format(new Date());
                ReturnDetails rDetails = new ReturnDetails();
                rDetails.setBarcode(in.getStringExtra("barcode"));
                rDetails.setBatchno(batchno);
                rDetails.setCreated_at(currentDateandTime);
                rDetails.setExp(expdate);
                rDetails.setMfg(mfgdate);
                rDetails.setMrp(mrprice);
                rDetails.setPname(prodname);
                rDetails.setReason("damaged");
                rDetails.setRetailerId("r1");
                rDetails.setDistributorId("d1");
                dbReference.child("Returns").push().setValue(rDetails);
            }
        });


        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Choose Retailers");
        categories.add("Dinesh Kumar");
        categories.add("Rajiv Goel");
        categories.add("Sanjay Bansal");
        categories.add("Alok Pandey");
        categories.add("Anuj Jain");
        categories.add("Saurabh Singh");
        categories.add("Sandeep Aggarwal");
        categories.add("Ajay Dhawan");
        categories.add("Shreyashish Sengupta");
        categories.add("Aditya Gohad");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item



        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}