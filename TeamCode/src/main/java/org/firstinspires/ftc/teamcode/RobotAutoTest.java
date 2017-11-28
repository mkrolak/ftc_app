package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

/**
 * Created by mkrol on 9/21/2017.
 */

@Autonomous
public class RobotAutoTest extends LinearOpMode {
   /* Robot11821 voltageBot;
    DcMotor testMotor;
    ColorSensor testSensor;*/
    ElapsedTime timer;
    VuforiaLocalizer vuforia;

    @Override
    public void runOpMode() throws InterruptedException {
        /*testSensor = (ColorSensor) hardwareMap.get("sensor_test");
        testMotor = (DcMotor) hardwareMap.get("motor_test");
        testMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);*/
        
        //Robot11821 voltageBot = new Robot11821();
        timer = new ElapsedTime();
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        
        parameters.vuforiaLicenseKey = "AfVEpqX/////AAAAGRC64ob+vU9eoUAi7WPxoEYtKuIrLSIczL3B2VnilMOb1XRB6ZJ/066GMf85U0EYhItpvmWQFixhDdeBHl4Vg+uat1fXlhgZpj96WRQbgfjvX3m/9skk/6JTNZeRUU+3maigdKZBvW4F+pWxR/9ekKFf0jIJx1Ro3wTvKuvZJV8HwO3mvY78P1mxrr+694qyIkxwRSP+03juVZvGD/85y6077e3siElVz3caFrSDsmI11iSrZznYoyEoOHfAtTQqIzHkLau7YOAl45sB8GQAacRCWHLICJx/c3yL4cjs2hNmCywkBKnte0s3xWV6JodDyyg9j9WXVowKcWT+hHPqz88uXAQ4FP2P/bF5j7C6TeDk";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        
        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        
        waitForStart();
        
      relicTrackables.activate();
        
        timer.reset();
        
        
        
        //testMotor.setTargetPosition(120);
        //testMotor.setPower(1);
        //while(testMotor.isBusy());
            
            
            
            RelicRecoveryVuMark vuMark = RelicRecoveryVuMark.from(relicTemplate);
             telemetry.addData("VuMark", "%s visible", vuMark);
             telemetry.update();
             
    
        
       
        
        
    }
    
    
}
