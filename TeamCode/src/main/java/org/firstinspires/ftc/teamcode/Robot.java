package org.firstinspires.ftc.teamcode;


import android.widget.Switch;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by mkrol on 9/21/2017.
 */

public class Robot {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int FORWARD = 2;
    public static final int BACK = 3;
    public static final int FORWARDLEFT = 4;
    public static final int FORWARDRIGHT = 5;
    public static final int BACKLEFT = 6;
    public static final int BACKRIGHT = 7;
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

    //Select the direction for omni chasic
    public void setDirection(int direction){
        //Test to see which direction with the 8 final
        switch (direction){
            case LEFT:
                //frontLeftMotor.setDirection();
                //frontRightMotor.setDirection();
                //backLeftMotor.setDirection();
                //backRightMotor.setDirection();
                break;
            case RIGHT:
                //frontLeftMotor.setDirection();
                //frontRightMotor.setDirection();
                //backLeftMotor.setDirection();
                //backRightMotor.setDirection();K
                break;
            case FORWARD:
                //frontLeftMotor.setDirection();
                //frontRightMotor.setDirection();
                //backLeftMotor.setDirection();
                //backRightMotor.setDirection();
                break;
            case BACK:
                //frontLeftMotor.setDirection();
                //frontRightMotor.setDirection();
                //backLeftMotor.setDirection();
                //backRightMotor.setDirection();
                break;
            case FORWARDLEFT:
                //frontRightMotor.setDirection();
                //backRightMotor.setDirection();
                break;
            case FORWARDRIGHT:
                //frontLeftMotor.setDirection();
                //backLeftMotor.setDirection();
                break;
            case BACKLEFT:
                //frontRightMotor.setDirection();
                //backRightMotor.setDirection();
                break;
            case BACKRIGHT:
                //frontLeftMotor.setDirection();
                //backLeftMotor.setDirection();
                break;
        }

    }

}
