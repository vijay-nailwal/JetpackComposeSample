package com.example.jetpackcompose.repository

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import com.example.jetpackcompose.data.Country
import com.example.jetpackcompose.database.CountryDao
import com.example.jetpackcompose.util.getCountryList

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

class CountryRepository(private val context: Context, private val countryDao: CountryDao) :
    Parcelable {

    private val contextForRepo: Context = context

    private var allCountries: List<Country> = emptyList()

    constructor(parcel: Parcel) : this(
        TODO("context"),
        TODO("countryDao")
    ) {

    }

    suspend fun fetchAndInsertAll() = withContext(Dispatchers.IO) {
        if(getAllCountries() != null && getAllCountries().isNotEmpty()) {
            Log.i("Room", "Countries already exist in the database ${getAllCountries().size}")
            return@withContext

        } else {
            Log.i("Room", "Fetching and inserting countries")
            val mutableCountryList: MutableList<Country> = getCountryList(contextForRepo)
            Log.i("Room", "Fetched countries: ${mutableCountryList.size}")
            val countryList: List<Country> = mutableCountryList.toList()
            Log.i("Room", "Inserting Country list: ${countryList.size}")
            countryDao.insertAll(countryList)
            return@withContext
        }
    }

    suspend fun getAllCountries(): List<Country> = withContext(Dispatchers.IO) {
        if(allCountries.isNotEmpty()) {
            Log.i("Room", "getAllCountries : ${allCountries.size}")
            return@withContext allCountries
        } else {
            allCountries = countryDao.getAllCountries()
            Log.i("Room", "getAllCountries else : ${allCountries.size}")
            return@withContext allCountries
        }
    }

    suspend fun deleteCountry(country: Country) = withContext(Dispatchers.IO) {
        Log.i("Room", " deleteCountry Countries Size before Deletion: ${allCountries.size}")
        countryDao.delete(country)
        allCountries = countryDao.getAllCountries()
        Log.i("Room", "deleteCountry Countries Size after Deletion: ${allCountries.size}")
    }

    suspend fun updateCapital(country: Country, newCapital: String) = withContext(Dispatchers.IO) {
        val parsedString = "[\"${newCapital}\"]"
        val parsedArray = Json.decodeFromString<List<String>>(parsedString)
        Log.i("Room", " updateCapital count: $parsedArray")
        //val count = countryDao.updateCapital(parsedArray, country?.id!!)
        val country = country?.copy(capital = parsedArray)
        countryDao.updateCountry(country!!)
        allCountries = countryDao.getAllCountries()

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CountryRepository> {
        override fun createFromParcel(parcel: Parcel): CountryRepository {
            return CountryRepository(parcel)
        }

        override fun newArray(size: Int): Array<CountryRepository?> {
            return arrayOfNulls(size)
        }
    }
}