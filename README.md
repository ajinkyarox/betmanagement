# bet-management

## A betting management system to store, retrieve and manage the bets and calculate the winnings. Following are the steps to place a bet and get winnings

### Every API has an "Authorization" header which contains a jwt token in the Request Header.

### http://localhost:8765/betmanagementsystem/saveAccountDetails for saving account details. This API does not need "Authorization" header to be passed which contains the token. The Request body is as follows - 
#### {"username":"abdullah","password":"abdullah","accountType":"user","dateOfBirth":"1999-09-20T10:00:00.000"}

### http://localhost:8765/auth/login to Login and generate a JWT Token. The Request body is as follows - 
#### { "username":"ajinkya"}

### http://localhost:8765/auth/validate to validate the token.The Request body is as follows - 
#### {"token":"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzc3MiLCJpYXQiOjE2NTYyNzM5MzAsImV4cCI6MTY1NjI3NDExMH0eyHrO71WJi8M7-lk3UqQXfkr7UVjfi_gWvNac18aH9kvbGDiWfmkpwPgkAc6h1uRpIcuenlsQXFlSitVFkuL-w"}

### http://localhost:8765/betmanagementsystem/saveorUpdateEventDetails to create or update an Event.The Request body is as follows - 
#### {"eventname" :"MANCHESTER UNITED V CHELSEA - 2 GOALS BY HALFTIME BY MU", "eventDescription":"2 GOALS BY HALFTIME BY MU", "startDateTime":"2022-06-29T06:45:00.000" "endDateTime" :"2022-06-29T07:15:00.000"}

### http://localhost:8765/betmanagementsystem/getEventDetails?eventId=0 to get event related details.

### http://localhost:8765/betmanagementsystem/saveorUpdateMarketDetails to create or update a Market related to an event.The Request body is as follows - 
#### {"marketId": 5,"marketname": "MANCHESTER UNITED","marketdescription": "Football team", "winst": "WON","eventId": 3 }

### http://localhost:8765/betmanagementsystem/getMarketDetails?marketId=0 to get details related to a market.The Request body is as follows - 

### http://localhost:8765/betmanagementsystem/saveorUpdateStakeDetails to create or update a stake placed by an user and this stake is related to a certain market and an event.The Request body is as follows - 
#### {"stakeAmount" : 30,"eventId" : 3,"marketId" : 6,"userId" : 9}

### http://localhost:8765/betmanagementsystem/getStakeDetails?stakeId=0 to get details related to a stake.

### http://localhost:8765/betmanagementsystem/calculateWinnings?eventId=3 to calculate the amount won by the users who placed their bets on the winning market.

### http://localhost:8765/betmanagementsystem/getWinnings?eventId=3 to get the details related to the users of the winning market.



 
