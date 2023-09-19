# Java lab for Dio & Santander Bootcamp
Project to validate knowledge acquired in the last bootcamp module. The objective is to create a RESTful API, using Java + Spring Boot and finally deploy it.

## Class Diagram
Below is a small class diagram used as a basis for the project.

```mermaid
classDiagram
  class CharacterClass {
    - class_name: String
    - health: Integer
    - base_physical_damage: Integer
    - base_magical_damage: Integer
    - base_physical_defense: Integer
    - base_magical_defense: Integer
    + CharacterClass(class_name: String, base_physical_damage: Integer, base_magical_damage: Integer, base_physical_defense: Integer, base_magical_defense: Integer)
  }

  class Player {
    - name: String
    - class_id: Integer
    + Player(name: String, class_id: Integer)
  }

  class Match {
    - players: List<Player>
    - status: String
    - winner: Player
    + Match(players: List<Player>, status: String, winner: Player)
  }

  Player "*" --* "*" Match : participates in
  Match "*" o-- "1" Player : has winner
  Player "1" --> "1" CharacterClass : belongs to
```
