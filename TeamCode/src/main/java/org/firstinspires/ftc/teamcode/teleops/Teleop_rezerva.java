package org.firstinspires.ftc.teamcode.teleops;


import static org.firstinspires.ftc.teamcode.utils.Constants.slot1;
import static org.firstinspires.ftc.teamcode.utils.Constants.slot2;
import static org.firstinspires.ftc.teamcode.utils.Constants.slot3;
import static org.firstinspires.ftc.teamcode.utils.Constants.sniperSpeed;
import static org.firstinspires.ftc.teamcode.utils.Constants.sorterinit;

import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.systems.AngleSys;
import org.firstinspires.ftc.teamcode.systems.ColorSensorData;
import org.firstinspires.ftc.teamcode.systems.Hardware;
import org.firstinspires.ftc.teamcode.systems.IntakeSys;
import org.firstinspires.ftc.teamcode.systems.LiftSys;
import org.firstinspires.ftc.teamcode.systems.OutakeSys;
import org.firstinspires.ftc.teamcode.systems.SensorSys;

@Configurable
@TeleOp(name = "Rezerva1.0", group = "teleop")
public class Teleop_rezerva extends LinearOpMode {
    public Servo sorter;

   Hardware sys;
    public SensorSys sensor;

    public OutakeSys outake;
    public IntakeSys mainMotor;


    public LiftSys lift;
    public AngleSys angle;



    public void Slotul1(){
        sorter.setPosition(slot1);
    }

    public void Slotul2(){
        sorter.setPosition(slot2);
    }

    public void Slotul3(){
        sorter.setPosition(slot3);
    }
    @Override
    public void runOpMode() throws InterruptedException {
        sys = new Hardware(hardwareMap);
         sorter = hardwareMap.get(Servo.class, "sorter");
         outake = new OutakeSys(hardwareMap);
         sensor = new SensorSys(hardwareMap);
      //   mainMotor = new IntakeSys(hardwareMap);
        lift = new LiftSys( hardwareMap);
      //   angle = new AngleSys(hardwareMap);
         sorter.setPosition(sorterinit);


         waitForStart();
         while(opModeIsActive()){
             ColorSensorData detected = sensor.getSensorData();


             if(detected == ColorSensorData.Green){
                 telemetry.addLine("Bila curenta: verde");
             }else if(detected == ColorSensorData.Purple){
                 telemetry.addLine("Bila curenta: Mov");
             }else{
                 telemetry.addLine("Nicio bila");
             }

             if(gamepad1.triangle){
                 Slotul1();

             }

             if(gamepad1.circle){
                 Slotul2();
             }

             if(gamepad1.cross){
                 Slotul3();
             }
 /*            if(gamepad1.square){
                  mainMotor.startIntake();

              }else{
                  mainMotor.stopIntake();
              }

  */

            if(gamepad1.dpad_up){
                  lift.LiftUp();
              }
              if(gamepad1.dpad_down){
                  lift.LiftDown();
              }

/*              if(gamepad2.dpad_up){
                  angle.Increase();
                  sleep(300);
              }
              if(gamepad2.dpad_down){
                  angle.Decrease();
                  sleep(300);
              }

 */
              if(gamepad2.cross){
                  outake.StartOutake();
              }else{
                  outake.StopOutake();
              }

            //Movement
             double px = -gamepad1.right_stick_x * sniperSpeed;
              double py = gamepad1.right_stick_y * sniperSpeed;
              double pp = -gamepad1.left_stick_x * sniperSpeed;
              sys.leftMotorBack.setPower(py+pp+px);
              sys.leftMotorFront.setPower(py+pp-px);
              sys.rightMotorBack.setPower(py-pp-px);
              sys.rightMotorFront.setPower(py-pp+px);



             telemetry.update();


         }
    }
}
