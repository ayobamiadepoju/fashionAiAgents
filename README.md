# 👗 Fashion AI Agent – Telex.im Integration

This project is a multi-agent AI system that provides weather-based outfit suggestions and generates visual representations of fashion looks. It is built using [Google ADK](https://github.com/google/adk), powered by Gemini models, and deployed as a Spring Boot service with webhook support for [Telex.im](https://telex.im).

---

## 🚀 Features

- 🌤️ Weather-aware outfit recommendations
- 👗 Fashion prompt generation
- 🖼️ Outfit image generation via LLM
- 💬 Friendly chat responses (e.g., “Hi”, “Hello”)
- 🔌 Telex.im integration via Mastra A2A protocol

---

## 🧱 Architecture
User → Telex.im → Webhook → Fashion Agent ↳ Weather Agent ↳ Image Generator Agent


- `fashion_agent`: Orchestrates the conversation and coordinates other agents
- `weather_agent`: Fetches current weather for a given location
- `image_generator_agent`: Generates outfit visuals based on prompts

---

## 🛠️ Technologies

- Java 21+
- Spring Boot
- Google ADK (Agent Development Kit)
- Gemini 2.0 Flash (via Google Generative AI SDK)
- Telex.im (Mastra A2A workflow)
- RxJava (for async agent events)

---

## 📦 Project Structure
```
src/ 
│    ├── main/ 
│    │   
│    ├── java/ 
│    └── hng/backend/task3/fashionAiAgent/ 
│            ├── AiAgents.java 
│            ├── TelexWebhookController.java 
│            ├── FashionAiAgentApplication.java 
└──          └── TelexMessage.java

```


---

## 🧪 Local Testing

Run the app locally:

```bash
./gradlew bootRun

Then test via console or send POST requests to:
http://localhost:8080/telex/webhook

Sample payload:
{
  "text": "What should I wear today?"
}
```
Absolutely! Here's your detailed README.md formatted in proper Markdown:
# 👗 Fashion AI Agent – Telex.im Integration

This project is a multi-agent AI system that provides weather-based outfit suggestions and generates visual representations of fashion looks. It is built using [Google ADK](https://github.com/google/adk), powered by Gemini models, and deployed as a Spring Boot service with webhook support for [Telex.im](https://telex.im).

---

## 🚀 Features

- 🌤️ Weather-aware outfit recommendations
- 👗 Fashion prompt generation
- 🖼️ Outfit image generation via LLM
- 💬 Friendly chat responses (e.g., “Hi”, “Hello”)
- 🔌 Telex.im integration via Mastra A2A protocol

---

## 🧱 Architecture


User → Telex.im → Webhook → Fashion Agent ↳ Weather Agent ↳ Image Generator Agent

- `fashion_agent`: Orchestrates the conversation and coordinates other agents
- `weather_agent`: Fetches current weather for a given location
- `image_generator_agent`: Generates outfit visuals based on prompts

---

## 🛠️ Technologies

- Java 17+
- Spring Boot
- Google ADK (Agent Development Kit)
- Gemini 2.0 Flash (via Google Generative AI SDK)
- Telex.im (Mastra A2A workflow)
- RxJava (for async agent events)

---

## 📦 Project Structure
```
src/ 
├── main/ 
│   ├── java/ 
│   
│   └── hng/backend/task3/fashionAiAgent/ 
│   │       
├── FashionAiAgentApplication.java 
│   
│       
├── AgentFactory.java 
│   
│       
├── TelexWebhookController.java 
│   
│

└── TelexMessage.java
```

---

## 🧪 Local Testing

Run the app locally:

```bash
./gradlew bootRun
```

### Then test via console or send POST requests to:
```
http://localhost:8080/telex/webhook
```

### Sample payload:
```
{
  "text": "What should I wear today?"
}
```


## 🌐 Deployment
Deploy to a public HTTPS endpoint using:
- Render
- Railway
- Google Cloud Run
Ensure your webhook is reachable at:

```
https://your-app.com/telex/webhook
```

## 🔗 Telex.im Integration
1. Invite Yourself
Run this in Telex chat:
```
/telex-invite your-email@example.com
```

2. Register Workflow
Create a Mastra workflow JSON like:
```
{
  "name": "fashion_agent",
  "nodes": [
    {
      "id": "fashion_node",
      "name": "Fashion Agent",
      "type": "a2a/mastra-a2a-node",
      "typeVersion": 1,
      "url": "https://your-app.com/telex/webhook",
      "position": [100, 200]
    }
  ],
  "description": "Suggests outfits based on weather",
  "category": "lifestyle",
  "active": true
}
```

Upload it to Mastra or register via API.

📜 Logs
View agent logs:
```
https://api.telex.im/agent-logs/{channel-id}.txt
```

Replace {channel-id} with your Telex channel UUID.

## ✅ Future Improvements
- Auto-detect user location via IP
- Personalize outfit suggestions based on user preferences
- Add seasonal styling tips
- Store user history for smarter recommendations

## 👤 Author
**Name:** AYOBAMI ADEPOJU  
**Email:** ayobamiadepoju263@gmail.com  
**Stack:** Java / Spring Boot  
**GitHub:** [@ayobamiadepoju](https://github.com/ayobamiadepoju)
HNG Stage 3 Backend Task
Built with ❤️ using Google ADK, Gemini, and Spring Boot
