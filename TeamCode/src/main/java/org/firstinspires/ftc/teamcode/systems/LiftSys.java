package org.firstinspires.ftc.teamcode.systems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class LiftSys {

    public Servo lift;

    public LiftSys(HardwareMap hardwareMap){
        lift = hardwareMap.get(Servo.class, "lift");
    }

    public void LiftUp(){
       lift.setPosition(1);
    }

    public void LiftDown(){
        lift.setPosition(0);
    }
}
