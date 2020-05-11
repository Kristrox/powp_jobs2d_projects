package edu.kis.powp.jobs2d.command;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ImmutableCompoundCommand implements ICompoundCommand {

    private List<DriverCommand> driverCommands = null;

    public ImmutableCompoundCommand(List<DriverCommand> driverCommands) {
        this.driverCommands = new ArrayList<>();
        this.driverCommands.addAll(driverCommands);
        this.driverCommands = Collections.unmodifiableList(this.driverCommands);
    }

    @Override
    public Iterator<DriverCommand> iterator() {
        return this.driverCommands.iterator();
    }

    @Override
    public void execute(Job2dDriver driver) {
        this.driverCommands.forEach(c -> c.execute(driver));
    }

    @Override
    public DriverCommand clone() throws CloneNotSupportedException {
        return ICompoundCommand.super.clone();
    }
}
