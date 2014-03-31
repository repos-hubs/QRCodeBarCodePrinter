package com.allinpay.printer.devices;

import com.allinpay.printer.control.PrinterControl;
import com.allinpay.printer.control.impl.PrinterControlImpl;
import com.allinpay.printer.control.impl.PrinterControlImplEx;

public class DeviceManager {
	private static DeviceManager self = null;

	public static synchronized DeviceManager getInstance() {
		if (self == null) {
			self = new DeviceManager();
		}
		return self;
	}

	public PrinterControl getPrinterControl() {
		return new PrinterControlImpl();
	}
	
	public PrinterControl getPrinterControlEx() {
		return new PrinterControlImplEx();
	}
}
