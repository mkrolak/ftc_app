package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by mkrol on 9/21/2017.
 */


public class Robot {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int FORWARD = 2;
    public static final int BACK = 3;
    private DcMotor frontRightMotor;
    private DcMotor frontLeftMotor;
    private DcMotor backRightMotor;
    private DcMotor backLeftMotor;

    public Robot(){
        //frontLeftMotor = hardwareMap.get();
        //frontRoghtMotor = hardwareMap.get();
        //backRightMotor = hardwareMap.get();
        //backLeftMotor = hardwareMap.get();



    }

    public void moveForward(float power){
        //frontLeftMotor.setPower();
    }


    public void setDirection(int direction){

    }
}
