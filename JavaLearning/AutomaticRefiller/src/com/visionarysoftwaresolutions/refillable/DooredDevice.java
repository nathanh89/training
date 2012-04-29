/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.visionarysoftwaresolutions.refillable;

/**
 *
 * @author nathan
 */
public interface DooredDevice {
    public boolean isDoorOpen();
    public void setDoorOpen(boolean doorOpen);
    public void operateDoor();
}
