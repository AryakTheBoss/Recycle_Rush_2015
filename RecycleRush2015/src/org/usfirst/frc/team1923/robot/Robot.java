
package org.usfirst.frc.team1923.robot;


import org.usfirst.frc.team1923.robot.commands.AutoRoutine_MAK;
import org.usfirst.frc.team1923.robot.commands.DriveDistanceCommand;
import org.usfirst.frc.team1923.robot.subsystems.DriveTrainSubsystem;
import org.usfirst.frc.team1923.robot.subsystems.ElevatorSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	public static DriveTrainSubsystem driveTrainSubsystem;
    //public static Elevator elevator
    public static ElevatorSubsystem elevatorSubsystem; 
    // Auton Selector
    public SendableChooser autoChooser;
       
    // Define Auton command
    Command autonomousCommand;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		driveTrainSubsystem = new DriveTrainSubsystem();
		elevatorSubsystem = new ElevatorSubsystem();
		// Initialize Robot
		RobotMap.init();
		
		SmartDashboard.putData(driveTrainSubsystem);
		SmartDashboard.putData(elevatorSubsystem);
		
		
        // instantiate the command used for the autonomous period
        //autonomousCommand = new ExampleCommand();
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Auton Routine # 1 ", new AutoRoutine_MAK());
		autoChooser.addObject("Auton Routine # 2", new AutoRoutine_MAK());
		SmartDashboard.putData("Auto Mode", autoChooser);
		addCommandsToDashboard();
		
    }
	
	

    public void autonomousInit() {
        // schedule the autonomous command (example)
        //if (autonomousCommand != null) autonomousCommand.start();
        autonomousCommand = (Command) autoChooser.getSelected();
		autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        log();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        log();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    public void disabledPeriodic() {
		Scheduler.getInstance().run();
		log();
	}
    public void log(){
    	// Log values at Dashboard
    	SmartDashboard.putNumber("Distance", driveTrainSubsystem.getLeftEncoderDistance());
    	SmartDashboard.putNumber("Elevator Position", elevatorSubsystem.getElevatorEncoderPosition());
    }
    public void addCommandsToDashboard(){
    	SmartDashboard.putData("Drive DRIVE_DIST_1", new DriveDistanceCommand(RobotMap.DRIVE_DIST_1,5.0));
    	SmartDashboard.putData("Drive DRIVE_DIST_2", new DriveDistanceCommand(RobotMap.DRIVE_DIST_2,5.0));
    	SmartDashboard.putData("Move Elevator ELEVATOR_POSITION_1", new DriveDistanceCommand(RobotMap.ELEVATOR_POSITION_1,5.0));
    	SmartDashboard.putData("Move Elevator ELEVATOR_POSITION_2", new DriveDistanceCommand(RobotMap.ELEVATOR_POSITION_2,5.0));
    	SmartDashboard.putData("Move Elevator ELEVATOR_POSITION_3", new DriveDistanceCommand(RobotMap.ELEVATOR_POSITION_3,5.0));
    	SmartDashboard.putData("Move Elevator ELEVATOR_POSITION_4", new DriveDistanceCommand(RobotMap.ELEVATOR_POSITION_4,5.0));
    	
    	
    }
    
}
