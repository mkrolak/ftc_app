package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by mkrol on 9/21/2017.
 */


public class Robot {
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
        frontLeftMotor.setPower();
    }

    public void setDirection(Direction direction){

    }
}
