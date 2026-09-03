# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.

# Keep kotlinx.serialization descriptors
-keepattributes *Annotation*
-keepclassmembers class **$Companion { *; }

# Room
-keep class * extends androidx.room.RoomDatabase

# Hilt
-dontwarn dagger.hilt.**

# Keep serializable classes
-keepclassmembers class * implements kotlinx.serialization.Serializable {
    static final kotlinx.serialization.descriptors.SerialDescriptor $$serializer;
}
-keepclassmembers class com.psychtests.** {
    *** Companion;
}
-keepclasseswithmembers class com.psychtests.** {
    kotlinx.serialization.KSerializer serializer(...);
}