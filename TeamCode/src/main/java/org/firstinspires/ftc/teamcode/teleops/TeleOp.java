package org.firstinspires.ftc.teamcode.teleops;

import static org.firstinspires.ftc.teamcode.utils.Constants.comeback;
import static org.firstinspires.ftc.teamcode.utils.Constants.counterforce;
import static org.firstinspires.ftc.teamcode.utils.Constants.launchSpeed;
import static org.firstinspires.ftc.teamcode.utils.Constants.launchTime;
import static org.firstinspires.ftc.teamcode.utils.Constants.sniperSpeed;
import static org.firstinspires.ftc.teamcode.utils.Constants.stoppos;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;

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
                sys.launchFront.setPower(launchSpeed);
                sys.extramotor.setPower(launchSpeed);
                sys.positioner.setPower(1);
//                sys.launchFront.setTargetPosition(stoppos);
//
//                // Turn On RUN_TO_POSITION
//                sys.launchFront.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                sys.launchFront.setPower(1);
//                sys.extramotor.setTargetPosition(-stoppos);
//                sys.extramotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                sys.extramotor.setPower(1);
//                sys.launchFront.setPower(launchSpeed);
//                sys.fuckass.setPower(launchSpeed);
//                sleep(launchTime);
//                sys.launchFront.setPower(counterforce);
//                sys.fuckass.setPower(counterforce);
//                sleep(comeback);
//                sys.launchFront.setPower(0);
//                sys.fuckass.setPower(0);
            }else if(gamepad1.triangle){
                sys.launchFront.setPower(-launchSpeed);
                sys.extramotor.setPower(-launchSpeed);
//                sys.launchFront.setTargetPosition(0);
//
//                // Turn On RUN_TO_POSITION
//                sys.launchFront.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
//                sys.launchFront.setPower(1);
//                sys.extramotor.setTargetPosition(0);
//                sys.extramotor.setMode(DcMotorEx.RunModefuckass.RUN_TO_POSITION);
//                sys.extramotor.setPower(1);fuckass
                sys.positioner.setPower(-1);
            }else{
                sys.launchFront.setPower(0);
                sys.extramotor.setPower(0);
                sys.positioner.setPower(0);
            }
//            if (gamepad1.cross){
//                sys.launchFront.setPower(launchSpeed);
//                sys.positioner.setPower(launchSpeed);launchSpeed
//                sys.launchBack.setPower(launchSpeed);
//                sys.fuckass.setPower(launchSpeed);
//            }else if(gamepad1.triangle){
//                sys.launchFront.setPower(-launchSpeed);
//                sys.positioner.setPower(-launchSpeed);
//                sys.launchBack.setPower(-launchSpeed);
//                sys.fuckass.setPower(-launchSpeed);
//            }else{
//                sys.launchFront.setPower(0);
//                sys.positioner.setPower(0);
//                sys.launchBack.setPower(0);
//                sys.fuckass.setPower(0);
//            }

            if(gamepad1.dpad_right){
                sys.positioner.setPower(1);
            }else if(gamepad1.dpad_left){
                sys.positioner.setPower(-1);
            }else{sys.positioner.setPower(0);}
        }
    }
}
