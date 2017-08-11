package com.example.softlogic.task02kotlin

import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.osmdroid.views.MapView;
import org.osmdroid.tileprovider.tilesource.ITileSource
import org.osmdroid.tileprovider.tilesource.MapBoxTileSource
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.util.LocationUtils
import org.osmdroid.views.MapController
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay


class MainActivity : AppCompatActivity() {

    var m: MapController? = null
    var mv: MapView? = null
    var mylocation = MyLocationNewOverlay(GpsMyLocationProvider(applicationContext), mv)

    //mylocation.enableFollowLocation();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //pass location as argument
        onLocationChanged(mylocation.lastFix)
    }

    fun onLocationChanged(location: Location):Unit {

        val latitude = location.latitude
        val longitude = location.longitude
        val altitude = location.altitude
        val accuracy = location.accuracy

        val p = GeoPoint(latitude, longitude)

        m?.animateTo(p);
        m?.setCenter(p);



        mylocation.enableMyLocation();
        mv?.getOverlays()?.add(mylocation)
    }
}
