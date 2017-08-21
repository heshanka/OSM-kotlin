package com.example.softlogic.task02kotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.location.Location
import android.location.LocationManager
import android.location.LocationListener

import org.osmdroid.api.IMapController
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay
import org.osmdroid.tileprovider.constants.OpenStreetMapTileProviderConstants

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mapView = findViewById(R.id.mapview) as MapView
        mapView.isClickable = true
        mapView.setBuiltInZoomControls(true)
        mapView.setMultiTouchControls(true)
        mapView.setUseDataConnection(true)
        mapView.setTileSource(TileSourceFactory.MAPQUESTOSM)

        val myLocationOverlay = MyLocationNewOverlay(applicationContext, mapView)
        mapView.overlays.add(myLocationOverlay)
        myLocationOverlay.enableMyLocation()
        myLocationOverlay.enableFollowLocation()

        val mapViewController = mapView.controller
        mapViewController.setZoom(16)
        mapViewController.setCenter(SCHOOL)


    }

    companion object {

        protected val PROVIDER_NAME = LocationManager.GPS_PROVIDER
        
        //Give the latitude and longitude of the area on the map
        
        val Somewhere = GeoPoint(33.989820, -81.029123)
    }

}
