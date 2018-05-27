<!--
  Title: Android GDPR
  Description: A simple android demo how to use GDPR consent SDK.  Makes GDPR consent management and collection easy. CMP.
  Consent Management Platform.
  Author: gdprsdk
  -->
# android-gdpr-demo
Android Demo App showing how easy to use a GDPR SDK to detect if in EU and collect consent from user.


Watch the video to see how the Demo works:
https://bit.ly/2GTA9Dk
<br/>
<br/>
Link to the APK:
https://bit.ly/2KTYjQD
<br/>
<br/>

<p align="center">
  <img src="gdpr_demo_1.png" width="276" height="490"/>  
</p>
<p align="center">
  The Demo app has 1 simple screen.  This screen shows the current GDPR consent string and shows how to set this app as being subject to GDPR policy.  Clicking on the 'Privacy Settings' button invokes the sdk by starting the GDPR CMP Activity for gathering consent from user (below).
</p>
<br/>


<p align="center">
  <img src="gdpr_demo_2.png" width="276" height="490"/>
</p>
<p align="center">
  This is the main GDPR SDK screen for gathering consent from user.  The consent process is as simple as choosing "I Consent" or "I Do Not Consent".  However, if the user wishes to have a more detailed/customized consent setup, press the Details button, leading us to the next screen below.  There is a Trial notice, but everything will continue to work fine.
</p>
<br/>


<p align="center">
  <img src="gdpr_demo_3.png" width="276" height="490"/>
</p>
<p align="center">
  This is the customized/detailed GDPR SDK screen for gathering consent on a more granular level.  The user may consent or (not consent) to itemized privacy categories and individual vendors.  There are approximately 5 privacy categories and currently over 300 vendors!  Checking or unchecking categories will automatically select or unselect vendors associated to those categories.  Again, this screen exists for users who wish to have a more granular, customized privacy setup.  Simply consenting to "I Consent" or "I Do Not Consent" on the previous main consent screen will suffice.  The user needs to press 'SAVE' button to save their choices and the consent string will be saved.
</p>
<br/>


<p align="center">
  <img src="gdpr_demo_4.png" width="276" height="490"/>
</p>
<p align="center">
  After the user has gone thru the consent experience, which could be as simple as pressing "I Consent" or "I Do Not Consent" or "Save", the sdk brings you back to your original Demo app screen.  You can see the new consent string.  You can go back to the details screen to verify that the user consent settings have been persisted and saved.
</p>
<br/>


Ideal use-case scenario in your app or game: 
1) Use our sdk method to determine if the user is in the EU --> GdprCmp.isSubjectToGDPR(..)
   Of course, you may use your own method to determine EU.  The sdk method uses device locale.
2) If EU, set the application as being subject to GDPR. --> GdprCmp.setIsSubjectToGDPR(true)
3) Show the CMP UI -->  GdprCmp.startCmpActivityForResult(..)
4) Receive onActivityResult callback and check result code against CmpActivityResult result codes.
5) If the user made a choice, then the consent string has been saved and you are done.
6) Finally, provide an overflow menu option for the user, if they wish, to open the privacy settings again.
   This provides users a way to change their privacy settings at any time.

GdprCmp methods:

    /**
     * Starts the main CMP activity for gathering user consent.
     *
     * @param activity - parent activity
     * @param requestCode - activity request code
     * @param allowBackButton - if true, allows user to back out of CMP screen.  Otherwise, no.
     * @param defaultConsentAll - if true and if the first time and user goes thru to CMP Details, then
     *                          all consent items will be checked on.  Otherwise, all checked off.
     *                          
     * Uses CmpActivityResult for activity result codes.
     */
    public static void startCmpActivityForResult(Activity activity, int requestCode, boolean allowBackButton, boolean defaultConsentAll);



    /**
     * Starts the CMP Details activity for gathering user consent.
     *
     * @param activity - parent activity
     * @param requestCode - activity request code
     * @param allowBackButton - if true, allows user to back out of CMP screen.  Otherwise, no.
     * @param defaultConsentAll - if true and if the first time, then all consent items will be checked on.  
     *                          Otherwise, all checked off.
     *                          
     * Uses CmpActivityResult for activity result codes.
     */
    public static void startCmpDetailsActivityForResult(Activity activity, int requestCode, boolean allowBackButton, boolean defaultConsentAll);



    /**
     * Stores the consent string to default shared preferences following IAB specs.
     *
     * @param context
     * @param iabConsentString
     */
    public static void setGDPRConsentString(final Context context, final String iabConsentString);
    
    
    
    /**
     * Sets the app as being subject to GDPR or not.
     *
     * @param context
     * @param isSubjectToGDPR - true sets this app as being subject to GDPR.  false, not subject.
     */
    public static void setIsSubjectToGDPR(final Context context, final boolean isSubjectToGDPR);



    /**
     * Indicates if the app is subject to GDPR.  If 'setIsSubjectToGDPR' has not been invoked yet,
     * then checks device settings to see if it's in a EU country.  If in EU country, then returns true.  
     *
     * @param context
     * @return
     */
    public static boolean isSubjectToGDPR(Context context);



    /**
     * Returns the existing consent string stored in shared preferences.
     *
     * @param context
     * @return consent string. null, if not yet stored.
     */
    public static String getGDPRConsentString(Context context);




    /**
     * Indicates if consent string has been set.
     *
     * @param context
     * @return
     */
    public static boolean hasGDPRConsentString(Context context);



    /**
     * Removes GDPR settings from shared preferences of this app.  Useful for testing.
     * Otherwise, not recommended.
     *
     * @param context
     */
    public static void clearGDPRSettings(Context context);
    
    
    
    /**
     * Starts the CMP Details activity for gathering user consent.
     *
     * @param activity - parent activity
     * @param requestCode - activity request code
     * @param allowBackButton - if true, allows user to back out of CMP screen.  Otherwise, no.
     * @param defaultConsentAll - if true and if the first time, then all consent items will be checked on.  
     *                          Otherwise, all checked off.
     *                          
     * Uses CmpActivityResult for activity result codes.
     */
    public static void startCmpDetailsActivityForResult(Activity activity, int requestCode, boolean allowBackButton, boolean defaultConsentAll);



    /**
     * Stores the consent string to default shared preferences following IAB specs.
     *
     * @param context
     * @param iabConsentString
     */
    public static void setGDPRConsentString(final Context context, final String iabConsentString);



    /**
     * Sets the app as being subject to GDPR or not.
     *
     * @param context
     * @param isSubjectToGDPR - true sets this app as being subject to GDPR.  false, not subject.
     */
    public static void setIsSubjectToGDPR(final Context context, final boolean isSubjectToGDPR);

    
    
    /**
     * Indicates if the app is subject to GDPR.  If 'setIsSubjectToGDPR' has not been invoked yet,
     * then checks device settings to see if it's in a EU country.  If in EU country, then returns true.  
     *
     * @param context
     * @return
     */
    public static boolean isSubjectToGDPR(Context context);

    
    
    /**
     * Returns the existing consent string stored in shared preferences.
     *
     * @param context
     * @return consent string. null, if not yet stored.
     */
    public static String getGDPRConsentString(Context context);

    
    
    /**
     * Indicates if consent string has been set, i.e. stored in shared preferences.
     *
     * @param context
     * @return
     */
    public static boolean hasGDPRConsentString(Context context);

    
    
    /**
     * Removes GDPR settings from shared preferences of this app.  Useful for testing.
     * Otherwise, not recommended.
     *
     * @param context
     */
    public static void clearGDPRSettings(Context context);
