package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by Axel on 9/21/2017.
 */

public class RobotTele extends LinearOpMode {
    @Override
    Robot robot = new Robot();
    public void runOpMode() throws InterruptedException {
        //test for diagonals
        if(gamepad1.right_stick_x != 0 && gamepad1.right_stick_y != 0) {
        }
        //test to see if driver wants it to go left
        if(gamepad1.right_stick_x != 0) {
            if(gamepad1.right_stick_x > 0) {
                robot.setDirection(robot.RIGHT);
            }
            else {
                robot.setDirection(robot.LEFT);
            }
        }
        }
    }
}
