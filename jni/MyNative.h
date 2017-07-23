#include <jni.h>

extern "C" {

void Java_com_tramvm_opencvjni_MyNative_doSomething(JNIEnv* env, jobject thiz,
		jlong lOrigin);


void Java_com_tramvm_opencvjni_MyNative_drawRandom(JNIEnv* env, jobject thiz,
		jlong lOrigin, jint posX, int posY, int red, int green, int blue);
}
