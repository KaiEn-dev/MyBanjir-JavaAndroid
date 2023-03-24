package com.example.mybanjir.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mybanjir.Alert.AlertCentre;
import com.example.mybanjir.R;
import com.example.mybanjir.Search.Search;

import java.io.Serializable;

/*
    - Home Setup activity -

    Set up home location at the first launch of the app
 */
public class HomeSetup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_setup);
    }

    /*
        Launch Search activity when GO button is pressed
     */
    public void GOhomesetup(View v){
        Intent i = new Intent(v.getContext(), Search.class);
        i.putExtra("homesetup", 1);
        v.getContext().startActivity(i);
        this.finish();
    }

    /*
        Disable back press button to ensure home location is set
    */
    @Override
    public void onBackPressed() {
        Toast.makeText(HomeSetup.this, "Home location must be setup",Toast.LENGTH_SHORT).show();
    }

}