<p align="center"><img src="markdown/fractal.png" align="center"/></p>

This branch is in charge of updating fractal to the newest version of ftc_app. Please do not push your code changes here.

##Structure & Reference
Please check the [wiki](https://github.com/nhs-t10/fractal/wiki) to learn the core concepts of fractal in detail.

##Setup

1. On your [git bash][Git], go to the directory you want this repo to be saved in and type ```git clone https://github.com/nhs-t10/fractal.git```.
2. In [Android Studio][Studio], open ```[your directory]/fractal```.
3. In the project, locate ```/FtcRobotController/src/main/java/com/qualcomm/ftcrobotcontroller/opmodes``` and run ```NullOp.java```.
4. If you set up the repository properly, you should see a window prompting you to choose a device. If not, see [common errors](https://github.com/nhs-t10/Fractal#common-errors) or google search your error.

##Common Errors
+ ```Non-zero exit value``` - While I do not know what causes this error, restarting [Android Studio][Studio] tends to fix it.
+ ```SDK location not found``` - This error occurs when you open the project through the _FtcRobotController_ directory as opposed to the _Fractal directory_. The easiest way to fix this is just to delete the current project and setup a new one.

##Notice
For people working directly in this repo, please push all new changes to a development branch.

[Studio]:http://developer.android.com/tools/studio/index.html
[Git]:https://git-scm.com/
