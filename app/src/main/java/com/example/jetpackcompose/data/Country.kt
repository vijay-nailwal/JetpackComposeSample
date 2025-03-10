package com.example.jetpackcompose.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity
@Serializable
data class Country(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var altSpellings: List<String>? = null,
    var area: Double? = null,
    var capital: List<String>? = null,
    var capitalInfo: CapitalInfo? = null,
    var car: Car? = null,
    var cca2: String? = null,
    var cca3: String? = null,
    var ccn3: String? = null,
    @Ignore var coatOfArms: CoatOfArms? = null,
    var continents: List<String>? = null,
    var currencies: Map<String, Currency>? = null,
    @Ignore var demonyms: Demonyms? = null,
    var flag: String? = null,
    var flags: Flags? = null,
    var idd: Idd? = null,
    var independent: Boolean? = null,
    var landlocked: Boolean? = null,
    var languages: Languages? = null,
    var latlng: List<Double>? = null,
    var maps: Maps? = null,
    var name: Name? = null,
    var population: Int? = null,
    var region: String? = null,
    var startOfWeek: String? = null,
    var status: String? = null,
    var subregion: String? = null,
    var timezones: List<String>? = null,
    var tld: List<String>? = null,
    @Ignore var translations: Translations? = null,
    var unMember: Boolean? = null
) {
    constructor() : this(
        id = null,
        altSpellings = null,
        area = null,
        capital = null,
        capitalInfo = null,
        car = null,
        cca2 = null,
        cca3 = null,
        ccn3 = null,
        continents = null,
        currencies = null,
        flag = null,
        flags = null,
        idd = null,
        independent = null,
        landlocked = null,
        languages = null,
        latlng = null,
        maps = null,
        name = null,
        population = null,
        region = null,
        startOfWeek = null,
        status = null,
        subregion = null,
        timezones = null,
        tld = null,
        unMember = null
    )
}
