#include <jni.h>
#include <string>
#include <cstdlib>
#include <time.h>

std::string generateRandomString() {
    std::string rnd_strings[] = {"Verizon XR", "Augmented", "Reality", "Virtual", "5G", "AI", "JNI",
                                 "C++", "Engineering", "Android"};
    std::string rnd_sentence = "";
    srand(time(0));
    int number_of_words = rand() % 10 + 1;

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
