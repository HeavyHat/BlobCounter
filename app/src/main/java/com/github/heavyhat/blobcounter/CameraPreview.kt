package com.github.heavyhat.blobcounter

import android.content.Context
import android.hardware.Camera
import android.view.SurfaceHolder
import android.view.SurfaceView

/**
 * Created by brynhanby-roberts on 21/09/2017.
 */

class CameraPreview : SurfaceView, SurfaceHolder.Callback
{
    private final var currentContext : Context;
    private final var currentCamera : Camera;
    private final var currentHolder : SurfaceHolder;

    constructor(context : Context, camera : Camera) : super(context) {
        currentContext = context;
        currentCamera = camera;
        currentHolder = getHolder();
        currentHolder.addCallback(this);
    }

    override fun surfaceChanged(holder: SurfaceHolder?, format: Int, width: Int, height: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun surfaceCreated(holder: SurfaceHolder?) {

        try
        {
            currentCamera.setPreviewDisplay(holder);
            currentCamera.startPreview()
        } catch (e : Exception)
        {

        }
    }

    override fun surfaceDestroyed(holder: SurfaceHolder?) {

    }
}