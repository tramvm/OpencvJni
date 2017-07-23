package com.tramvm.opencvjni;

import static com.tramvm.opencvjni.Common.TAG;

import java.util.Random;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;

import android.graphics.Bitmap;
import android.util.Log;

/**
 * Main class apply effect on image using OpenCV.
 * @author Tramvm@gmail.com
 *
 */
public class MyOpencv {
	/**
	 * Initial OpenCV and load custom native libraries
	 */
	static {
		Log.i(TAG, "Load native");
		if (!OpenCVLoader.initDebug()) {
			Log.e(TAG, "Unable to load OpenCV");
		} else {
			Log.i(TAG, "OpenCV loaded");
		}
		System.loadLibrary("my_native"); // file libmy_native.so, but we just use my_native to load
		Log.i(TAG, "OpenCV my_native");
	}
	
	public static Bitmap process(Bitmap bOrigin){
		// Convert Bitmap to Mat
		Mat mOrigin = new Mat(); 
		Utils.bitmapToMat(bOrigin, mOrigin);
		//Mat mResult  = applyChange(mOrigin);
		Mat mResult  = applyChange2(mOrigin);
		Bitmap bResult = Common.toBitmap(mResult);
		
		// Important: Must release memory
		mResult.release();
		return bResult;
	}
	
	static Mat applyChange(Mat origin) {
		MyNative processor = new MyNative();
		processor.doSomething(origin.nativeObj);
		return origin;
	}

	
	static Mat applyChange2(Mat origin) {
		MyNative processor = new MyNative();
		int posX = new Random().nextInt(origin.width());
		int posY = new Random().nextInt(origin.height());
		int red = new Random().nextInt(255);
		int green = new Random().nextInt(255);
		int blue = new Random().nextInt(255);
		processor.drawRandom(origin.nativeObj, posX, posY, red, green, blue);
		return origin;
	}
	
}
