## Examen de Test Unitarios

---

### Enunciado

Con el código de este repositorio realiza:

- (*4 puntos*) Los test unitarios de los **dos** métodos, utiliza test **parametrizados**. Suponiendo que la `string` DNI, siempre es un DNI válido.
- (*2 puntos*) En el código, hay un error, ¿lo pudiste comprabar en los test? ¿Plantea la solución?
- (*3 puntos*) Si no hubiera una comprobación previamente encuanto a la longitud de la `string` del DNI, ¿Qué hay que cambiar en los tests para que comprueben estos casos?

Entrega tu repositorio con el código y los test. Además un `Readme` explicando y justificando cada apartado

Formato del `Readme` *1 punto*

---

# Respuesta examen test unitarios

### Solución a longitud del DNI

- La solución para que en ningún caso halla un DNI con una longitud incorrecta es dentro del método que lo comprueba.
- En el método comprobarDNI añadimos una comprobación para saber si su longitud es distinto de 8. Quedando así

- ```[public static boolean comprobarDNI(String dni, char letra) {
    if (dni == null || dni.length() != 8) {
        throw new IllegalArgumentException("El DNI debe tener exactamente 8 caracteres numéricos.");
    }
    char letraCalculada = calcularLetraDNI(dni);
    return letraCalculada == letra;
    }]
### Test calcularLetraDNI
- Comprobaremos que se asigne la letra correcta a cada resto posible haciendo por lo menos 1 test por cada letra
- También comprobaremos que identifica DNIs no válidos
- A parte agregamos un test para DNIs de longitud incorrecta (este lanza una excepción porque el error del ejercicio no ha sido correjido en el Main)
### Test comprobarDNI
- Este test contiene tests parametrizados para el método comprobarDNI, comprobando tanto casos positivos como negativos.
- Además se vuelve a comprobar si la longitud del DNI   es correcta. (en caso contrario como puede darse sin el arreglo salta una excepción)