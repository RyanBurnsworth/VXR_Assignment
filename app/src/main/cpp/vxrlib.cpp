#include <jni.h>
#include <string>
#include <vector>
#include <cstdlib>
#include <time.h>

std::string jstring2string(JNIEnv *env, jstring jStr) {
    if (!jStr)
        return "";

    const jclass stringClass = env->GetObjectClass(jStr);
    const jmethodID getBytes = env->GetMethodID(stringClass, "getBytes", "(Ljava/lang/String;)[B");
    const jbyteArray stringJbytes = (jbyteArray) env->CallObjectMethod(jStr, getBytes,
                                                                       env->NewStringUTF("UTF-8"));

    size_t length = (size_t) env->GetArrayLength(stringJbytes);
    jbyte *pBytes = env->GetByteArrayElements(stringJbytes, NULL);

    std::string ret = std::string((char *) pBytes, length);
    env->ReleaseByteArrayElements(stringJbytes, pBytes, JNI_ABORT);

    env->DeleteLocalRef(stringJbytes);
    env->DeleteLocalRef(stringClass);
    return ret;
}

std::string generateRandomString() {
    std::string rnd_strings[] = {"Verizon XR", "Augmented", "Reality", "Virtual", "5G", "AI", "JNI",
                                 "C++", "Engineering", "Android"};
    std::string rnd_sentence = "";
    srand(time(0));
    int number_of_words = rand() % 9;

    for (int i = 0; i < number_of_words; i++) {
        int rnd_word_index = rand() % 9;
        rnd_sentence = rnd_sentence + " " + rnd_strings[rnd_word_index];
    }

    return rnd_sentence;
}

extern "C"

JNIEXPORT jstring JNICALL
Java_com_ryanburnsworth_vxrassignment_MainActivity_generateRandomString(
        JNIEnv *env,
        jobject /* this */) {
    std::string rnd_sentence = generateRandomString();
    return env->NewStringUTF(rnd_sentence.c_str());
}
