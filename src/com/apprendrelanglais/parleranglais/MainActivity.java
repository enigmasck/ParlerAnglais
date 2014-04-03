package com.apprendrelanglais.parleranglais;

import java.util.Locale;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.*;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
	
	private CharSequence phraseDrawerTitle;
	private CharSequence phrasetitle; 

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
		Fragment fragment = new TitleFragment();
		Bundle args = new Bundle();
		args.putInt(TitleFragment.ARG_TITLE_NUMBER, position);
		fragment.setArguments(args);
		
	    FragmentManager fragmentManager = getFragmentManager();
	    fragmentManager.beginTransaction()
	                   .replace(R.id.content_frame, fragment)
	                   .commit();
	    
	    phraseListView.setItemChecked(position, true);
	    setTitle(phraseMainTitles[position]);
	    phraseDrawerLayout.closeDrawer(phraseListView);
		
	}
	
	public static class TitleFragment extends Fragment{
	    public static final String ARG_TITLE_NUMBER = "title number";

	    public TitleFragment() {
	        // Empty constructor required for fragment subclasses
	    }

	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View rootView = inflater.inflate(R.layout.fragment_title, container, false);
	        int i = getArguments().getInt(ARG_TITLE_NUMBER);
	        String planet = getResources().getStringArray(R.array.phraseMainTitles)[i];

	        int imageId = getResources().getIdentifier(planet.toLowerCase(Locale.getDefault()),
	                        "drawable", getActivity().getPackageName());
	        ((ImageView) rootView.findViewById(R.id.image)).setImageResource(imageId);
	        getActivity().setTitle(planet);
	        return rootView;
	    }
	}
	
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }
    
    public void setTitle(CharSequence title){
    	newTitle = title;
    	
    }



    
}