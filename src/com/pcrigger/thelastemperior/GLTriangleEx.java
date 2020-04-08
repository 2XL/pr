package com.pcrigger.thelastemperior;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

public class GLTriangleEx {

	private float vertices[] =
		{ 
			0f, 1f, // p0 -> first point 2D object
			1f, -1f, // p1
			-1f, -1f  // p2
		};
	
	private FloatBuffer vertBuff;	// cada float son 4 bytes
	private short[] pIndex = { 0,1,2};
	private ShortBuffer pBuff;
	
	
	public GLTriangleEx(){
		ByteBuffer bBuff = ByteBuffer.allocateDirect(vertices.length * 4);
		bBuff.order(ByteOrder.nativeOrder());
		vertBuff = bBuff.asFloatBuffer();
		vertBuff.put(vertices);
		vertBuff.position(0);
		
		ByteBuffer pbBuff = ByteBuffer.allocateDirect(pIndex.length*2);
		pbBuff.order(ByteOrder.nativeOrder()); // the garbage collector dont remove it
		pBuff = pbBuff.asShortBuffer();
		pBuff.put(pIndex);
		pBuff.position(0);
	}
	
	// vid 174 - creating draw method for openGL
	public void draw(GL10 gl){
		// conecting points
		gl.glFrontFace(GL10.GL_CW);	// CW clock wise
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY); // allow us set arrays
	
		gl.glVertexPointer(2, GL10.GL_FLOAT, 0, vertBuff);
		// 2 dimentional - float tipe -
		gl.glDrawElements(GL10.GL_TRIANGLES, pIndex.length, GL10.GL_SHORT, pBuff);
		// concting points - we are in clock wise
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		
	}
}
