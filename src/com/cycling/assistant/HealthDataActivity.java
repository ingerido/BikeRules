package com.cycling.assistant;

import java.lang.reflect.Method; 

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;

public class HealthDataActivity extends Activity {
	
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);   
          
        ChartView chart = new ChartView(this);
        
        Display mDisplay = getWindowManager().getDefaultDisplay();
        @SuppressWarnings("deprecation")
		int height = mDisplay.getHeight();
        @SuppressWarnings("deprecation")
		int width = mDisplay.getWidth();
        
        chart.SetInfo(
        		height, width,
                new String[]{"7-11","7-12","7-13","7-14","7-15","7-16","7-17"},   //X��̶�
                new String[]{"","5","10","15","20","25"},   //Y��̶�
                new String[]{"2","5","10","4","8","17","13"},  //����
                "Health Data"
        );
        setContentView(chart);      
    }  

	// Menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		setIconEnable(menu, true);  
		
	    MenuItem item1 = menu.add(0, Menu.FIRST + 1, 0, "Connection");  
	    item1.setIcon(R.drawable.connectionmenu);  
	    MenuItem item2 = menu.add(0, Menu.FIRST + 2, 0, "Map");  
	    item2.setIcon(R.drawable.mapmenu);     
		return true;
	}
	
	@Override  
	public boolean onPrepareOptionsMenu(Menu menu)   
	{  
	    // TODO Auto-generated method stub  
	    return super.onPrepareOptionsMenu(menu);  
	}  
	  
	//enableΪtrueʱ���˵����ͼ����Ч��enableΪfalseʱ��Ч��4.0ϵͳĬ����Ч  
	private void setIconEnable(Menu menu, boolean enable)  
	{  
	    try   
	    {  
	        Class<?> clazz = Class.forName("com.android.internal.view.menu.MenuBuilder");  
	        Method m = clazz.getDeclaredMethod("setOptionalIconsVisible", boolean.class);  
	        m.setAccessible(true);  
	          
	        m.invoke(menu, enable);  
	          
	    } catch (Exception e)   
	    {  
	        e.printStackTrace();  
	    }  
	}  
	
	// Menu Event
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	
		switch (item.getItemId()) {
		case Menu.FIRST + 1:
	        // show map
			Intent intent_map = new Intent(HealthDataActivity.this ,ConnectionActivity.class);
			startActivity(intent_map);
			break;
		case Menu.FIRST + 2:
	        // show health data
			Intent intent_healthdata = new Intent(HealthDataActivity.this ,MapDisplayActivity.class);
			startActivity(intent_healthdata);
			break;
		}
		return true;
	}
}
