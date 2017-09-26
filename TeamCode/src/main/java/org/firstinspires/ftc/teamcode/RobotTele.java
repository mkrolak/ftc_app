package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by Axel on 9/21/2017.
 */
@TeleOp
public class RobotTele extends LinearOpMode {
    Robot robot = new Robot();
    @Override
    public void runOpMode() throws InterruptedException {
        //test to see if drivedr wants to go diagonals
        if(gamepad1.right_stick_x != 0 && gamepad1.right_stick_y != 0) {
            if(gamepad1.right_stick_x > 0){
                if(gamepad1.right_stick_y > 0){
                    robot.setDirection(robot.FORWARDRIGHT);
                }else {
                    robot.setDirection(robot.BACKRIGHT);
                }
            } else{
                if(gamepad1.right_stick_y > 0){
                    robot.setDirection(robot.FORWARDLEFT);
                } else {
                    robot.setDirection(robot.BACKLEFT);
                }
            }
        }
        //test to see if driver wants to go left or right
        if(gamepad1.right_stick_x != 0) {
            if (gamepad1.right_stick_x > 0) {
                robot.setDirection(robot.RIGHT);
            } else {
                robot.setDirection(robot.LEFT);
            }
        }
        //test to see if driver wants to go forward and back
        if(gamepad1.right_stick_y != 0) {
            if(gamepad1.right_stick_y > 0){
                robot.setDirection(robot.FORWARD);
            } else {
                robot.setDirection(robot.BACK);
            }

        }
    }
}
