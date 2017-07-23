package com.tramvm.opencvjni;

import org.opencv.android.Utils;
import org.opencv.core.Mat;

import android.graphics.Bitmap;

public class Common {
	public static String TAG = "MyAPP";
	
	/**
	 * Convert Mat to Bitmap
	 * @param mat
	 * @return
	 */
	public static Bitmap toBitmap(Mat mat) {
		Bitmap bitmap = Bitmap.createBitmap(mat.width(), mat.height(), Bitmap.Config.ARGB_8888);
		Utils.matToBitmap(mat, bitmap);
		return bitmap;
	}
}
