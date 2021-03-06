package com.example.mvcsample;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {

	BroadcastReceiver receiver;
	@ViewById(R.id.txt)
	TextView txt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ControlerService_.intent(this).start();
		receiver=new BroadcastReceiver() {
			
			@Override
			public void onReceive(Context arg0, Intent arg1) {
				// TODO Auto-generated method stub
				
			}
		};
		this.registerReceiver(receiver, new IntentFilter("action1_rlt"));
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		return true;
	}
	@Click(R.id.txt)
	void txtClick(){
		LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("action2"));
		Log.d("Controler", System.currentTimeMillis()+"");
	}

}
