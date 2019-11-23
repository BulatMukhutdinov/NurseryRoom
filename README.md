# NurseryRoom
The main purpose of this project is to show hot to use new features of Room, specifically prepacked DB and interaction with Coroutines.
There are examples of suspended functions in DAO. The most interesting part is observable queries using Coroutines Flow.
## App
App has a prepacked list of Masters, Dogs, and Cats. Masters and Dogs have one-to-many relations and Masters and Cats have many-to-many relations. So a user can just add new relations using existing entities.
## Architecture
The project utilizes Clean architecture + MVI
