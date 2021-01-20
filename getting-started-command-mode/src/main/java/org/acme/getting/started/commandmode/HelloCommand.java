package org.acme.getting.started.commandmode;

import picocli.CommandLine;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

// NOTE: impossible to get this app running before 10s in my laptop (no native)
// java -jar ...-runner.jar
@CommandLine.Command(mixinStandardHelpOptions = true)
public class HelloCommand implements Runnable {

  @CommandLine.Option(names = {"-n", "--name"}, description = "Who will we greet?", defaultValue = "World")
  String name;

  private final HelloService greetingService;

  public HelloCommand(HelloService greetingService) {
    this.greetingService = greetingService;
  }

  @Override
  public void run() {
    greetingService.sayHello(name);
  }
}

@Dependent
class HelloService {
  void sayHello(String name) {
    System.out.println("Hello " + name + "!");
  }
}
