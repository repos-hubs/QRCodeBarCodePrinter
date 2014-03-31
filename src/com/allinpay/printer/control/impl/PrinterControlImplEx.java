package com.allinpay.printer.control.impl;

import com.allinpay.printer.control.Align;
import com.allinpay.printer.control.Depth;
import com.allinpay.printer.control.FontType;
import com.allinpay.printer.control.PrinterSetting;
import com.allinpay.printer.entity.CharacterSetting_Command;
import com.allinpay.printer.entity.FormatSetting_Command;
import com.allinpay.printer.exception.AccessException;

public class PrinterControlImplEx extends PrinterControlImpl {
	
	protected static final String TAG = "PrinterControlImplEx";
	
	public void printText(String paramString,byte fonttype) throws AccessException
	{
		if (!this.isOpened) {
			throw new AccessException(2);
		}
		printText(paramString,fonttype,Align.LEFT,Depth.NORMAL);
	}
	
	public void printText(String paramString,byte fonttype,byte align) throws AccessException
	{
		if (!this.isOpened) {
			throw new AccessException(2);
		}
		printText(paramString,fonttype,align,Depth.NORMAL);
	}
	
	public void printText(String paramString,byte fonttype,byte align,byte depth) throws AccessException
	{
		if (!this.isOpened) {
			throw new AccessException(2);
		}
		if(PrinterSetting.checkFontType(fonttype))
		{
			sendESC(CharacterSetting_Command.getGSExclamationN(fonttype));
		}
		if(PrinterSetting.checkAlignMode(align))
		{
			sendESC(FormatSetting_Command.getESCan(align));
		}
		if(PrinterSetting.checkFontDepth(depth))
		{
			sendESC(CharacterSetting_Command.getESCEn(depth));
		}
		
		printText(paramString);
		
		if(PrinterSetting.checkFontType(FontType.NORMAL))
		{
			sendESC(CharacterSetting_Command.getGSExclamationN(FontType.NORMAL));
		}
		if(PrinterSetting.checkAlignMode(Align.LEFT))
		{
			sendESC(FormatSetting_Command.getESCan(Align.LEFT));
		}
		if(PrinterSetting.checkFontDepth(Depth.NORMAL))
		{
			sendESC(CharacterSetting_Command.getESCEn(Depth.NORMAL));
		}
	}
}
