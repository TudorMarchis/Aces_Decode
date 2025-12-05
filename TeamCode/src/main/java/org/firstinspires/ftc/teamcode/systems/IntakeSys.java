package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotorEx;

public class IntakeSys{
    DcMotorEx mainMotor;
    void startIntake(){
        mainMotor.setPower(1);
    }

    void stopIntake(){
        mainMotor.setPower(0);
    }
}
