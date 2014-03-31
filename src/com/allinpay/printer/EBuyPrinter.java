package com.allinpay.printer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import com.allinpay.R;
import com.allinpay.data.common.Utils;
import com.allinpay.entity.Demo1Entity;
import com.allinpay.printer.constants.EBuyConstant;
import com.allinpay.printer.control.Align;
import com.allinpay.printer.control.Depth;
import com.allinpay.printer.control.FontType;
import com.allinpay.printer.control.PrinterControl;
import com.allinpay.printer.devices.DeviceManager;
import com.allinpay.printer.entity.FormatSetting_Command;
import com.allinpay.printer.exception.AccessException;
import com.allinpay.printer.util.QRcodeBitmap;
import com.allinpay.util.StringUtils;

public class EBuyPrinter extends EBuyConstant{

	private Context ctx;
	
	public EBuyPrinter(Context ctx) {
		this.ctx = ctx;
	}
	
	@Override
	public void print(Demo1Entity demodata) throws AccessException {
		PrinterControl control = DeviceManager.getInstance()
				.getPrinterControlEx();

		control.open();
		
		control.sendESC(FormatSetting_Command.getESCan(Align.CENTER));
		
		Drawable mDrawable = ctx.getResources().getDrawable(R.drawable.zfb);
		Bitmap mBitMap = ((BitmapDrawable)mDrawable).getBitmap();
		control.printImage(Bitmap.createScaledBitmap(mBitMap, 250, 80, false));
		
		
		control.printText(TAG_DTITAL+"\n", 
				FontType.DOUBLE_WH, Align.CENTER);
		
		control.printText(TAG_LINE2+"\n");
		
		control.printText(TAG_MERCHANT+"\n");
		
		control.printText("万宁测试门店"+"\n", 
				FontType.NORMAL, Align.LEFT,Depth.DEEP);
		
		control.printText(TAG_TERMINAL+"99000018"+"\n");
		
		control.printText(TAG_REF+"845160000619"+"\n");
		
		control.printText(TAG_DATE +Utils.getCurrentDate()+"\n");
		
		control.printText(TAG_TIME+Utils.getCurrentTime()+"\n");
		
		control.printText(TAG_PAYTYPE+"\n");
		
		control.printText("二维码支付"+"\n", 
				FontType.NORMAL, Align.LEFT,Depth.DEEP);
		
		control.printText(TAG_TRACE+"000619"+"\n");
		
		control.printText(TAG_LINE2+"\n");
		
		control.printText(TAG_CHANNEL+"支付宝当面付"+"\n");
		
		control.printText(TAG_ACCOUNT+"imbakn@gmail.com"+"\n");
		
		control.printText(TAG_AMOUNT+"0.01元"+"\n");
		
		String number = "201403241100100473006562136";
		
		control.printText("No."+number+"\n");
		
		//设置的状态并没有记录，所以结束后要重新设置回去，否这有bug
		control.sendESC(FormatSetting_Command.getESCan(Align.CENTER));
		Bitmap mQrcode = QRcodeBitmap.create(number, 250, 250);
		control.printImage(mQrcode);
		control.sendESC(FormatSetting_Command.getESCan(Align.LEFT));
		
		
		control.printText("POS退货时，请扫上方二维码"+"\n");
		
		control.printText(TAG_LINE2+"\n");
		
		control.printText(TAG_TELLERNO+"0001"+"\n");
		
		control.printText(TAG_SIGNATURE+"\n\n\n");
		
		control.printText(TAG_LINE2+"\n");
		
		control.printText("\n\n\n");
		control.close();
	}

}
