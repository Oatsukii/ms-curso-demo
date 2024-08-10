//Testin proveniente de K6 https://k6.io/

import http from 'k6/http'
export const options = {
    iterations:1,
};

export default function () {
  const response = http.get('http://localhost:8080/products')
}


// En terminal utilizar el comando:
// sudo k6 run --vus 10 --duration 15s test.js // investigar para windows de lo contrario estar usando el de postman