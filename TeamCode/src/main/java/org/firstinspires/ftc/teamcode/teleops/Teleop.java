package org.firstinspires.ftc.teamcode.teleops;

import static org.firstinspires.ftc.teamcode.utils.Constants.sniperSpeed;

import com.bylazar.ftcontrol.panels.configurables.annotations.Configurable;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.systems.ColorSensorData;
import org.firstinspires.ftc.teamcode.systems.Hardware;
import org.firstinspires.ftc.teamcode.systems.IntakeSys;
import org.firstinspires.ftc.teamcode.systems.LiftSys;
import org.firstinspires.ftc.teamcode.systems.OutakeSys;
import org.firstinspires.ftc.teamcode.systems.SensorSys;
import org.firstinspires.ftc.teamcode.systems.SorterSys;

@Configurable
@TeleOp(name = "Teleop", group = "teleop")
public class Teleop extends LinearOpMode {

    Hardware sys;
    public SorterSys sorter;
    public SensorSys sensor;
    public LiftSys lift;
    public IntakeSys intake;
    public OutakeSys outake;
  //  public AngleSys angle;


    @Override
    public void runOpMode() throws InterruptedException {
        sys = new Hardware(hardwareMap);
        sorter = new SorterSys(hardwareMap);
        sensor = new SensorSys(hardwareMap);
        lift = new LiftSys(hardwareMap);
        intake = new IntakeSys(hardwareMap);
        outake =new OutakeSys(hardwareMap);
  //      angle = new AngleSys(hardwareMap);

        waitForStart();

        new Thread(() -> {
            while(opModeIsActive()){
                double px = -gamepad2.left_stick_x * sniperSpeed;
                double py = -gamepad2.left_stick_y * sniperSpeed;
                double pp = gamepad2.right_stick_x * sniperSpeed;
                sys.leftMotorBack.setPower(py+px+pp);
                sys.leftMotorFront.setPower(py+pp-px);
                sys.rightMotorBack.setPower(py-pp-px);
                sys.rightMotorFront.setPower(py-pp+px);
            }

        }).start();

        while(opModeIsActive()){

            telemetry.addData("Color0", sorter.mem[0]);
            telemetry.addData("Color1", sorter.mem[1]);
            telemetry.addData("Color2", sorter.mem[2]);
            telemetry.update();

     /*       if(gamepad1.cross){
                sorter.canIntake = false;
                sorter.loadType(ColorSensorData.Green);
                sleep(350);
            }else if(gamepad1.circle){
                sorter.canIntake = false;
                sorter.loadType(ColorSensorData.Purple);
                sleep(350);
            }
            sorter.canIntake = true;
*/
            if(gamepad1.left_bumper){
                intake.startIntake();
            }else{
                intake.stopIntake();
            }

            if(intake.active) {
                ColorSensorData sensorOutput = sensor.getSensorData();
                if(sensorOutput != ColorSensorData.Nan && sorter.canIntake){
                    sleep(300);
                    sorter.depositArtifact(sensorOutput);
                    sleep(1000);
                };
                telemetry.addData("Color0", sorter.mem[0]);
                telemetry.addData("Color1", sorter.mem[1]);
                telemetry.addData("Color2", sorter.mem[2]);
                telemetry.update();

                sorter.canIntake = true;
            }

            if(gamepad1.cross){
                outake.StartOutake();
//                sleep(4?00);
                sorter.Slot1();
                sleep(1500);
                lift.LiftUp();
                sleep(600);
                lift.LiftDown();
                outake.StopOutake();
                sorter.freeUp(0);
            }else if(gamepad1.circle){
                outake.StartOutake();
//                sleep(300);
                sorter.Slot2();
                sleep(1500);
                lift.LiftUp();
                sleep(600);
                lift.LiftDown();
                outake.StopOutake();
                sorter.freeUp(1);

            }else if(gamepad1.triangle){
                outake.StartOutake();
//                sleep(300);
                sorter.Slot3();
                sleep(1500);
                lift.LiftUp();
                sleep(600);
                lift.LiftDown();
                outake.StopOutake();
                sorter.freeUp(2);
            }
            if(gamepad1.right_bumper){
                intake.ReverseIntake();

            }else{
                intake.stopIntake();
            }

  /*          if(gamepad2.dpad_up){if(gamepad1.cross){
                    sorter.canIntake = false;
                    sorter.loadType(ColorSensorData.Green);
                    sleep(350);
                }else if(gamepad1.circle){
                    sorter.canIntake = false;
                    sorter.loadType(ColorSensorData.Purple);
                    sleep(350);
                }
                angle.Increase}();
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

            if(gamepad2.right_bumper){
                lift.LiftUp();
            }
            if(gamepad2.left_bumper){
                lift.LiftDown();
            }





        }

    }
}
