1. Собираем jar

"mvn clean package"

2. Собираем образ

"docker image build -t otus-app ."

3. Запускаем контейнер

"docker run -d -p 80:8080 otus-app"