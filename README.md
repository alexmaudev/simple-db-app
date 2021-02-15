**Simple application with database access**

Simple crud rest application without security and exception handling.

How to run the application?
from the directory ./simple-db-app please run the command "./mvnw spring-boot:run"

Request example: (Person creating)
curl --location --request POST 'http://localhost:8080/person/' \
--header 'Content-Type: application/json' \
--data-raw '{
"first_name": "C",
"last_name": "D"
}'