package org.firstinspires.ftc.teamcode.teleops;

import static org.firstinspires.ftc.teamcode.utils.Constants.comeback;
import static org.firstinspires.ftc.teamcode.utils.Constants.counterforce;
import static org.firstinspires.ftc.teamcode.utils.Constants.decrease;
import static org.firstinspires.ftc.teamcode.utils.Constants.elicieinit;
import static org.firstinspires.ftc.teamcode.utils.Constants.increase;
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
    double elicie = elicieinit;

    public void eliciepozitiva(){
        elicie += increase;
        elicie = Math.min(elicie, 1);
        sys.sorter.setPosition(elicie);

    }

    public void elicienegativa(){
        elicie -= decrease;
        elicie = Math.max(elicie,0);
        sys.sorter.setPosition(elicie);

    }
    @Override
    public void runOpMode() throws InterruptedException {
        sys = new Hardware(hardwareMap);
        sys.sorter.setPosition(elicieinit);

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

            if(gamepad1.right_bumper){
                eliciepozitiva();
                sleep(400);
            }

            if(gamepad1.left_bumper){
                elicienegativa();
                sleep(400);
            }
            if(gamepad1.cross){
                sys.sorter.setPosition(0);
            }


       }
    }
}
