package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class Hardware {
    public DcMotorEx leftMotorBack, rightMotorBack, rightMotorFront, leftMotorFront;
    public DcMotorEx launchFront,launchBack, positioner, extramotor;
    public Hardware(HardwareMap hardwareMap){
        leftMotorBack = hardwareMap.get(DcMotorEx.class, "stanga_spate");
        rightMotorBack = hardwareMap.get(DcMotorEx.class, "dreapta_spate");
        rightMotorFront = hardwareMap.get(DcMotorEx.class, "dreapta_fata");
        leftMotorFront = hardwareMap.get(DcMotorEx.class, "stanga_fata");

            launchFront = hardwareMap.get(DcMotorEx.class, "frontlift");
            launchBack = hardwareMap.get(DcMotorEx.class, "backlift");
            positioner = hardwareMap.get(DcMotorEx.class, "positioner");
            extramotor = hardwareMap.get(DcMotorEx.class, "fuckass"); // Olaie stie ce face

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

        launchFront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        extramotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
//        launchFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        extramotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        launchFront.setDirection(DcMotorSimple.Direction.REVERSE);

    }

}
