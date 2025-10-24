package org.firstinspires.ftc.teamcode.teleops;

import static org.firstinspires.ftc.teamcode.utils.Constants.launchSpeed;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.systems.Hardware;

@TeleOp
public class Outake extends LinearOpMode {
    Hardware sys;

    @Override
    public void runOpMode() throws InterruptedException {
        sys =  new Hardware(hardwareMap);
        waitForStart();
 //       sys.launchFront.setPower(launchSpeed);
 //       sys.positioner.setPower(launchSpeed);
 //       sys.launchBack.setPower(launchSpeed);
 //       sys.extramotor.setPower(launchSpeed);
 //       while (opModeIsActive()){}
    }
}
