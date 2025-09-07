package org.firstinspires.ftc.teamcode.teleops;

import static org.firstinspires.ftc.teamcode.utils.Constants.launchSpeed;
import static org.firstinspires.ftc.teamcode.utils.Constants.launchTime;
import static org.firstinspires.ftc.teamcode.utils.Constants.sniperSpeed;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.systems.Hardware;

@com.qualcomm.robotcore.eventloop.opmode.TeleOp
public class TeleOp extends LinearOpMode {
    Hardware sys;
    @Override
    public void runOpMode() throws InterruptedException {
        sys = new Hardware(hardwareMap);
        waitForStart();
        while (opModeIsActive()){
            // Movement
            double px = - gamepad1.right_stick_x * sniperSpeed;
            double py = - gamepad1.right_stick_y * sniperSpeed;
            double pp = gamepad1.left_stick_x * sniperSpeed;
            sys.leftMotorBack.setPower(py + pp + px);
            sys.leftMotorFront.setPower(py + pp - px);
            sys.rightMotorBack.setPower(py - pp - px);
            sys.rightMotorFront.setPower(py - pp + px);

            if(gamepad1.cross){
                new Thread(() -> {
                    sys.launchFront.setPower(launchSpeed);
                    sys.positioner.setPower(launchSpeed);
                    sys.launchBack.setPower(launchSpeed);
                    sleep(launchTime);
                    sys.launchFront.setPower(0);
                    sys.positioner.setPower(0);
                    sys.launchBack.setPower(0);
                }).start();
            }

        }
    }
}
