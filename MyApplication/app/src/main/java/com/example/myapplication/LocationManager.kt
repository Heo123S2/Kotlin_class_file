package com.example.myapplication

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.Priority

class LocationManager(private val context: Context) {
    private val fusedLocationProviderClient by lazy {
        LocationServices.getFusedLocationProviderClient(context)
    }

    fun getLocation(onPermissionDenied: () -> Unit, onCurrentLocation: (Location) -> Unit) {
        if (context.checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            fusedLocationProviderClient.getCurrentLocation(Priority.PRIORITY_HIGH_ACCURACY, null)
                .addOnSuccessListener {
                    onCurrentLocation(it)
                }
        } else {
            onPermissionDenied()
        }
    }
}