package dicmeta.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class DicmetaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DicmetaApplication.class, args);
	}

}
