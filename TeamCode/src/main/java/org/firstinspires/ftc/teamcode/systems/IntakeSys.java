package org.firstinspires.ftc.teamcode.systems;

import com.bylazar.configurables.annotations.Configurable;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Configurable
public class IntakeSys{
    public DcMotorEx mainMotor;
    public static double motorPower=-1
            ;
    public boolean active=false;
    public IntakeSys(HardwareMap hardwareMap){
        mainMotor = hardwareMap.get(DcMotorEx.class, "intake");
        mainMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        mainMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
    }
    public void startIntake(){
        mainMotor.setPower(motorPower);
        active = true;
    }

    public void stopIntake(){
        mainMotor.setPower(0);
        active = false;
    }
}
