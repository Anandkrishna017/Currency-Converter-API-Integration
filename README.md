# Currency Conversion API  

A Spring Boot application that integrates with a public API to provide real-time currency conversion functionality. It fetches current exchange rates and allows you to convert currency amounts between different currencies.  

## Features  
- Fetch real-time exchange rates using a public API  
- Convert amounts from one currency to another  

## Prerequisites  
- Java 21  
- Maven  
- Internet connection (to access the public API)  

## Installation  

1. Clone the repository:  
   ```bash
   git clone https://github.com/your-username/currency-conversion-api.git
   cd currency-conversion-api
   ```  

2. Configure the public API key (if required):  
   - Create .env file in root directory.  
   - Add your API key if the API service you are using requires authentication:  
     ```.env
     API_URL="Your-API-URL" eg:https://xyz.org/api/latest.json?app_id={appId}&base={base}
API_KEY="<your-API-KEY>"
     ```  

3. Build the project using Maven:  
   ```bash
   mvn clean install
   ```  

## How to Run  

1. Start the application:  
   ```bash
   mvn spring-boot:run
   ```  

2. The application will be available at:  
   ```
   http://localhost:8080
   ```  

## API Endpoints  

### 1. Fetch Exchange Rates  
**GET** `/api/rates?base=USD`  
Fetch the exchange rates for the given base currency. The default base is USD.  

#### Example Request:  
```
http://localhost:8080/api/rates?base=USD
```  

#### Example Response:  
```json
{
  "base": "USD",
  "date": "2025-02-05",
  "rates": {
    "EUR": 0.945,
    "GBP": 0.826,
    "INR": 82.73
  }
}
```

---

### 2. Convert Currency  
**POST** `/api/convert`  
Convert an amount from one currency to another using the fetched exchange rates.  

#### Request Body:  
```json
{
  "from": "USD",
  "to": "EUR",
  "amount": 100
}
```  

#### Example Response:  
```json
{
  "from": "USD",
  "to": "EUR",
  "amount": 100,
  "convertedAmount": 94.5
}
```  

---

## How It Works  

1. **Fetch Exchange Rates:**  
   The application fetches real-time exchange rates from the configured public API.  

2. **Convert Currency:**  
   The conversion uses the fetched rates to calculate the converted amount from the source currency to the target currency.  


