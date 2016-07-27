package conch3.server;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ConchApplication extends Application<ConchConfig> {
  public static void main(String[] args) throws Exception {
    new ConchApplication().run(args);
  }

  @Override
  public String getName() {
    return "hello-conch";
  }

  @Override
  public void initialize(Bootstrap<ConchConfig> bootstrap) {
    // nothing to do yet
  }

  @Override
  public void run(ConchConfig configuration,
                  Environment environment) {
	  final ConchResource main = new ConchResource(
			  configuration.getTemplate(),
			  configuration.getDefaultReply());
	  
	  final TemplateHealthCheck healthCheck =
		        new TemplateHealthCheck(configuration.getTemplate());
	  environment.healthChecks().register("template", healthCheck);
	  environment.jersey().register(main);	  
  }
}