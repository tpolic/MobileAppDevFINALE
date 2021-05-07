package com.example.finale.view.detail

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.finale.R
import com.example.finale.databinding.FragmentDetailEventBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import androidx.navigation.fragment.navArgs
import com.example.finale.data.model.Event
import com.example.finale.data.model.Location
import com.example.finale.databinding.EventListItemBinding

class SupportMapFragment : Fragment(), OnMapReadyCallback {
    private lateinit var binding: FragmentDetailEventBinding
   // private val args: DetailEventFragmentArgs by navArgs()

            // TODO: Rename and change types of parameters
    //private var location: Location? = null
    //private var requestCode: Int = 101
    //private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var googleMap: GoogleMap
    val event : Event = Event(name="Plesni Studio Fusion", location= Location(latitude=45.77997, longitude=15.96937), description = "event", start = "May 6 ")

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        println("working")
        super.onActivityCreated(savedInstanceState)
        //fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        //fetchLastLocation()
        val map_view: MapView = getView()?.findViewById(R.id.map_view) as MapView
        map_view.onCreate(savedInstanceState)
        map_view.onResume()
        map_view.getMapAsync(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater?, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        return inflater?.inflate(R.layout.fragment_support_map,container, false)

    }

    override fun onMapReady(googleMap: GoogleMap) {

        val lat : Double = event.location.latitude
        val long : Double = event.location.longitude
        val latLng = LatLng(lat, long)
        val mo: MarkerOptions = MarkerOptions().position(latLng).title("Event is here")
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng))
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10F))
        googleMap.addMarker(mo)
    }
}