#include "MyNative.h"

#include <android/log.h>
#include <opencv/cv.h>
#include <opencv/cxcore.h>
#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>
#include <opencv2/imgproc/imgproc_c.h>
#include <stdio.h>
#include <stdlib.h>
#include <cmath>
#include <iostream>
#include <string>
#include <vector>

using namespace std;
using namespace cv;

/** Options */
bool DEBUG = true;

/** For log */
#define  LOG_TAG    "MY NATIVE"

#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)
#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define  LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG,__VA_ARGS__)
/** End for log */

/**
 * For test: add a green circle to image with options pass by a mat.
 */
void Java_com_tramvm_opencvjni_MyNative_doSomething(JNIEnv* env, jobject thiz,
		jlong lOrigin) {

	LOGI("Call MyNative.doSomething");
	// Get object
	Mat& origin = *(Mat*) lOrigin;

	int px = 300;
	int py = 300;
	int radius = 100;
	int thickness = 50;

	circle(origin, Point(px, py), radius, Scalar(255, 255, 0), thickness); // this is yellow color
}

void Java_com_tramvm_opencvjni_MyNative_drawRandom(JNIEnv* env, jobject thiz,
		jlong lOrigin, jint posX, int posY, int red, int green, int blue) {

	LOGI("Call MyNative.drawRandom");
	// Get object
	Mat& origin = *(Mat*) lOrigin;

	int px = posX;
	int py = posY;
	int radius = 100;
	int thickness = 50;

	circle(origin, Point(px, py), radius, Scalar(red, green, blue), thickness);

}

