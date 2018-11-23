#!/bin/bash

getCompanyByName () {
curl  localhost:8080/company/filter?name=$1 2>/dev/null
}

getAddresByID () {
curl  localhost:8080/address/$1 2>/dev/null
}
setCar () {
BODY=$(echo \{\"registrationNumber\":\"$1\",\"company\":$(getCompanyByName $2)\})
curl -X POST -H "Content-Type: application/json" -d "$BODY" localhost:8080/car 2>/dev/null
}
setCompany () {
curl -X POST -H "Content-Type: application/json" -d \{\"name\":\"$1\"\} localhost:8080/company 2>/dev/null

}

setAddress () {
curl -X POST -H "Content-Type: application/json" -d \{\"houseNumber\":\"$1\",\"street\":\"$2\",\"zipCode\":\"$3\"\} localhost:8080/address 2>/dev/null
}

setOffice () {
BODY=$(echo \{\"name\":\"$1\",\"address\":$(getAddresByID $2),\"company_id\": $3\})
curl -X POST -H "Content-Type: application/json" -d "$BODY" localhost:8080/office 2>/dev/null
}

setOffice2 () {
BODY=$(echo \{\"name\":\"$1\",\"address\":$(getAddresByID $2),\"company\": $(getCompanyByName $3)\})
curl -X POST -H "Content-Type: application/json" -d "$BODY" localhost:8080/office 2>/dev/null
}

for VAR in $(seq 1 101) ; do
   setCompany company$VAR
#   getCompanyByName company$VAR

done


#setCompany company1
#setCompany company2
#setCompany company3
#setCompany company4

#setCar "CAR 0001" company1
#setCar "CAR 0002" company1
#setCar "CAR 0011" company2
#setCar "CAR 0012" company2
#
#setAddress hn1 st1 zip1
#setAddress hn2 st2 zip2
#setAddress hn3 st3 zip3

#setOffice of1 9 1

#curl -X POST -H "Content-Type: application/json" -d '{"name":"company1"}' localhost:8080/company
#curl -X POST -H "Content-Type: application/json" -d '{"name":"company2"}' localhost:8080/company
#curl -X POST -H "Content-Type: application/json" -d '{"name":"company3"}' localhost:8080/company
#curl -X POST -H "Content-Type: application/json" -d '{"name":"company4"}' localhost:8080/company


#curl -X POST -H "Content-Type: application/json" -d '{"registrationNumber":"CAR 0001","company":{"id":1,"name":"company1"}}' localhost:8080/car
#curl -X POST -H "Content-Type: application/json" -d '{"registrationNumber":"CAR 0002","company":{"id":1,"name":"company1"}}' localhost:8080/car
#curl -X POST -H "Content-Type: application/json" -d '{"registrationNumber":"CAR 0011","company":{"id":2,"name":"company2"}}' localhost:8080/car
#curl -X POST -H "Content-Type: application/json" -d '{"registrationNumber":"CAR 0012","company":{"id":2,"name":"company2"}}' localhost:8080/car

#curl -X POST -H "Content-Type: application/json" -d '{"id":1,"houseNumber":"qw","street":"sty","zipCode":"asde"}' localhost:8080/address



