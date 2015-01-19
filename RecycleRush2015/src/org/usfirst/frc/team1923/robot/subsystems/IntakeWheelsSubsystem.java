package org.usfirst.frc.team1923.robot.subsystems;

import org.usfirst.frc.team1923.robot.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class IntakeWheelsSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    // Intake wheel Forward
    public void rotateIntakeForward(){
    	RobotMap.intakeLeftSpike.set(Relay.Value.kForward);
    	RobotMap.intakeRightSpike.set(Relay.Value.kReverse);
    }
 // Intake wheel Reverse
    public void rotateIntakeReverse(){
    	RobotMap.intakeLeftSpike.set(Relay.Value.kReverse);
    	RobotMap.intakeRightSpike.set(Relay.Value.kForward);
    }
 // Intake wheel stop
    public void stopIntake(){
    	RobotMap.intakeLeftSpike.set(Relay.Value.kOff);
    	RobotMap.intakeRightSpike.set(Relay.Value.kOff);
    }
}

