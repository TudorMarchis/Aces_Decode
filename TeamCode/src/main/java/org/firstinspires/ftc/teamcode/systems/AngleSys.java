package org.firstinspires.ftc.teamcode.systems;

import static org.firstinspires.ftc.teamcode.utils.Constants.angleinit;
import static org.firstinspires.ftc.teamcode.utils.Constants.decrease;
import static org.firstinspires.ftc.teamcode.utils.Constants.increase;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class AngleSys {
   public Servo angle;

   double anglepos = angleinit;

   public AngleSys(HardwareMap hardwareMap){
       angle = hardwareMap.get(Servo.class, "angle");
       angle.setPosition(anglepos);
   }

   public void Decrease(){
      anglepos += increase;
      anglepos = Math.min(anglepos, 1);
      angle.setPosition(anglepos);


   }

   public void Increase(){
      anglepos -= decrease;
      anglepos = Math.max(anglepos, 0.3);
      angle.setPosition(anglepos);
   }
}
