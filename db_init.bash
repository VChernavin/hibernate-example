#!/bin/bash

getCompanyByName () {
curl  localhost:8080/company/filter?name=$1 2>/dev/null
}
setCar () {
BODY=$(echo \{\"registrationNumber\":\"$1\",\"company\":$(getCompanyByName $2)\})
curl -X POST -H "Content-Type: application/json" -d "$BODY" localhost:8080/car 2>/dev/null
}
setCompany () {
curl -X POST -H "Content-Type: application/json" -d \{\"name\":\"$1\"\} localhost:8080/company 2>/dev/null

}

setCompany company1
setCompany company2
setCompany company3
setCompany company4

setCar "CAR 0001" company1
setCar "CAR 0002" company1
setCar "CAR 0011" company2
setCar "CAR 0012" company2

#curl -X POST -H "Content-Type: application/json" -d '{"name":"company1"}' localhost:8080/company
#curl -X POST -H "Content-Type: application/json" -d '{"name":"company2"}' localhost:8080/company
#curl -X POST -H "Content-Type: application/json" -d '{"name":"company3"}' localhost:8080/company
#curl -X POST -H "Content-Type: application/json" -d '{"name":"company4"}' localhost:8080/company


#curl -X POST -H "Content-Type: application/json" -d '{"registrationNumber":"CAR 0001","company":{"id":1,"name":"company1"}}' localhost:8080/car
#curl -X POST -H "Content-Type: application/json" -d '{"registrationNumber":"CAR 0002","company":{"id":1,"name":"company1"}}' localhost:8080/car
#curl -X POST -H "Content-Type: application/json" -d '{"registrationNumber":"CAR 0011","company":{"id":2,"name":"company2"}}' localhost:8080/car
#curl -X POST -H "Content-Type: application/json" -d '{"registrationNumber":"CAR 0012","company":{"id":2,"name":"company2"}}' localhost:8080/car




