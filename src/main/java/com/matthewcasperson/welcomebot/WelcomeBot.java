package com.matthewcasperson.welcomebot;

import com.microsoft.bot.builder.MessageFactory;
import com.microsoft.bot.builder.TurnContext;
import com.microsoft.bot.builder.teams.TeamsActivityHandler;
import java.util.concurrent.CompletableFuture;

public class WelcomeBot extends TeamsActivityHandler {
  @Override
  protected CompletableFuture<Void> onMessageActivity(final TurnContext turnContext) {
    return turnContext.sendActivity(
        MessageFactory.text("Echo: " + turnContext.getActivity().getText())
    ).thenApply(sendResult -> null);
  }

  @Override
  protected CompletableFuture<Void> onConversationUpdateActivity(final TurnContext turnContext) {
    return turnContext.sendActivity(MessageFactory.text("I was triggered by onConversationUpdateActivity."))
        .thenApply(sendResult -> null);
  }

  @Override
  protected CompletableFuture<Void> onUnrecognizedActivityType(TurnContext turnContext) {
    return turnContext.sendActivity(MessageFactory.text("I was triggered by onUnrecognizedActivityType: "
        + turnContext.getActivity().getType()))
        .thenApply(sendResult -> null);
  }

  protected CompletableFuture<Void> onTypingActivity(TurnContext turnContext) {
    return turnContext.sendActivity(MessageFactory.text("I was triggered by onTypingActivity."))
        .thenApply(sendResult -> null);
  }
}
