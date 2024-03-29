package com.clearcapital.oss.executors;

import com.clearcapital.oss.commands.Command;
import com.clearcapital.oss.commands.CommandExecutionException;

/**
 * <p>
 * An implementation of the BundleExecutor interface, which executes commands as soon as they are added.
 * </p>
 * 
 * <p>
 * There are two main uses for this class:
 * </p>
 * 
 * <ul>
 * <li>unit testing</li>
 * <li>command line utilities where using a QueuedBundleExecutor would result in running out of memory.</li>
 * </ul>
 * 
 */
public class ImmediateCommandExecutor implements CommandExecutor {

    private static final CommandExecutor instance = new ImmediateCommandExecutor();

    @Override
    public void close() throws CommandExecutionException {
        // No-op
    }

    @Override
    public void addCommand(Command bundle) throws CommandExecutionException {
        if (bundle != null) {
            bundle.execute();
        }
    }

    @Override
    public void execute() throws CommandExecutionException {
        // no-op
    }

    public static CommandExecutor getInstance() {
        return instance;
    }

}
