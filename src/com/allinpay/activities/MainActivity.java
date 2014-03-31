package com.allinpay.activities;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.allinpay.R;
import com.allinpay.printer.EBuyPrinter;
import com.allinpay.printer.FaceToFacePrinter;
import com.allinpay.printer.exception.AccessException;

public class MainActivity extends Activity implements View.OnClickListener {
	
	private Button printButton1,printButton2;


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main_activity);
		findViews();
		
		
	}

	private void findViews() {
		printButton1 = (Button) findViewById(R.id.printButton1);
		printButton1.setOnClickListener(this);
		printButton2 = (Button) findViewById(R.id.printButton2);
		printButton2.setOnClickListener(this);
	}
	

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.printButton1:
			EBuyPrinter mEBuyPrinter = new EBuyPrinter(getApplicationContext());
			try {
				mEBuyPrinter.print(null);
			} catch (AccessException e) {
				e.printStackTrace();
			}
			break;
		case R.id.printButton2:	
			FaceToFacePrinter mFaceToFacePrinter = new FaceToFacePrinter(getApplicationContext());
			try {
				mFaceToFacePrinter.print();
			} catch (AccessException e) {
				e.printStackTrace();
			}
			break;
			
		default:
			break;
		}
	}
	
	
}