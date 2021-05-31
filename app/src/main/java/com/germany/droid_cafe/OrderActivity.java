package com.germany.droid_cafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView imgCaptur;
    TextView idDescrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        idDescrip = findViewById(R.id.idDescrip);
        TextView order_textview = findViewById(R.id.order_textview);
        imgCaptur = findViewById(R.id.imgCaptur);


        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

//        textView.setText(message);
        if (message.equals("Donut")) {
            idDescrip.setText(R.string.donut);
            order_textview.setText(R.string.donut_order);
            imgCaptur.setImageResource(R.drawable.donut_circle);
        } else if (message.equals("iceCream")) {
            idDescrip.setText(R.string.ice_cream_sandwiches);
            order_textview.setText(R.string.ice_cream_order);
            imgCaptur.setImageResource(R.drawable.icecream_circle);
        } else if (message.equals("froyo")) {
            idDescrip.setText(R.string.froyo);
            order_textview.setText(R.string.froyo_order);
            imgCaptur.setImageResource(R.drawable.froyo_circle);
        }


        Spinner spinner = findViewById(R.id.lblSpinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);

        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
// ... End of onCreate code ...
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
//        boolean marca= R.id.rbDia.isChecked();
        switch (view.getId()) {
            case R.id.rbDia:
                if (checked)
                    // Same day service
                    displayToast(getString(R.string.rbDia));
                break;
            case R.id.rbNextday:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.rbNextDay));
                break;
            case R.id.rbPickUp:
                if (checked)
                    // Pick up
                    displayToast(getString(R.string.rbPickUp));
                break;
            default:
                // Do nothing.
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
        String spinnerLabel = parent.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {


    }


//    public class OrderActivity extends AppCompatActivity implements
//            AdapterView.OnItemSelectedListener {
//
//    }

}