package org.firstinspires.ftc.teamcode;


import android.widget.Switch;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by mkrol on 9/21/2017.
 * was removed do to input of encoter 
 */

public class Robot11821 {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int FORWARD = 2;
    public static final int BACK = 3;
    public static final int FORWARDLEFT = 4;
    public static final int FORWARDRIGHT = 5;
    public static final int BACKLEFT = 6;
    public static final int BACKRIGHT = 7;
    public static final int TURNCLOCKWISE = 8;
    public static final int TURNCOUNTERCLOCKWISE = 9;
    
    private DcMotor frontRightMotor;
    private DcMotor frontLeftMotor;
    private DcMotor backRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor leftIntakeMotor;
    private DcMotor rightIntakeMotor;

    public Robot11821(DcMotor frontLeftMotorP, DcMotor frontRightMotorP,DcMotor backLeftMotorP,DcMotor backRightMotorP, DcMotor leftIntakeMotorP, DcMotor rightIntakeMotorP){
        frontLeftMotor = frontLeftMotorP;
        frontRightMotor = frontRightMotorP;
        backRightMotor = backRightMotorP;
        backLeftMotor = backLeftMotorP;
        leftIntakeMotor = leftIntakeMotorP;
        rightIntakeMotor = rightIntakeMotor;



    }

    public void move(double power){
        frontLeftMotor.setPower(power);
        frontRightMotor.setPower(power);
        backRightMotor.setPower(power);
        backLeftMotor.setPower(power);
    }

    //Select the direction for omni chasic
    public void setDirection(int direction){
        //Test to see which direction with the 8 final
        switch (direction){
            case LEFT:
                frontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                break;
            case RIGHT:
                frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                break;
            case FORWARD:
                frontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                break;
            case BACK:
                frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                break;
            case FORWARDLEFT:
                frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                frontLeftMotor.setPower(0);
                backLeftMotor.setPower(0);
                break;
            case FORWARDRIGHT:
                frontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                frontLeftMotor.setPower(0);
                break;
            case BACKLEFT:
                frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                break;
            case BACKRIGHT:
                frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                break;
            case TURNCLOCKWISE:
                frontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                frontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                backLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                backRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
                break;
            case TURNCOUNTERCLOCKWISE:
                frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
                break;
        }

    }
    public void navagation(double x,double y){
        if(x > y){
            move(x);
        }  {
            move(y);
        }
        //test to see if driver wants to go diagonals
        if(x != 0 && y != 0) {
            if(x > 0){
                if(y > 0){
                    setDirection(FORWARDRIGHT);
                }else {
                    setDirection(BACKRIGHT);
                }
            } else{
                if(y > 0){
                    setDirection(FORWARDLEFT);
                } else {
                    setDirection(BACKLEFT);
                }
            }
        }
        //test to see if driver wants to go left or right
        if(y != 0) {
            if (x > 0) {
                setDirection(RIGHT);
            } else {
                setDirection(LEFT);
            }
        }
        //test to see if driver wants to go forward and back
        if(x != 0) {
            if(y > 0){
                setDirection(FORWARD);
            } else {
                setDirection(BACK);
            }

        }
    }
    //It controls the intake motors if it is true it will bring the blocks in and if it is false it will push out
    public void intake(boolean in){
        if(in) {
            leftIntakeMotor.setPower(1);
            rightIntakeMotor.setPower(1);
        } else {
            leftIntakeMotor.setPower(-1);
            rightIntakeMotor.setPower(-1);
        }

    }

}
