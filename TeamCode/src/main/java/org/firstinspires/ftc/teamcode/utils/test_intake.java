package org.firstinspires.ftc.teamcode.utils;

import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Configurable
@TeleOp(name = "matura", group = "teleop")
public class test_intake extends LinearOpMode {
    public DcMotorEx intake;
    @Override
    public void runOpMode() throws InterruptedException {
        intake = hardwareMap.get(DcMotorEx.class, "intake");

        waitForStart();

        while(opModeIsActive()){
            intake.setPower(1);
        }

    }
}
