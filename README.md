# galaxy
Simple geometry functions for a simple galaxy with 3 planets and a sun.

El proyecto responde a las siguiente consignas:

En una galaxia lejana, existen tres civilizaciones. Vulcanos, Ferengis y Betasoides. Cada
civilización vive en paz en su respectivo planeta.
Dominan la predicción del clima mediante un complejo sistema informático.
A continuación el diagrama del sistema solar.
Premisas:
● El planeta Ferengi se desplaza con una velocidad angular de 1 grados/día en sentido
horario. Su distancia con respecto al sol es de 500Km.
● El planeta Betasoide se desplaza con una velocidad angular de 3 grados/día en sentido
horario. Su distancia con respecto al sol es de 2000Km.
● El planeta Vulcano se desplaza con una velocidad angular de 5 grados/día en sentido
antihorario, su distancia con respecto al sol es de 1000Km.
● Todas las órbitas son circulares.
Cuando los tres planetas están alineados entre sí y a su vez alineados con respecto al sol, el
sistema solar experimenta un período de sequía.
Cuando los tres planetas no están alineados, forman entre sí un triángulo. Es sabido que en el
momento en el que el sol se encuentra dentro del triángulo, el sistema solar experimenta un
período de lluvia, teniendo éste, un pico de intensidad cuando el perímetro del triángulo está en
su máximo.
Las condiciones óptimas de presión y temperatura se dan cuando los tres planetas están
alineados entre sí pero no están alineados con el sol.
Realizar un programa informático para poder predecir en los próximos 10 años:
1. ¿Cuántos períodos de sequía habrá?
2. ¿Cuántos períodos de lluvia habrá y qué día será el pico máximo de lluvia?
3. ¿Cuántos períodos de condiciones óptimas de presión y temperatura habrá?

---------------------------------------------------------------------------------------------------

Observaciones, asunciones:

1. Para mayor simplicidad y por oposición a lo que sucede en el mundo real, asumimos que el movimiento de los planetas es discreto.
2. Utilizamos una aproximación de 2 decimales para las posiciones de los planetas.
3. La galaxia está diseñada para incluir exactamente 3 planetas y los resultados no están definidos para una mayor cantidad. 
Algunas funciones no necesitarían sufrir ningún cambio en ese caso, sin embargo. Por ejemplo aquella que verifica si los planetas se encuentran alineados.
4. Muchas funciones que podrían considerarse típicas como getName para el caso de un planeta, fueron aquí obviadas para intentar
mantener el ejercicio lo más sencillo posible.
