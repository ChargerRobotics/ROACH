package frc.robot;

import edu.wpi.first.wpilibj.PWMSparkMax;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class Robot extends TimedRobot 
{
  public SpeedController frontLeftMotor= new VictorSP(1);
  public SpeedController backLeftMotor = new PWMVictorSPX(2);
  public SpeedControllerGroup leftDrive = new SpeedControllerGroup(frontLeftMotor, backLeftMotor);

  public SpeedController frontRightMotor = new PWMSparkMax(3);
  public SpeedController backRightMotor = new PWMVictorSPX(4);
  public SpeedControllerGroup rightDrive = new SpeedControllerGroup(frontRightMotor, backRightMotor);

  public XboxController controller = new XboxController(0);

  public static int leftStickY = 1;
  public static int rightStickY = 5;

  public static int leftTrigger = 2;
  public static int rightTrigger = 3;

  @Override
  public void disabledInit()
  {

  }

  @Override
  public void robotInit() 
  {
    leftDrive.set(0);
    rightDrive.set(0);
  }

  @Override
  public void robotPeriodic() 
  {
   
  }

  @Override
  public void autonomousInit() 
  {
    
  }

  @Override
  public void autonomousPeriodic() 
  {
    
  }

  @Override
  public void teleopInit() 
  {
    leftDrive.set(0);
    rightDrive.set(0);
  }
  
  @Override
  public void teleopPeriodic() 
  {
    double leftY = controller.getRawAxis(leftStickY);
    double rightY = controller.getRawAxis(rightStickY) * 0.999;
    double rightTrig = controller.getRawAxis(rightTrigger);

    if (rightTrig > .35)
    {
      leftY *= rightTrig;
      rightY *= rightTrig;
    }
    else
    {
      leftY *= .35;
      rightY *= .35;
    }
    // if(rightTrig > .5)
    // {
    //   leftY *= .75;
    //   rightY *= .75;
    // } else 
    // {
    //   leftY *= .35;
    //   rightY *= .35;
    // }


    if(leftY < .05) 
    {
      if(leftY > -.05) 
      {
        leftY = 0;
      }
    }

    
    if(rightY < .05) 
    {
      if(rightY > .05) 
      {
        rightY = 0;
      }
    }

    leftDrive.set(-leftY);
    rightDrive.set(-rightY);
  }


}
