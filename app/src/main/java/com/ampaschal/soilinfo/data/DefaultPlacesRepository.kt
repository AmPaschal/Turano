package com.ampaschal.soilinfo.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ampaschal.soilinfo.entities.Place
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class DefaultPlacesRepository: PlacesRepository {

    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val placesRef = database.getReference("places")
    private val _placesList: MutableLiveData<List<PlaceSummary>> = MutableLiveData()

    init {
        getAllPlaces()
    }

    override fun getPlacesList(): MutableLiveData<List<PlaceSummary>> {
        return _placesList
    }

    private fun getAllPlaces() {

        placesRef.child("titles").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(databaseError: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val places = dataSnapshot.children.map { snapShot: DataSnapshot ->
                    getPlaceSummary(
                        snapShot
                    )
                }
                _placesList.value = places.filterNotNull()
            }

        })
    }

    private fun getPlaceSummary(snapShot: DataSnapshot): PlaceSummary? {
        return snapShot.getValue(PlaceSummary::class.java)?.apply {
            key = snapShot.key ?: ""
        }
    }


    override fun getPlaceById(placeId: String, func: (place: Place?) -> Unit) {
        val placeRef = placesRef.child("details").child(placeId)

        placeRef.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onCancelled(databaseError: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val snapshot = dataSnapshot.getValue(Place::class.java)
                func(snapshot)
            }
        })
    }

    override fun addPlace(place: Place) {

        val placeSummary = PlaceSummary(place.name, place.type)
        val key = placesRef.child("titles").push().key

        if (key == null) {
            Log.w(javaClass.simpleName, "Couldn't get push keys for places")
            return
        }

        val placesMap = hashMapOf<String, Any>(
            "titles/$key" to placeSummary,
            "details/$key" to place
        )

        placesRef.updateChildren(placesMap)

    }

}