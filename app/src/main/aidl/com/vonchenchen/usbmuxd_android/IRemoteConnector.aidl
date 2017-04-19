// IRemoteConnector.aidl
package com.vonchenchen.usbmuxd_android;

// Declare any non-default types here with import statements

interface IRemoteConnector {

    int openUSBAsync(int param);
    int closeUSBAsync(int param);
    ParcelFileDescriptor getFileDescriptor(int port);
}
