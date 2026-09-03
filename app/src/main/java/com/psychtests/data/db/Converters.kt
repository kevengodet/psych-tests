package com.psychtests.data.db

import androidx.room.TypeConverter
import com.psychtests.data.model.SeverityLevel
import com.psychtests.data.model.TestCategory
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {
    private val json = Json { ignoreUnknownKeys = true }

    @TypeConverter
    fun fromLocalDateTime(value: LocalDateTime?): String? = value?.toString()

    @TypeConverter
    fun toLocalDateTime(value: String?): LocalDateTime? = value?.let { LocalDateTime.parse(it) }

    @TypeConverter
    fun fromSeverityLevel(value: SeverityLevel?): String? = value?.name

    @TypeConverter
    fun toSeverityLevel(value: String?): SeverityLevel? = value?.let { SeverityLevel.valueOf(it) }

    @TypeConverter
    fun fromTestCategory(value: TestCategory?): String? = value?.name

    @TypeConverter
    fun toTestCategory(value: String?): TestCategory? = value?.let { TestCategory.valueOf(it) }

    @TypeConverter
    fun fromMapStringString(value: Map<String, String>?): String? = value?.let { json.encodeToString(it) }

    @TypeConverter
    fun toMapStringString(value: String?): Map<String, String>? = value?.let { json.decodeFromString(it) }

    @TypeConverter
    fun fromMapStringInt(value: Map<String, Int>?): String? = value?.let { json.encodeToString(it) }

    @TypeConverter
    fun toMapStringInt(value: String?): Map<String, Int>? = value?.let { json.decodeFromString(it) }

    @TypeConverter
    fun fromMapStringDouble(value: Map<String, Double>?): String? = value?.let { json.encodeToString(it) }

    @TypeConverter
    fun toMapStringDouble(value: String?): Map<String, Double>? = value?.let { json.decodeFromString(it) }

    @TypeConverter
    fun fromListString(value: List<String>?): String? = value?.let { json.encodeToString(it) }

    @TypeConverter
    fun toListString(value: String?): List<String>? = value?.let { json.decodeFromString(it) }
}