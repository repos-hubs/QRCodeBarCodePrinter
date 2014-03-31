package cn.koolcloud.jni;

public class PinpadInterface {
	static {
		System.loadLibrary("allinpay_pinpad");
		System.loadLibrary("allinpayPos");
	}
	
	public final static int KEY_TYPE_DUKPT = 0;
	public final static int KEY_TYPE_TDUKPT = 1;
	public final static int KEY_TYPE_MASTER = 2;
	public final static int KEY_TYPE_PUBLIC = 3;
	public final static int KEY_TYPE_FIX = 5;
	
	public final static int MAC_METHOD_X99 = 0;
	public final static int MAC_METHOD_ECB = 1;
	
	public native static int open();
	public native static int close();
	public native static int setText(int nLineIndex, byte arrayText[], int nTextLength, int nFlagSound);
	public native static int setKey(int nKeyType, int nMasterKeyID, int nUserKeyID, int nAlgorith);
	public native static int setPinLength(int nLength, int nFlag);
	public native static int encrypt(byte arrayPlainText[], int nTextLength, byte arrayCipherTextBuffer[]);
	public native static int inputPIN(byte arrayASCIICardNumber[], int nCardNumberLength, byte arrayPinBlockBuffer[], int nTimeout_MS, int nFlagSound);
	public native static int calculateMac(byte arrayData[], int nDataLength, int nMACFlag, byte arrayMACOutBuffer[]);
	public native static int updateUserKey(int nMasterKeyID, int nUserKeyID, byte arrayCipherNewUserKey[], int nCipherNewUserKeyLength);
	public native static int updateMasterKey(int nMasterKeyID, byte arrayOldKey[], int nOldKeyLength, byte arrayNewKey[], int nNewKeyLength);
}
