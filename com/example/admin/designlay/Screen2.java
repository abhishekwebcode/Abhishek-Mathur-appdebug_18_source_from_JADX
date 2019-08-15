package com.example.admin.designlay;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;

public class Screen2 extends AppCompatActivity {

    class C03121 implements OnClickListener {
        C03121() {
        }

        public void onClick(View view) {
            Snackbar.make(view, (CharSequence) "Replace with your own action", 0).setAction((CharSequence) "Action", null).show();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0311R.layout.activity_screen2);
        setSupportActionBar((Toolbar) findViewById(C0311R.id.toolbar));
        ((FloatingActionButton) findViewById(C0311R.id.fab)).setOnClickListener(new C03121());
    }
}
