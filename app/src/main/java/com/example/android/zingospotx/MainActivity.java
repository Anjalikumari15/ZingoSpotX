package com.example.android.zingospotx;;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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

import org.json.JSONObject;

import POJOs.ReturnDetails;

public class MainActivity extends Activity implements OnItemSelectedListener{
    Thread t1 = new Thread(new Runnable() {
        @Override
        public void run() {
            StringBuilder content = new StringBuilder();
            try{
                // construct data

                JSONObject urlParameters = new JSONObject();
                urlParameters.put("apikey","EEILC1D86MSS75XR6T4055QBSE8KI1Z7");
                urlParameters.put("secret","QHH6V8VY1GNLX1X3");
                urlParameters.put("usetype","stage");
                urlParameters.put("phone", "7503917865");
                urlParameters.put("message", URLEncoder.encode("A Return with Return ID -L_-hBHwrzQfkodviRul, is initiated by retailer R1, to distributor D1, on 20190303_021505.\nFor more information contact 9561278478","UTF-8"));
                //  Log.d("xyz", "run: message1");
                //urlParameters.put("senderid", senderId);
                URL obj = new URL("http://www.way2sms.com/api/v1/sendCampaign");
                // send data
                HttpURLConnection httpConnection = (HttpURLConnection) obj.openConnection();
                httpConnection.setDoOutput(true);
                httpConnection.setRequestMethod("POST");
                DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
                wr.write(urlParameters.toString().getBytes());
                // get the response
                BufferedReader bufferedReader = null;
                if (httpConnection.getResponseCode() == 200) {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                } else {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
                }

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append("\n");
                }

                bufferedReader.close();
                String str = content.toString();
                Log.d("abc", "sendCampaigns: " + str);
            }catch(Exception ex){
                // System.out.println("Exception at:",ex);
                Log.d("abc", "sendCampaigns: error "+ ex);

            }
        }
    });
    Thread t2 = new Thread(new Runnable() {
        @Override
        public void run() {
            StringBuilder content = new StringBuilder();
            try{
                // construct data

                JSONObject urlParameters = new JSONObject();
                urlParameters.put("apikey","EEILC1D86MSS75XR6T4055QBSE8KI1Z7");
                urlParameters.put("secret","QHH6V8VY1GNLX1X3");
                urlParameters.put("usetype","stage");
               // urlParameters.put("phone", "8375860629");
                urlParameters.put("message", URLEncoder.encode("A Return with Return ID -L_-hBHwrzQfkodviRul, is initiated by retailer R1, to distributor D1, on 20190303_021505.\nFor more information contact 9561278478","UTF-8"));
              //  Log.d("xyz", "run : A Return with Return ID______, is initiated by retailer _______, to distributor __________, on Date_______.\nFor more information contact 9561278478");
                //urlParameters.put("senderid", senderId);
                URL obj = new URL("http://www.way2sms.com/api/v1/sendCampaign");
                // send data
                HttpURLConnection httpConnection = (HttpURLConnection) obj.openConnection();
                httpConnection.setDoOutput(true);
                httpConnection.setRequestMethod("POST");
                DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
                wr.write(urlParameters.toString().getBytes());
                // get the response
                BufferedReader bufferedReader = null;
                if (httpConnection.getResponseCode() == 200) {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                } else {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
                }

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append("\n");
                }

                bufferedReader.close();
                String str = content.toString();
                Log.d("abc", "sendCampaigns: " + str);
            }catch(Exception ex){
                // System.out.println("Exception at:",ex);
                Log.d("abc", "sendCampaigns: error "+ ex);

            }
        }
    });
    Thread t3 = new Thread(new Runnable() {
        @Override
        public void run() {
            StringBuilder content = new StringBuilder();
            try{
                // construct data

                JSONObject urlParameters = new JSONObject();
                urlParameters.put("apikey","EEILC1D86MSS75XR6T4055QBSE8KI1Z7");
                urlParameters.put("secret","QHH6V8VY1GNLX1X3");
                urlParameters.put("usetype","stage");
              //  urlParameters.put("phone", "9560213528");
                urlParameters.put("message", URLEncoder.encode("A Return with Return ID -L_-hBHwrzQfkodviRul, is initiated by retailer R1, to distributor D1, on 20190303_021505.\nFor more information contact 9561278478","UTF-8"));
                Log.d("xyz", "run: message3");
                //urlParameters.put("senderid", senderId);
                URL obj = new URL("http://www.way2sms.com/api/v1/sendCampaign");
                // send data
                HttpURLConnection httpConnection = (HttpURLConnection) obj.openConnection();
                httpConnection.setDoOutput(true);
                httpConnection.setRequestMethod("POST");
                DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
                wr.write(urlParameters.toString().getBytes());
                // get the response
                BufferedReader bufferedReader = null;
                if (httpConnection.getResponseCode() == 200) {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
                } else {
                    bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
                }

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line).append("\n");
                }

                bufferedReader.close();
                String str = content.toString();
                Log.d("abc", "sendCampaigns: " + str);
            }catch(Exception ex){
                // System.out.println("Exception at:",ex);
                Log.d("abc", "sendCampaigns: error "+ ex);

            }
        }
    });

    Button b1;
    String item = "";
    String extra = "";
    public void clear(View v) {
        EditText prod = (EditText)findViewById(R.id.product_name);
        prod.setText("");

        EditText batch = (EditText)findViewById(R.id.batch_no);
        batch.setText("");

        EditText mfg = (EditText)findViewById(R.id.mfg_date);
        mfg.setText("");

        EditText exp = (EditText)findViewById(R.id.exp_date);
        exp.setText("");

        EditText mrp = (EditText)findViewById(R.id.mrp);
        mrp.setText("");


    }
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
                    rDetails.setRet1("");
                    rDetails.setRet2("");
                    if(in.hasExtra("barcode"))
                    dbReference.child("Returns").push().setValue(rDetails);

                    Toast.makeText(MainActivity.this, "Items added to the cart and notification sent",
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
                t1.start();
                Log.d("abc", "onClick: thread1");
                t2.start();
                Log.d("abc", "onClick: thread2");
                t3.start();
                Log.d("abc", "onClick: thread3");
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

                Log.d("abc", "onClick: pikachu"+in.hasExtra("barcode"));
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
                rDetails.setRet1("");
                rDetails.setRet2("");
                if(in.hasExtra("barcode"))
                    dbReference.child("Returns").push().setValue(rDetails);
            }
        });

        //Spinner element
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(this);
        List<String> rea = new ArrayList<>();
        rea.add("Reason of return");
        rea.add("Damaged");
        rea.add("Expired");
        //creating adapter for spinner 2
        ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rea);
        dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(dataAdapter2);




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

       // if(item.equals("Choose Retailers")==true || item.equals("Reason of return")==true)
      //  Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    }
