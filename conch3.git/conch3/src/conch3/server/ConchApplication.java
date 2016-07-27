package conch3.server;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
//import com.example.helloworld.resources.HelloWorldResource;
//import com.example.helloworld.health.TemplateHealthCheck;

public class HelloConchApplication extends Application<HelloConchConfig> {
  public static void main(String[] args) throws Exception {
    new HelloConchApplication().run(args);
  }

  @Override
  public String getName() {
    return "hello-conch";
  }

  @Override
  public void initialize(Bootstrap<HelloConchConfig> bootstrap) {
    // nothing to do yet
  }

  @Override
  public void run(HelloConchConfig configuration,
                  Environment environment) {
	  final HelloConchResource resource = new HelloConchResource(
		        configuration.getTemplate(),
		        configuration.getDefaultName()
			  );
	  final TemplateHealthCheck healthCheck =
		        new TemplateHealthCheck(configuration.getTemplate());
	  environment.healthChecks().register("template", healthCheck);
	  environment.jersey().register(resource);
  }
}