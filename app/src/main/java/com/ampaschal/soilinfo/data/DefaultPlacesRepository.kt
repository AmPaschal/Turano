package com.ampaschal.soilinfo.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.*

class DefaultPlacesRepository: PlacesRepository {

    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val _placesList: MutableLiveData<List<PlaceSummary>> = MutableLiveData()
    val placesList: LiveData<List<PlaceSummary>> = _placesList

    init {
        getAllPlaces()
    }

    private fun getAllPlaces() {
        val placesRef = database.getReference("places")
        placesRef.addValueEventListener(object : ValueEventListener{
            override fun onCancelled(databaseError: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val places = dataSnapshot.children.map { snapShot: DataSnapshot -> snapShot.value as PlaceSummary }
                _placesList.value = places
            }

        })
    }

    private fun getPlaceById(placeId: String): LiveData<Place> {
        val placeRef = database.getReference("placeDetails").child(placeId)

        val place = MutableLiveData<Place>()
        placeRef.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onCancelled(databaseError: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val snapshot = dataSnapshot.value as Place
                place.value = snapshot
            }

        })
        return place
    }

}