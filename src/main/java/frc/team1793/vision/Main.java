package frc.team1793.vision;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.vision.VisionPipeline;
import edu.wpi.first.vision.VisionRunner;

public class Main {

    private static final CameraServer CAMERA_SERVER = CameraServer.getInstance();


    private static final GripPipeline pipeline = new GripPipeline();

    //Unused for now, we might need it
    public static <P extends VisionPipeline> void onPipelineFinished(P pipeline) {
    }

    public static void main(String[] args) {
        UsbCamera camera = CAMERA_SERVER.startAutomaticCapture();
        VisionRunner<GripPipeline> runner = new VisionRunner<>(camera, pipeline, Main::onPipelineFinished);
        runner.runForever();
    }
}
