# bet-management

## A betting management system to store, retrieve and manage the bets and calculate the winnings. Following are the steps to place a bet and get winnings

### http://localhost:8765/betmanagementsystem/saveAccountDetails for saving account details. This API does not need "Authorization" header to be passed which contains the token.

### http://localhost:8765/auth/login to Login and generate a JWT Token.

### http://localhost:8765/auth/validate to validate the token.

### http://localhost:8765/betmanagementsystem/saveorUpdateEventDetails to create or update an Event.

### http://localhost:8765/betmanagementsystem/getEventDetails?eventId=0 to get event related details.

### http://localhost:8765/betmanagementsystem/saveorUpdateMarketDetails to create or update a Market related to an event.

### http://localhost:8765/betmanagementsystem/getMarketDetails?marketId=0 to get details related to a market.

### http://localhost:8765/betmanagementsystem/saveorUpdateStakeDetails to create or update a stake placed by an user and this stake is related to a certain market and an event.

### http://localhost:8765/betmanagementsystem/getStakeDetails?stakeId=0 to get details related to a stake.

### http://localhost:8765/betmanagementsystem/calculateWinnings?eventId=3 to calculate the amount won by the users who placed their bets on the winning market.

### http://localhost:8765/betmanagementsystem/getWinnings?eventId=3 to get the details related to the users of the winning market.



 
