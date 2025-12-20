package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSys{
    public DcMotorEx mainMotor;

    public IntakeSys(HardwareMap hardwareMap){
        mainMotor = hardwareMap.get(DcMotorEx.class, "intake");
        mainMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        mainMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
    }
    public void startIntake(){
        mainMotor.setPower(1);
    }

    public void stopIntake(){
        mainMotor.setPower(0);
    }
}
