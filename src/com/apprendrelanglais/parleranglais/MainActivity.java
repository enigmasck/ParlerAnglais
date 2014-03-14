package com.apprendrelanglais.parleranglais;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.widget.*;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

//using this for layouts
//http://developer.android.com/training/implementing-navigation/nav-drawer.html

public class MainActivity extends Activity {
	
	private String[] phraseMainTitles;
	private String[] phrasePlacesTitles;
	private String[] phraseGreetingTitles;
	private String[] phraseDirectionTitles;
	private DrawerLayout phraseDrawerLayout;
	private ListView phraseListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        phraseMainTitles = getResources().getStringArray(R.array.phraseMainTitles);
        phrasePlacesTitles = getResources().getStringArray(R.array.phrasePlacesTitles);
        phraseGreetingTitles = getResources().getStringArray(R.array.phraseGreetingTitles);
        
        phraseDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        phraseListView = (ListView) findViewById(R.id.left_drawer);
        
        phraseListView.setAdapter(new ArrayAdapter<String>(this,
        												R.layout.drawer_list_item,
        												phraseMainTitles));
        
        phraseListView.setOnItemClickListener(new DrawerItemClickListener());
        
        
       
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
	private void selectItem(int position){
		Fragment fragment = new TitleFragement;
		
		
	}

    
}
