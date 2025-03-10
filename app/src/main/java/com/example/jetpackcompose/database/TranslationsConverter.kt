package com.example.jetpackcompose.database

import androidx.room.TypeConverter
import com.example.jetpackcompose.data.Translations
import kotlinx.serialization.json.Json

class TranslationsConverter {
    @TypeConverter
    fun fromTranslations(translations: Translations): String {
        return Json.encodeToString(translations)
    }

    @TypeConverter
    fun toTranslations(data: String): Translations {
        return Json.decodeFromString<Translations>(data)
    }
}