# Rentalcars

## Part 1

### SIPP Specification Assumption

First Letter

| Letter | Value |
| --- | :--- |
| M | Mini         |
| E | Economy      |
| C | Compact      |
| I | Intermediate |
| S | Standard     |
| F | Full size    |
| P | Premium      |
| L | Luxury       |
| X | Special      |

Second Letter

| Letter | Value |
| --- | :--- |
| B | 2 doors       |
| C | 4 doors       |
| D | 5 doors       |
| W | Estate        |
| T | Convertible   |
| F | SUV           |
| P | Pick up       |
| V | Passenger Van |

Using the tables to calculate car/door type from second character of SIPP code, if character does not exist within the set defined in the second letter set, it will look in the first letter set.

e.g. for the edge case CXMR, second letter X is not within the set, thus it will look in the first letter set whereby it exists and return Special.

## Part 2

### Prerequisites
This is a spring boot application that uses JDBC to connect to a mySQL database. src/main/resources/application.properties may need to be configured.

```
spring.datasource.url=jdbc:mysql://localhost:8889/rentalcars
spring.datasource.username=root
spring.datasource.password=root
```

Please create a database called rentalcars and configure port, user, pass if necessary.

Once spring application runs, it will populate the database utilising the ORM and via the DataLoader class.
