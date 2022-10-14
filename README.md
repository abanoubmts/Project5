# Project5
please find the below implementaion details :- 
-------------------------------------------------------
1- Share project before any implment the required changes 
2- import authentication firbase "import com.firebase.ui.auth.AuthUI" and use function called (launchSign_AUTH) 
3- Add Constants object to collect all used constants 
  note : you can refer to constants class 
4- Create activity result to start another activity and receive a result from firbase result for authentication status 
5- Create startReminderActivity by add intent varaible to use  start activity func from activity class 

after build the above stpes we will face the below issue 
android:exported needs to be explicitly specified for <activity>. Apps targeting Android 12 and higher are required to specify an explicit value for `android:exported` when the corresponding component has an intent filter defined. 
  
6-  modify activity tags  android:name=".authentication.AuthenticationActivity"  / android.intent.action.MAIN /  android.intent.category.LAUNCHER

  after build we face another issue missing google-services.json  
  
7- so we add google-services.json   




