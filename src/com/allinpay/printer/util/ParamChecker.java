package com.allinpay.printer.util;

import com.allinpay.printer.control.PrinterControl;
import com.allinpay.printer.control.impl.PrinterControlImpl;
import com.allinpay.util.Log2;

public class ParamChecker extends PrinterControlImpl {
	public static boolean checkParamForBarcode(int format, byte[] content) {
		boolean isLegal = false;
		int length = content.length;
		switch (format) {
		case PrinterControl.BARCODE_UPC_A:
			if ((length >= 11) || (length <= 12))
				isLegal = checkBytes(content);
			else {
				isLegal = false;
			}
			break;
		case PrinterControl.BARCODE_UPC_E:
			if ((length >= 11) || (length <= 12))
				isLegal = checkBytes(content);
			else {
				isLegal = false;
			}
			break;
		case PrinterControl.BARCODE_JAN13:
			if ((length >= 12) || (length <= 13))
				isLegal = checkBytes(content);
			else {
				isLegal = false;
			}
			break;
		case PrinterControl.BARCODE_JAN8:
			if ((length >= 7) || (length <= 8))
				isLegal = checkBytes(content);
			else {
				isLegal = false;
			}
			break;
		case PrinterControl.BARCODE_CODE39:
			if ((length >= 1) || (length <= 255))
				isLegal = checkBytes2(content);
			else {
				isLegal = false;
			}
			break;
		case PrinterControl.BARCODE_CODABAR:
			if ((length >= 1) || (length <= 255))
				isLegal = checkBytes(content);
			else {
				isLegal = false;
			}
			break;
		case PrinterControl.BARCODE_CODE93:
			if ((length >= 1) || (length <= 255))
				isLegal = checkBytes3(content);
			else {
				isLegal = false;
			}
			break;
		case PrinterControl.BARCODE_CODE128:
			if ((length >= 2) || (length <= 255))
				isLegal = checkBytes3(content);
			else {
				isLegal = false;
			}
			break;
		default:
			Log2.e("Devices", "This format is not supported");

			return false;
		}
		return isLegal;
	}

	private static boolean checkBytes(byte[] content) {
		boolean isLegal = true;
		byte[] arrayOfByte = content;
		int j = content.length;
		for (int i = 0; i < j; i++) {
			byte b = arrayOfByte[i];
			if ((b < 48) && (b > 57)) {
				isLegal = false;
				break;
			}
		}
		return isLegal;
	}

	private static boolean checkBytes2(byte[] content) {
		boolean isLegal = true;
		byte[] arrayOfByte = content;
		int j = content.length;
		for (int i = 0; i < j; i++) {
			byte b = arrayOfByte[i];
			if ((b < 45) && (b > 57) && (b < 65) && (b > 90) && (b != 36)
					&& (b != 43)) {
				isLegal = false;
				break;
			}
		}
		return isLegal;
	}

	private static boolean checkBytes3(byte[] content) {
		boolean isLegal = true;
		byte[] arrayOfByte = content;
		int j = content.length;
		for (int i = 0; i < j; i++) {
			byte b = arrayOfByte[i];
			if ((b < 0) && (b > 127)) {
				isLegal = false;
				break;
			}
		}
		return isLegal;
	}
}
