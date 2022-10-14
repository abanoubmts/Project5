# Project5
please find the below implementaion details :- 
-------------------------------------------------------
1- Share project before any implment the required changes 
and kindly note we add layout tag in authentication layout to enable data binding 
2- import authentication firbase "import com.firebase.ui.auth.AuthUI" and use function called (launchSign_AUTH)  and kindly note this way of 3 ways for firbase authentication 
3- Add Constants object to collect all used constants 
  note : you can refer to constants class 
4- Create activity result to start another activity and receive a result from firbase result for authentication status 
5- Create startReminderActivity by add intent varaible to use  start activity func from activity class 

after build the above stpes we will face the below issue 
android:exported needs to be explicitly specified for <activity>. Apps targeting Android 12 and higher are required to specify an explicit value for `android:exported` when the corresponding component has an intent filter defined. 
  
6-  modify activity tags  android:name=".authentication.AuthenticationActivity"  / android.intent.action.MAIN /  android.intent.category.LAUNCHER

  after build we face another issue missing google-services.json  
  
7- so we add google-services.json related to you after register account on firbase 
  
8- regarding for Geofence implementation  ,  
  8.1 - Geofence is an imitated variable that describes a real geographical area of interest. 
  8.2 - Geofencing API allows you to define the outline or limit of a specific area. When users cross the Geofence, they are alerted by a notification.
  8.3 - Geofencing API employs the use of device sensors to detect a user’s location in a battery-efficient manner.

 so we need to add in gradle the below commands 
  //Maps & Geofencing
    implementation "com.google.android.gms:play-services-location:$playServicesVersion"
    implementation "com.google.android.gms:play-services-maps:$playServicesVersion"
  
 9- modify mainfest.xml to add the GeofenceBroadcastReceiver tag to register the BroadCastReceiver:
  <receiver
            android:name=".locationreminders.geofence.GeofenceBroadcastReceiver"
            android:enabled="true"
            android:exported="true" />
 10- The BroadcastReceiver listens for Geofence transitions and provides a notification , when a device enters a particular geofence area.
  through GeofenceTransitionsJobIntentService.enqueueWork(context, intent)




