package com.allinpay.printer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.allinpay.R;
import com.allinpay.data.common.Utils;
import com.allinpay.printer.constants.FaceToFaceConstants;
import com.allinpay.printer.control.Align;
import com.allinpay.printer.control.Depth;
import com.allinpay.printer.control.FontType;
import com.allinpay.printer.control.PrinterControl;
import com.allinpay.printer.devices.DeviceManager;
import com.allinpay.printer.entity.FormatSetting_Command;
import com.allinpay.printer.exception.AccessException;

public class FaceToFacePrinter extends FaceToFaceConstants{

	private Context ctx;
	
	public FaceToFacePrinter(Context ctx) {
		this.ctx = ctx;
	}
	
	public void print() throws AccessException {
		PrinterControl control = DeviceManager.getInstance()
				.getPrinterControlEx();
		control.open();
		control.sendESC(FormatSetting_Command.getESCan(Align.CENTER));
		
		Drawable mDrawable = ctx.getResources().getDrawable(R.drawable.zfb);
		Bitmap mBitMap = ((BitmapDrawable)mDrawable).getBitmap();
		control.printImage(Bitmap.createScaledBitmap(mBitMap, 250, 80, false));
		
		control.sendESC(FormatSetting_Command.getESCan(Align.LEFT));
		control.printText("\n");
		
		control.printText(TAG_DTITAL+"\n", FontType.DOUBLE_H,Align.CENTER);
		
		control.printText(TAG_DATETIME+Utils.getCurrentDateTime()+"\n", FontType.NORMAL, Align.LEFT);
		
		control.printText(TAG_BATCH+"000001"+"\t"+TAG_CERT+"00011"+"\n", FontType.NORMAL, Align.LEFT);
		
		control.printText(TAG_MERCHANT+"123456789123456"+"\n", FontType.NORMAL, Align.LEFT);
		
		control.printText("消费撤销"+"\n", FontType.DOUBLE_W, Align.CENTER);
		
		control.printText(TAG_ORDERNO+"\n", FontType.NORMAL, Align.LEFT,Depth.DEEP);
		
		control.printText("201403281664565656456"+"\n", FontType.NORMAL, Align.LEFT,Depth.DEEP);
		
		control.sendESC(FormatSetting_Command.getESCan(Align.CENTER));
		control.printBarcode(PrinterControl.BARCODE_JAN13, "123456789123");
		control.sendESC(FormatSetting_Command.getESCan(Align.LEFT));
		
		control.printText(TAG_AMOUNT+"\t\t"+"0.01"+"\n", FontType.DOUBLE_H, Align.LEFT,Depth.DEEP);
		
		control.printText("\n\n");
		
		control.printText(TAG_SIGN+"\n");
		
		control.printText("---商户存跟---"+"\n", FontType.DOUBLE_H, Align.CENTER);
		control.printText(TAG_LINE2+"\n");
		
		control.printText("\n\n\n");
		control.close();
	}
}
