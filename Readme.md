# LOTR-Game

Este repositorio es del proyecto final del curso de Programación Java Certificacion OCP de Tokio School.

![1721918435079](image/Readme/1721918435079.png)

## Descripción

EL proyecto consiste en un juego en donde se pueden crear personajes de la saga de El Señor de los Anillos.
Donde se destaca la facción de Heroes y Bestias, cada uno con sus propias habilidades y características.
Dentro de los Heroes tenemos razas como Humanos, Elfos, Enanos, Magos y Hobbits. EN el grupo de las Bestias tenemos Orcos, Trasgos, Uruk-hai y Nazgul.

## Modalidad de juego.

El juego consiste en una batalla por turnos entre los personajes de las facciones de Heroes y Bestias.
EL ataque se produce cuando al tirar los dados y el valor de los dados es mayor al valor de la defensa del personaje enemigo.
Cada personaje tiene un ataque y una defensa, además de una habilidad especial que puede ser utilizada en el turno del personaje.
El juego termina cuando uno de los bandos ha sido derrotado.

## Habiliades Especiales

- Heroes tienen dos tiros de dados entre 0 y 100 y se eleije el mayor.
- Elfos tienen un aumento de 10 puntos en su ataque cuando su oponente es un orco.
- Hobbits al tener temor de los Trasgos, su ataque disminuye en 5 puntos.
- Las Bestias tienen un solo tiro de dado de 0 a 90.
- Orcos tiene mucha fuerza en su ataque por eso la armadura de su opente disminuye el 10%.

## Tecnologías Utilizadas

- Java 21
- JavaFX
- Maven

### Clonar Proyecto

```
https://github.com/mattyys/lotrGame.git
```

### Compilar Proyecto MAVEN

```
mvn clean package
```

### Ejecutar Proyecto MAVEN

```
mvn run:javafx
```
