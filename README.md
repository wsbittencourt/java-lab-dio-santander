# Java lab for Dio & Santander Bootcamp
Project to validate knowledge acquired in the last bootcamp module. The objective is to create a RESTful API, using Java + Spring Boot and finally deploy it.

## Class Diagram
Below is a small class diagram used as a basis for the project.

```mermaid
classDiagram
  class Player {
    - name: String
    - hp: Integer
    - damage: Integer
    - defense: Integer
    - luck: Float
    + Player(name: String, hp: Integer, damage: Integer, defense: Integer, luck: Float)
  }

  class Match {
    - players: List<Player>
    - status: String
    - winner: Player
    + Match(players: List<Player>, status: String, winner: Player)
  }

  Player --|> Match : participates in
  Match --|> Player : has winner
```
