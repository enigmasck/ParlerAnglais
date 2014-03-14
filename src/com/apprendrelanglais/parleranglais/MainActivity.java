package com.apprendrelanglais.parleranglais;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	private String[] phraseCats;
	private DrawerLayout phraseDrawerLayout;
	private ListView phraseListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
