package com.matthewcasperson.welcomebot;

import com.microsoft.bot.builder.Bot;
import com.microsoft.bot.integration.spring.BotController;
import com.microsoft.bot.integration.spring.BotDependencyConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({BotController.class})
public class WelcomeBotApplication extends BotDependencyConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(WelcomeBotApplication.class, args);
	}

	@Bean
	public Bot getBot() {
		return new WelcomeBot();
	}
}
