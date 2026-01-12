package org.firstinspires.ftc.teamcode.utils;

import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Configurable
@TeleOp(name = "test_motor", group = "teleop")
public class test_motor extends LinearOpMode {
    DcMotor motor;
    public static double putere=-1;
    @Override
    public void runOpMode() throws InterruptedException {
        motor = hardwareMap.get(DcMotor.class, "motor");

        waitForStart();

        while(opModeIsActive()){
            motor.setPower(putere);
        }

    }
}
