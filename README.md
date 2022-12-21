## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## PROYECTO

Realizar un programa en Java, que funcione por la Terminal de Eclipse que emule un juego de tipo RPG. El juego es de tipo libre, pero debe ser similar en conceptos y elementos de programación indicados en el ejemplo. 

Cada jugador dispondrá de dos modos de juego. Con personajes individuales, o con batallones.
El modo individual, será la lucha de un personaje frente a otro NPC.
El modo batallón, será una colección de personajes que se enfrenten a otro batallón de NPC del mismo número.

## Atributos del personaje:

Nombre
Liga (JUSTICIA, TERROR, NEUTRAL, PICARO, JUVENIL)
Vida
Ataque
AtaqueSpecial
DefensaSpecial
Velocidad


## JUEGO INDIVIDUAL

En el modo individual, se crearán dos jugadores y luego se producirá el enfrentamiento. El primer atacante será el primer personaje que creemos. 
Realiza un menú para estas acciones.

__Consideraciones__:
Los personajes tendrán dos modos de crearse.
* Indicándole el nombre, Liga y valor de cada uno de los stats.
* Indicándole el nombre y la Liga a la que pertenecen.
* En el caso de no indicar un valor en los stats, el programa generara un número aleatorio entre 1 y 50.

## CONDICIONES
Ataque: Cada personaje tendrá un método para ejecutar los ataques. Estos lanzaran un número entero entre uno y el valor del atributo.
	Ejemplo:  catAmerica.ataque() -> 23
Si la velocidad del atacante es mayor que el que defiende. Este número se restará a la vida del personaje atacado, menos el valor de la defensa.
	Ejemplo:  fuerza del ataque: 22, valor de la defesa 15, vida del personaje 30.
		    (22-15) = 7    Luego -> 30-7 El personaje quedara con 23 de vida.
*Si el valor de la defensa es mayor que la del valor del ataque del atacante, no se    producirá daño alguno. 
*En el caso del ataque especial el valor será la suma de ataque+ataqueSpecial. Cada personaje solo dispondrá de la posibilidad de realizar un ataque-special en su existencia.
* Cada personaje, si es atacado y el resultado es muerte (vida en 0), antes de morir en ese último ataque usará la defensa-special que será la suma de las dos defensas.

__Ligas__

Para las ligas, las siguientes clases tendrán las siguientes bonificaciones y penalizaciones.
	Si dos personajes de la misma liga se enfrentan, no se alterarán sus stats. Pero si son de diferentes ligas, decide que ventaja o desventaja tendrán entre ellos.
	Ejemplo:
Justicia vs terror: Los ataques de tendrán una penalización del 10%.
			    		Si el ataque es 50 -> 50-(50*0.1)
			   La defensa tendrá una bonificación del 15%;
