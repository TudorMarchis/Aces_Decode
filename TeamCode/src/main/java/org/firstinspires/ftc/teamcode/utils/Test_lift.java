package org.firstinspires.ftc.teamcode.utils;

import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.systems.LiftSys;

@Configurable
@TeleOp(name = "test_lift", group ="teleop")
public class Test_lift extends LinearOpMode {
    public LiftSys lift;
    @Override
    public void runOpMode() throws InterruptedException {
        lift = new LiftSys(hardwareMap);

        waitForStart();
        while(opModeIsActive()){
            if(gamepad1.dpad_up){
                lift.LiftUp();
            }
            if(gamepad1.dpad_down){
                lift.LiftDown();
            }
        }

    }
}
