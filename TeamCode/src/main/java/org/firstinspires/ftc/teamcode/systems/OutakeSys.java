package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class OutakeSys {
    public DcMotorEx outake;

    public OutakeSys(HardwareMap hardwareMap){
        outake = hardwareMap.get(DcMotorEx.class, "outake");
        outake.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        outake.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);




    }

    public void StartOutake(){
        outake.setPower(-1);
    }

    public void StopOutake(){
        outake.setPower(0);
    }


}
