package org.firstinspires.ftc.teamcode.systems;

import static org.firstinspires.ftc.teamcode.utils.Constants.liftdown;
import static org.firstinspires.ftc.teamcode.utils.Constants.liftup;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class LiftSys {

    public Servo lift;

    public LiftSys(HardwareMap hardwareMap){
        lift = hardwareMap.get(Servo.class, "lift");
    }

    public void LiftUp(){
       lift.setPosition(liftup);
    }

    public void LiftDown(){
        lift.setPosition(liftdown);
    }
}
