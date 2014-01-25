/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.templates.Wiring;
import edu.wpi.first.wpilibj.templates.commands.ShiftGearBox;

/**
 *
 * @author Chris
 */
public class Shifter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    Solenoid m_LShifter;
    Solenoid m_RShifter;

    public Shifter() {
        m_LShifter = new Solenoid(Wiring.rShifter);
        m_RShifter = new Solenoid(Wiring.lShifter);
        m_LShifter.set(false);
        m_RShifter.set(false);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void Shift() {
        //'gearing' is set to whatever state the shifting solenoids are currently in
        boolean gearing = false;
        gearing = m_LShifter.get();

        //Diagnostic
        System.out.println("Attempting to shift: Subsystem Method.");

        System.out.println("Attempting to shift: Gearing =" + gearing);

        //Switch on 'gearing', sent to "shifter".set()
        if (gearing == true) {
            m_LShifter.set(false);
            m_RShifter.set(true);
        }
        if (gearing == false) {
            m_RShifter.set(false);
            m_LShifter.set(true);
            System.err.println("LShifter" + m_LShifter.get());
            System.err.println("RShifter" + m_RShifter.get());
        }
    }

}
