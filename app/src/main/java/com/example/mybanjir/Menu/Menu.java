package com.example.mybanjir.Menu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.mybanjir.R;

/*
    - Menu Activity -
*/
public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    /*
        Instantiate Event Handler when views are clicked
    */
    public void Clicked (View v) {
        MenuEventHandler homehandle = new MenuEventHandler(v, Menu.this);
    }

}