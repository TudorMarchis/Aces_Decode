package org.firstinspires.ftc.teamcode.utils;

import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.systems.LiftSys;

@Configurable
@TeleOp(name = "test_lift", group ="teleop")
public class Test_lift extends LinearOpMode {
    public LiftSys lift;
    public Servo sorter;
    public DcMotor outake;
    public static double poz = 0.04;
    public static double putere = -1;
    @Override
    public void runOpMode() throws InterruptedException {
        lift = new LiftSys(hardwareMap);
        sorter = hardwareMap.get(Servo.class, "1");
        outake = hardwareMap.get(DcMotor.class, "2");
        outake.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        outake.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        sorter.setPosition(poz);

        waitForStart();
        while(opModeIsActive()){
            outake.setPower(putere);
            sorter.setPosition(poz);
            if(gamepad1.dpad_up){
                lift.LiftUp();
            }
            if(gamepad1.dpad_down){
                lift.LiftDown();
            }
        }

    }
}
