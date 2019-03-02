package com.example.android.zingospotx;;

        import java.util.ArrayList;
        import java.util.List;
        import android.app.Activity;
        import android.content.Intent;
        import android.os.Bundle;
import android.util.Log;
import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.Spinner;
        import android.widget.Toast;
        import android.widget.AdapterView.OnItemSelectedListener;

        import com.example.android.zingospotx.R;

public class MainActivity extends Activity implements OnItemSelectedListener{
    Button b1;
    String item = "";
    String extra = "";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent in = getIntent();
        Log.d("abc", "onCreate: "+in);
        Log.d("abc", "onCreate: "+in.toString());



        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);
        b1=findViewById(R.id.scanbarcode);
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

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,BarcodeActivity.class);
                startActivity(i);
            }
        });
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