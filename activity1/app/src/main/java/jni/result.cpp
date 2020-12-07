//
// Created by Jose Devian on 12/7/20.
//

#include "result.h"
#include "../../../../../../../../../../../../../Library/Android/sdk/ndk/21.0.6113669/toolchains/llvm/prebuilt/darwin-x86_64/sysroot/usr/include/jni.h"
#include <jni.h>

extern "C"
JNIEXPORT jstring JNICALL Java_id_ac_ui_cs_mobileprogramming_activity1_MainActivity_getCString(JNIEnv *env, jobject obj) {
    return env->NewStringUTF("Hello World! From native code!");
}
