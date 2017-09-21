package com.github.heavyhat.blobcounter

import android.app.Activity
import android.hardware.Camera
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.Toast

class MainActivity : Activity() {

    fun getCameraInstance() : Camera?
    {
        var c : Camera?;
        c = null;
        try
        {
            c = Camera.open(0);
        }
        catch (e : Exception)
        {
            Log.e("ERROR", "Can't open camera");
        }
        return c;

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var camera = getCameraInstance();
        if(camera != null) {
            var preview = CameraPreview(this, camera);
            var layout = findViewById(R.id.camera_preview) as FrameLayout;
            layout.addView(preview);
            camera.release();
        }
        else
        {
            Toast.makeText(this, "Couldn't get Camera.", Toast.LENGTH_LONG).show()
        }
    }
}
