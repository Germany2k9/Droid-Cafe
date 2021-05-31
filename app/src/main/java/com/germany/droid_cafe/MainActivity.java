package com.germany.droid_cafe;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =
                "com.germany.droid_cafe.extra.MESSAGE";

        String mOrderMessage;
        ImageView imgCaptur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        imgCaptur = findViewById(R.id.imgCaptur);

        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                    if (mOrderMessage!=null){
                        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                            intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
//                intent.putExtra(imgCaptur, );

                        startActivity(intent);
                    }else{
                        Snackbar.make(view, "Debes seleccionar un Producto",  Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    }




            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.actionOrden:

                displayToast(getString(R.string.action_order_message));
                if (mOrderMessage!=null){
                    Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                    intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                    startActivity(intent);
                }else{
                    displayToast( "Debes seleccionar un Producto");
                }

                return true;
            case R.id.actionEstado:
                displayToast(getString(R.string.action_status_message));
                return true;
            case R.id.actionFavoritos:
                displayToast(getString(R.string.action_favorites_message));
                return true;
            case R.id.actionContact:
                displayToast(getString(R.string.action_contact_message));
                return true;
            default:
                // Do nothing
        }
        return super.onOptionsItemSelected(item);



//        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.actionOrden) {
//            return true;
//        }

//        return super.onOptionsItemSelected(item);

  }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();


//        Toast.makeText(getApplicationContext(), message,
//                Toast.LENGTH_SHORT).show();
    }

    /**
     * Shows a message that the donut image was clicked.
     */
    public void showDonutOrder(View view) {
        displayToast(getString(R.string.donut_order_message));

        mOrderMessage = "Donut";

  }

    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    public void showIceCreamOrder(View view) {
        displayToast(getString(R.string.ice_cream_order_message));
        mOrderMessage = "iceCream";
    }

    /**
     * Shows a message that the froyo image was clicked.
     */
    public void showFroyoOrder(View view) {
        displayToast(getString(R.string.froyo_order_message));
        mOrderMessage = "froyo";
    }

}