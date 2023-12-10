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
        sensor = new TimeOfFlight(0);
        this.controller = controller;
        sawLastTime = false;
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
        if (controller.getAButton()) {
            setSpeed(1);
        } else if (getDistance() < 1000) {
            setSpeed(0.5);
        } else {
            setSpeed(0);
            TickMeter(5); //timer to measure time after belt turn off 

        }
        if (getDistance() < 1000 && !sawLastTime) {
            count++;
        }
        if (getDistance() < 1000) {
            sawLastTime = true;
        } else {
            sawLastTime = false;
        }




    }

    private void TickMeter(int i) {
    }

    public int getCount() {
        return count;
    }
}