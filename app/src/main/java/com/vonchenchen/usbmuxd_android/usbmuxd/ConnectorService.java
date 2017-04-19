package com.vonchenchen.usbmuxd_android.usbmuxd;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.vonchenchen.usbmuxd_android.IRemoteConnector;
import com.vonchenchen.usbmuxd_android.usbmuxd.muxdprotocol.SimpleTcpWrapper;

/**
 * 连接服务
 * 在独立线程中使用
 * Created by lidechen on 3/24/17.
 */

public class ConnectorService extends Service{

    private static final String TAG = "ConnectorService";

    public ConnectorService(){
        super();
    }

    IRemoteConnector.Stub mRemoteStud = new IRemoteConnector.Stub(){

        @Override
        public int openUSBAsync(int param) throws RemoteException {

            if(mSimpleTcpWrapper != null){
                boolean reset;
                if(param == 0){
                    reset = false;
                }else {
                    reset = true;
                }
                mSimpleTcpWrapper.openUSBAsync(reset);

                return 0;
            }else {
                return -1;
            }
        }

        @Override
        public int closeUSBAsync(int param) throws RemoteException {

            if(mSimpleTcpWrapper != null) {
                mSimpleTcpWrapper.closeUSB();
                return 0;
            }else{
                return -1;
            }
        }

        @Override
        public ParcelFileDescriptor getFileDescriptor(int port) throws RemoteException {
            return null;
        }
    };

    protected SimpleTcpWrapper mSimpleTcpWrapper;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mRemoteStud;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mSimpleTcpWrapper = new SimpleTcpWrapper(ConnectorService.this);
        setupLocalSocketClients();
        mSimpleTcpWrapper.start();
    }

    protected void setupLocalSocketClients(){

        if(Config.DEBUG){
            Log.i(TAG, "setupLocalSocketClients");
        }
    }
}
