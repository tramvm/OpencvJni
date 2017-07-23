package com.tramvm.opencvjni;

/**
 * Native class can understand like interface for Java communicate with the
 * native.
 * 
 * @author Tramvm@gmail.com
 *
 */
public class MyNative {
	/**
	 * 
	 * @param origin:
	 *            address of object Mat
	 */
	public native void doSomething(long origin);

	public native void drawRandom(long origin, int posX, int posY, int red, int green, int blue);
}
