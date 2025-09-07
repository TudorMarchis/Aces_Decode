package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.systems.Hardware;
import org.firstinspires.ftc.teamcode.utils.Constants;

@Autonomous
public class ParcareCiocanita extends LinearOpMode {
    Hardware sys;

    @Override
    public void runOpMode() throws InterruptedException {
        sys = new Hardware(hardwareMap);
        waitForStart();
        sys.leftMotorBack.setPower(Constants.sniperSpeed);
        sys.rightMotorBack.setPower(Constants.sniperSpeed);
        sys.leftMotorFront.setPower(Constants.sniperSpeed);
        sys.rightMotorFront.setPower(Constants.sniperSpeed);
        sleep(Constants.timpparcat);
        sys.leftMotorBack.setPower(0);
        sys.rightMotorBack.setPower(0);
        sys.leftMotorFront.setPower(0);
        sys.rightMotorFront.setPower(0);
    }
}
