# android-gdpr-demo
Android Demo App easily showing how to use a cool GDPR SDK

Watch the video to see how the Demo works:
https://drive.google.com/open?id=1Vw8YMFnhAIWjw1klA4hxWHOR7UZGSpPR
<br/>
Link to the GDPR Sdk Demo for Android:
https://drive.google.com/open?id=1QpuxKweJ21ek7g6nlKRzoT1UGlEUnISq
<br/>

<p align="center">
  <img src="gdpr_demo_1.png" width="276" height="490"/>  
</p>
<p align="center">
  The Demo app has 1 simple screen.  This screen shows the current GDPR consent string and shows how to set this app as being GDPR applicable.  Clicking on the 'Privacy Settings' button will start the GDPR SDK Activity for gathering consent from user (below).
</p>
<br/>


<p align="center">
  <img src="gdpr_demo_2.png" width="276" height="490"/>
</p>
<p align="center">
  This is the main GDPR SDK screen for gathering consent from user.  If the user wishes to have a more detailed/customized consent setup, press the Details button, leading us to the next screen.  In most cases, if the user chooses "I Consent" or "I Do Not Consent" then the consent gathering process is finished and would return to the original Demo Screen.  The consent string would be saved.
</p>
<br/>


<p align="center">
  <img src="gdpr_demo_3.png" width="276" height="490"/>
</p>
<p align="center">
  This is the customized/detailed GDPR SDK screen for gathering more granular consent from user.  Here the user may consent or (not consent) to itemized privacy points.  Checking or unchecking purposes will automatically select or unselect vendors associated to those purposes.  Again, this screen exists for those users who wish to have a more granular, customized privacy setup.  Simply consenting to "I Consent" or "I Do Not Consent" on the previous main consent screen will suffice.
</p>
<br/>


<p align="center">
  <img src="gdpr_demo_4.png" width="276" height="490"/>
</p>
<p align="center">
  After the user has gone thru the consent experience, which could be as simple as pressing "I Consent" or "I Do Not Consent" or "Save", the sdk brings you back to your original Demo app screen.  You can see the new consent string.  You can back back to the details screen to verify that the user consent settings have been persisted and saved.
</p>
<br/>
