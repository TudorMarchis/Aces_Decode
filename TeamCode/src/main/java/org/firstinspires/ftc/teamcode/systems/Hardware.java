package org.firstinspires.ftc.teamcode.systems;

import static org.firstinspires.ftc.teamcode.utils.Constants.elicieinit;
import static org.firstinspires.ftc.teamcode.utils.Constants.minDetect;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    public DcMotorEx leftMotorBack, rightMotorBack, rightMotorFront, leftMotorFront;
    public DcMotor intake;
    public Servo sorter, lift;
    public Hardware(HardwareMap hardwareMap){
        leftMotorBack = hardwareMap.get(DcMotorEx.class, "stanga_spate");
        rightMotorBack = hardwareMap.get(DcMotorEx.class, "dreapta_spate");
        rightMotorFront = hardwareMap.get(DcMotorEx.class, "dreapta_fata");
        leftMotorFront = hardwareMap.get(DcMotorEx.class, "stanga_fata");
       // intake = hardwareMap.get(DcMotor.class, "intake");
        sorter = hardwareMap.get(Servo.class, "sorter");
        lift =hardwareMap.get(Servo.class, "lift");

        leftMotorBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotorBack.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightMotorFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftMotorFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Set mode for drive motors
        leftMotorFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftMotorBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotorFront.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightMotorBack.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // Reverse necessary
        leftMotorFront.setDirection(DcMotorEx.Direction.REVERSE);
        leftMotorBack.setDirection(DcMotorEx.Direction.REVERSE);

    }



}


