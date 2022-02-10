# Gamanza Backend Coding Challenge

We are very pleased and happy that you are interested in working with us and like to join our
Gamanza family. This coding challenge is a great playground and an opportunity for you to show us
your knowledge, skills, motivation, and passion. We don’t expect perfect code, but something you
will be proud of. It’s completely up to you how you will tackle this task and solve it. Use tools, libraries,
technology and patterns you would usually use and of course your knowledge.

What we would like to see:
- Architecture pattern usage and clean code
- Usage of modern platform features and up-to-date coding practices (e.g. CDI, annotations, etc.)
- Knowledge of JavaScript, Express, ORM, REST, Sockets, JOI, ...
- Well written tests (JEST, ...) (we don’t expect a huge code coverage)
- Clean VCS history

The finished project should be delivered in a form of a publicly available GIT repository and should
contain all the necessary code for running the application. Trust in your own knowledge and do your
best (as with a real project) and commit often so we can see and understand the process and make
a proper final product.


Good luck.

---

## Demo Application
Your final product should be a backend application for casino players and games management via
REST API, described in details in the following sections. Keep in mind that application can be
used by multiple clients at the same time and all data needs to be persisted somewhere(preferred in some
lightweight database). UI is not part of this demo application.

Optional:
- implement HTTP cache mechanisms where is needed
- implement request counter for all REST calls and save it in the local file
- swagger documentation


### Games
Games have properties as game title, description, list of players, some pictures, etc. (as identifier use
UUID). Implement REST operations to support basic UI requirements:

- list all games
- list games with pagination support
- search for games
- CRUD operations

### Players
Players have properties as first name, last name, born date, etc. Implement REST operations to
support basic UI requirements:

- list all players 
- list players with pagination support
- list games played by player with pagination support
- search for players
- CRUD operations

The application and final product are not specifically defined and there are not huge requirements
so you can finish this assignment in one day or in one month, depends on how much of knowledge you
want to show to us.


We wish you a good luck and are waiting for your feedback.
