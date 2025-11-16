plugins {
    // plugin DSL yang diperlukan
    id 'com.android.application' version '8.8.0' apply false
}


task clean(type: Delete) {
    delete rootProject.buildDir
}
