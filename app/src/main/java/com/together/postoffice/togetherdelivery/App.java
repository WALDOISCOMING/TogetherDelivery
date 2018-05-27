package com.together.postoffice.togetherdelivery;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by 길경완 on 2018-05-27.
 * 목적:
 * 1. 퍼미션.
 * 2. 로그인 여부.
 */

public class App extends Activity {
    private static final int ACCESS_COARSE_LOCATION_PERMISSION=2048;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkPermission();
    }




    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case ACCESS_COARSE_LOCATION_PERMISSION:
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    checkLogin ();
                } else {
                    finish();
                }
                return;
        }
    }
    private void checkPermission() {
        if ( ContextCompat.checkSelfPermission( this, android.Manifest.permission.ACCESS_COARSE_LOCATION ) != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions( this, new String[] {  android.Manifest.permission.ACCESS_COARSE_LOCATION  },
                    ACCESS_COARSE_LOCATION_PERMISSION);
        } else {
            checkLogin ();
        }
    }

    private void checkLogin () {
        //login check.
        Intent intent = new Intent(App.this,LoginActivity.class);
        startActivity(intent);



    }
}
