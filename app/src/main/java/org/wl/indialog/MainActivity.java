package org.wl.indialog;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.left_to_right);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InEmptyDialog.build(MainActivity.this).setSlideType(InEmptyDialog.SlideType.LEFT_TO_RIGHT).show();
            }
        });
        btn = (Button) findViewById(R.id.right_to_left);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InEmptyDialog.build(MainActivity.this).setSlideType(InEmptyDialog.SlideType.RIGHT_TO_LEFT).show();
            }
        });
        btn = (Button) findViewById(R.id.top_to_bottom);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InEmptyDialog.build(MainActivity.this).setSlideType(InEmptyDialog.SlideType.TOP_TO_BOTTOM).show();
            }
        });
        btn = (Button) findViewById(R.id.bottom_to_top);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InEmptyDialog.build(MainActivity.this).setSlideType(InEmptyDialog.SlideType.BOTTOM_TO_TOP).show();
            }
        });
        btn = (Button) findViewById(R.id.fade_in_out);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InEmptyDialog.build(MainActivity.this).setSlideType(InEmptyDialog.SlideType.FADE_IN_OUT).show();
            }
        });
        btn = (Button) findViewById(R.id.newspaper);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InEmptyDialog.build(MainActivity.this).setSlideType(InEmptyDialog.SlideType.NEWSPAPER).show();
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
