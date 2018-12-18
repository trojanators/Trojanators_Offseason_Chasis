package frc.robot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.wpi.first.wpilibj.RobotState;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class log extends Command{
    
    public log(){
        initialize();
    }
    @Override
    public void initialize() {
        SmartDashboard.putString("+=========================", "=========================+");
        SmartDashboard.putString("|                    ROBOT", "LOGGER                   |");
        SmartDashboard.putString("==========================", "==========================");
        SmartDashboard.putString("", "");
        SmartDashboard.putString("Sorry I Falied our Mission","but I'll get the bread Nexttime");
        execute();
    }
    @Override
 public void execute() {
        while(RobotState.isEnabled()) {
        long date = System.currentTimeMillis();
        double current = OI.pdp.getCurrent(1);
        // Started Dasboard netlog
        SmartDashboard.putNumber("Date",date);
        SmartDashboard.putString("","");
        SmartDashboard.putNumber("Power",current);
        SmartDashboard.putString("","");
        SmartDashboard.putNumber("controller x",OI.controller.getRawAxis(1) );
        SmartDashboard.putString("","");
        SmartDashboard.putNumber("controller y",OI.controller.getRawAxis(4) );
        SmartDashboard.putString("","");
        SmartDashboard.putString("Ping","");
        SmartDashboard.putString("","");
        SmartDashboard.putData("Air-Pressure",OI.compressorSpike);
        SmartDashboard.putString("","");
        SmartDashboard.putBoolean("shift-isActive", OI.shiftSolenoid.getPCMSolenoidVoltageFault());
        // starts and prints log to file 
            loggingtofile.consoleLog("======================================================");
            loggingtofile.consoleLog("|                   ROBO LOG                         |");
            loggingtofile.consoleLog("======================================================");
            loggingtofile.consoleLog();
            loggingtofile.consoleLog("Date", date);
            loggingtofile.consoleLog();
            loggingtofile.consoleLog("Power",current);
            loggingtofile.consoleLog();
            loggingtofile.consoleLog("controller x",OI.controller.getRawAxis(1) );
            loggingtofile.consoleLog();
            loggingtofile.consoleLog("controller 4",OI.controller.getRawAxis(4) );
            loggingtofile.consoleLog();
            loggingtofile.consoleLog("shift-isActive", OI.shiftSolenoid.getPCMSolenoidVoltageFault());
        while(RobotState.isDisabled()){
            loggingtofile.consoleLog("netlog","Disabled");
            end();
        }
    }
    
}
    @Override
    protected void end() {
        SmartDashboard.putString("GOOD By","Log is now stoped");
        loggingtofile.consoleLog("Stoped","netlog");
        isFinished();
    }
    @Override
    protected boolean isFinished() {
        return true;
    }
    
}
