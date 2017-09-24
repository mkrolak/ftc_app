import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Robot;

/**
 * Created by Axel on 9/24/2017.
 */
@TeleOp
public class Testcode extends LinearOpMode {
    DcMotor testmotor;

    @Override
    public void runOpMode() throws InterruptedException {
        testmotor = hardwareMap.get("motor_test");
        if (gamepad1.a) {
            testmotor.setDirection(DcMotorSimple.Direction.FORWARD);
        }
        if (gamepad1.b) {
            testmotor.setDirection(DcMotorSimple.Direction.REVERSE);
        }
        if(gamepad1.left_bumper){
            gamepad1.toString();
        }

    }

}
