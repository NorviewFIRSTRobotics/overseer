
# Overseer

Overseer is designed for quickly deploying computer vision on a Raspberry Pi for the FIRST Robotics Competition.

# Configuration

Create a file called `gradle.properties` in the root directory of this project  
    Set the values:  
                
        vision_user=<username>   
        vision_password=<password>
        vision_host=<ip address of the host>
        
        
In the build.gradle, increment `version` whenever a major change is made.

The `GripPileline.java` is generated by [GRIP](https://github.com/WPIRoboticsProjects/GRIP) and is only in this repository as an example.
It should be replaced with the intended GripPipeline.  

# Building and Deploying

* Run `./gradlew build` to create the jar

* Run `./gradlew deploy` to send the jar and the launch script to the raspberry pi


# How this works

* This project works by deploying the built jar to the raspberry pi over an SFTP connection and restarting a systemd unit on the pi (`vision.service`).

* All important files are upload to `/srv/vision/`

* The systemd unit file launches the `run_vision.sh` file found in this project to launch the jar file that was uploaded

* In `/srv/vision/natives` there are some integral raspbian compiled shared objects necessary for the WPILib cameraserver, WPILib networktables and opencv to run in java. Currently these are manually put on the Pi and can be found at these locations:
    * [OpenCV-jni](http://first.wpi.edu/FRC/roborio/maven/development/edu/wpi/first/thirdparty/frc2019/opencv/opencv-jni/3.4.4-4/opencv-jni-3.4.4-4-linuxraspbian.jar)
    * [cscore-jni](http://first.wpi.edu/FRC/roborio/maven/development/edu/wpi/first/cscore/cscore-jni/2019.1.1-5-ge97e7a7/cscore-jni-2019.1.1-5-ge97e7a7-linuxraspbian.jar)
    * [ntcore-jni](http://first.wpi.edu/FRC/roborio/maven/development/edu/wpi/first/ntcore/ntcore-jni/2019.1.1-5-ge97e7a7/ntcore-jni-2019.1.1-5-ge97e7a7-linuxraspbian.jar)
    
    In the future I intend to automatically put these on to a pi on deployment



