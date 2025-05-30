package org.irri.iric.portal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessBuilderExample
{
  
  public static void main(String[] args) throws Exception
  {
    new ProcessBuilderExample();
  }

  // can run basic ls or ps commands
  // can run command pipelines
  // can run sudo command if you know the password is correct
  public ProcessBuilderExample() throws IOException, InterruptedException
  {
    // build the system command we want to run
    List<String> commands = new ArrayList<String>();
    commands.add("/bin/sh");
    commands.add("-c");
    commands.add("ls -l /var/tmp | grep tmp");

    // execute the command
    SystemCommandExecutor commandExecutor = new SystemCommandExecutor(commands);
    int result = commandExecutor.executeCommand();

    // get the stdout and stderr from the command that was run
    StringBuilder stdout = commandExecutor.getStandardOutputFromCommand();
    StringBuilder stderr = commandExecutor.getStandardErrorFromCommand();
    
    // print the stdout and stderr
    AppContext.debug("The numeric result of the command was: " + result);
    AppContext.debug("STDOUT:");
    AppContext.debug(stdout.toString());
    AppContext.debug("STDERR:");
    AppContext.debug(stderr.toString());
  }
}
