package Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.info_window_adapter.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.squareup.picasso.Picasso;

import Model.Modelo;

public class adaptador implements GoogleMap.InfoWindowAdapter {

    private static final String TAG = "adaptadorplaces";
    private LayoutInflater inflater;
    private Modelo places;

    public adaptador(LayoutInflater inflater){
        this.inflater = inflater;
        View v = inflater.inflate(R.layout.window, null);
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null;
    }

    @Override
    public View getInfoWindow( Marker marker) {
        if (marker == null) {
            return null;
        }
        try {

            View v = inflater.inflate(R.layout.window, null);
            places = (Modelo) marker.getTag();
            ImageView image = (ImageView)v.findViewById(R.id.imgicono);
            ((TextView)v.findViewById(R.id.lblNombre)).setText(places.name);
            ((TextView)v.findViewById(R.id.lblDireccion)).setText(places.vicinity);
            ((TextView)v.findViewById(R.id.lblweb)).setText(places.open_now);
            Picasso.get().load(places.icon).into(image);

            ImageView image2 = (ImageView)v.findViewById(R.id.imgUsr);
            if (places.photo_reference != null && !places.photo_reference.isEmpty()) {
                //Glide.with(v).load("https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photo_reference=" + places.photo_reference + "&key=AIzaSyCx2klhltS0foiCjqvuxh27SV67y_VyZ_w").into(image);
                Picasso.get().load("https://maps.googleapis.com/maps/api/place/photo?maxwidth=400&photo_reference=" + places.photo_reference + "&key=AIzaSyCx2klhltS0foiCjqvuxh27SV67y_VyZ_w").into(image2);

            }
            return v;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
