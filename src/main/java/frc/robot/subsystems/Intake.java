package frc.robot.subsystems;
import com.playingwithfusion.TimeOfFlight;

import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Intake extends SubsystemBase {
    private TimeOfFlight sensor;

    public Intake(){
        sensor = new TimeOfFlight(00);
        
    }

    public double getDistance() {
        return sensor.getRange();
    }

    @Override //updates and checks value of distance, if 
    public void periodic() {
        // if (getDistance() < 1000) {
        //     setSpeed(0.5);
        // } else {
        //     setSpeed(0);
         
            
        // }
      
        System.out.println(sensor.getRange());

    }
}
