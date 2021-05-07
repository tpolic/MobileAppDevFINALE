package com.example.finale.view.detail

import android.app.Fragment
import android.location.Location
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.example.finale.R
//import com.google.android.gms.location.places.Places
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class SupportMapFragmentTest : FragmentActivity(R.layout.fragment_support_map), OnMapReadyCallback {
    // TODO: Rename and change types of parameters
    private var location: Location? = null
    private var requestCode: Int = 101
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        println("working")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_support_map)
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        //fetchLastLocation()

    }
    /*private fun fetchLastLocation(){
        //if(ActivityCompat.checkSelfPermission(this, Manifest.pet)){}

        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, Array<String>(size = 100){
                Manifest.permission.ACCESS_FINE_LOCATION}, requestCode)
        }
        var task: com.google.android.gms.tasks.Task<Location> =
            this.fusedLocationProviderClient.getLastLocation()

        task.addOnSuccessListener(OnSuccessListener<Location>() {
            @Override
            fun onSuccessListener(loc: Location) {
                if (location == null) {
                    location = loc
                    Toast.makeText(
                        applicationContext,
                        "test  ${location!!.getLatitude()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }*/

    override fun onMapReady(googleMap: GoogleMap) {
        //var latLng: LatLng = LatLng(location!!.getLatitude(), location!!.getLongitude())
        println("Makarska test")
        val latLng = LatLng(45.815399, 15.966568)
        val mo: MarkerOptions = MarkerOptions().position(latLng).title("Event is here")
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5F))
        googleMap.addMarker(mo)
    }

    class SupportMapFragment : Fragment(), OnMapReadyCallback{

        private var location: Location? = null
        private var requestCode: Int = 101
        private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

        override fun onCreate(savedInstanceState: Bundle?) {
            println("working")
            super.onCreate(savedInstanceState)

        }

        override fun onMapReady(googleMap: GoogleMap) {
            //var latLng: LatLng = LatLng(location!!.getLatitude(), location!!.getLongitude())
            println("Makarska test")
            val latLng = LatLng(45.815399, 15.966568)
            val mo: MarkerOptions = MarkerOptions().position(latLng).title("Event is here")
            googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng))
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 5F))
            googleMap.addMarker(mo)
        }

        override fun onCreateView(
            inflater: LayoutInflater?, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            val v = EditText(getActivity())
            v.setText("Hello Fragment!")
            return v
        }
    }
}


