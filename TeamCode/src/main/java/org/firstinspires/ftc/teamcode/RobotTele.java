package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by Axel on 9/21/2017.
 */
@TeleOp
public class RobotTele extends LinearOpMode {
    Robot11821_2 robot;
   @Override
    public void runOpMode() throws InterruptedException {
         robot = new Robot11821_2((DcMotor) hardwareMap.get("backLeft"), (DcMotor) hardwareMap.get("backRight"), (DcMotor) hardwareMap.get("frontLeft"), (DcMotor) hardwareMap.get("frontRight"), (DcMotor) hardwareMap.get("intakeRight"),(DcMotor) hardwareMap.get("intakeLeft"), (Servo)hardwareMap.get("servo"), (ColorSensor)hardwareMap.get("colorSensor"),(ColorSensor)hardwareMap.get("floorSensor"));        
       waitForStart();
        while(opModeIsActive()){
            //Gamepad 1
            //Set direction
            robot.navagation(gamepad1.right_stick_x,gamepad1.right_stick_y);
            //Gamepad 2
            //set intake
            if(gamepad1.a) {
                robot.intake(Robot11821_2.IN);
            }else if(gamepad1.b) {
                robot.intake(Robot11821_2.OUT);
            }else{
                robot.intake(Robot11821_2.OFF);
            }
        }

    }
}
