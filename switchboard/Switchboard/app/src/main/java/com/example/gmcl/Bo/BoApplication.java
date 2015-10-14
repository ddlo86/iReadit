package com.example.gmcl.Bo;

import com.parse.Parse;

/**
 * Created by JamesCrocker on 2015-08-02.
 */
public class BoApplication extends android.app.Application {
    @Override
    public void onCreate(){
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "qTVUihSGFBl5TdpSWXr853qEM1OQ7laMGnopvpDQ", "vFM22StucuvV6ErgvynZ8x04Cb1AZp9J1J0C2RQb");

    }
}
