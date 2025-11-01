package hng.backend.task3.fashionAiAgent;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import com.google.adk.tools.AgentTool;

public class AiAgents {

    public static BaseAgent createRootAgent() {

        LlmAgent weatherAgent = LlmAgent.builder()
                .name("weather_agent")
                .model("gemini-2.0-flash")
                .description("Provides weather info for fashion suggestions.")
                .instruction("""
                You are a weather assistant.
                Given a location, return the current weather including temperature and conditions.
            """)
                .outputKey("weather")
                .build();

        LlmAgent imageAgent = LlmAgent.builder()
                .name("image_generator_agent")
                .model("gemini-2.0-flash")
                .description("Generates outfit visuals.")
                .instruction("""
                You are a stylist image generator.
                Given a fashion description, create a realistic image of the outfit.
            """)
                .outputKey("image")
                .build();

        return LlmAgent.builder()
                .name("fashion_agent")
                .model("gemini-2.0-flash")
                .description("Fashion assistant powered by Copilot logic suggests outfits based on weather and generates visuals.")
                .instruction("""
                If the user greets you (e.g., "hi", "hello"), respond warmly and invite them to ask what to wear.

                If the user asks what to wear:
                1. Ask weather_agent for current weather.
                2. Suggest an outfit based on the weather.
                3. Send a visual prompt to image_generator_agent.
                4. Return:
                   - Weather summary
                   - Outfit suggestion
                   - Outfit image
            """)
                .outputKey("answer")
                .tools(AgentTool.create(weatherAgent))
                .tools(AgentTool.create(imageAgent))
                .build();
    }
}