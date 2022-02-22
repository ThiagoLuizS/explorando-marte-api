# explorando-marte-api
API para cálculo de coordenadas em marte

# Introdução de como executar a API
 - Esta é uma API Rest baseada em Spring Boot, portanto não é necessário configurar o servidor local, pois o spring já vem com o tomcat embutido.
 - Existe apenas um Endpoint do tipo POST para ser chamado.
 - Utilizei a ferramente Spring Tools Suite, que já vem com o a biblioteca do Spring Boot embarcada para inicializar a API. Se caso estiver utilizando outra ferramenta, exemplo:    Eclipse, IntelliJ será necessário baixar o plugin do Spring Boot
 - Após inicializar a API a Documentação do Swagger pode ser acessada através do Navegador pela URL: http://localhost:8080/swagger-ui.html
 - O corpo para fazer a requisição de teste está no formato abaixo, respeitando os nomes do atributos e também a obrigatoriedade de todos os campos.

```json
POST http://localhost:8080/api/input

{
    "mesh": {
        "x": 5,
        "y": 5
    },
    "actions": [
        {
            "position": {
                "x": 1,
                "y": 2,
                "direction": "N"
            },
            "movements": ["L","M","L","M","L","M","L","M","M"]
        },
        {
            "position": {
                "x": 3,
                "y": 3,
                "direction": "E"
            },
            "movements": ["M","M","R","M","M","R","M","R","R","M"]
        }
    ]
}
```
