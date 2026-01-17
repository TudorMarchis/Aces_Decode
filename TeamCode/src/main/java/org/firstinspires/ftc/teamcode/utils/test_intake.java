package org.firstinspires.ftc.teamcode.utils;

import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.systems.IntakeSys;
import org.firstinspires.ftc.teamcode.systems.LiftSys;

@Configurable
@TeleOp(name = "test_intake", group ="teleop")
public class test_intake extends LinearOpMode {
    public IntakeSys intake;
    public Servo sorter;
    public DcMotor outake;
    public static double poz = 0.04;
    public static double putere = -1;
    @Override
    public void runOpMode() throws InterruptedException {
        intake = new IntakeSys(hardwareMap);
        waitForStart();
        while(opModeIsActive()){intake.startIntake();}
    }
}
