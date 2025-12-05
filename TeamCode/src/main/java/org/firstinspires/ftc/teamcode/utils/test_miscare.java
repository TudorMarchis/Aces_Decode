package org.firstinspires.ftc.teamcode.utils;

import static org.firstinspires.ftc.teamcode.utils.Constants.sniperSpeed;

import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@Configurable
 @TeleOp(name= "test_miscare", group = "teleop")
public class test_miscare extends LinearOpMode {
    public DcMotor lf, rf, lr, rr;
    @Override
    public void runOpMode() throws InterruptedException {
        lf = hardwareMap.get(DcMotor.class, "lf");
        rf = hardwareMap.get(DcMotor.class, "rf");
        lr = hardwareMap.get(DcMotor.class, "lr");
        rr = hardwareMap.get(DcMotor.class, "rr");

        waitForStart();
        while(opModeIsActive()){

            double px = -gamepad1.right_stick_x * sniperSpeed;
            double py = -gamepad1.right_stick_y * sniperSpeed;
            double pp = -gamepad1.left_stick_x * sniperSpeed;
            lr.setPower(py+pp+px);
            lf.setPower(py+pp-px);
            rf.setPower(py-pp-px);
            rr.setPower(py-pp+px);
        }
    }
}
