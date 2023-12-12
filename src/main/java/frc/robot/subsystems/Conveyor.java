package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.playingwithfusion.TimeOfFlight;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Conveyor extends SubsystemBase {

    private CANSparkMax motor;

    
    private TimeOfFlight sensor;
    private XboxController controller;
    private boolean sawLastTime;
    private int count;
    public Conveyor(XboxController controller) {
        motor = new CANSparkMax(0, MotorType.kBrushless);
        sensor = new TimeOfFlight(00);
        this.controller = controller;
        count = 0;
    }

    public Conveyor() {
    }

    public void setSpeed(double speed) {
        motor.set(speed);
    }

    public double getDistance() {
        return sensor.getRange();
    }

    @Override //updates and checks value of distance, if 
    public void periodic() {
         if (getDistance() > 1000) {
            TickMeter(5);
            count++;
        } 
        if(count == 5){
            setSpeed(.5);
            
            
            
            
            



        }



    }

    private void when(boolean b) {
    }

    private void TickMeter(int i) {
    }

    public int getCount() {
        return count;
    }
}