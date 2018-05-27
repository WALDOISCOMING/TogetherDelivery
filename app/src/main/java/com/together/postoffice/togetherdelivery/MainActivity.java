package com.together.postoffice.togetherdelivery;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import net.daum.mf.map.api.MapView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        MapView mapView = new MapView(this);
        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        ListView listview = (ListView)findViewById(R.id.shipping_list_view);
        ArrayList<ShippingData> data = new ArrayList<>();
        ShippingData s1 = new ShippingData("우체국1","주소",0,0,0);
        ShippingData s2 = new ShippingData("우체국1","주소",0,0,0);
        ShippingData s3 = new ShippingData("우체국1","주소",0,0,0);
        ShippingData s4 = new ShippingData("우체국1","주소",0,0,0);
        ShippingData s5 = new ShippingData("우체국1","주소",0,0,0);
        data.add(s1);data.add(s2);data.add(s3);data.add(s4);data.add(s5);

        ListViewAdapter adapter=new ListViewAdapter(this,R.layout.shipping_list_item,data);
        listview.setAdapter(adapter);
    }
    public class ListViewAdapter extends BaseAdapter {
        private LayoutInflater inflater;
        private ArrayList<ShippingData> data;
        private int layout;
        public ListViewAdapter(Context context, int layout, ArrayList<ShippingData> data){
            this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            this.data=data;
            this.layout=layout;
        }
        @Override
        public int getCount(){return data.size();}
        @Override
        public String getItem(int position){return data.get(position).postOfficeName;}
        @Override
        public long getItemId(int position){return position;}
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            if(convertView==null){
                convertView=inflater.inflate(layout,parent,false);
            }
            ShippingData shippingData=data.get(position);

            TextView name=(TextView)convertView.findViewById(R.id.test);
            name.setText(shippingData.postOfficeName);
            return convertView;
        }
    }



    class ShippingData {
        String postOfficeName;
        String addrName;
        double latitude;
        double longitude;
        double mailWeight;
        ShippingData(String postOfficeName,String addrName,double latitude,double longitude,double mailWeight) {
            this.postOfficeName=postOfficeName;
            this.addrName=addrName;
            this.latitude=latitude;
            this.longitude=longitude;
            this.mailWeight=mailWeight;
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
