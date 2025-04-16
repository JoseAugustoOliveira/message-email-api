
# Documentação da API de envio de email, sms e mensagens via whats app

A API esta documentada via Swagger:

http://localhost:8090/swagger-ui/index.html#/

# Endpoints

```
USUARIOS 

POST - /messages    -    Envio da mensagem
```

# Informações importantes

* Exemplo de request para envio das mensagens

```
EMAIL: 

{
  "to": "jose@email.com",
  "channel": "EMAIL",
  "message": "Olá José! O preço da ação XPTO caiu 5% hoje.",
  "templateName": "Alerta de preço"
}
```

```
SMS: 

{
  "to": "+5511988888888",
  "channel": "SMS",
  "message": "Alerta: ação XPTO caiu 5% hoje."
}
```

```
WHATS_APP: 

{
  "to": "+5511999999999",
  "channel": "WHATS_APP",
  "message": "Olá João! A ação XPTO está em queda. Deseja receber mais alertas?"
}
```


* Com utilização dos serviços do twilio 'https://www.twilio.com/docs/serverless/functions-assets/functions/dependencies#twilio-docs-content-area'

# Ferramentas e Dependências

* Java 21
* Spring Boot 3.4.4
* Twilio
* Swagger
* Maven
* Lombok
* OpenApi - Swagger
* Spring boot starter mail