Feature: Generate access token for salesforce dynamically

Scenario Outline: Generate access token dynamically
Given Enter the URL for access token generation
And Enter the grant type "<grant>" and "<client_id>" and "<client_secret>" and "<username>" and "<password>" and generate access token
#And Enter the "<client_id>"  and "<client_secret>" for access token
#And Enter the "<username>" and "<password>" for access token
#When Post the request for access token
#Then Get the access token

Examples:
|grant|client_id|client_secret|username|password|
|password|3MVG9DREgiBqN9WlUgrL9xmAS10fHfFznRfYob21ViNmxI9TQxE17VCBnMuuumZb.aDk4qcYyMDhxk2uiwGBL|F6823BC4F1B4B2558975D024531E23BACFC6239E42A2B98B2BAF7955F90496E7|gdevi.g3@sales.sandbox|Soft2007!@|
