package com.pcrigger.thelastemperior;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;


import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

// vid 169
public class GLRendererEx implements Renderer {

	// vid 176
	private GLTriangleEx tri;
	public GLRendererEx() {
		tri = new GLTriangleEx();
	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig eglconfig) {
		// TODO Auto-generated method stub
		gl.glDisable(GL10.GL_DITHER);	// rechazar cosas default para accelerar 
		gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
		
		gl.glClearColor(.8f, .0f, .2f, 1f);
		gl.glClearDepthf(1f);
	}

	@Override
	public void onDrawFrame(GL10 gl) {
		// TODO Auto-generated method stub
		gl.glDisable(GL10.GL_DITHER);
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
		
		gl.glMatrixMode(GL10.GL_MODELVIEW);
		gl.glLoadIdentity();
		GLU.gluLookAt(gl, 0, 0, -23, 0, 0, 0, 0, 2, 0);
		tri.draw(gl);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {
		// TODO Auto-generated method stub
		// vid 177
		gl.glViewport(0, 0, width, height);
		// rations
		float ratio = (float) width/height;
		gl.glMatrixMode(GL10.GL_PROJECTION);
		gl.glLoadIdentity();	// referd to our method there
		// set how far thez direction we wanaset
		gl.glFrustumf(-ratio, ratio, -1, 1, 1, 25);
	}

}
