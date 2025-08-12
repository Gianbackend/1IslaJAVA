# 🏝️ Simulador de Isla en Java

Este proyecto es un *simulador de ecosistema* desarrollado en Java, en el que distintas especies de animales y plantas interactúan en un entorno bidimensional. Los animales se mueven, comen, se reproducen, mueren y pueden migrar (o aparecer) según configuraciones predefinidas.
Se favorece la migración de herbívoros para mantener el equilibrio ecológico. Ejemplos de probabilidades:
- Oruga: 3%
- Raton: 1%
- Conejo: 1%
- Águila, Boa, Oso: 0%
La regeneración de plantas ocurre con un 5% por celda cada turno.


## 📌 Características principales

- **POO con jerarquía de clases** (Animal → Herbívoro / Carnívoro → especies concretas).
- **15 especies**: 10 herbívoros, 5 carnívoros.
- **Plantas** como recurso para herbívoros.
- **Movimientos limitados por velocidad** según especie.
- **Depredación** con probabilidades según tabla.
- **Muerte por hambre** con probabilidad configurable.
- **Reproducción** con número de crías por especie.
- **Migración configurable** por especie (favorece herbívoros como orugas).
- **Regeneración de plantas** cada turno.
- **Parámetros centralizados** en `Config.java`.
- **Persistencia opcional** del estado (`SAVE_STATE`).

## ⚙️ Configuración (Config.java)

Algunos parámetros que puedes ajustar:

- `ROWS` / `COLS`: tamaño de la isla (por defecto 20x20).
- `TICK_SECONDS`: segundos entre cada turno (por defecto 3s).
- `HUNGER_DEATH_PROB`: probabilidad de morir por hambre si no come (por defecto 0.70).
- `PLANT_REGEN_PROB`: probabilidad de regeneración de plantas por celda y turno (por defecto 0.05).
- `MIGRATION_PROB`: probabilidad de migración por especie.
  - Ejemplo: `MIGRATION_PROB.put(Species.ORUGA, 0.03);`
- `INITIAL_COUNTS`: número inicial de cada especie.
- `LITTER_SIZE`: número de crías por reproducción.
- `STOP_WHEN_NO_ANIMALS`: detener simulación cuando no queden animales.
- `SAVE_STATE`: guardar y cargar estado desde `isla.ser` cuando requiera retomar un estado guardado como persistencia.

## ▶️ Ejecución

1. Clona el repositorio:
   ```bash
   git clone https://github.com/usuario/simulador-isla-java.git
   cd simulador-isla-java
Compila y ejecuta:

bash
Copiar
Editar
javac Project2Poo/*.java
java Project2Poo.Main

Durante la simulación verás:

Mapa con contenido de cada celda ([🐇🌿]).

Estadísticas con conteo por especie y 🌿 plantas.

📊 Ejemplo de salida
leer
Copiar
Editar
📍 Estado de la isla (turno 0):
[🌿] [🐇] [  ] [  ] [  ]
...

📊 Estadísticas Iniciales: 🐃:2 🐻:2 🐎:6 🦌:8 🐗:3 🐑:8 🐐:8 🐺:10 🐍:5 🦊:6 🦅:3 🐇:30 🦆:8 🐁:20 🐛:30 🌿:22

📂 Estructura del proyecto

📂 Project2Poo

 ├─ 📂 _A_app

 │   └─ Main.java

 ├─ 📂 animals

 │   ├─ 📂 carnivoros

 │   │   ├─ Aguila.java

 │   │   ├─ Boa.java

 │   │   ├─ Lobo.java

 │   │   ├─ Oso.java

 │   │   └─ Zorro.java

 │   └─ 📂 herbivoros

 │       ├─ Bufalo.java

 │       ├─ Caballo.java

 │       ├─ Cabra.java

 │       ├─ Ciervo.java

 │       ├─ Conejo.java

 │       ├─ Jabali.java

 │       ├─ Oruga.java

 │       ├─ Oveja.java

 │       ├─ Pato.java

 │       └─ Raton.java

 ├─ 📂 config

 │   ├─ Config.java

 │   ├─ PredationTable.java

 │   └─ Species.java

 ├─ 📂 core

 │   ├─ Animal.java

 │   ├─ Carnivoro.java

 │   └─ Herbivoro.java

 ├─ 📂 util

 │   └─ AnimalFactory.java

 └─ 📂 world

     ├─ Cell.java

     └─ Plant.java



🚀 Mejoras opcionales implementadas
*Persistencia opcional del estado (SAVE_STATE).

*Migración configurable por especie.

*Inicio desde estado guardado.

*Turno 0 separado antes de iniciar la simulación.

*Parámetros centralizados.

📈 Posibles mejoras futuras
Hambre modelada según kg de alimento necesarios.

*Depredación parcial.

*Climas/estaciones que afecten la regeneración.

*Migración estacional.

*Interfaz gráfica.

📜 Licencia
Este proyecto se distribuye bajo la licencia propia. Puedes usarlo y modificarlo libremente.
