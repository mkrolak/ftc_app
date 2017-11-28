package org.firstinspires.ftc.teamcode;

import android.hardware.Sensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import android.hardware.SensorManager;
import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorEvent;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.CompassSensor;
import com.qualcomm.robotcore.hardware.I2cAddr;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous
public class RobotAuto extends LinearOpMode implements SensorEventListener{
    SensorManager mSensorManager;
    
    DcMotor backRight;
    DcMotor backLeft;
    DcMotor frontRight;
    DcMotor frontLeft;
    
    DcMotor intakeRight;
    DcMotor intakeLeft;
    
    Servo servo;
    
    ColorSensor color;
    
    ColorSensor bottomColor;
    
    ElapsedTime timer;
    
    Robot11821_2 robot;
    
    VuforiaLocalizer vuforia;
    
    float directionX;
    float directionY;
    float directionZ;
    
    float directionXInit;
    float directionYInit;
    float directionZInit;
    
    int team;
    
    public void runOpMode() throws InterruptedException {
        SensorManager mSensorManager = (SensorManager)hardwareMap.appContext.getSystemService(Context.SENSOR_SERVICE);
    
        servo = (Servo) hardwareMap.get("servo");
        
        backRight = (DcMotor) hardwareMap.get("backRight");
        backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeft = (DcMotor) hardwareMap.get("backLeft");
        backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        frontRight = (DcMotor) hardwareMap.get("frontRight");
        frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontLeft = (DcMotor) hardwareMap.get("frontLeft");
        frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        intakeRight = (DcMotor) hardwareMap.get("intakeRight");
        intakeLeft = (DcMotor) hardwareMap.get("intakeLeft");
        
        color = (ColorSensor) hardwareMap.get("colorSensor");
        bottomColor = (ColorSensor) hardwareMap.get("floorSensor");
        
        color.setI2cAddress(I2cAddr.create8bit(0x10));
        bottomColor.setI2cAddress(I2cAddr.create8bit(0x3c));
        
        
        
        robot = new Robot11821_2(backLeft,backRight,frontLeft,frontRight, intakeRight, intakeLeft, servo, color, bottomColor);
        
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters parameters = new VuforiaLocalizer.Parameters(cameraMonitorViewId);
        
        parameters.vuforiaLicenseKey = "AfVEpqX/////AAAAGRC64ob+vU9eoUAi7WPxoEYtKuIrLSIczL3B2VnilMOb1XRB6ZJ/066GMf85U0EYhItpvmWQFixhDdeBHl4Vg+uat1fXlhgZpj96WRQbgfjvX3m/9skk/6JTNZeRUU+3maigdKZBvW4F+pWxR/9ekKFf0jIJx1Ro3wTvKuvZJV8HwO3mvY78P1mxrr+694qyIkxwRSP+03juVZvGD/85y6077e3siElVz3caFrSDsmI11iSrZznYoyEoOHfAtTQqIzHkLau7YOAl45sB8GQAacRCWHLICJx/c3yL4cjs2hNmCywkBKnte0s3xWV6JodDyyg9j9WXVowKcWT+hHPqz88uXAQ4FP2P/bF5j7C6TeDk";
        parameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.vuforia = ClassFactory.createVuforiaLocalizer(parameters);
        
        VuforiaTrackables relicTrackables = this.vuforia.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        
        timer = new ElapsedTime();
        
        
        waitForStart();
        
    
        relicTrackables.activate();
        
        timer.reset();
        
        directionXInit = directionX;
        directionYInit = directionY;
        directionZInit = directionZ;
        
        while(bottomColor.red() == 0 && bottomColor.blue() == 0);
        
        team = (bottomColor.red() > bottomColor.blue())?-1:1;
        
        
        
        robot.setServo(.5);
            
        robot.setDirection(Robot11821_2.DOWN);
        robot.runTo(1);
        robot.start(1);
        while(robot.isBusy());
        
        RelicRecoveryVuMark vuMark;
        
        
        
        while(robot.getColor()[0] == 0 && robot.getColor()[2] == 0){
            robot.runTo(.1);
            robot.start(1);
        }
        
        double time = timer.seconds();
        double distance = ((robot.getColor()[0] < robot.getColor()[2])?(-1.0):1);
        distance = -1*team;
        
        robot.setDirection((team==-1)?new double[]{.5,.5,-1,-1}:new double[]{-.5,-.5,1,1});
        robot.runTo(distance);
        robot.start(.5);
        while(robot.isBusy());
        
        robot.setServo(1.0);
        
        
        robot.setDirection(Robot11821_2.UP);
        robot.runTo(.375);
        robot.start(.2);
        while(robot.isBusy());
        
        
        robot.setDirection((team==-1)?new double[]{.5,.5,-1,-1}:new double[]{-.5,-.5,1,1});
        robot.runTo((-1*distance)+(2.5)); //Changed
        robot.start(.5);
        while(robot.isBusy());
        
        
        do{
            vuMark = RelicRecoveryVuMark.from(relicTemplate);
        }while(vuMark == RelicRecoveryVuMark.UNKNOWN);
        
        
        
        robot.setDirection((team==-1)?Robot11821_2.RIGHT:Robot11821_2.LEFT);
        robot.runTo(4);
        robot.start(.5);
        while(robot.isBusy());
        
        
        robot.setDirection(Robot11821_2.CLOCKWISE);
        do{
            robot.runTo(.5);
            robot.start(.5);
            while(robot.isBusy());
            //only mod -1 if value is greater than 1 or less that -1
        }while(directionYInit-.05 > (directionY+1)%-1 && directionYInit+.05 < (directionY+1)%-1 && directionYInit-.05 > (directionZ+1)%-1 && directionZInit+.05 < (directionZ+1)%-1);
        
        //Scoot toward the glyph thing and check for color
        //Needs measurements for the glyph thing
        
        double multiplier = 0;
        
        
    
        if(vuMark == RelicRecoveryVuMark.LEFT){
            multiplier = (team==1)?-1:1;
        }else if(vuMark == RelicRecoveryVuMark.CENTER){
            multiplier = 0;
        }else if(vuMark == RelicRecoveryVuMark.RIGHT){
            multiplier = (team==2)?-1:1;
        }
    
        
    
        robot.setDirection(Robot11821_2.LEFT);
        robot.runTo(multiplier*1);
        robot.start();
        while(robot.isBusy());
        
        //robot.intake(Robot11821_2.OUTPUT);
        
        
        
    }
    
    
    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }

    @Override
    public final void onSensorChanged(SensorEvent event) {
        directionX = event.values[0];
        directionY = event.values[1];
        directionZ = event.values[2];
        
    }
    
}