package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;


/**
 * Created by Axel on 9/24/2017.
 */
@TeleOp
public class Testcode extends LinearOpMode {
    DcMotor testmotor;
    ColorSensor testSensor;

    @Override
    public void runOpMode() throws InterruptedException {
        testmotor = (DcMotor) hardwareMap.get("motor_test");
        testSensor = (ColorSensor) hardwareMap.get("sensor_test");
        
        waitForStart();
        
        while(opModeIsActive()){
            if (gamepad1.a) {
                testmotor.setDirection(DcMotorSimple.Direction.FORWARD);
                testmotor.setPower(1);
            }
            if (gamepad1.b) {
                testmotor.setDirection(DcMotorSimple.Direction.REVERSE);
                testmotor.setPower(1);
            }
            if(gamepad1.left_bumper){
                telemetry.addLine(gamepad1.toString());
                telemetry.addLine(testSensor.red() + " " + testSensor.blue() + " " + testSensor.green());
                telemetry.update();
            }
        }

    }

}
